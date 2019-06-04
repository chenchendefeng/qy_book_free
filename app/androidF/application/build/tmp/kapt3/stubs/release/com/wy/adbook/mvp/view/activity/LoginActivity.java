package com.wy.adbook.mvp.view.activity;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-08.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/LoginActivity;", "Lcom/wy/adbook/app/base/QYBaseActivity;", "Lcom/wy/adbook/mvp/presenter/LoginPresenter;", "Lcom/wy/adbook/mvp/contranct/LoginContract$View;", "()V", "countDownDisposable", "Lio/reactivex/disposables/Disposable;", "delayShowKeyboard", "", "getLoginProtocolText", "Landroid/text/SpannableStringBuilder;", "kotlin.jvm.PlatformType", "getToolbar", "Landroid/view/View;", "initData", "savedInstanceState", "Landroid/os/Bundle;", "initListener", "initView", "", "setupActivityComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "startCountdown", "subscribeWxEvent", "key", "Lcom/wy/adbook/wxapi/WXEntryActivity$WxEventBusKey;", "useEventBus", "", "Companion", "application_release"})
public final class LoginActivity extends com.wy.adbook.app.base.QYBaseActivity<com.wy.adbook.mvp.presenter.LoginPresenter> implements com.wy.adbook.mvp.contranct.LoginContract.View {
    private io.reactivex.disposables.Disposable countDownDisposable;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WEI_XIN_LOGIN = "wxLogin";
    
    /**
     * * 电话号码长度
     */
    private static final int NUM_PHONE = 11;
    
    /**
     * * 验证码/密码长度
     */
    private static final int NUM_CODE = 6;
    
    /**
     * * 倒计时时间 s
     */
    private static final int COUNT_DOWN = 60;
    private static final java.lang.String LOGIN_FOR_PUT_ON = "loginForPutOn";
    private static java.lang.ref.WeakReference<com.wy.adbook.mvp.view.activity.LoginActivity> weakActivity;
    private static cn.smssdk.EventHandler eventHandler;
    public static final com.wy.adbook.mvp.view.activity.LoginActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View getToolbar() {
        return null;
    }
    
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
    
    @java.lang.Override()
    public boolean useEventBus() {
        return false;
    }
    
    private final void delayShowKeyboard() {
    }
    
    private final void initListener() {
    }
    
    private final android.text.SpannableStringBuilder getLoginProtocolText() {
        return null;
    }
    
    /**
     * * 开始验证码倒计时
     */
    @java.lang.Override()
    public void startCountdown() {
    }
    
    /**
     * * 监听微信登录成功
     */
    @org.simple.eventbus.Subscriber(mode = org.simple.eventbus.ThreadMode.MAIN)
    public final void subscribeWxEvent(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.wxapi.WXEntryActivity.WxEventBusKey key) {
    }
    
    public LoginActivity() {
        super();
    }
    
    public static final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public static final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @LoginFor()
    int loginFor) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/LoginActivity$Companion;", "", "()V", "COUNT_DOWN", "", "LOGIN_FOR_PUT_ON", "", "NUM_CODE", "NUM_PHONE", "WEI_XIN_LOGIN", "eventHandler", "Lcn/smssdk/EventHandler;", "weakActivity", "Ljava/lang/ref/WeakReference;", "Lcom/wy/adbook/mvp/view/activity/LoginActivity;", "startActivity", "", "context", "Landroid/content/Context;", "loginFor", "application_release"})
    public static final class Companion {
        
        public final void startActivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        public final void startActivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @LoginFor()
        int loginFor) {
        }
        
        private Companion() {
            super();
        }
    }
}