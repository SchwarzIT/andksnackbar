package kaufland.com.snackbarlibrary.worker;


import android.content.Context;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

import kaufland.com.snackbarlibrary.Snackbar;
import kaufland.com.snackbarlibrary.SnackbarConfiguration;
import kaufland.com.snackbarlibrary.model.Message;
import kaufland.com.snackbarlibrary.utils.Limit;
import kaufland.com.snackbarlibrary.view.SnackbarView;

public class WorkerHandler {

    private static Snackbar mSnackbar;
    private BlockingQueue<Message> mWorkQueue;
    private ExecutorService mService;
    private static WorkerHandler mWorkerHandler;
    private int mQueueSize;

    private WorkerHandler() {
    }

    public static synchronized WorkerHandler getInstance() {
        return mWorkerHandler = mWorkerHandler == null ? new WorkerHandler() : mWorkerHandler;
    }

    public void init(SnackbarConfiguration configuration, Limit queueSize) {
        init(configuration, mQueueSize = queueSize.getLimit());
    }

    public void init(SnackbarConfiguration configuration, int queueSize) {
        if (configuration == null) {
            return;
        }
        mSnackbar = new Snackbar(configuration);
        init(Runtime.getRuntime().availableProcessors(), queueSize);
    }

    public void init(int workerSize, int queueSize) {
        mWorkQueue = new LinkedBlockingDeque<>(queueSize);
        mService = Executors.newFixedThreadPool(workerSize);

        for (int i = 0; i < workerSize; i++) {
            mService.submit(new SnackbarWorker(mWorkQueue));
        }
    }

    private void produce(Message message) {
        try {
            mWorkQueue.put(message);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void showSnackbar(SnackbarView view) {
        if (view != null) {
            createMessage(view);
        }
    }

    private void createMessage(SnackbarView view) {
        produce(new Message(view, mSnackbar));
    }

    public int getQueueSize() {
        return mQueueSize;
    }

    public void rebindContext(Context context) {
        if (mSnackbar != null) {
            mSnackbar.updateContext(context);
            mSnackbar.show();
        }
    }
}
