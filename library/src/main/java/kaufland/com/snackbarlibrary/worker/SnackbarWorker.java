package kaufland.com.snackbarlibrary.worker;

import android.util.Log;

import java.util.concurrent.BlockingQueue;

import kaufland.com.snackbarlibrary.Snackbar;
import kaufland.com.snackbarlibrary.model.Message;
import kaufland.com.snackbarlibrary.view.SnackbarView;

public class SnackbarWorker implements Runnable, Notification {

    private static final String TAG = SnackbarWorker.class.getSimpleName();

    private boolean mRunning;
    private final BlockingQueue<Message> mWorkQueue;

    public SnackbarWorker(BlockingQueue<Message> workQueue) {
        mWorkQueue = workQueue;
    }

    @Override
    public boolean isRunning() {
        return mRunning;
    }

    @Override
    public void isFinished() {

    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Message message = mWorkQueue.take();
                Snackbar snackbar = message.getSnackbar();
                SnackbarView snackbarView = message.getSnackbarView();

                if (message == null || snackbar == null || snackbarView == null) {
                    Thread.currentThread().interrupt();
                    mWorkQueue.remove(this);
                    return;
                }

                if (snackbarView.getDuration() != null && snackbarView.getDuration() > 0) {
                    Thread.sleep(snackbarView.getDuration());
                    snackbar.removeSnackbarView(snackbarView);
                    Thread.currentThread().interrupt();
                    mWorkQueue.remove(this);

                } else if (snackbar.getSnackbarAdapter() != null && snackbar.getSnackbarAdapter().getItemCount() < WorkerHandler.getInstance().getQueueSize()) {
                    snackbar.addSnackbarView(snackbarView);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                Log.e(TAG, e.getMessage());
            }
        }
    }
}
