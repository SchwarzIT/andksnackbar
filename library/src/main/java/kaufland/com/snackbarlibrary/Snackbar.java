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

/**
 * Created by vkos2006 on 7/10/17.
 */

public class Snackbar {

    private final WindowManager windowManager;
    private final Context applicationContext;
    private SnackbarView snackbarView;
    private LayoutInflater inflater;
    private RecyclerView snackbarRecycler;
    private SnackbarAdapter snackbarAdapter;



    private Snackbar(@NonNull final Context applicationContext, SnackbarView snackbarView)
    {
        this.applicationContext = applicationContext;
        this.windowManager = (WindowManager) applicationContext.getSystemService(Context.WINDOW_SERVICE);
        this.snackbarView=snackbarView;
        inflater = (LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        snackbarAdapter = new SnackbarAdapter();

    }

    public static Snackbar make(@NonNull final Context applicationContext, SnackbarView snackbarView){
        return new Snackbar(applicationContext,snackbarView);
    }


    private WindowManager.LayoutParams createDefaultLayoutParams(int type,@Nullable IBinder windowToken)
    {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = PixelFormat.TRANSLUCENT;
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = GravityCompat.getAbsoluteGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP, ViewCompat.LAYOUT_DIRECTION_LTR);
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        layoutParams.token = windowToken;
        layoutParams.type=type;
        return layoutParams;
    }

    public void show(){

        WindowManager.LayoutParams layoutParams = createDefaultLayoutParams(WindowManager.LayoutParams.TYPE_APPLICATION,null);
        FrameLayout rootLayout = new FrameLayout(applicationContext){
            @Override
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                onRootViewAvailable(this);
            }
        };
        windowManager.addView(rootLayout,layoutParams);

    }

    private void onRootViewAvailable(final FrameLayout rootView) {

        View recyclerParent = inflater.from(rootView.getContext()).inflate(R.layout.view_snackbar,null);
        snackbarRecycler= (RecyclerView) recyclerParent.findViewById(R.id.snackbar_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(rootView.getContext());
        snackbarRecycler.setLayoutManager(manager);
        rootView.addView(recyclerParent,snackbarRecycler.getLayoutParams());
        snackbarRecycler.setAdapter(snackbarAdapter);
        snackbarAdapter.addItem(snackbarView);
    }

    public void addSnackbar(SnackbarView view) {
        snackbarAdapter.addItem(view);
    }
}
