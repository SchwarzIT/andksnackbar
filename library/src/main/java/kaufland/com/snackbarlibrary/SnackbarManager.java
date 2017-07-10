package kaufland.com.snackbarlibrary;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import kaufland.com.snackbarlibrary.view.SnackbarView;

public class SnackbarManager {


    private SnackbarWrapper mSnackbarWrapper;

    private Queue<SnackbarView> mSnackbarViewsQueue;


    public SnackbarManager() {
        mSnackbarViewsQueue = new ArrayBlockingQueue<>(10);
    }
}
