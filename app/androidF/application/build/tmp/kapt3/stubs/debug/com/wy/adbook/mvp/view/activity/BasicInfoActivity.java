package com.wy.adbook.mvp.view.activity;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/BasicInfoActivity;", "Lcom/wy/adbook/app/base/QYBaseActivity;", "Lcom/wy/adbook/mvp/presenter/BasicInfoPresenter;", "Lcom/wy/adbook/mvp/contranct/BasicInfoContract$View;", "()V", "basicInfoAdapter", "Lcom/wy/adbook/mvp/view/adapter/BasicInfoAdapter;", "getBasicInfoAdapter", "()Lcom/wy/adbook/mvp/view/adapter/BasicInfoAdapter;", "setBasicInfoAdapter", "(Lcom/wy/adbook/mvp/view/adapter/BasicInfoAdapter;)V", "llm", "Landroid/support/v7/widget/LinearLayoutManager;", "getLlm", "()Landroid/support/v7/widget/LinearLayoutManager;", "setLlm", "(Landroid/support/v7/widget/LinearLayoutManager;)V", "getToolbar", "Landroid/view/View;", "initData", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "setupActivityComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "showChangeNickNameDialog", "Companion", "application_debug"})
public final class BasicInfoActivity extends com.wy.adbook.app.base.QYBaseActivity<com.wy.adbook.mvp.presenter.BasicInfoPresenter> implements com.wy.adbook.mvp.contranct.BasicInfoContract.View {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.BasicInfoAdapter basicInfoAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public android.support.v7.widget.LinearLayoutManager llm;
    public static final com.wy.adbook.mvp.view.activity.BasicInfoActivity.Companion Companion = null;
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
    public final com.wy.adbook.mvp.view.adapter.BasicInfoAdapter getBasicInfoAdapter() {
        return null;
    }
    
    public final void setBasicInfoAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.BasicInfoAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.widget.LinearLayoutManager getLlm() {
        return null;
    }
    
    public final void setLlm(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.LinearLayoutManager p0) {
    }
    
    @java.lang.Override()
    public void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void showChangeNickNameDialog() {
    }
    
    public BasicInfoActivity() {
        super();
    }
    
    public static final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/BasicInfoActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "application_debug"})
    public static final class Companion {
        
        public final void startActivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        private Companion() {
            super();
        }
    }
}