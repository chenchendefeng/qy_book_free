package com.wy.adbook.mvp.model.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/ReadFooterPage;", "Ljava/io/Serializable;", "()V", "count", "", "getCount", "()I", "setCount", "(I)V", "pageNo", "getPageNo", "setPageNo", "pages", "getPages", "setPages", "readFooterItemList", "", "Lcom/wy/adbook/mvp/model/entity/ReadFooterItem;", "getReadFooterItemList", "()Ljava/util/List;", "setReadFooterItemList", "(Ljava/util/List;)V", "application_release"})
public final class ReadFooterPage implements java.io.Serializable {
    
    /**
     * * "count": 0,
     *    "data": [
     *    {
     *    "bid": 0,
     *    "coverImg": "string",
     *    "createDate": "2019-05-28T09:30:34.121Z",
     *    "cuId": 0,
     *    "id": 0,
     *    "name": "string"
     *    }
     *    ],
     *    "otherData": [
     *    {
     *    "bid": 0,
     *    "coverImg": "string",
     *    "createDate": "2019-05-28T09:30:34.121Z",
     *    "cuId": 0,
     *    "id": 0,
     *    "name": "string"
     *    }
     *    ],
     *    "pageNo": 0,
     *    "pageSize": 0,
     *    "pages": 0
     */
    @com.google.gson.annotations.SerializedName(value = "count")
    private int count;
    @com.google.gson.annotations.SerializedName(value = "pageNo")
    private int pageNo;
    @com.google.gson.annotations.SerializedName(value = "pages")
    private int pages;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "data")
    private java.util.List<com.wy.adbook.mvp.model.entity.ReadFooterItem> readFooterItemList;
    
    public final int getCount() {
        return 0;
    }
    
    public final void setCount(int p0) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.wy.adbook.mvp.model.entity.ReadFooterItem> getReadFooterItemList() {
        return null;
    }
    
    public final void setReadFooterItemList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.wy.adbook.mvp.model.entity.ReadFooterItem> p0) {
    }
    
    public ReadFooterPage() {
        super();
    }
}