package com.wy.adbook.mvp.view.fragment;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-28.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010\'\u001a\u00020\u0019H\u0014J\u0012\u0010(\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020&H\u0016J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0019H\u0014R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u00062"}, d2 = {"Lcom/wy/adbook/mvp/view/fragment/CommonQuestionFragment;", "Lcom/wy/adbook/app/base/QYBaseFragment;", "Lcom/wy/adbook/mvp/presenter/CommonQuestionPresenter;", "Lcom/wy/adbook/mvp/contranct/CommonQuestionContract$View;", "()V", "commonQuestionAdapter", "Lcom/wy/adbook/mvp/view/adapter/CommonQuestionAdapter;", "getCommonQuestionAdapter", "()Lcom/wy/adbook/mvp/view/adapter/CommonQuestionAdapter;", "setCommonQuestionAdapter", "(Lcom/wy/adbook/mvp/view/adapter/CommonQuestionAdapter;)V", "faqList", "", "Lcom/wy/adbook/mvp/model/entity/FaqItem;", "getFaqList", "()Ljava/util/List;", "setFaqList", "(Ljava/util/List;)V", "linearLayoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLinearLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "setLinearLayoutManager", "(Landroid/support/v7/widget/LinearLayoutManager;)V", "changeStatus", "", "status", "Lcom/wy/adbook/view/status/IStatusCoverView$Status;", "initData", "savedInstanceState", "Landroid/os/Bundle;", "initView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "isHandlerStatusBarHeight", "", "loadData", "setData", "data", "", "setRefresh", "isRefresh", "setupFragmentComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "startInitView", "Companion", "application_release"})
public final class CommonQuestionFragment extends com.wy.adbook.app.base.QYBaseFragment<com.wy.adbook.mvp.presenter.CommonQuestionPresenter> implements com.wy.adbook.mvp.contranct.CommonQuestionContract.View {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.CommonQuestionAdapter commonQuestionAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public android.support.v7.widget.LinearLayoutManager linearLayoutManager;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public java.util.List<com.wy.adbook.mvp.model.entity.FaqItem> faqList;
    public static final com.wy.adbook.mvp.view.fragment.CommonQuestionFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void setupFragmentComponent(@org.jetbrains.annotations.NotNull()
    com.jess.arms.di.component.AppComponent appComponent) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.CommonQuestionAdapter getCommonQuestionAdapter() {
        return null;
    }
    
    public final void setCommonQuestionAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.CommonQuestionAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.widget.LinearLayoutManager getLinearLayoutManager() {
        return null;
    }
    
    public final void setLinearLayoutManager(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.LinearLayoutManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.model.entity.FaqItem> getFaqList() {
        return null;
    }
    
    public final void setFaqList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.FaqItem> p0) {
    }
    
    @java.lang.Override()
    public void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void setData(@org.jetbrains.annotations.Nullable()
    java.lang.Object data) {
    }
    
    @java.lang.Override()
    protected void startInitView() {
    }
    
    @java.lang.Override()
    protected void loadData() {
    }
    
    @java.lang.Override()
    public boolean isHandlerStatusBarHeight() {
        return false;
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
    public void changeStatus(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.view.status.IStatusCoverView.Status status) {
    }
    
    @java.lang.Override()
    public void setRefresh(boolean isRefresh) {
    }
    
    public CommonQuestionFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/wy/adbook/mvp/view/fragment/CommonQuestionFragment$Companion;", "", "()V", "newInstance", "Lcom/wy/adbook/mvp/view/fragment/CommonQuestionFragment;", "application_release"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.wy.adbook.mvp.view.fragment.CommonQuestionFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}