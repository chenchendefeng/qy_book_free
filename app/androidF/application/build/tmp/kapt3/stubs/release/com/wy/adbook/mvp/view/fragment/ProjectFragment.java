package com.wy.adbook.mvp.view.fragment;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001@B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'H\u0016J\b\u0010(\u001a\u00020%H\u0002J\u0012\u0010)\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020%H\u0002J$\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020%H\u0014J\b\u00106\u001a\u00020%H\u0016J\u0010\u00107\u001a\u00020%2\u0006\u00108\u001a\u000204H\u0016J\u0012\u00109\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0010\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020%H\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006A"}, d2 = {"Lcom/wy/adbook/mvp/view/fragment/ProjectFragment;", "Lcom/wy/adbook/app/base/QYBaseFragment;", "Lcom/wy/adbook/mvp/presenter/ProjectPresenter;", "Lcom/wy/adbook/mvp/contranct/ProjectContract$View;", "()V", "banner", "Lcn/bingoogolapple/bgabanner/BGABanner;", "getBanner", "()Lcn/bingoogolapple/bgabanner/BGABanner;", "banner$delegate", "Lkotlin/Lazy;", "bannerList", "", "Lcom/wy/adbook/mvp/model/entity/BannerItem;", "getBannerList", "()Ljava/util/List;", "setBannerList", "(Ljava/util/List;)V", "headerView", "Landroid/view/View;", "getHeaderView", "()Landroid/view/View;", "setHeaderView", "(Landroid/view/View;)V", "projectAdapter", "Lcom/wy/adbook/mvp/view/adapter/ProjectAdapter;", "getProjectAdapter", "()Lcom/wy/adbook/mvp/view/adapter/ProjectAdapter;", "setProjectAdapter", "(Lcom/wy/adbook/mvp/view/adapter/ProjectAdapter;)V", "projectLinearLayout", "Landroid/support/v7/widget/LinearLayoutManager;", "getProjectLinearLayout", "()Landroid/support/v7/widget/LinearLayoutManager;", "setProjectLinearLayout", "(Landroid/support/v7/widget/LinearLayoutManager;)V", "changeStatusCoverView", "", "status", "Lcom/wy/adbook/view/status/IStatusCoverView$Status;", "initBanner", "initData", "savedInstanceState", "Landroid/os/Bundle;", "initListener", "initProjectView", "initView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "isHandlerStatusBarHeight", "", "loadData", "refreshBanner", "refreshStatus", "isRefresh", "setData", "data", "", "setupFragmentComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "startInitView", "Companion", "application_release"})
public final class ProjectFragment extends com.wy.adbook.app.base.QYBaseFragment<com.wy.adbook.mvp.presenter.ProjectPresenter> implements com.wy.adbook.mvp.contranct.ProjectContract.View {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.ProjectAdapter projectAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public android.support.v7.widget.LinearLayoutManager projectLinearLayout;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public android.view.View headerView;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public java.util.List<com.wy.adbook.mvp.model.entity.BannerItem> bannerList;
    private final kotlin.Lazy banner$delegate = null;
    private static final java.lang.String ARGUMENT_BANNER = "argumentBanner";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ARGUMENT_SUBJECT_TYPE = "argSubjectType";
    public static final com.wy.adbook.mvp.view.fragment.ProjectFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void setupFragmentComponent(@org.jetbrains.annotations.NotNull()
    com.jess.arms.di.component.AppComponent appComponent) {
    }
    
    @java.lang.Override()
    public void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initListener() {
    }
    
    private final void initProjectView() {
    }
    
    @java.lang.Override()
    public void setData(@org.jetbrains.annotations.Nullable()
    java.lang.Object data) {
    }
    
    @java.lang.Override()
    public boolean isHandlerStatusBarHeight() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.ProjectAdapter getProjectAdapter() {
        return null;
    }
    
    public final void setProjectAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.ProjectAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.widget.LinearLayoutManager getProjectLinearLayout() {
        return null;
    }
    
    public final void setProjectLinearLayout(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.LinearLayoutManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getHeaderView() {
        return null;
    }
    
    public final void setHeaderView(@org.jetbrains.annotations.NotNull()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.model.entity.BannerItem> getBannerList() {
        return null;
    }
    
    public final void setBannerList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.BannerItem> p0) {
    }
    
    private final cn.bingoogolapple.bgabanner.BGABanner getBanner() {
        return null;
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
    
    @java.lang.Override()
    protected void loadData() {
    }
    
    private final void initBanner() {
    }
    
    @java.lang.Override()
    public void refreshBanner() {
    }
    
    @java.lang.Override()
    public void refreshStatus(boolean isRefresh) {
    }
    
    @java.lang.Override()
    public void changeStatusCoverView(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.view.status.IStatusCoverView.Status status) {
    }
    
    public ProjectFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/wy/adbook/mvp/view/fragment/ProjectFragment$Companion;", "", "()V", "ARGUMENT_BANNER", "", "ARGUMENT_SUBJECT_TYPE", "newInstance", "Lcom/wy/adbook/mvp/view/fragment/ProjectFragment;", "isBanner", "", "subjectType", "application_release"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.wy.adbook.mvp.view.fragment.ProjectFragment newInstance(boolean isBanner, @org.jetbrains.annotations.NotNull()
        java.lang.String subjectType) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}