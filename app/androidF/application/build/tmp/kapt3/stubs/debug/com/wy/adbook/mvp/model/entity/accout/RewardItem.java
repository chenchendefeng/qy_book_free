package com.wy.adbook.mvp.model.entity.accout;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-16.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/accout/RewardItem;", "Ljava/io/Serializable;", "()V", "days", "", "getDays", "()I", "setDays", "(I)V", "gold", "", "getGold", "()Ljava/lang/String;", "setGold", "(Ljava/lang/String;)V", "type", "getType", "setType", "application_debug"})
public final class RewardItem implements java.io.Serializable {
    @com.google.gson.annotations.SerializedName(value = "days")
    private int days;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "gold")
    private java.lang.String gold;
    
    /**
     * * 类型（firstSign:首签；dailySign：日常；continuitySign：连续）
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "type")
    private java.lang.String type;
    
    public final int getDays() {
        return 0;
    }
    
    public final void setDays(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGold() {
        return null;
    }
    
    public final void setGold(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public RewardItem() {
        super();
    }
}