package com.wy.adbook.di.module;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-26.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\u0003H\u0007J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0007J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/wy/adbook/di/module/WithdrawalRecordModule;", "", "view", "Lcom/wy/adbook/mvp/contranct/WithdrawalRecordContract$View;", "(Lcom/wy/adbook/mvp/contranct/WithdrawalRecordContract$View;)V", "llm", "Landroid/support/v7/widget/LinearLayoutManager;", "provideAboutModel", "Lcom/wy/adbook/mvp/contranct/WithdrawalRecordContract$Model;", "model", "Lcom/wy/adbook/mvp/model/WithdrawalRecordModel;", "provideAboutView", "withdrawalRecordAdapter", "Lcom/wy/adbook/mvp/view/adapter/WithdrawalRecordAdapter;", "list", "", "Lcom/wy/adbook/mvp/model/entity/WithdrawalRecordItem;", "withdrawalRecordItemList", "application_debug"})
@dagger.Module()
public final class WithdrawalRecordModule {
    private final com.wy.adbook.mvp.contranct.WithdrawalRecordContract.View view = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.WithdrawalRecordContract.View provideAboutView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.WithdrawalRecordContract.Model provideAboutModel(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.WithdrawalRecordModel model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.view.adapter.WithdrawalRecordAdapter withdrawalRecordAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalRecordItem> list) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final android.support.v7.widget.LinearLayoutManager llm() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalRecordItem> withdrawalRecordItemList() {
        return null;
    }
    
    public WithdrawalRecordModule(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.WithdrawalRecordContract.View view) {
        super();
    }
}