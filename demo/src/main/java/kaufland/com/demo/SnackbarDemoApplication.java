package kaufland.com.demo;

import android.app.Application;

import kaufland.com.snackbarlibrary.SnackbarConfiguration;
import kaufland.com.snackbarlibrary.utils.Limit;
import kaufland.com.snackbarlibrary.worker.WorkerHandler;

public class SnackbarDemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        WorkerHandler.getInstance().init(new SnackbarConfiguration.Builder()
                .setGravity(SnackbarConfiguration.Gravity.GRAVITY_TOP)
                .build(), Limit.SINGLE);
    }
}
