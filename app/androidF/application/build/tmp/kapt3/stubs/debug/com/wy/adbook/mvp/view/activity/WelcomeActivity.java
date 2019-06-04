package com.wy.adbook.mvp.view.activity;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/WelcomeActivity;", "Lcom/wy/adbook/app/base/QYBaseActivity;", "Lcom/wy/adbook/mvp/presenter/WelcomePresenter;", "Lcom/wy/adbook/mvp/contranct/IWelcomeContract$View;", "()V", "initData", "", "savedInstanceState", "Landroid/os/Bundle;", "initListener", "initView", "", "setupActivityComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "showAd", "showGif", "fileUrl", "", "showImg", "showSkipCount", "currentCount", "", "showVideo", "application_debug"})
public final class WelcomeActivity extends com.wy.adbook.app.base.QYBaseActivity<com.wy.adbook.mvp.presenter.WelcomePresenter> implements com.wy.adbook.mvp.contranct.IWelcomeContract.View {
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void setupActivityComponent(@org.jetbrains.annotations.NotNull()
    com.jess.arms.di.component.AppComponent appComponent) {
    }
    
    @java.lang.Override()
    public int initView(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return 0;
    }
    
    @java.lang.Override()
    public void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initListener() {
    }
    
    @java.lang.Override()
    public void showAd() {
    }
    
    @java.lang.Override()
    public void showSkipCount(long currentCount) {
    }
    
    @java.lang.Override()
    public void showImg(@org.jetbrains.annotations.NotNull()
    java.lang.String fileUrl) {
    }
    
    @java.lang.Override()
    public void showGif(@org.jetbrains.annotations.NotNull()
    java.lang.String fileUrl) {
    }
    
    @java.lang.Override()
    public void showVideo(@org.jetbrains.annotations.NotNull()
    java.lang.String fileUrl) {
    }
    
    public WelcomeActivity() {
        super();
    }
}