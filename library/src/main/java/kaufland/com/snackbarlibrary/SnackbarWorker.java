package kaufland.com.snackbarlibrary;

import android.os.Handler;
import android.os.Message;

import java.util.concurrent.Semaphore;

import kaufland.com.snackbarlibrary.view.SnackbarView;


public class SnackbarWorker extends Thread implements SnackbarView.Callback {

    private SnackbarView mSnackbarView;
    private Semaphore mSemaphore;
    private Handler mHandler;

    public SnackbarWorker(SnackbarView snackbarView, Semaphore semaphore, Handler handler) {
        mSnackbarView = snackbarView;
        mSemaphore = semaphore;
        mHandler = handler;
        mSnackbarView.setCallback(this);
    }

    @Override
    public void run() {
        try {
            mSemaphore.acquire();
            createMessage(SnackbarManager.MSG_SHOW);
            if (mSnackbarView.getDuration() != null && mSnackbarView.getDuration() > 0) {
                Thread.sleep(mSnackbarView.getDuration());
                createMessage(SnackbarManager.MSG_DISMISS);
                mSemaphore.release();
            }

        } catch (InterruptedException e) {
            mSemaphore.release();
        }
    }

    @Override
    public void onDismiss() {
        createMessage(SnackbarManager.MSG_DISMISS);
        mSemaphore.release();
    }


    public Message createMessage(int what) {
        Message message = mHandler.obtainMessage();
        message.what = what;
        message.obj = mSnackbarView;
        message.sendToTarget();
        return message;
    }
}
