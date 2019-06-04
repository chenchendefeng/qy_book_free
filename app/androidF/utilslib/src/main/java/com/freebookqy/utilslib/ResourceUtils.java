package com.freebookqy.utilslib;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.*;

public class ResourceUtils {


    @DrawableRes
    public static int getDrawableId(Context context, String name) {
        Resources res = context.getResources();
        return res.getIdentifier(name, "drawable", context.getPackageName());
    }

    @LayoutRes
    public static int getLayoutId(Context context, String name) {
        Resources res = context.getResources();
        return res.getIdentifier(name, "layout", context.getPackageName());
    }

    @StringRes
    public static int getStringsId(Context context, String name) {
        Resources res = context.getResources();
        return res.getIdentifier(name, "string", context.getPackageName());
    }

    public static int getMipmapsId(Context context, String name) {
        Resources res = context.getResources();
        return res.getIdentifier(name, "mipmap", context.getPackageName());
    }


    @ColorRes
    public static int getColorId(Context context, String name) {
        Resources res = context.getResources();
        return res.getIdentifier(name, "color", context.getPackageName());
    }

    @ColorInt
    public static int getColor(Context context, int colorRes) {
        return context.getResources().getColor(colorRes);
    }

    @RawRes
    public static int getRawId(Context context, String name) {
        Resources res = context.getResources();
        return res.getIdentifier(name, "raw", context.getPackageName());
    }

    @AnimRes
    public static int getAnimId(Context context, String name) {
        Resources res = context.getResources();
        return res.getIdentifier(name, "anim", context.getPackageName());
    }

    @StyleRes
    public static int getStyleId(Context context, String name) {
        Resources res = context.getResources();
        return res.getIdentifier(name, "style", context.getPackageName());
    }

    @StyleableRes
    public static int getStyleableId(Context context, String name) {
        Resources res = context.getResources();
        return res.getIdentifier(name, "styleable", context.getPackageName());
    }

    @AttrRes
    public static int getAttrId(Context context, String name) {
        Resources res = context.getResources();
        return res.getIdentifier(name, "attr", context.getPackageName());
    }

    @ArrayRes
    public static int getArrayId(Context context, String name) {
        Resources res = context.getResources();
        return res.getIdentifier(name, "array", context.getPackageName());
    }

    public static String getString(Context context, int stringRes) {
        String string = context.getString(stringRes);
        return string;
    }

    public static String getString(Context context, int StringRes, Object... objects) {
        String s = context.getString(StringRes, objects);
        return s;
    }

    public static float getDimen(Context context, @DimenRes int dimenRes) {
        return context.getResources().getDimensionPixelSize(dimenRes);
    }


}
