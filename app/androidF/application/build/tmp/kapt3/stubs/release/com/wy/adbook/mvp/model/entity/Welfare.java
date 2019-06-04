package com.wy.adbook.mvp.model.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/Welfare;", "Ljava/io/Serializable;", "()V", "dailyList", "", "Lcom/wy/adbook/mvp/model/entity/WelfareItem;", "getDailyList", "()Ljava/util/List;", "setDailyList", "(Ljava/util/List;)V", "noviceList", "getNoviceList", "setNoviceList", "readList", "getReadList", "setReadList", "application_release"})
public final class Welfare implements java.io.Serializable {
    
    /**
     * * 日常福利
     */
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "dailyList")
    private java.util.List<com.wy.adbook.mvp.model.entity.WelfareItem> dailyList;
    
    /**
     * * 新人福利
     */
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "noviceList")
    private java.util.List<com.wy.adbook.mvp.model.entity.WelfareItem> noviceList;
    
    /**
     * * 阅读福利
     */
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "readList")
    private java.util.List<com.wy.adbook.mvp.model.entity.WelfareItem> readList;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.wy.adbook.mvp.model.entity.WelfareItem> getDailyList() {
        return null;
    }
    
    public final void setDailyList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.wy.adbook.mvp.model.entity.WelfareItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.wy.adbook.mvp.model.entity.WelfareItem> getNoviceList() {
        return null;
    }
    
    public final void setNoviceList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.wy.adbook.mvp.model.entity.WelfareItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.wy.adbook.mvp.model.entity.WelfareItem> getReadList() {
        return null;
    }
    
    public final void setReadList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.wy.adbook.mvp.model.entity.WelfareItem> p0) {
    }
    
    public Welfare() {
        super();
    }
}