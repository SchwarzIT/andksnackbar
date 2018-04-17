package kaufland.com.snackbarlibrary.view;

import android.view.View;
import android.view.ViewGroup;

public abstract class SnackbarView {

    private Callback mCallback;

    public abstract Integer getDuration();

    public abstract View onCreateView(ViewGroup parent);

    public abstract void onBindView();

    public Callback getCallback() {
        return mCallback;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    public abstract void onDismissed();

    public interface Callback {
        void onDismiss(SnackbarView view);
    }
}
