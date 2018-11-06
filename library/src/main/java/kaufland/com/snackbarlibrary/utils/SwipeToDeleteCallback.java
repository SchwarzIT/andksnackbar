package kaufland.com.snackbarlibrary.utils;

import android.support.v7.widget.helper.ItemTouchHelper;

public abstract class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {

    public SwipeToDeleteCallback() {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
    }

}
