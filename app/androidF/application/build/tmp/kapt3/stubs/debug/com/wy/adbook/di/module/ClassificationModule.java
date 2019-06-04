package com.wy.adbook.di.module;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/5.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u0003H\u0007J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\bH\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0007J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u000bH\u0007J\b\u0010\u0019\u001a\u00020\u000bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/wy/adbook/di/module/ClassificationModule;", "", "view", "Lcom/wy/adbook/mvp/contranct/ClassificationContract$View;", "(Lcom/wy/adbook/mvp/contranct/ClassificationContract$View;)V", "classificationAdapter", "Lcom/wy/adbook/mvp/view/adapter/ClassificationAdapter;", "list", "", "Lcom/wy/adbook/mvp/model/entity/Classification;", "getLinearLayoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "provideAboutModel", "Lcom/wy/adbook/mvp/contranct/ClassificationContract$Model;", "model", "Lcom/wy/adbook/mvp/model/ClassificationModel;", "provideAboutView", "provideBannerList", "Lcom/wy/adbook/mvp/model/entity/BannerItem;", "provideClassificationContentAdapter", "Lcom/wy/adbook/mvp/view/adapter/ClassificationContentAdapter;", "provideClassificationList", "provideHeaderView", "Landroid/view/View;", "provideLinearLayoutManager1", "provideLinearLayoutManager2", "application_debug"})
@dagger.Module()
public final class ClassificationModule {
    private final com.wy.adbook.mvp.contranct.ClassificationContract.View view = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.ClassificationContract.View provideAboutView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.ClassificationContract.Model provideAboutModel(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.ClassificationModel model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Named(value = "l1")
    @com.jess.arms.di.scope.ActivityScope()
    public final android.support.v7.widget.LinearLayoutManager provideLinearLayoutManager1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Named(value = "l2")
    @com.jess.arms.di.scope.ActivityScope()
    public final android.support.v7.widget.LinearLayoutManager provideLinearLayoutManager2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final android.support.v7.widget.LinearLayoutManager getLinearLayoutManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final android.view.View provideHeaderView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final java.util.List<com.wy.adbook.mvp.model.entity.BannerItem> provideBannerList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final java.util.List<com.wy.adbook.mvp.model.entity.Classification> provideClassificationList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.view.adapter.ClassificationAdapter classificationAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.Classification> list) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.view.adapter.ClassificationContentAdapter provideClassificationContentAdapter() {
        return null;
    }
    
    public ClassificationModule(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.ClassificationContract.View view) {
        super();
    }
}