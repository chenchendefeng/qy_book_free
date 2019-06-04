package com.freebookqy.utilslib;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by  on 10/31/15.
 */
public final class StatusBarUtils {

    private static final String TAG = StatusBarUtils.class.getSimpleName();
    private final boolean lightStatusBar;
    //透明且背景不占用控件的statusbar，这里估且叫做沉浸
    private final boolean transparentStatusBar;
    private final boolean transparentNavigationbar;
    private final boolean actionBarOtherColor;
    private final Window window;
    private final View actionBarView;
    private final int current = Build.VERSION.SDK_INT;

    private static final int UNSTABLE_STATUS = View.SYSTEM_UI_FLAG_FULLSCREEN;
    private static final int UNSTABLE_NAV = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    private static final int STABLE_STATUS = View.SYSTEM_UI_FLAG_FULLSCREEN |
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    private static final int STABLE_NAV = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    private static final int EXPAND_STATUS = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
    private static final int EXPAND_NAV = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;


    private StatusBarUtils(Window window, boolean lightStatusBar, boolean transparentStatusBar, boolean transparentNavigationbar, View actionBarView, boolean actionBarOtherColor) {
        this.lightStatusBar = lightStatusBar;
        this.transparentStatusBar = transparentStatusBar;
        this.window = window;
        this.transparentNavigationbar = transparentNavigationbar;
        this.actionBarOtherColor = actionBarOtherColor;
        this.actionBarView = actionBarView;
    }

    public static void showUnStableStatusBar(Activity activity) {
        clearFlag(activity, UNSTABLE_STATUS);
    }

    public static void showUnStableNavBar(Activity activity) {
        clearFlag(activity, UNSTABLE_NAV);
    }

    public static void hideStableStatusBar(Activity activity) {
        //App全屏，隐藏StatusBar
        setFlag(activity, STABLE_STATUS);
    }

    public static void hideStableNavBar(Activity activity) {
        //App全屏，隐藏StatusBar
        setFlag(activity, STABLE_NAV);
    }

    public static void showStableNavBar(Activity activity) {
        clearFlag(activity, UNSTABLE_NAV);
    }


