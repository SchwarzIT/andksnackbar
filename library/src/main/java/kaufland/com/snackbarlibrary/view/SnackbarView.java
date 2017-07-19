package kaufland.com.snackbarlibrary.view;

import android.view.View;
import android.view.ViewGroup;


public abstract class SnackbarView {

    private Callback callback;

    public abstract Integer getDuration();

    public abstract View onCreateView(ViewGroup parent);

    public abstract void onBindView();

    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback {
        void onDismiss();
    }
}
