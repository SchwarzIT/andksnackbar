package kaufland.com.snackbarlibrary;

import android.content.Context;
import android.graphics.PixelFormat;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import java.lang.ref.WeakReference;

import kaufland.com.snackbarlibrary.utils.SwipeToDeleteCallback;
import kaufland.com.snackbarlibrary.view.SnackbarAdapter;
import kaufland.com.snackbarlibrary.view.SnackbarView;


public class Snackbar {

    private static final String TAG = Snackbar.class.getName();

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

        if (mContext == null) {
            Log.e(TAG, "context=null did you missed to call SnackbarManager.rebindContext?");
            return;
        }

        if (mRootLayout == null || !mContext.equals(mRootLayout.getContext())) {
            WindowManager.LayoutParams layoutParams = createDefaultLayoutParams();
            mRootLayout = new KFrameLayout(mContext, this);

            try {
                mWindowManager.addView(mRootLayout, layoutParams);
            } catch (WindowManager.BadTokenException e) {
                Log.d("exception", e.getMessage());
                //can happen if activity changed and method is called before updateContext was called
            }
        }
    }

    private static class KFrameLayout extends FrameLayout {

        private WeakReference<Snackbar> mReference;

        public KFrameLayout(@NonNull Context context, Snackbar snackbar) {
            super(context);
            mReference = new WeakReference<>(snackbar);
        }

        @Override
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (mReference.get() != null) {
                mReference.get().onRootViewAvailable(this);
            }
        }
    }

    private void onRootViewAvailable(final FrameLayout rootView) {

        View recyclerParent = mInflater.from(rootView.getContext()).inflate(R.layout.view_snackbar, null);
        mSnackbarRecycler = recyclerParent.findViewById(R.id.snackbar_recycler);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteCallback() {

            @Override
            public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

                SnackbarView snackbarView = mSnackbarAdapter.getSnackbarView(viewHolder.getAdapterPosition());
                if (snackbarView == null || !snackbarView.isSwipeToDismiss()) {
                    return 0;
                }

                return super.getSwipeDirs(recyclerView, viewHolder);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                SnackbarView snackbarView = mSnackbarAdapter.getSnackbarView(viewHolder.getAdapterPosition());
                if (snackbarView != null) {
                    snackbarView.getCallback().onDismiss();
                }
            }
        });

        itemTouchHelper.attachToRecyclerView(mSnackbarRecycler);

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
            snackbarView.onDismissed();
        }

        if (mSnackbarAdapter.isEmpty()) {
            removeViewFromWindowManager();
            mRootLayout = null;
        }
    }

    public void updateContext(Context context) {
        removeViewFromWindowManager();
        mRootLayout = null;
        mContext = context;
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private void removeViewFromWindowManager() {
        if (mRootLayout != null && mWindowManager != null) {
            try {
                ((RecyclerView)mRootLayout.findViewById(R.id.snackbar_recycler)).setAdapter(null);
                mWindowManager.removeViewImmediate(mRootLayout);
            } catch (WindowManager.BadTokenException | IllegalArgumentException e) {
                Log.d(TAG, e.getMessage());
                //can happen if activity changed and method is called before updateContext was called
            }
        }
    }

    public void verifyVisible() {
        if (mRootLayout == null || mRootLayout.getParent() == null) {
            removeViewFromWindowManager();
            mRootLayout = null;
            show();
        }
    }
}
