package kaufland.com.snackbarlibrary.view;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by vkos2006 on 7/3/17.
 */

public abstract class SnackbarView {

    abstract Integer getDuration();

    abstract View onCreateView(ViewGroup parent);

    abstract void onBindView();

}
