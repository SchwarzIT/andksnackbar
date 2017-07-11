package kaufland.com.snackbarlibrary;

import android.content.Context;
import kaufland.com.snackbarlibrary.view.SnackbarView;

public class SnackbarManager {


    private static Snackbar mSnackbar;

    private static  Configuration mConfiguration;


    public static void init(Configuration configuration){
        mConfiguration = configuration;
    }

    private SnackbarManager(Configuration configuration){
        mConfiguration=configuration;
    }

    public static void makeSnackbar(Context applicationContext,SnackbarView view){
        if(mSnackbar ==null){
            mSnackbar = Snackbar.make(applicationContext,view);
            mSnackbar.show();
        }else{
            mSnackbar.addSnackbar(view);
        }
    }
}
