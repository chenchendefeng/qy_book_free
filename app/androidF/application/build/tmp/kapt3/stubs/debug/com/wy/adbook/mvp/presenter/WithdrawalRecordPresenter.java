package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-26.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/wy/adbook/mvp/presenter/WithdrawalRecordPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/WithdrawalRecordContract$Model;", "Lcom/wy/adbook/mvp/contranct/WithdrawalRecordContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/WithdrawalRecordContract$Model;Lcom/wy/adbook/mvp/contranct/WithdrawalRecordContract$View;)V", "recordItemList", "", "Lcom/wy/adbook/mvp/model/entity/WithdrawalRecordItem;", "getRecordItemList", "()Ljava/util/List;", "setRecordItemList", "(Ljava/util/List;)V", "withdrawalRecordAdapter", "Lcom/wy/adbook/mvp/view/adapter/WithdrawalRecordAdapter;", "getWithdrawalRecordAdapter", "()Lcom/wy/adbook/mvp/view/adapter/WithdrawalRecordAdapter;", "setWithdrawalRecordAdapter", "(Lcom/wy/adbook/mvp/view/adapter/WithdrawalRecordAdapter;)V", "fetchData", "", "loadMore", "application_debug"})
@com.jess.arms.di.scope.ActivityScope()
public final class WithdrawalRecordPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.WithdrawalRecordContract.Model, com.wy.adbook.mvp.contranct.WithdrawalRecordContract.View> {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.WithdrawalRecordAdapter withdrawalRecordAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalRecordItem> recordItemList;
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.WithdrawalRecordAdapter getWithdrawalRecordAdapter() {
        return null;
    }
    
    public final void setWithdrawalRecordAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.WithdrawalRecordAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalRecordItem> getRecordItemList() {
        return null;
    }
    
    public final void setRecordItemList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalRecordItem> p0) {
    }
    
    public final void fetchData() {
    }
    
    public final void loadMore() {
    }
    
    @javax.inject.Inject()
    public WithdrawalRecordPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.WithdrawalRecordContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.WithdrawalRecordContract.View view) {
        super(null, null);
    }
}