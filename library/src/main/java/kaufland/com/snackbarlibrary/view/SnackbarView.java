package kaufland.com.snackbarlibrary.view;

import android.view.View;
import android.view.ViewGroup;

import kaufland.com.snackbarlibrary.Callback;

/**
 * Created by vkos2006 on 7/3/17.
 */

public abstract class SnackbarView {

    private Callback callback;

    abstract Integer getDuration();

    abstract View onCreateView(ViewGroup parent);

    abstract void onBindView();

    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

}
