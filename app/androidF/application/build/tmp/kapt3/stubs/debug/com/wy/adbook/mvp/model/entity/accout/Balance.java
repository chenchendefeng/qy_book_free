package com.wy.adbook.mvp.model.entity.accout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/accout/Balance;", "Ljava/io/Serializable;", "()V", "goldBalance", "", "getGoldBalance", "()I", "setGoldBalance", "(I)V", "rmbTotal", "getRmbTotal", "setRmbTotal", "rmbalance", "getRmbalance", "setRmbalance", "application_debug"})
public final class Balance implements java.io.Serializable {
    
    /**
     * * 金币余额
     */
    @com.google.gson.annotations.SerializedName(value = "goldBalance")
    private int goldBalance;
    
    /**
     * * 人民币总额
     */
    @com.google.gson.annotations.SerializedName(value = "rmbTotal")
    private int rmbTotal;
    
    /**
     * * 人民币余额
     */
    @com.google.gson.annotations.SerializedName(value = "rmbalance")
    private int rmbalance;
    
    public final int getGoldBalance() {
        return 0;
    }
    
    public final void setGoldBalance(int p0) {
    }
    
    public final int getRmbTotal() {
        return 0;
    }
    
    public final void setRmbTotal(int p0) {
    }
    
    public final int getRmbalance() {
        return 0;
    }
    
    public final void setRmbalance(int p0) {
    }
    
    public Balance() {
        super();
    }
}