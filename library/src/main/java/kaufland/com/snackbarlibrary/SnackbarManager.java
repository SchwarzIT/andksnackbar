package kaufland.com.snackbarlibrary;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;


public class SnackbarManager {

    private static Snackbar mSnackbar;

    private static SnackbarConfiguration mSnackbarConfiguration;

    private static Handler mHandler = new Handler(Looper.getMainLooper()) {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };


    public static void init(Context applicationContext, SnackbarConfiguration snackbarConfiguration) {
        mSnackbarConfiguration = snackbarConfiguration;
        mSnackbar = new Snackbar(applicationContext, snackbarConfiguration);

    }


}
