package kaufland.com.snackbarlibrary.view;

import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by vkos2006 on 6/29/17.
 */

public interface SnackbarItem {

    View getView();

    String getMessage();

    Drawable getRightIcon();

    View.OnClickListener getRightActionListener();

    Integer getBacgroundColor();

    Integer getTextColor();
}
