package kaufland.com.snackbarlibrary;

import android.os.Handler;
import android.os.Message;

import java.util.concurrent.Semaphore;

import kaufland.com.snackbarlibrary.view.SnackbarView;


public class SnackbarWorker extends Thread implements SnackbarView.Callback {

    private SnackbarView snackbarView;
    private Semaphore semaphore;
    private Handler handler;

    public SnackbarWorker(SnackbarView snackbarView, Semaphore semaphore, Handler handler) {
        this.snackbarView = snackbarView;
        this.semaphore = semaphore;
        this.handler = handler;
        snackbarView.setCallback(this);
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            createMessage(SnackbarManager.MSG_SHOW);
            if (snackbarView.getDuration() != null && snackbarView.getDuration() > 0) {
                Thread.sleep(snackbarView.getDuration());
                createMessage(SnackbarManager.MSG_DISMISS);
                semaphore.release();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDismiss() {
        createMessage(SnackbarManager.MSG_DISMISS);
        semaphore.release();
    }


    private Message createMessage(int what) {
        Message message = handler.obtainMessage();
        message.what = what;
        message.obj = snackbarView;
        message.sendToTarget();
        return message;
    }
}
