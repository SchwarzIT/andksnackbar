package kaufland.com.snackbarlibrary;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.util.concurrent.Semaphore;

import kaufland.com.snackbarlibrary.view.SnackbarView;


public class SnackbarManager {

    public static final int MSG_SHOW = 0;
    public static final int MSG_DISMISS = 1;
    private static Snackbar sSnackbar;
    private static SnackbarConfiguration sSnackbarConfiguration;
    private static Semaphore sSemaphore;
    private static final  Handler sHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {

                case MSG_SHOW:
                    SnackbarView viewToAdd = (SnackbarView) msg.obj;
                    sSnackbar.addSnackbarView(viewToAdd);
                    return true;

                case MSG_DISMISS:
                    SnackbarView viewToRemove = (SnackbarView) msg.obj;
                    sSnackbar.removeSnackbarView(viewToRemove);
                    return true;
            }

            return false;
        }
    });


    public static void init(Context applicationContext, SnackbarConfiguration snackbarConfiguration) {
        sSnackbarConfiguration = snackbarConfiguration;
        sSnackbar = new Snackbar(applicationContext, snackbarConfiguration);
        if(snackbarConfiguration.getSnackbarType().equals(SnackbarConfiguration.SnackbarType.SINGLE_SNACKBAR)){
            sSemaphore = new Semaphore(1);
        }else{
            sSemaphore = new Semaphore(Runtime.getRuntime().availableProcessors());
        }
    }

    public static void showSnackbar(SnackbarView view){
        new SnackbarWorker(view,sSemaphore,sHandler).start();
    }




}
