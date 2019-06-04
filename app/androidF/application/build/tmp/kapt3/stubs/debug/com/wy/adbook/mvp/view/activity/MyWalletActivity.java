package com.wy.adbook.mvp.view.activity;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/6.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002()B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\u0012\u0010!\u001a\u00020\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010#\u001a\u00020\u0016H\u0002J\b\u0010$\u001a\u00020\u0016H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\'H\u0016R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000e\u0010\tR\u001f\u0010\u0010\u001a\u00060\u0011R\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006*"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/MyWalletActivity;", "Lcom/wy/adbook/app/base/QYBaseActivity;", "Lcom/wy/adbook/mvp/presenter/MyWalletPresenter;", "Lcom/wy/adbook/mvp/contranct/MyWalletContract$View;", "()V", "viewList", "", "Landroid/view/View;", "getViewList", "()Ljava/util/List;", "viewList$delegate", "Lkotlin/Lazy;", "walletList", "", "getWalletList", "walletList$delegate", "walletVpAdapter", "Lcom/wy/adbook/mvp/view/activity/MyWalletActivity$WalletVpAdapter;", "getWalletVpAdapter", "()Lcom/wy/adbook/mvp/view/activity/MyWalletActivity$WalletVpAdapter;", "walletVpAdapter$delegate", "changeStatusCoverView", "", "status", "Lcom/wy/adbook/view/status/IStatusCoverView$Status;", "getCurrentAdapter", "Lcom/wy/adbook/mvp/view/adapter/WalletItemAdapter;", "getToolbar", "initData", "savedInstanceState", "Landroid/os/Bundle;", "initIndicator", "initListener", "initView", "", "initVp", "refreshView", "setupActivityComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "Companion", "WalletVpAdapter", "application_debug"})
public final class MyWalletActivity extends com.wy.adbook.app.base.QYBaseActivity<com.wy.adbook.mvp.presenter.MyWalletPresenter> implements com.wy.adbook.mvp.contranct.MyWalletContract.View {
    private final kotlin.Lazy walletList$delegate = null;
    private final kotlin.Lazy walletVpAdapter$delegate = null;
    private final kotlin.Lazy viewList$delegate = null;
    public static final com.wy.adbook.mvp.view.activity.MyWalletActivity.Companion Companion = null;
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
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View getToolbar() {
        return null;
    }
    
    private final java.util.List<java.lang.String> getWalletList() {
        return null;
    }
    
    @java.lang.Override()
    public void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initListener() {
    }
    
    private final com.wy.adbook.mvp.view.activity.MyWalletActivity.WalletVpAdapter getWalletVpAdapter() {
        return null;
    }
    
    private final void initVp() {
    }
    
    private final java.util.List<android.view.View> getViewList() {
        return null;
    }
    
    private final void initIndicator() {
    }
    
    @java.lang.Override()
    public void changeStatusCoverView(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.view.status.IStatusCoverView.Status status) {
    }
    
    @java.lang.Override()
    public void refreshView() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.wy.adbook.mvp.view.adapter.WalletItemAdapter getCurrentAdapter() {
        return null;
    }
    
    public MyWalletActivity() {
        super();
    }
    
    public static final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/MyWalletActivity$WalletVpAdapter;", "Landroid/support/v4/view/PagerAdapter;", "context", "Landroid/content/Context;", "viewList", "", "Landroid/view/View;", "(Lcom/wy/adbook/mvp/view/activity/MyWalletActivity;Landroid/content/Context;Ljava/util/List;)V", "getViewList", "()Ljava/util/List;", "setViewList", "(Ljava/util/List;)V", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "getItemPosition", "instantiateItem", "isViewFromObject", "", "p0", "p1", "application_debug"})
    public final class WalletVpAdapter extends android.support.v4.view.PagerAdapter {
        private final android.content.Context context = null;
        @org.jetbrains.annotations.NotNull()
        private java.util.List<android.view.View> viewList;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.Object instantiateItem(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup container, int position) {
            return null;
        }
        
        @java.lang.Override()
        public void destroyItem(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup container, int position, @org.jetbrains.annotations.NotNull()
        java.lang.Object object) {
        }
        
        @java.lang.Override()
        public boolean isViewFromObject(@org.jetbrains.annotations.NotNull()
        android.view.View p0, @org.jetbrains.annotations.NotNull()
        java.lang.Object p1) {
            return false;
        }
        
        @java.lang.Override()
        public int getCount() {
            return 0;
        }
        
        @java.lang.Override()
        public int getItemPosition(@org.jetbrains.annotations.NotNull()
        java.lang.Object object) {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<android.view.View> getViewList() {
            return null;
        }
        
        public final void setViewList(@org.jetbrains.annotations.NotNull()
        java.util.List<android.view.View> p0) {
        }
        
        public WalletVpAdapter(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.util.List<android.view.View> viewList) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/MyWalletActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "application_debug"})
    public static final class Companion {
        
        public final void startActivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        private Companion() {
            super();
        }
    }
}