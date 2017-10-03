package kaufland.com.snackbarlibrary;

import android.content.Context;
import android.graphics.PixelFormat;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private Context mContext;
    private LayoutInflater mInflater;
    private RecyclerView mSnackbarRecycler;
    private SnackbarAdapter mSnackbarAdapter;
    private SnackbarConfiguration mSnackbarConfiguration;


    public Snackbar(@NonNull SnackbarConfiguration configuration) {
        mSnackbarConfiguration = configuration;
        mSnackbarAdapter = new SnackbarAdapter();
    }


    private WindowManager.LayoutParams createDefaultLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = PixelFormat.TRANSLUCENT;
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        int gravity = mSnackbarConfiguration.getGravity().equals(SnackbarConfiguration.Gravity.GRAVITY_TOP) ? Gravity.TOP : Gravity.BOTTOM;
        layoutParams.gravity = GravityCompat.getAbsoluteGravity(gravity, ViewCompat.LAYOUT_DIRECTION_LTR);
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_LAYOUT_IN_OVERSCAN;
        return layoutParams;
    }

    public void show() {

        if (mRootLayout == null || !mContext.equals(mRootLayout.getContext())) {
            WindowManager.LayoutParams layoutParams = createDefaultLayoutParams();
            mRootLayout = new FrameLayout(mContext) {
                @Override
                protected void onAttachedToWindow() {
                    super.onAttachedToWindow();
                    onRootViewAvailable(this);
                }
            };

            try {
                mWindowManager.addView(mRootLayout, layoutParams);
            } catch (WindowManager.BadTokenException e) {
                Log.d("exception",e.getMessage());
                //can happen if activity changed and method is called before updateContext was called
            }
        }
    }

    private void onRootViewAvailable(final FrameLayout rootView) {

        View recyclerParent = mInflater.from(rootView.getContext()).inflate(R.layout.view_snackbar, null);
        mSnackbarRecycler = recyclerParent.findViewById(R.id.snackbar_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(rootView.getContext());
        mSnackbarRecycler.setLayoutManager(manager);
        rootView.addView(recyclerParent, mSnackbarRecycler.getLayoutParams());
        mSnackbarRecycler.setAdapter(mSnackbarAdapter);
        mSnackbarAdapter.notifyDataSetChanged();
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
            try {
                mWindowManager.removeView(mRootLayout);
            } catch (WindowManager.BadTokenException | IllegalArgumentException e) {
                Log.d("exception",e.getMessage());
                //can happen if activity changed and method is called before updateContext was called
            }

            mRootLayout = null;
        }
    }

    public void updateContext(Context context) {
        mContext = context;
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(mRootLayout!=null && mWindowManager!=null){
            mWindowManager.removeView(mRootLayout);
        }
    }
}
