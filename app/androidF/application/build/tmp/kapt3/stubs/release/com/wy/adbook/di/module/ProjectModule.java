package com.wy.adbook.di.module;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/1.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0003H\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0007J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0006H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/wy/adbook/di/module/ProjectModule;", "", "view", "Lcom/wy/adbook/mvp/contranct/ProjectContract$View;", "(Lcom/wy/adbook/mvp/contranct/ProjectContract$View;)V", "bannerList", "", "Lcom/wy/adbook/mvp/model/entity/BannerItem;", "headerView", "Landroid/view/View;", "projectAdapter", "Lcom/wy/adbook/mvp/view/adapter/ProjectAdapter;", "list", "Lcom/wy/adbook/mvp/view/adapter/ProjectItem;", "provideAboutModel", "Lcom/wy/adbook/mvp/contranct/ProjectContract$Model;", "model", "Lcom/wy/adbook/mvp/model/ProjectModel;", "provideAboutView", "provideLayoutManager1", "Landroid/support/v7/widget/LinearLayoutManager;", "provideProjectList", "application_release"})
@dagger.Module()
public final class ProjectModule {
    private final com.wy.adbook.mvp.contranct.ProjectContract.View view = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.FragmentScope()
    public final com.wy.adbook.mvp.contranct.ProjectContract.View provideAboutView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.FragmentScope()
    public final com.wy.adbook.mvp.contranct.ProjectContract.Model provideAboutModel(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.ProjectModel model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.FragmentScope()
    public final android.support.v7.widget.LinearLayoutManager provideLayoutManager1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.FragmentScope()
    public final java.util.List<com.wy.adbook.mvp.view.adapter.ProjectItem> provideProjectList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.FragmentScope()
    public final com.wy.adbook.mvp.view.adapter.ProjectAdapter projectAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.view.adapter.ProjectItem> list) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.FragmentScope()
    public final android.view.View headerView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.FragmentScope()
    public final java.util.List<com.wy.adbook.mvp.model.entity.BannerItem> bannerList() {
        return null;
    }
    
    public ProjectModule(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.ProjectContract.View view) {
        super();
    }
}