    /**
     * 显示隐藏状态栏，全屏不变，只在有全屏时有效
     *
     * @param enable
     */
    public static void setStatusBarVisibility(Activity activity, boolean enable) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        if (enable) {
            lp.flags |= WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN;
        } else {
            lp.flags &= (~WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        }
        activity.getWindow().setAttributes(lp);
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public static void setFlag(Activity activity, int flag) {
        if (Build.VERSION.SDK_INT >= 19) {
            View decorView = activity.getWindow().getDecorView();
            int option = decorView.getSystemUiVisibility() | flag;
            decorView.setSystemUiVisibility(option);
        }
    }

    //取消flag
    public static void clearFlag(Activity activity, int flag) {
        if (Build.VERSION.SDK_INT >= 19) {
            View decorView = activity.getWindow().getDecorView();
            int option = decorView.getSystemUiVisibility() & (~flag);
            decorView.setSystemUiVisibility(option);
        }
    }


    /**
     * 设置是否全屏
     *
     * @param enable
     */
    public static void setFullScreen(Activity activity, boolean enable) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        if (enable) {
            lp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        } else {
            lp.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        activity.getWindow().setAttributes(lp);
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    /**
     * 获取虚拟按键的高度
     *
     * @return
     */
    public static int getNavigationBarHeight() {
        int navigationBarHeight = 0;
        Resources rs = Utils.INSTANCE.getApp().getResources();
        int id = rs.getIdentifier("navigation_bar_height", "dimen", "android");
        if (id > 0 && hasNavigationBar()) {
            navigationBarHeight = rs.getDimensionPixelSize(id);
        }
        return navigationBarHeight;
    }

    /**
     * 是否存在虚拟按键
     *
     * @return
     */
    private static boolean hasNavigationBar() {
        boolean hasNavigationBar = false;
        Resources rs = Utils.INSTANCE.getApp().getResources();
        int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            hasNavigationBar = rs.getBoolean(id);
        }
        try {
            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                hasNavigationBar = false;
            } else if ("0".equals(navBarOverride)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {
        }
        return hasNavigationBar;
    }


    public static boolean hasNotchInScreen(Context context) {
        boolean ret = false;
        try {
            ClassLoader cl = context.getClassLoader();
            Class HwNotchSizeUtil = cl.loadClass("com.huawei.android.util.HwNotchSizeUtil");
            Method get = HwNotchSizeUtil.getMethod("hasNotchInScreen");
            ret = (boolean) get.invoke(HwNotchSizeUtil);
        } catch (ClassNotFoundException e) {
            Log.e("test", "hasNotchInScreen ClassNotFoundException");
        } catch (NoSuchMethodException e) {
            Log.e("test", "hasNotchInScreen NoSuchMethodException");
        } catch (Exception e) {
            Log.e("test", "hasNotchInScreen Exception");
        } finally {
            return ret;
        }
    }

    public static int[] getNotchSize(Context context) {
        int[] ret = new int[]{0, 0};
        try {
            ClassLoader cl = context.getClassLoader();
            Class HwNotchSizeUtil = cl.loadClass("com.huawei.android.util.HwNotchSizeUtil");
            Method get = HwNotchSizeUtil.getMethod("getNotchSize");
            ret = (int[]) get.invoke(HwNotchSizeUtil);
        } catch (ClassNotFoundException e) {
            Log.e("test", "getNotchSize ClassNotFoundException");
        } catch (NoSuchMethodException e) {
            Log.e("test", "getNotchSize NoSuchMethodException");
        } catch (Exception e) {
            Log.e("test", "getNotchSize Exception");
        } finally {
            return ret;
        }
    }

    public static final int VIVO_NOTCH = 0x00000020;//是否有刘海
    public static final int VIVO_FILLET = 0x00000008;//是否有圆角

    /**
     * vivo的刘海宽为100dp,高为27dp。
     * @param context
     * @return
     */
    public static boolean hasNotchAtVivo(Context context) {
        boolean ret = false;
        try {
            ClassLoader classLoader = context.getClassLoader();
            Class FtFeature = classLoader.loadClass("android.util.FtFeature");
            Method method = FtFeature.getMethod("isFeatureSupport", int.class);
            ret = (boolean) method.invoke(FtFeature, VIVO_NOTCH);
        } catch (ClassNotFoundException e) {
            Log.e("Notch", "hasNotchAtVivo ClassNotFoundException");
        } catch (NoSuchMethodException e) {
            Log.e("Notch", "hasNotchAtVivo NoSuchMethodException");
        } catch (Exception e) {
            Log.e("Notch", "hasNotchAtVivo Exception");
        } finally {
            return ret;
        }
    }

    public static boolean hasNotchAtOPPO(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }







    public static boolean isLessOrEqualKitkat() {
        return Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT;
    }

    public static Builder from(Activity activity) {
        return new Builder().setWindow(activity);
    }

    public static Builder from(Dialog dialog) {
        return new Builder().setWindow(dialog);
    }

    public static Builder from(Window window) {
        return new Builder().setWindow(window);
    }

    /**
     * Default status dp = 24 or 25
     * mhdpi = dp * 1
     * hdpi = dp * 1.5
     * xhdpi = dp * 2
     * xxhdpi = dp * 3
     * eg : 1920x1080, xxhdpi, => status/all = 25/640(dp) = 75/1080(px)
     * <p>
     * don't forget toolbar's dp = 48
     *
     * @return px
     */
    @IntRange(from = 0, to = 75)
    public static int getStatusBarOffsetPx(Context context) {
        if (isLessOrEqualKitkat()) {
            return 0;
        }
        Context appContext = context.getApplicationContext();
        int result = 0;
        int resourceId = appContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = appContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @IntRange(from = 0, to = 75)
    public static int getNavigationBarOffsetPx(Context context) {
        if (isLessOrEqualKitkat()) {
            return 0;
        }
        Context appContext = context.getApplicationContext();
        int result = 0;
        int resourceId = appContext.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = appContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void processActionBar(final View v) {
        if (v == null || !transparentStatusBar || isLessOrEqualKitkat()) {
            return;
        }
        v.post(new Runnable() {
            @Override
            public void run() {
                v.setPadding(v.getPaddingLeft(), v.getPaddingTop() + getStatusBarOffsetPx(v.getContext()), v.getPaddingRight(), v.getPaddingBottom());
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                if (!actionBarOtherColor) {
                    v.setBackgroundColor(Color.WHITE);
                }
                float dimension = v.getContext().getResources().getDimension(R.dimen.utils_title_bar_height);
                layoutParams.height = (int) (dimension + getStatusBarOffsetPx(v.getContext()));
                v.setLayoutParams(layoutParams);
            }
        });
    }

    /**
     * 调用私有API处理颜色
     */
    private void processPrivateAPI() {
        try {
            processFlyMe(lightStatusBar);
        } catch (Exception e) {
            try {
                processMIUI(lightStatusBar);
            } catch (Exception e2) {
                //
            }
        }
    }

    private void process() {
        if (isLessOrEqualKitkat()) {
            return;
        }
        //调用私有API处理颜色
        processPrivateAPI();
        processActionBar(actionBarView);
        //处理4.4~5.0沉浸
        if (current >= Build.VERSION_CODES.KITKAT && current < Build.VERSION_CODES.M) {
            processKitkat();
        } else if (current >= Build.VERSION_CODES.M) {
            processM();
        }
    }

    /**
     * 处理4.4沉浸
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void processKitkat() {
        WindowManager.LayoutParams winParams = window.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (transparentStatusBar) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        window.setAttributes(winParams);
    }

    /**
     * 改变小米的状态栏字体颜色为黑色, 要求MIUI6以上
     * Tested on: MIUIV7 5.0 Redmi-Note3
     */
    private void processMIUI(boolean lightStatusBar) throws Exception {
        Class<? extends Window> clazz = window.getClass();
        int darkModeFlag;
        Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
        Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
        darkModeFlag = field.getInt(layoutParams);
        Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
        extraFlagField.invoke(window, lightStatusBar ? darkModeFlag : 0, darkModeFlag);
    }

    /**
     * 改变魅族的状态栏字体为黑色，要求FlyMe4以上
     */
    private void processFlyMe(boolean isLightStatusBar) throws Exception {
        WindowManager.LayoutParams lp = window.getAttributes();
        Class<?> instance = Class.forName("android.view.WindowManager$LayoutParams");
        int value = instance.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON").getInt(lp);
        Field field = instance.getDeclaredField("meizuFlags");
        field.setAccessible(true);
        int origin = field.getInt(lp);
        if (isLightStatusBar) {
            field.set(lp, origin | value);
        } else {
            field.set(lp, (~value) & origin);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void processM() {
        if (current < Build.VERSION_CODES.M) {
            return;
        }
        int flag = window.getDecorView().getSystemUiVisibility();
        if (lightStatusBar) {
            /**
             * 改变字体颜色
             * see {@link <a href="https://developer.android.com/reference/android/R.attr.html#windowLightStatusBar"></a>}
             */
            flag |= (WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {
            flag |= (WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            flag &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            flag |= (WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
        if (transparentStatusBar) {
            flag |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        if (transparentNavigationbar) {
            flag |= (View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
        window.getDecorView().setSystemUiVisibility(flag);
    }

    final public static class Builder {
        private Window window;
        private boolean lightStatusBar = false;
        private boolean transparentStatusbar = false;
        private boolean transparentNavigationbar = false;
        private boolean actionBarOtherColor = true;//是否要把title变成主色调以外的颜色
        private View actionBarView;

        public Builder setActionbarView(@Nullable View actionbarView) {
            this.actionBarView = actionbarView;
            return this;
        }

        private Builder setWindow(@NonNull Window Window) {
            this.window = Window;
            return this;
        }

        private Builder setWindow(@NonNull Activity activity) {
            this.window = activity.getWindow();
            return this;
        }

        private Builder setWindow(@NonNull Dialog dialog) {
            this.window = dialog.getWindow();
            return this;
        }

        public Builder setLightStatusBar(boolean lightStatusBar) {
            this.lightStatusBar = lightStatusBar;
            return this;
        }

        public Builder setTransparentStatusbar(boolean transparentStatusbar) {
            this.transparentStatusbar = transparentStatusbar;
            return this;
        }

        public Builder setActionBarOtherColor(boolean actionBarOtherColor) {
            this.actionBarOtherColor = actionBarOtherColor;
            return this;
        }

        public Builder setTransparentNavigationbar(boolean transparentNavigationbar) {
            this.transparentNavigationbar = transparentNavigationbar;
            return this;
        }

        public void process() {
            new StatusBarUtils(window, lightStatusBar, transparentStatusbar, transparentNavigationbar, actionBarView, actionBarOtherColor).process();
        }
    }


}