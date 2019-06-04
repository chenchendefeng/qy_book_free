package com.wy.adbook.di.module;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-28.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0003H\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0007J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/wy/adbook/di/module/ReadFooterModule;", "", "view", "Lcom/wy/adbook/mvp/contranct/ReadFooterContract$View;", "(Lcom/wy/adbook/mvp/contranct/ReadFooterContract$View;)V", "provideAboutModel", "Lcom/wy/adbook/mvp/contranct/ReadFooterContract$Model;", "model", "Lcom/wy/adbook/mvp/model/ReadFooterModel;", "provideAboutView", "provideLinearLayout", "Landroid/support/v7/widget/LinearLayoutManager;", "provideReadFooterAdapter", "Lcom/wy/adbook/mvp/view/adapter/ReadFooterAdapter;", "list", "", "Lcom/wy/adbook/mvp/model/entity/ReadFooterItem;", "provideReadFooterItemList", "application_release"})
@dagger.Module()
public final class ReadFooterModule {
    private final com.wy.adbook.mvp.contranct.ReadFooterContract.View view = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.ReadFooterContract.View provideAboutView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.ReadFooterContract.Model provideAboutModel(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.ReadFooterModel model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final android.support.v7.widget.LinearLayoutManager provideLinearLayout() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.view.adapter.ReadFooterAdapter provideReadFooterAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.ReadFooterItem> list) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final java.util.List<com.wy.adbook.mvp.model.entity.ReadFooterItem> provideReadFooterItemList() {
        return null;
    }
    
    public ReadFooterModule(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.ReadFooterContract.View view) {
        super();
    }
}