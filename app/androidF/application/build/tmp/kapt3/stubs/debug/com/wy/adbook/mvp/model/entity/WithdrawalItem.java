package com.wy.adbook.mvp.model.entity;

import java.lang.System;

/**
 * * 提现兑换规则
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001e\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\u001e\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/WithdrawalItem;", "Ljava/io/Serializable;", "()V", "goldCount", "", "getGoldCount", "()I", "setGoldCount", "(I)V", "isNew", "setNew", "withdrawalCash", "getWithdrawalCash", "setWithdrawalCash", "withdrawalId", "getWithdrawalId", "setWithdrawalId", "application_debug"})
public final class WithdrawalItem implements java.io.Serializable {
    @com.google.gson.annotations.SerializedName(value = "is_new")
    private int isNew;
    @com.google.gson.annotations.SerializedName(value = "withdrawal_cash")
    private int withdrawalCash;
    @com.google.gson.annotations.SerializedName(value = "need_gold")
    private int goldCount;
    @com.google.gson.annotations.SerializedName(value = "id")
    private int withdrawalId;
    
    public final int isNew() {
        return 0;
    }
    
    public final void setNew(int p0) {
    }
    
    public final int getWithdrawalCash() {
        return 0;
    }
    
    public final void setWithdrawalCash(int p0) {
    }
    
    public final int getGoldCount() {
        return 0;
    }
    
    public final void setGoldCount(int p0) {
    }
    
    public final int getWithdrawalId() {
        return 0;
    }
    
    public final void setWithdrawalId(int p0) {
    }
    
    public WithdrawalItem() {
        super();
    }
}