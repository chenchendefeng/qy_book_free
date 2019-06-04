package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001dJ\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\bJ\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001bJ\u0010\u0010%\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010\'J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002J\u0016\u0010)\u001a\u00020\u001d2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/wy/adbook/mvp/presenter/ProjectPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/ProjectContract$Model;", "Lcom/wy/adbook/mvp/contranct/ProjectContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/ProjectContract$Model;Lcom/wy/adbook/mvp/contranct/ProjectContract$View;)V", "bannerList", "", "Lcom/wy/adbook/mvp/model/entity/BannerItem;", "getBannerList", "()Ljava/util/List;", "setBannerList", "(Ljava/util/List;)V", "mProjectList", "Lcom/wy/adbook/mvp/view/adapter/ProjectItem;", "getMProjectList", "setMProjectList", "projectAdapter", "Lcom/wy/adbook/mvp/view/adapter/ProjectAdapter;", "getProjectAdapter", "()Lcom/wy/adbook/mvp/view/adapter/ProjectAdapter;", "setProjectAdapter", "(Lcom/wy/adbook/mvp/view/adapter/ProjectAdapter;)V", "subjectTypeList", "Lcom/wy/adbook/mvp/model/entity/SubjectType;", "subjectTypeStr", "", "fetchBanner", "", "fetchData", "fetchSubject", "isRefresh", "", "getTestData", "handlerBannerItem", "url", "initData", "bundle", "Landroid/os/Bundle;", "refreshDataAndView", "replaceBannerList", "it", "application_release"})
@com.jess.arms.di.scope.FragmentScope()
public final class ProjectPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.ProjectContract.Model, com.wy.adbook.mvp.contranct.ProjectContract.View> {
    private java.lang.String subjectTypeStr;
    private java.util.List<com.wy.adbook.mvp.model.entity.SubjectType> subjectTypeList;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public java.util.List<com.wy.adbook.mvp.model.entity.BannerItem> bannerList;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.ProjectAdapter projectAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public java.util.List<com.wy.adbook.mvp.view.adapter.ProjectItem> mProjectList;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.model.entity.BannerItem> getBannerList() {
        return null;
    }
    
    public final void setBannerList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.BannerItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.ProjectAdapter getProjectAdapter() {
        return null;
    }
    
    public final void setProjectAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.ProjectAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.view.adapter.ProjectItem> getMProjectList() {
        return null;
    }
    
    public final void setMProjectList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.view.adapter.ProjectItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.view.adapter.ProjectItem> getTestData() {
        return null;
    }
    
    public final void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle) {
    }
    
    public final void fetchData() {
    }
    
    private final void fetchBanner() {
    }
    
    private final void replaceBannerList(java.util.List<com.wy.adbook.mvp.model.entity.BannerItem> it) {
    }
    
    private final void fetchSubject(boolean isRefresh) {
    }
    
    private final void refreshDataAndView(boolean isRefresh) {
    }
    
    public final void handlerBannerItem(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    @javax.inject.Inject()
    public ProjectPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.ProjectContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.ProjectContract.View view) {
        super(null, null);
    }
}