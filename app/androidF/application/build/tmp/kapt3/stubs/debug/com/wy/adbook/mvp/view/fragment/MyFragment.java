package com.wy.adbook.mvp.view.fragment;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0002J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0014J\b\u0010 \u001a\u00020\u0012H\u0016J\u0012\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010\'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0012H\u0014J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020-H\u0007J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010,\u001a\u00020/H\u0007J\b\u00100\u001a\u00020&H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u00062"}, d2 = {"Lcom/wy/adbook/mvp/view/fragment/MyFragment;", "Lcom/wy/adbook/app/base/QYBaseFragment;", "Lcom/wy/adbook/mvp/presenter/MyPresenter;", "Lcom/wy/adbook/mvp/contranct/MyContract$View;", "()V", "linearLayoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLinearLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "setLinearLayoutManager", "(Landroid/support/v7/widget/LinearLayoutManager;)V", "myAdapter", "Lcom/wy/adbook/mvp/view/adapter/MyAdapter;", "getMyAdapter", "()Lcom/wy/adbook/mvp/view/adapter/MyAdapter;", "setMyAdapter", "(Lcom/wy/adbook/mvp/view/adapter/MyAdapter;)V", "changeStatus", "", "status", "Lcom/wy/adbook/view/status/IStatusCoverView$Status;", "initData", "savedInstanceState", "Landroid/os/Bundle;", "initListener", "initView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "loadData", "refreshView", "setData", "data", "", "setRefresh", "isRefresh", "", "setupFragmentComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "startInitView", "subscribeLoginEvent", "event", "Lcom/wy/adbook/mvp/model/event/LoginEvent;", "subscribeWxEvent", "Lcom/wy/adbook/wxapi/WXEntryActivity$WxEventBusKey;", "useEventBus", "Companion", "application_debug"})
public final class MyFragment extends com.wy.adbook.app.base.QYBaseFragment<com.wy.adbook.mvp.presenter.MyPresenter> implements com.wy.adbook.mvp.contranct.MyContract.View {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.MyAdapter myAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public android.support.v7.widget.LinearLayoutManager linearLayoutManager;
    public static final com.wy.adbook.mvp.view.fragment.MyFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public boolean useEventBus() {
        return false;
    }
    
    @java.lang.Override()
    public void setupFragmentComponent(@org.jetbrains.annotations.NotNull()
    com.jess.arms.di.component.AppComponent appComponent) {
    }
    
    @java.lang.Override()
    public void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void setData(@org.jetbrains.annotations.Nullable()
    java.lang.Object data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.MyAdapter getMyAdapter() {
        return null;
    }
    
    public final void setMyAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.MyAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.widget.LinearLayoutManager getLinearLayoutManager() {
        return null;
    }
    
    public final void setLinearLayoutManager(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.LinearLayoutManager p0) {
    }
    
    @java.lang.Override()
    protected void startInitView() {
    }
    
    private final void initListener() {
    }
    
    @java.lang.Override()
    protected void loadData() {
    }
    
    @java.lang.Override()
    public void refreshView() {
    }
    
    @java.lang.Override()
    public void changeStatus(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.view.status.IStatusCoverView.Status status) {
    }
    
    @java.lang.Override()
    public void setRefresh(boolean isRefresh) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View initView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @org.simple.eventbus.Subscriber(mode = org.simple.eventbus.ThreadMode.MAIN)
    public final void subscribeLoginEvent(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.event.LoginEvent event) {
    }
    
    @org.simple.eventbus.Subscriber(mode = org.simple.eventbus.ThreadMode.MAIN)
    public final void subscribeWxEvent(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.wxapi.WXEntryActivity.WxEventBusKey event) {
    }
    
    public MyFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/wy/adbook/mvp/view/fragment/MyFragment$Companion;", "", "()V", "newInstance", "Lcom/wy/adbook/mvp/view/fragment/MyFragment;", "application_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.wy.adbook.mvp.view.fragment.MyFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}