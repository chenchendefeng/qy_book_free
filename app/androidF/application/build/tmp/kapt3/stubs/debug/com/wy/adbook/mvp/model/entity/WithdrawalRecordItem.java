package com.wy.adbook.mvp.model.entity;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/WithdrawalRecordItem;", "Ljava/io/Serializable;", "()V", "amount", "", "getAmount", "()I", "setAmount", "(I)V", "status", "getStatus", "setStatus", "time", "", "getTime", "()Ljava/lang/String;", "setTime", "(Ljava/lang/String;)V", "application_debug"})
public final class WithdrawalRecordItem implements java.io.Serializable {
    @com.google.gson.annotations.SerializedName(value = "status")
    private int status;
    @com.google.gson.annotations.SerializedName(value = "amount")
    private int amount;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "time")
    private java.lang.String time;
    
    public final int getStatus() {
        return 0;
    }
    
    public final void setStatus(int p0) {
    }
    
    public final int getAmount() {
        return 0;
    }
    
    public final void setAmount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTime() {
        return null;
    }
    
    public final void setTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public WithdrawalRecordItem() {
        super();
    }
}