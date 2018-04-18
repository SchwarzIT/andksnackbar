package kaufland.com.snackbarlibrary;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import kaufland.com.snackbarlibrary.view.SnackbarView;


public class SnackbarManager {

    private static SnackbarQueue mSnackbarQueue;

    public static void init(SnackbarConfiguration snackbarConfiguration) {
        if (snackbarConfiguration == null) {
            return;
        }

        mSnackbarQueue = new SnackbarQueue(snackbarConfiguration);
    }

    public static void rebindContext(Context context){

        if(mSnackbarQueue != null){
            mSnackbarQueue.rebindContext(context);
        }
    }

    public static void showSnackbar(SnackbarView view) {

        if (view != null) {

            if(mSnackbarQueue != null){
                mSnackbarQueue.add(view);
            }

        }
    }


}
