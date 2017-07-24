package kaufland.com.snackbarlibrary.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;


public class ViewUtils {

    public static int convertDpToPixel(Context context, int dp) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int px = dp * (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }
}
