package com.wy.adbook.mvp.model.entity.accout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b\u00a8\u0006\u0019"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/accout/FlowPage;", "Ljava/io/Serializable;", "()V", "count", "", "getCount", "()I", "setCount", "(I)V", "data", "", "Lcom/wy/adbook/mvp/model/entity/accout/FlowItem;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "otherData", "getOtherData", "setOtherData", "pageNo", "getPageNo", "setPageNo", "pages", "getPages", "setPages", "application_debug"})
public final class FlowPage implements java.io.Serializable {
    @com.google.gson.annotations.SerializedName(value = "count")
    private int count;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "data")
    private java.util.List<com.wy.adbook.mvp.model.entity.accout.FlowItem> data;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "otherData")
    private java.util.List<com.wy.adbook.mvp.model.entity.accout.FlowItem> otherData;
    @com.google.gson.annotations.SerializedName(value = "pageNo")
    private int pageNo;
    @com.google.gson.annotations.SerializedName(value = "pages")
    private int pages;
    
    public final int getCount() {
        return 0;
    }
    
    public final void setCount(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.wy.adbook.mvp.model.entity.accout.FlowItem> getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable()
    java.util.List<com.wy.adbook.mvp.model.entity.accout.FlowItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.wy.adbook.mvp.model.entity.accout.FlowItem> getOtherData() {
        return null;
    }
    
    public final void setOtherData(@org.jetbrains.annotations.Nullable()
    java.util.List<com.wy.adbook.mvp.model.entity.accout.FlowItem> p0) {
    }
    
    public final int getPageNo() {
        return 0;
    }
    
    public final void setPageNo(int p0) {
    }
    
    public final int getPages() {
        return 0;
    }
    
    public final void setPages(int p0) {
    }
    
    public FlowPage() {
        super();
    }
}