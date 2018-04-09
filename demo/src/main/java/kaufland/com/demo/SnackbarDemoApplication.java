package kaufland.com.demo;

import android.app.Application;

import kaufland.com.snackbarlibrary.SnackbarConfiguration;
import kaufland.com.snackbarlibrary.SnackbarManager;

/**
 * Created by vkos2006 on 7/12/17.
 */

public class SnackbarDemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SnackbarManager.init(new SnackbarConfiguration.Builder()
                .setGravity(SnackbarConfiguration.Gravity.GRAVITY_TOP)
                .setType(SnackbarConfiguration.SnackbarType.MULTIPLE_SNACKBARS)
                .setMaxViewCount(SnackbarConfiguration.MaxCount.DEFAULT)
                .build());
    }
}
