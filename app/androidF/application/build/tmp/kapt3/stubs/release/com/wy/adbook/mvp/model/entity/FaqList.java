package com.wy.adbook.mvp.model.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/FaqList;", "Ljava/io/Serializable;", "()V", "count", "", "getCount", "()I", "setCount", "(I)V", "faqItemList", "", "Lcom/wy/adbook/mvp/model/entity/FaqItem;", "getFaqItemList", "()Ljava/util/List;", "setFaqItemList", "(Ljava/util/List;)V", "pageNo", "getPageNo", "setPageNo", "pages", "getPages", "setPages", "application_release"})
public final class FaqList implements java.io.Serializable {
    @com.google.gson.annotations.SerializedName(value = "count")
    private int count;
    @com.google.gson.annotations.SerializedName(value = "pageNo")
    private int pageNo;
    @com.google.gson.annotations.SerializedName(value = "pages")
    private int pages;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "data")
    private java.util.List<com.wy.adbook.mvp.model.entity.FaqItem> faqItemList;
    
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
    public final java.util.List<com.wy.adbook.mvp.model.entity.FaqItem> getFaqItemList() {
        return null;
    }
    
    public final void setFaqItemList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.wy.adbook.mvp.model.entity.FaqItem> p0) {
    }
    
    public FaqList() {
        super();
    }
}