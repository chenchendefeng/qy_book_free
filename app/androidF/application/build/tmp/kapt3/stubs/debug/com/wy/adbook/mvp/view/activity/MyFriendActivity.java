package com.wy.adbook.mvp.view.activity;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001#B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006$"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/MyFriendActivity;", "Lcom/wy/adbook/app/base/QYBaseActivity;", "Lcom/wy/adbook/mvp/presenter/MyFriendPresenter;", "Lcom/wy/adbook/mvp/contranct/MyFriendContract$View;", "()V", "friendAdapter", "Lcom/wy/adbook/mvp/view/adapter/MyFriendAdapter;", "getFriendAdapter", "()Lcom/wy/adbook/mvp/view/adapter/MyFriendAdapter;", "setFriendAdapter", "(Lcom/wy/adbook/mvp/view/adapter/MyFriendAdapter;)V", "linearLayoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLinearLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "setLinearLayoutManager", "(Landroid/support/v7/widget/LinearLayoutManager;)V", "changeStatus", "", "status", "Lcom/wy/adbook/view/status/IStatusCoverView$Status;", "getToolbar", "Landroid/view/View;", "initData", "savedInstanceState", "Landroid/os/Bundle;", "initListener", "initView", "", "setRefresh", "isRefresh", "", "setupActivityComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "Companion", "application_debug"})
public final class MyFriendActivity extends com.wy.adbook.app.base.QYBaseActivity<com.wy.adbook.mvp.presenter.MyFriendPresenter> implements com.wy.adbook.mvp.contranct.MyFriendContract.View {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.MyFriendAdapter friendAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public android.support.v7.widget.LinearLayoutManager linearLayoutManager;
    public static final com.wy.adbook.mvp.view.activity.MyFriendActivity.Companion Companion = null;
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
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.MyFriendAdapter getFriendAdapter() {
        return null;
    }
    
    public final void setFriendAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.MyFriendAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.widget.LinearLayoutManager getLinearLayoutManager() {
        return null;
    }
    
    public final void setLinearLayoutManager(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.LinearLayoutManager p0) {
    }
    
    @java.lang.Override()
    public void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initListener() {
    }
    
    @java.lang.Override()
    public void setRefresh(boolean isRefresh) {
    }
    
    @java.lang.Override()
    public void changeStatus(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.view.status.IStatusCoverView.Status status) {
    }
    
    public MyFriendActivity() {
        super();
    }
    
    public static final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/MyFriendActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "application_debug"})
    public static final class Companion {
        
        public final void startActivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        private Companion() {
            super();
        }
    }
}