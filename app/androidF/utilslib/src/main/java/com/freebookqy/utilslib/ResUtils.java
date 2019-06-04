package com.freebookqy.utilslib;

import android.content.res.Resources;
import android.support.annotation.*;

public class ResUtils {


    @DrawableRes
    public static int getDrawableId(String name) {
        Resources res = Utils.INSTANCE.getApp().getResources();
        return res.getIdentifier(name, "drawable", Utils.INSTANCE.getApp().getPackageName());
    }

    @LayoutRes
    public static int getLayoutId( String name) {
        Resources res = Utils.INSTANCE.getApp().getResources();
        return res.getIdentifier(name, "layout", Utils.INSTANCE.getApp().getPackageName());
    }

    @StringRes
    public static int getStringsId( String name) {
        Resources res = Utils.INSTANCE.getApp().getResources();
        return res.getIdentifier(name, "string", Utils.INSTANCE.getApp().getPackageName());
    }

    public static int getMipmapsId( String name) {
        Resources res = Utils.INSTANCE.getApp().getResources();
        return res.getIdentifier(name, "mipmap", Utils.INSTANCE.getApp().getPackageName());
    }


    @ColorRes
    public static int getColorId(String name) {
        Resources res = Utils.INSTANCE.getApp().getResources();
        return res.getIdentifier(name, "color", Utils.INSTANCE.getApp().getPackageName());
    }

    @ColorInt
    public static int getColor(int colorRes) {
        return Utils.INSTANCE.getApp().getResources().getColor(colorRes);
    }

    @RawRes
    public static int getRawId( String name) {
        Resources res = Utils.INSTANCE.getApp().getResources();
        return res.getIdentifier(name, "raw", Utils.INSTANCE.getApp().getPackageName());
    }

    @AnimRes
    public static int getAnimId(String name) {
        Resources res = Utils.INSTANCE.getApp().getResources();
        return res.getIdentifier(name, "anim", Utils.INSTANCE.getApp().getPackageName());
    }

    @StyleRes
    public static int getStyleId( String name) {
        Resources res = Utils.INSTANCE.getApp().getResources();
        return res.getIdentifier(name, "style", Utils.INSTANCE.getApp().getPackageName());
    }

    @StyleableRes
    public static int getStyleableId( String name) {
        Resources res = Utils.INSTANCE.getApp().getResources();
        return res.getIdentifier(name, "styleable", Utils.INSTANCE.getApp().getPackageName());
    }

    @AttrRes
    public static int getAttrId( String name) {
        Resources res = Utils.INSTANCE.getApp().getResources();
        return res.getIdentifier(name, "attr", Utils.INSTANCE.getApp().getPackageName());
    }

    @ArrayRes
    public static int getArrayId( String name) {
        Resources res = Utils.INSTANCE.getApp().getResources();
        return res.getIdentifier(name, "array", Utils.INSTANCE.getApp().getPackageName());
    }

    public static String getString( int stringRes) {
        String string = Utils.INSTANCE.getApp().getString(stringRes);
        return string;
    }

    public static String getString( int StringRes, Object... objects) {
        String s = Utils.INSTANCE.getApp().getString(StringRes, objects);
        return s;
    }

    public static float getDimen( @DimenRes int dimenRes) {
        return Utils.INSTANCE.getApp().getResources().getDimensionPixelSize(dimenRes);
    }


}
