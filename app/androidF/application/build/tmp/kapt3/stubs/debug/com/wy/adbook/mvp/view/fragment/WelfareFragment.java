package com.wy.adbook.mvp.view.fragment;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00013B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J$\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\bH\u0002J\b\u0010\"\u001a\u00020\bH\u0016J\u0012\u0010#\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\b2\u0006\u0010\'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\bH\u0014J\u0010\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/H\u0007J\u0010\u00100\u001a\u00020\b2\u0006\u0010.\u001a\u000201H\u0007J\b\u00102\u001a\u00020(H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/wy/adbook/mvp/view/fragment/WelfareFragment;", "Lcom/wy/adbook/app/base/QYBaseFragment;", "Lcom/wy/adbook/mvp/presenter/WelfarePresenter;", "Lcom/wy/adbook/mvp/contranct/WelfareContract$View;", "()V", "headerType", "", "addViewToList", "", "welfareItemList", "", "Lcom/wy/adbook/mvp/model/entity/WelfareItem;", "list", "Landroid/view/ViewGroup;", "changeStatusCover", "status", "Lcom/wy/adbook/view/status/IStatusCoverView$Status;", "getDailyProgressView", "Landroid/view/View;", "getWelfareItemView", "Lcom/wy/adbook/view/WelfareItemView;", "welfareItem", "initData", "savedInstanceState", "Landroid/os/Bundle;", "initListener", "initSignInHeader", "initView", "inflater", "Landroid/view/LayoutInflater;", "container", "refreshHeader", "headViewType", "refreshHeaderView", "refreshView", "setData", "data", "", "setRefresh", "isRefresh", "", "setupFragmentComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "startInitView", "subscribeShareEvent", "event", "Lcom/wy/adbook/mvp/model/event/ShareEvent;", "subscribeSignEvent", "Lcom/wy/adbook/mvp/model/event/SignEvent;", "useEventBus", "Companion", "application_debug"})
public final class WelfareFragment extends com.wy.adbook.app.base.QYBaseFragment<com.wy.adbook.mvp.presenter.WelfarePresenter> implements com.wy.adbook.mvp.contranct.WelfareContract.View {
    private int headerType;
    public static final int HEAD_TYPE_NONE = -1;
    public static final int HEAD_TYPE_FIRST = 0;
    public static final int HEAD_TYPE_CONTINUOUS_SIGN_IN = 1;
    public static final com.wy.adbook.mvp.view.fragment.WelfareFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void setupFragmentComponent(@org.jetbrains.annotations.NotNull()
    com.jess.arms.di.component.AppComponent appComponent) {
    }
    
    @java.lang.Override()
    public boolean useEventBus() {
        return false;
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
    @java.lang.Override()
    public android.view.View initView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    protected void startInitView() {
    }
    
    private final void initListener() {
    }
    
    @java.lang.Override()
    public void refreshHeader(int headViewType) {
    }
    
    private final void refreshHeaderView() {
    }
    
    @java.lang.Override()
    public void refreshView() {
    }
    
    private final void addViewToList(java.util.List<com.wy.adbook.mvp.model.entity.WelfareItem> welfareItemList, android.view.ViewGroup list) {
    }
    
    private final android.view.View getDailyProgressView() {
        return null;
    }
    
    private final com.wy.adbook.view.WelfareItemView getWelfareItemView(com.wy.adbook.mvp.model.entity.WelfareItem welfareItem) {
        return null;
    }
    
    @java.lang.Override()
    public void setRefresh(boolean isRefresh) {
    }
    
    private final void initSignInHeader() {
    }
    
    @java.lang.Override()
    public void changeStatusCover(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.view.status.IStatusCoverView.Status status) {
    }
    
    @org.simple.eventbus.Subscriber(mode = org.simple.eventbus.ThreadMode.MAIN)
    public final void subscribeSignEvent(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.event.SignEvent event) {
    }
    
    @org.simple.eventbus.Subscriber(mode = org.simple.eventbus.ThreadMode.MAIN)
    public final void subscribeShareEvent(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.event.ShareEvent event) {
    }
    
    public WelfareFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/wy/adbook/mvp/view/fragment/WelfareFragment$Companion;", "", "()V", "HEAD_TYPE_CONTINUOUS_SIGN_IN", "", "HEAD_TYPE_FIRST", "HEAD_TYPE_NONE", "newInstance", "Lcom/wy/adbook/mvp/view/fragment/WelfareFragment;", "application_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.wy.adbook.mvp.view.fragment.WelfareFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}