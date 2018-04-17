package kaufland.com.snackbarlibrary.model;


import kaufland.com.snackbarlibrary.Snackbar;
import kaufland.com.snackbarlibrary.view.SnackbarView;

public class Message {

    private SnackbarView mSnackbarView;
    private Snackbar mSnackbar;

    public Message(SnackbarView view, Snackbar snackbar) {
        mSnackbarView = view;
        mSnackbar = snackbar;
    }

    public SnackbarView getSnackbarView() {
        return mSnackbarView;
    }

    public Snackbar getSnackbar() {
        return mSnackbar;
    }
}
