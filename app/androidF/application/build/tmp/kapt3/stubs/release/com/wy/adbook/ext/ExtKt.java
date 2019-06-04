package com.wy.adbook.ext;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u001a$\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u00012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014\u001a\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019\u001a\n\u0010\u001a\u001a\u00020\u001b*\u00020\u0019\u001a\n\u0010\u001c\u001a\u00020\u001d*\u00020\u0019\u001a\u0014\u0010\u001e\u001a\u00020\r*\u00020\u001f2\b\b\u0001\u0010\u0012\u001a\u00020\u0001\u001a\n\u0010 \u001a\u00020\r*\u00020!\u001a\n\u0010\"\u001a\u00020\r*\u00020\u001b\u001a\n\u0010\"\u001a\u00020\r*\u00020#\u001a\u0014\u0010$\u001a\u00020\u0011*\u00020\u00192\b\b\u0001\u0010%\u001a\u00020\u0001\u001a\u001c\u0010$\u001a\u00020\u0011*\u00020\u00192\b\b\u0001\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\'\u001a!\u0010(\u001a\u00020\r\"\b\b\u0000\u0010)*\u00020**\u00020\u001f2\u0006\u0010+\u001a\u0002H)\u00a2\u0006\u0002\u0010,\u001a\u0012\u0010(\u001a\u00020\r*\u00020\u001f2\u0006\u0010-\u001a\u00020\u0016\u001a\u001a\u0010(\u001a\u00020\r*\u00020\u001f2\u0006\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0001\u001a&\u0010(\u001a\u00020\r*\u00020\u001f2\u0006\u0010-\u001a\u00020\u00162\b\b\u0002\u0010.\u001a\u00020\u00012\b\b\u0002\u0010/\u001a\u000200\u001a\u001a\u00101\u001a\u00020\r*\u00020\u001f2\u0006\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0001\u001a\u001a\u00102\u001a\u00020\u0011*\u00020\u00112\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014\u001a\u0012\u00102\u001a\u00020\u0011*\u00020\u00112\u0006\u00103\u001a\u000204\u001a\u0012\u00105\u001a\u00020\r*\u00020#2\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0012\u00105\u001a\u00020\r*\u0002062\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0012\u00107\u001a\u00020\r*\u00020\u001b2\u0006\u00108\u001a\u000209\u001a\n\u0010:\u001a\u00020\u0001*\u00020\u0016\u001a\u0012\u0010;\u001a\u00020\u0011*\u00020\u00112\u0006\u0010<\u001a\u000200\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0003\"\u0015\u0010\n\u001a\u00020\u0005*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007\"\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0003\u00a8\u0006="}, d2 = {"dip2Px", "", "getDip2Px", "(I)I", "px", "", "getPx", "(F)F", "px2sp", "getPx2sp", "sp", "getSp", "dismissDialog", "", "dialog", "Landroid/support/v4/app/DialogFragment;", "bindClick", "Landroid/view/View;", "id", "method", "Lkotlin/Function0;", "getRealFilePath", "", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "getTopActivity", "Landroid/app/Activity;", "getYangYanComponent", "Lcom/wy/adbook/di/component/QYComponent;", "gif", "Landroid/widget/ImageView;", "glideScroll", "Landroid/support/v7/widget/RecyclerView;", "hideKeyboard", "Landroid/support/v4/app/Fragment;", "inflate", "layoutRes", "vg", "Landroid/view/ViewGroup;", "loadImage", "T", "Lcom/jess/arms/http/imageloader/ImageConfig;", "config", "(Landroid/widget/ImageView;Lcom/jess/arms/http/imageloader/ImageConfig;)V", "url", "placeholder", "isCenterCrop", "", "loadImageCircle", "onClick", "listener", "Landroid/view/View$OnClickListener;", "showDialog", "Landroid/support/v7/app/AppCompatActivity;", "showKeyboard", "editText", "Landroid/widget/EditText;", "toIntS", "visible", "isVisible", "application_release"})
public final class ExtKt {
    
    public static final float getPx(float $receiver) {
        return 0.0F;
    }
    
    public static final float getSp(float $receiver) {
        return 0.0F;
    }
    
    public static final int getPx(int $receiver) {
        return 0;
    }
    
    public static final int getSp(int $receiver) {
        return 0;
    }
    
    public static final int getDip2Px(int $receiver) {
        return 0;
    }
    
    public static final int getPx2sp(int $receiver) {
        return 0;
    }
    
    public static final int toIntS(@org.jetbrains.annotations.NotNull()
    java.lang.String $receiver) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.view.View inflate(@org.jetbrains.annotations.NotNull()
    android.content.Context $receiver, @android.support.annotation.LayoutRes()
    int layoutRes) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.view.View inflate(@org.jetbrains.annotations.NotNull()
    android.content.Context $receiver, @android.support.annotation.LayoutRes()
    int layoutRes, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup vg) {
        return null;
    }
    
    /**
     * * 点击事件扩展方法
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.view.View onClick(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> method) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.view.View bindClick(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver, @android.support.annotation.IdRes()
    int id, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> method) {
        return null;
    }
    
    /**
     * * 点击事件扩展方法
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.view.View onClick(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver, @org.jetbrains.annotations.NotNull()
    android.view.View.OnClickListener listener) {
        return null;
    }
    
    /**
     * * 设置View的可见
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.view.View visible(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver, boolean isVisible) {
        return null;
    }
    
    public static final void showDialog(@org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity $receiver, @org.jetbrains.annotations.NotNull()
    android.support.v4.app.DialogFragment dialog) {
    }
    
    public static final void showDialog(@org.jetbrains.annotations.NotNull()
    android.support.v4.app.Fragment $receiver, @org.jetbrains.annotations.NotNull()
    android.support.v4.app.DialogFragment dialog) {
    }
    
    public static final void dismissDialog(@org.jetbrains.annotations.NotNull()
    android.support.v4.app.DialogFragment dialog) {
    }
    
    /**
     * *
     */
    public static final <T extends com.jess.arms.http.imageloader.ImageConfig>void loadImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $receiver, @org.jetbrains.annotations.NotNull()
    T config) {
    }
    
    public static final void loadImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $receiver, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    public static final void loadImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $receiver, @org.jetbrains.annotations.NotNull()
    java.lang.String url, int placeholder) {
    }
    
    public static final void loadImageCircle(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $receiver, @org.jetbrains.annotations.NotNull()
    java.lang.String url, int placeholder) {
    }
    
    public static final void loadImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $receiver, @org.jetbrains.annotations.NotNull()
    java.lang.String url, int placeholder, boolean isCenterCrop) {
    }
    
    public static final void gif(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $receiver, @android.support.annotation.DrawableRes()
    int id) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.app.Activity getTopActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context $receiver) {
        return null;
    }
    
    /**
     * * 通过uri  获取文件的路径
     */
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getRealFilePath(@org.jetbrains.annotations.NotNull()
    android.net.Uri $receiver, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.wy.adbook.di.component.QYComponent getYangYanComponent(@org.jetbrains.annotations.NotNull()
    android.content.Context $receiver) {
        return null;
    }
    
    public static final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    android.support.v4.app.Fragment $receiver) {
    }
    
    public static final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    android.app.Activity $receiver) {
    }
    
    public static final void showKeyboard(@org.jetbrains.annotations.NotNull()
    android.app.Activity $receiver, @org.jetbrains.annotations.NotNull()
    android.widget.EditText editText) {
    }
    
    public static final void glideScroll(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView $receiver) {
    }
}