package com.wy.adbook.mvp.view.web.act;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-23.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00019B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010%\u001a\u00020&H\u0004J\n\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020&H\u0002J\u0012\u0010-\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\"\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020&H\u0014J\u0010\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020+H\u0014J\u0010\u00106\u001a\u00020&2\u0006\u00107\u001a\u000208H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020 X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006:"}, d2 = {"Lcom/wy/adbook/mvp/view/web/act/WebActivity;", "Lcom/wy/adbook/app/base/QYBaseActivity;", "Lcom/wy/adbook/mvp/view/web/act/WebPresenter;", "Lcom/wy/adbook/mvp/view/web/act/WebContract$View;", "()V", "INTENT_JSCALL", "", "getINTENT_JSCALL", "()Ljava/lang/String;", "isLoadFinish", "", "mAppJSCall", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "mHintCount", "", "mWebActivityProxy", "Lcom/wy/adbook/mvp/view/web/WebActivityProxy;", "onWebViewEvent", "Lcom/wy/adbook/mvp/view/web/frag/QYWebFragment$OnWebViewEvent;", "title", "getTitle", "setTitle", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "webFragment", "Lcom/wy/adbook/mvp/view/web/frag/QYWebFragment;", "getWebFragment", "()Lcom/wy/adbook/mvp/view/web/frag/QYWebFragment;", "setWebFragment", "(Lcom/wy/adbook/mvp/view/web/frag/QYWebFragment;)V", "back", "", "getToolbar", "Landroid/view/View;", "initData", "savedInstanceState", "Landroid/os/Bundle;", "initTitle", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "onSaveInstanceState", "outState", "setupActivityComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "Companion", "application_release"})
public class WebActivity extends com.wy.adbook.app.base.QYBaseActivity<com.wy.adbook.mvp.view.web.act.WebPresenter> implements com.wy.adbook.mvp.view.web.act.WebContract.View {
    @org.jetbrains.annotations.NotNull()
    private android.os.Handler mHandler;
    private int mHintCount;
    @org.jetbrains.annotations.NotNull()
    public com.wy.adbook.mvp.view.web.frag.QYWebFragment webFragment;
    private boolean mAppJSCall;
    private boolean isLoadFinish;
    private com.wy.adbook.mvp.view.web.WebActivityProxy mWebActivityProxy;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String INTENT_JSCALL = "jscall";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String title;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String url;
    private com.wy.adbook.mvp.view.web.frag.QYWebFragment.OnWebViewEvent onWebViewEvent;
    private static final java.lang.String TAG = null;
    public static final com.wy.adbook.mvp.view.web.act.WebActivity.Companion Companion = null;
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
    
    @org.jetbrains.annotations.NotNull()
    protected final android.os.Handler getMHandler() {
        return null;
    }
    
    protected final void setMHandler(@org.jetbrains.annotations.NotNull()
    android.os.Handler p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.web.frag.QYWebFragment getWebFragment() {
        return null;
    }
    
    public final void setWebFragment(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.web.frag.QYWebFragment p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getINTENT_JSCALL() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl() {
        return null;
    }
    
    public final void setUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    private final void initTitle() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    protected void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
    }
    
    protected final void back() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public WebActivity() {
        super();
    }
    
    public static final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    /**
     * * 传入js函数 字符串 比如：loadJsFunc("javascript:onAddressChange('')")
     */
    public static final void loadJsFunc(@org.jetbrains.annotations.NotNull()
    java.lang.String jsFunc) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J \u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/wy/adbook/mvp/view/web/act/WebActivity$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "loadJsFunc", "", "jsFunc", "startActivity", "context", "Landroid/content/Context;", "url", "title", "application_release"})
    public static final class Companion {
        
        public final void startActivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String url, @org.jetbrains.annotations.NotNull()
        java.lang.String title) {
        }
        
        /**
         * * 传入js函数 字符串 比如：loadJsFunc("javascript:onAddressChange('')")
         */
        public final void loadJsFunc(@org.jetbrains.annotations.NotNull()
        java.lang.String jsFunc) {
        }
        
        private Companion() {
            super();
        }
    }
}