package com.wy.adbook.mvp.view.activity;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-26.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001(B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002J\u0012\u0010\"\u001a\u00020#2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\'H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\n\u00a8\u0006)"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/WithdrawalActivity;", "Lcom/wy/adbook/app/base/QYBaseActivity;", "Lcom/wy/adbook/mvp/presenter/WithdrawalPresenter;", "Lcom/wy/adbook/mvp/contranct/WithdrawalContract$View;", "()V", "cashAdapter", "Lcom/wy/adbook/mvp/view/adapter/WithdrawablAdapter;", "getCashAdapter", "()Lcom/wy/adbook/mvp/view/adapter/WithdrawablAdapter;", "setCashAdapter", "(Lcom/wy/adbook/mvp/view/adapter/WithdrawablAdapter;)V", "glm1", "Lcom/freebookqy/viewlib/rv/layoutmanager/FullyGridLayoutManager;", "getGlm1", "()Lcom/freebookqy/viewlib/rv/layoutmanager/FullyGridLayoutManager;", "setGlm1", "(Lcom/freebookqy/viewlib/rv/layoutmanager/FullyGridLayoutManager;)V", "glm2", "getGlm2", "setGlm2", "goldAdapter", "getGoldAdapter", "setGoldAdapter", "changeStatus", "", "status", "Lcom/wy/adbook/view/status/IStatusCoverView$Status;", "getToolbar", "Landroid/view/View;", "initData", "savedInstanceState", "Landroid/os/Bundle;", "initListener", "initRv", "initView", "", "refreshView", "setupActivityComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "Companion", "application_debug"})
public final class WithdrawalActivity extends com.wy.adbook.app.base.QYBaseActivity<com.wy.adbook.mvp.presenter.WithdrawalPresenter> implements com.wy.adbook.mvp.contranct.WithdrawalContract.View {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "adapter1")
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.WithdrawablAdapter goldAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "adapter2")
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.WithdrawablAdapter cashAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "glm1")
    @javax.inject.Inject()
    public com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager glm1;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "glm2")
    @javax.inject.Inject()
    public com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager glm2;
    public static final com.wy.adbook.mvp.view.activity.WithdrawalActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void setupActivityComponent(@org.jetbrains.annotations.NotNull()
    com.jess.arms.di.component.AppComponent appComponent) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View getToolbar() {
        return null;
    }
    
    @java.lang.Override()
    public int initView(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.WithdrawablAdapter getGoldAdapter() {
        return null;
    }
    
    public final void setGoldAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.WithdrawablAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.WithdrawablAdapter getCashAdapter() {
        return null;
    }
    
    public final void setCashAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.WithdrawablAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager getGlm1() {
        return null;
    }
    
    public final void setGlm1(@org.jetbrains.annotations.NotNull()
    com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager getGlm2() {
        return null;
    }
    
    public final void setGlm2(@org.jetbrains.annotations.NotNull()
    com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager p0) {
    }
    
    @java.lang.Override()
    public void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initRv() {
    }
    
    private final void initListener() {
    }
    
    @java.lang.Override()
    public void refreshView() {
    }
    
    @java.lang.Override()
    public void changeStatus(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.view.status.IStatusCoverView.Status status) {
    }
    
    public WithdrawalActivity() {
        super();
    }
    
    public static final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/WithdrawalActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "application_debug"})
    public static final class Companion {
        
        public final void startActivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        private Companion() {
            super();
        }
    }
}