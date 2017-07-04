package kaufland.com.snackbarlibrary.view;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by vkos2006 on 7/3/17.
 */

public interface SnackbarView {

    int getDuration();

    View onCreateView(ViewGroup parent);

    void onBindView();
}
