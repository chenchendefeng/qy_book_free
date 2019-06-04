package com.wy.adbook.app.base;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\tH&\u00a8\u0006\u000f"}, d2 = {"Lcom/wy/adbook/app/base/QYView;", "Lcom/jess/arms/mvp/IView;", "finish", "", "getContext", "Landroid/content/Context;", "hideLoading", "showError", "str", "", "showLoading", "showMessage", "msg", "showSuccess", "success", "application_debug"})
public abstract interface QYView extends com.jess.arms.mvp.IView {
    
    @org.jetbrains.annotations.NotNull()
    public abstract android.content.Context getContext();
    
    public abstract void finish();
    
    public abstract void showLoading(@org.jetbrains.annotations.NotNull()
    java.lang.String str);
    
    public abstract void showError(@org.jetbrains.annotations.NotNull()
    java.lang.String str);
    
    public abstract void showSuccess(@org.jetbrains.annotations.NotNull()
    java.lang.String success);
    
    @java.lang.Override()
    public abstract void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String msg);
    
    /**
     * * 显示加载
     */
    @java.lang.Override()
    public abstract void showLoading();
    
    /**
     * * 隐藏加载
     */
    @java.lang.Override()
    public abstract void hideLoading();
}