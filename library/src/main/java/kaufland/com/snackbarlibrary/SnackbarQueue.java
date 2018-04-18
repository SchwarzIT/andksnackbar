package kaufland.com.snackbarlibrary;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import kaufland.com.snackbarlibrary.view.SnackbarView;

public class SnackbarQueue {


    private static final String TAG = SnackbarQueue.class.getName();
    private final Queue<SnackbarView> mQueue = new ConcurrentLinkedQueue<>();
    private final ExecutorService mExecutionWorker;

    private Snackbar mSnackbar;
    private volatile boolean mExecutionOnHold = true;

    private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    private class WaitingThread extends Thread {

        private int wait;

        public WaitingThread(int wait) {
            this.wait = wait;
        }

        @Override
        public void run() {
            super.run();
            try {
                sleep(wait);
            } catch (InterruptedException e) {
                //nope
            }
        }
    }


    public SnackbarQueue(SnackbarConfiguration snackbarConfiguration) {

        mSnackbar = new Snackbar(snackbarConfiguration);

        mExecutionWorker = Executors.newFixedThreadPool(snackbarConfiguration.getSnackbarMaxCount());
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
               if(mSnackbar != null){
                   mainThreadHandler.post(new Runnable() {
                       @Override
                       public void run() {
                           mSnackbar.verifyVisible();
                       }
                   });

               }
            }
        }, 800, 800, TimeUnit.MILLISECONDS);
    }

    public void rebindContext(Context context) {

        mExecutionOnHold = context == null;

        if (mSnackbar != null) {
            mSnackbar.updateContext(context);
            mSnackbar.show();
        }
    }

    public void add(final SnackbarView view) {
        mQueue.add(view);
        workOnQueue();
    }

    private synchronized void workOnQueue() {

        if (mExecutionOnHold) {
            Log.i(TAG, "SnackbarQueue is on hold. Not executing any executors.");
            return;
        }

        final SnackbarView view = mQueue.peek();

        mExecutionWorker.execute(new Runnable() {
            @Override
            public void run() {
                if (mExecutionOnHold || !mQueue.contains(view)) {
                    // periodic schedule may have scheduled nextExecutor while it was being executed
                    return;
                }

                mainThreadHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mSnackbar.addSnackbarView(view);
                        mQueue.remove(view);
                    }
                });


                final WaitingThread waiting = new WaitingThread(view.getDuration() != null && view.getDuration() > 0 ? view.getDuration() : Integer.MAX_VALUE);

                view.setCallback(new SnackbarView.Callback() {
                    @Override
                    public void onDismiss(SnackbarView view) {
                        waiting.interrupt();
                    }
                });

                waiting.start();
                try {
                    waiting.join();
                } catch (InterruptedException e) {
                    //nope
                }

                mainThreadHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mSnackbar.removeSnackbarView(view);
                    }
                });

                workOnQueue();
            }
        });

    }
}
