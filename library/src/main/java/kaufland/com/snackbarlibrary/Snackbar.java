package kaufland.com.snackbarlibrary;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import kaufland.com.snackbarlibrary.view.SnackbarAdapter;
import kaufland.com.snackbarlibrary.view.SnackbarView;


public class Snackbar {

    private FrameLayout rootLayout;
    private WindowManager windowManager;
    private Context applicationContext;
    private LayoutInflater inflater;
    private RecyclerView snackbarRecycler;
    private SnackbarAdapter snackbarAdapter;
    private SnackbarConfiguration snackbarConfiguration;


    public Snackbar(@NonNull final Context applicationContext, SnackbarConfiguration configuration) {
        this.applicationContext = applicationContext;
        this.snackbarConfiguration = configuration;
        this.windowManager = (WindowManager) applicationContext.getSystemService(Context.WINDOW_SERVICE);
        inflater = (LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        snackbarAdapter = new SnackbarAdapter();

    }


    private WindowManager.LayoutParams createDefaultLayoutParams(int type, @Nullable IBinder windowToken) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = PixelFormat.TRANSLUCENT;
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        int gravity = snackbarConfiguration.getGravity().equals(SnackbarConfiguration.Gravity.GRAVITY_TOP) ? Gravity.TOP : Gravity.BOTTOM;
        layoutParams.gravity = GravityCompat.getAbsoluteGravity(gravity, ViewCompat.LAYOUT_DIRECTION_LTR);
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        layoutParams.token = windowToken;
        layoutParams.type = type;
        return layoutParams;
    }

    public void show() {

        if (rootLayout == null) {
            WindowManager.LayoutParams layoutParams = createDefaultLayoutParams(WindowManager.LayoutParams.TYPE_TOAST, null);
            rootLayout = new FrameLayout(applicationContext) {
                @Override
                protected void onAttachedToWindow() {
                    super.onAttachedToWindow();
                    onRootViewAvailable(this);
                }
            };
            windowManager.addView(rootLayout, layoutParams);
        }
    }

    private void onRootViewAvailable(final FrameLayout rootView) {

        View recyclerParent = inflater.from(rootView.getContext()).inflate(R.layout.view_snackbar, null);
        snackbarRecycler = (RecyclerView) recyclerParent.findViewById(R.id.snackbar_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(rootView.getContext());
        snackbarRecycler.setLayoutManager(manager);
        rootView.addView(recyclerParent, snackbarRecycler.getLayoutParams());
        snackbarRecycler.setAdapter(snackbarAdapter);
    }

    public void addSnackbarView(SnackbarView snackbarView) {
        if (snackbarView != null) {
            show();
            snackbarAdapter.addItem(snackbarView);
        }
    }

    public void removeSnackbarView(SnackbarView snackbarView) {

        if (snackbarView != null) {
            snackbarAdapter.removeItem(snackbarView);
        }

        if(snackbarAdapter.isEmpty()){
            windowManager.removeView(rootLayout);
            rootLayout=null;
        }
    }
}
