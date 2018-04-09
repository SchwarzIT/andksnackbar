package kaufland.com.snackbarlibrary;

import android.os.Handler;
import android.os.Message;

import java.util.concurrent.Semaphore;

import kaufland.com.snackbarlibrary.view.SnackbarView;


public class SnackbarWorker extends Thread implements SnackbarView.Callback {

    private int mMaxViewCount;
    private SnackbarView mSnackbarView;
    private Semaphore mSemaphore;
    private Handler mHandler;

    public SnackbarWorker(SnackbarView snackbarView, Semaphore semaphore, Handler handler, int maxViewCount) {
        mSnackbarView = snackbarView;
        mSemaphore = semaphore;
        mHandler = handler;
        mMaxViewCount = maxViewCount;
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
    public void onDismiss(SnackbarView snackbarView) {
        snackbarView.onDismissed();
        createMessage(SnackbarManager.MSG_DISMISS);
        mSemaphore.release();
    }

    public Message createMessage(int what) {
        Message message = mHandler.obtainMessage();
        message.what = what;
        message.obj = mSnackbarView;
        message.arg1 = mMaxViewCount;
        message.sendToTarget();
        return message;
    }
}
