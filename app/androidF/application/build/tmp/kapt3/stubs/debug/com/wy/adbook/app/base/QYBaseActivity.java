package com.wy.adbook.app.base;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010\'\u001a\u00020&H\u0002J\u0006\u0010(\u001a\u00020&J\b\u0010)\u001a\u00020*H\u0016J\u0006\u0010+\u001a\u00020&J\u0012\u0010,\u001a\u00020&2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\"\u0010/\u001a\u0004\u0018\u00010$2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\"2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020&H\u0014J\u0014\u00105\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\u001c07H\u0016J\u000e\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020\bJ\u0006\u0010:\u001a\u00020&J\u000e\u0010:\u001a\u00020&2\u0006\u00109\u001a\u00020\bJ\u000e\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020\bJ\u000e\u0010=\u001a\u00020&2\u0006\u0010>\u001a\u00020\bJ\b\u0010?\u001a\u00020*H\u0016J\b\u0010@\u001a\u00020*H\u0016R\u001c\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u001c0\u001c0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006A"}, d2 = {"Lcom/wy/adbook/app/base/QYBaseActivity;", "P", "Lcom/jess/arms/mvp/IPresenter;", "Lme/imid/swipebacklayout/lib/app/SwipeBackActivity;", "Lcom/jess/arms/base/delegate/IActivity;", "Lcom/jess/arms/integration/lifecycle/ActivityLifecycleable;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "disposables$delegate", "Lkotlin/Lazy;", "loadDialog", "Lcom/freebookqy/viewlib/load/LoadDialog;", "getLoadDialog", "()Lcom/freebookqy/viewlib/load/LoadDialog;", "loadDialog$delegate", "mCache", "Lcom/jess/arms/integration/cache/Cache;", "", "mLifecycleSubject", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/trello/rxlifecycle2/android/ActivityEvent;", "mPresenter", "Lcom/jess/arms/mvp/IPresenter;", "mUnbinder", "Lbutterknife/Unbinder;", "getContext", "Landroid/content/Context;", "getToolbar", "Landroid/view/View;", "handlerBackPress", "", "handlerStatusBarHeight", "hideLoading", "isHandlerStatusBarHeight", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "name", "context", "attrs", "Landroid/util/AttributeSet;", "onDestroy", "provideCache", "provideLifecycleSubject", "Lio/reactivex/subjects/Subject;", "showError", "str", "showLoading", "showMessage", "msg", "showSuccess", "success", "useEventBus", "useFragment", "application_debug"})
public abstract class QYBaseActivity<P extends com.jess.arms.mvp.IPresenter> extends me.imid.swipebacklayout.lib.app.SwipeBackActivity implements com.jess.arms.base.delegate.IActivity, com.jess.arms.integration.lifecycle.ActivityLifecycleable {
    private final kotlin.Lazy loadDialog$delegate = null;
    private final kotlin.Lazy disposables$delegate = null;
    private final java.lang.String TAG = null;
    private final io.reactivex.subjects.BehaviorSubject<com.trello.rxlifecycle2.android.ActivityEvent> mLifecycleSubject = null;
    private com.jess.arms.integration.cache.Cache<java.lang.String, java.lang.Object> mCache;
    private butterknife.Unbinder mUnbinder;
    @org.jetbrains.annotations.Nullable()
    @javax.inject.Inject()
    public P mPresenter;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    private final com.freebookqy.viewlib.load.LoadDialog getLoadDialog() {
        return null;
    }
    
    private final io.reactivex.disposables.CompositeDisposable getDisposables() {
        return null;
    }
    
    private final void handlerStatusBarHeight() {
    }
    
    /**
     * * 显示加载
     */
    public final void showLoading() {
    }
    
    public final void showLoading(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
    }
    
    public final void showError(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
    }
    
    public final void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public final void showSuccess(@org.jetbrains.annotations.NotNull()
    java.lang.String success) {
    }
    
    /**
     * * 隐藏加载
     */
    public final void hideLoading() {
    }
    
    public boolean isHandlerStatusBarHeight() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public android.view.View getToolbar() {
        return null;
    }
    
    protected final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public synchronized com.jess.arms.integration.cache.Cache<java.lang.String, java.lang.Object> provideCache() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.subjects.Subject<com.trello.rxlifecycle2.android.ActivityEvent> provideLifecycleSubject() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs) {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    /**
     * * 是否使用 EventBus
     *     * Arms 核心库现在并不会依赖某个 EventBus, 要想使用 EventBus, 还请在项目中自行依赖对应的 EventBus
     *     * 现在支持两种 EventBus, greenrobot 的 EventBus 和畅销书 《Android源码设计模式解析与实战》的作者 何红辉 所作的 AndroidEventBus
     *     * 确保依赖后, 将此方法返回 true, Arms 会自动检测您依赖的 EventBus, 并自动注册
     *     * 这种做法可以让使用者有自行选择三方库的权利, 并且还可以减轻 Arms 的体积
     *     *
     *     * @return 返回 `true` (默认为使用 `true`), Arms 会自动注册 EventBus
     */
    @java.lang.Override()
    public boolean useEventBus() {
        return false;
    }
    
    /**
     * * 这个Activity是否会使用Fragment,框架会根据这个属性判断是否注册[android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks]
     *     * 如果返回false,那意味着这个Activity不需要绑定Fragment,那你再在这个Activity中绑定继承于 [com.jess.arms.base.BaseFragment] 的Fragment将不起任何作用
     *     *
     *     * @return
     */
    @java.lang.Override()
    public boolean useFragment() {
        return false;
    }
    
    @java.lang.Override()
    public final void onBackPressed() {
    }
    
    public void handlerBackPress() {
    }
    
    public QYBaseActivity() {
        super();
    }
}