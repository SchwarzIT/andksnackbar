package kaufland.com.snackbarlibrary.view;

import android.view.View;
import android.view.ViewGroup;


public abstract class SnackbarView {

    abstract Integer getDuration();

    abstract View onCreateView(ViewGroup parent);

    abstract void onBindView();

}
