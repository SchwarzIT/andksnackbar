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

    private FrameLayout mRootLayout;
    private WindowManager mWindowManager;
    private Context mApplicationContext;
    private LayoutInflater mInflater;
    private RecyclerView mSnackbarRecycler;
    private SnackbarAdapter mSnackbarAdapter;
    private SnackbarConfiguration mSnackbarConfiguration;


    public Snackbar(@NonNull final Context applicationContext, @NonNull SnackbarConfiguration configuration) {
        mApplicationContext = applicationContext;
        mSnackbarConfiguration = configuration;
        mWindowManager = (WindowManager) applicationContext.getSystemService(Context.WINDOW_SERVICE);
        mInflater = (LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mSnackbarAdapter = new SnackbarAdapter();

    }


    private WindowManager.LayoutParams createDefaultLayoutParams(int type, @Nullable IBinder windowToken) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = PixelFormat.TRANSLUCENT;
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        int gravity = mSnackbarConfiguration.getGravity().equals(SnackbarConfiguration.Gravity.GRAVITY_TOP) ? Gravity.TOP : Gravity.BOTTOM;
        layoutParams.gravity = GravityCompat.getAbsoluteGravity(gravity, ViewCompat.LAYOUT_DIRECTION_LTR);
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        layoutParams.token = windowToken;
        layoutParams.type = type;
        return layoutParams;
    }

    public void show() {

        if (mRootLayout == null) {
            WindowManager.LayoutParams layoutParams = createDefaultLayoutParams(WindowManager.LayoutParams.TYPE_TOAST, null);
            mRootLayout = new FrameLayout(mApplicationContext) {
                @Override
                protected void onAttachedToWindow() {
                    super.onAttachedToWindow();
                    onRootViewAvailable(this);
                }
            };
            mWindowManager.addView(mRootLayout, layoutParams);
        }
    }

    private void onRootViewAvailable(final FrameLayout rootView) {

        View recyclerParent = mInflater.from(rootView.getContext()).inflate(R.layout.view_snackbar, null);
        mSnackbarRecycler = (RecyclerView) recyclerParent.findViewById(R.id.snackbar_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(rootView.getContext());
        mSnackbarRecycler.setLayoutManager(manager);
        rootView.addView(recyclerParent, mSnackbarRecycler.getLayoutParams());
        mSnackbarRecycler.setAdapter(mSnackbarAdapter);
    }

    public void addSnackbarView(SnackbarView snackbarView) {
        if (snackbarView != null) {
            show();
            mSnackbarAdapter.addItem(snackbarView);
        }
    }

    public void removeSnackbarView(SnackbarView snackbarView) {

        if (snackbarView != null) {
            mSnackbarAdapter.removeItem(snackbarView);
        }

        if (mSnackbarAdapter.isEmpty()) {
            mWindowManager.removeView(mRootLayout);
            mRootLayout = null;
        }
    }
}
