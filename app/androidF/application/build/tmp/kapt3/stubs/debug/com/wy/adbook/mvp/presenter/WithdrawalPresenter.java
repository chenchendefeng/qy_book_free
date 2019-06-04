package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-26.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u000fJ\u0006\u0010!\u001a\u00020\u001bR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013\u00a8\u0006\""}, d2 = {"Lcom/wy/adbook/mvp/presenter/WithdrawalPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/WithdrawalContract$Model;", "Lcom/wy/adbook/mvp/contranct/WithdrawalContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/WithdrawalContract$Model;Lcom/wy/adbook/mvp/contranct/WithdrawalContract$View;)V", "cashAdapter", "Lcom/wy/adbook/mvp/view/adapter/WithdrawablAdapter;", "getCashAdapter", "()Lcom/wy/adbook/mvp/view/adapter/WithdrawablAdapter;", "setCashAdapter", "(Lcom/wy/adbook/mvp/view/adapter/WithdrawablAdapter;)V", "cashList", "", "Lcom/wy/adbook/mvp/model/entity/WithdrawalItem;", "getCashList", "()Ljava/util/List;", "setCashList", "(Ljava/util/List;)V", "goldAdapter", "getGoldAdapter", "setGoldAdapter", "goldList", "getGoldList", "setGoldList", "enterCashDetail", "", "enterGoldDetail", "enterWithdrawalDetail", "fetchData", "startWithdrawal", "withdrawalItem", "toInviteFriends", "application_debug"})
@com.jess.arms.di.scope.ActivityScope()
public final class WithdrawalPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.WithdrawalContract.Model, com.wy.adbook.mvp.contranct.WithdrawalContract.View> {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "adapter1")
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.WithdrawablAdapter goldAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "adapter2")
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.WithdrawablAdapter cashAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "list1")
    @javax.inject.Inject()
    public java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalItem> goldList;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "list2")
    @javax.inject.Inject()
    public java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalItem> cashList;
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.WithdrawablAdapter getGoldAdapter() {
        return null;
    }
    
    public final void setGoldAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.WithdrawablAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.WithdrawablAdapter getCashAdapter() {
        return null;
    }
    
    public final void setCashAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.WithdrawablAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalItem> getGoldList() {
        return null;
    }
    
    public final void setGoldList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalItem> getCashList() {
        return null;
    }
    
    public final void setCashList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.WithdrawalItem> p0) {
    }
    
    public final void fetchData() {
    }
    
    public final void startWithdrawal(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.WithdrawalItem withdrawalItem) {
    }
    
    public final void enterGoldDetail() {
    }
    
    public final void enterWithdrawalDetail() {
    }
    
    public final void toInviteFriends() {
    }
    
    public final void enterCashDetail() {
    }
    
    @javax.inject.Inject()
    public WithdrawalPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.WithdrawalContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.WithdrawalContract.View view) {
        super(null, null);
    }
}