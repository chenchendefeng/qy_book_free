package com.wy.adbook.mvp.model.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001e\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR\u001e\u0010 \u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\r\u00a8\u0006#"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/Classification;", "Ljava/io/Serializable;", "category", "", "(Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "count", "", "getCount", "()I", "setCount", "(I)V", "isSelected", "", "()Z", "setSelected", "(Z)V", "itemList", "", "Lcom/wy/adbook/mvp/model/entity/ClassificationItem;", "getItemList", "()Ljava/util/List;", "setItemList", "(Ljava/util/List;)V", "pageNo", "getPageNo", "setPageNo", "pageSize", "getPageSize", "setPageSize", "pages", "getPages", "setPages", "application_debug"})
public final class Classification implements java.io.Serializable {
    private boolean isSelected;
    @com.google.gson.annotations.SerializedName(value = "pageNo")
    private int pageNo;
    @com.google.gson.annotations.SerializedName(value = "pageSize")
    private int pageSize;
    @com.google.gson.annotations.SerializedName(value = "pages")
    private int pages;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "data")
    private java.util.List<com.wy.adbook.mvp.model.entity.ClassificationItem> itemList;
    @com.google.gson.annotations.SerializedName(value = "count")
    private int count;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String category;
    
    public final boolean isSelected() {
        return false;
    }
    
    public final void setSelected(boolean p0) {
    }
    
    public final int getPageNo() {
        return 0;
    }
    
    public final void setPageNo(int p0) {
    }
    
    public final int getPageSize() {
        return 0;
    }
    
    public final void setPageSize(int p0) {
    }
    
    public final int getPages() {
        return 0;
    }
    
    public final void setPages(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.wy.adbook.mvp.model.entity.ClassificationItem> getItemList() {
        return null;
    }
    
    public final void setItemList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.wy.adbook.mvp.model.entity.ClassificationItem> p0) {
    }
    
    public final int getCount() {
        return 0;
    }
    
    public final void setCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategory() {
        return null;
    }
    
    public final void setCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public Classification(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
        super();
    }
    
    public Classification() {
        super();
    }
}