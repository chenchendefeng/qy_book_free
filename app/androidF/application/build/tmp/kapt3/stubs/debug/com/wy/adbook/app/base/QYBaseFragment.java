package com.wy.adbook.app.base;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0004J\u0006\u0010\u0011\u001a\u00020\rJ\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0014J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0014J\b\u0010\u0018\u001a\u00020\rH\u0014J\b\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u001a\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0006H\u0016J\u000e\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\rJ\u000e\u0010%\u001a\u00020\r2\u0006\u0010#\u001a\u00020$J\u0010\u0010&\u001a\u00020\r2\u0006\u0010\'\u001a\u00020$H\u0016J\u000e\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020$J\b\u0010*\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0006X\u0084D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006+"}, d2 = {"Lcom/wy/adbook/app/base/QYBaseFragment;", "P", "Lcom/jess/arms/mvp/IPresenter;", "Lcom/jess/arms/base/BaseFragment;", "()V", "isFirst", "", "mAct", "Landroid/support/v4/app/FragmentActivity;", "umengPageReport", "getUmengPageReport", "()Z", "finish", "", "getContext", "Landroid/content/Context;", "getFragmentActivity", "hideLoading", "isHandlerStatusBarHeight", "loadData", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onFragmentPause", "onFragmentResume", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "onVisibilityChange", "visible", "setUserVisibleHint", "isVisibleToUser", "showError", "str", "", "showLoading", "showMessage", "msg", "showSuccess", "success", "startInitView", "application_debug"})
public abstract class QYBaseFragment<P extends com.jess.arms.mvp.IPresenter> extends com.jess.arms.base.BaseFragment<P> {
    private android.support.v4.app.FragmentActivity mAct;
    
    /**
     * * 此fragment是否需要友盟页面路径统计
     */
    private final boolean umengPageReport = true;
    private boolean isFirst;
    private java.util.HashMap _$_findViewCache;
    
    protected final boolean getUmengPageReport() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final android.support.v4.app.FragmentActivity getFragmentActivity() {
        return null;
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void setUserVisibleHint(boolean isVisibleToUser) {
    }
    
    /**
     * * fragment显示发生变化（切换/跳转/返回）时的回调
     *     * @param visible 对用户可见或不可见
     */
    private final void onVisibilityChange(boolean visible) {
    }
    
    protected void startInitView() {
    }
    
    protected void loadData() {
    }
    
    protected void onFragmentResume() {
    }
    
    protected void onFragmentPause() {
    }
    
    public boolean isHandlerStatusBarHeight() {
        return false;
    }
    
    public final void finish() {
    }
    
    /**
     * * 显示加载
     */
    public final void showLoading() {
    }
    
    public final void showLoading(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
    }
    
    /**
     * * 隐藏加载
     */
    public final void hideLoading() {
    }
    
    public final void showError(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
    }
    
    public void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public final void showSuccess(@org.jetbrains.annotations.NotNull()
    java.lang.String success) {
    }
    
    public QYBaseFragment() {
        super();
    }
}