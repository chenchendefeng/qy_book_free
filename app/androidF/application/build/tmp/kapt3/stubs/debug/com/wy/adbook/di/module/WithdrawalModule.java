package com.wy.adbook.di.module;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-26.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0016\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0007J\b\u0010\u0011\u001a\u00020\u000eH\u0007J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0003H\u0007J\u0018\u0010\u0018\u001a\u00020\u00062\u000e\b\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/wy/adbook/di/module/WithdrawalModule;", "", "view", "Lcom/wy/adbook/mvp/contranct/WithdrawalContract$View;", "(Lcom/wy/adbook/mvp/contranct/WithdrawalContract$View;)V", "cashWithdrawalAdapter", "Lcom/wy/adbook/mvp/view/adapter/WithdrawablAdapter;", "list2", "", "Lcom/wy/adbook/mvp/model/entity/WithdrawalItem;", "cashWithdrawalItemList", "getAdapter", "list", "getFglm", "Lcom/freebookqy/viewlib/rv/layoutmanager/FullyGridLayoutManager;", "getList", "glm1", "glm2", "goldWithdrawalItemList", "provideAboutModel", "Lcom/wy/adbook/mvp/contranct/WithdrawalContract$Model;", "model", "Lcom/wy/adbook/mvp/model/WithdrawalModel;", "provideAboutView", "withdrawalAdapter", "list1", "application_debug"})
@dagger.Module()
public final class WithdrawalModule {
    private final com.wy.adbook.mvp.contranct.WithdrawalContract.View view = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.WithdrawalContract.View provideAboutView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.WithdrawalContract.Model provideAboutModel(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.WithdrawalModel model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "glm1")
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager glm1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "glm2")
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager glm2() {
        return null;
    }
    
    private final com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager getFglm() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "list1")
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalItem> goldWithdrawalItemList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "list2")
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalItem> cashWithdrawalItemList() {
        return null;
    }
    
    private final java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalItem> getList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "adapter1")
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.view.adapter.WithdrawablAdapter withdrawalAdapter(@org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "list1")
    java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalItem> list1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "adapter2")
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.view.adapter.WithdrawablAdapter cashWithdrawalAdapter(@org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "list2")
    java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalItem> list2) {
        return null;
    }
    
    private final com.wy.adbook.mvp.view.adapter.WithdrawablAdapter getAdapter(java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalItem> list) {
        return null;
    }
    
    public WithdrawalModule(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.WithdrawalContract.View view) {
        super();
    }
}