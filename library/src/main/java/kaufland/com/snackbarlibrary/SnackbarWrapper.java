package kaufland.com.snackbarlibrary;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * Created by vkos2006 on 7/10/17.
 */

public class SnackbarWrapper {

    private final WindowManager windowManager;
    private final Context applicationContext;
    private FrameLayout rootLayout;


    public SnackbarWrapper(@NonNull final Context applicationContext)
    {
        this.applicationContext = applicationContext;
        this.windowManager = (WindowManager) applicationContext.getSystemService(Context.WINDOW_SERVICE);

    }


    private WindowManager.LayoutParams createDefaultLayoutParams(int type, @Nullable IBinder windowToken)
    {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = PixelFormat.TRANSLUCENT;
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = GravityCompat.getAbsoluteGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, ViewCompat.LAYOUT_DIRECTION_LTR);
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        layoutParams.type = type;
        layoutParams.token = windowToken;
        return layoutParams;
    }

    public void show(){

        WindowManager.LayoutParams layoutParams = createDefaultLayoutParams(WindowManager.LayoutParams.TYPE_TOAST,null);
        rootLayout = new FrameLayout(applicationContext){
            @Override
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                onRootViewAvailable(this);
            }
        };
        windowManager.addView(rootLayout,layoutParams);

    }

    private void onRootViewAvailable(final FrameLayout rootView) {

        final CoordinatorLayout snackbarContainer = new CoordinatorLayout(new ContextThemeWrapper(applicationContext, R.style.SnackbarTheme))
        {
            @Override
            public void onAttachedToWindow()
            {
                super.onAttachedToWindow();
                onSnackbarContainerAttached(rootView, this);
            }
        };
        windowManager.addView(snackbarContainer, createDefaultLayoutParams(WindowManager.LayoutParams.TYPE_APPLICATION_PANEL, rootView.getWindowToken()));
    }

    private void onSnackbarContainerAttached(FrameLayout rootView, CoordinatorLayout snackbarContainer) {
        
        
    }
    
    private boolean isWindowManagerActive(){
        return rootLayout!=null && rootLayout.getParent()!=null;
    }


}
