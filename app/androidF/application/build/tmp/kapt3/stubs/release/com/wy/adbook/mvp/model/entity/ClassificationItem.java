package com.wy.adbook.mvp.model.entity;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/5.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010!\u001a\u00020\u000bR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006\""}, d2 = {"Lcom/wy/adbook/mvp/model/entity/ClassificationItem;", "Ljava/io/Serializable;", "()V", "bookNum", "", "getBookNum", "()I", "setBookNum", "(I)V", "categoryList", "", "", "getCategoryList", "()Ljava/util/List;", "setCategoryList", "(Ljava/util/List;)V", "classificationName", "getClassificationName", "()Ljava/lang/String;", "setClassificationName", "(Ljava/lang/String;)V", "id", "getId", "setId", "sexType", "getSexType", "setSexType", "topBook", "Lcom/wy/adbook/mvp/model/entity/book/Book;", "getTopBook", "()Lcom/wy/adbook/mvp/model/entity/book/Book;", "setTopBook", "(Lcom/wy/adbook/mvp/model/entity/book/Book;)V", "getCategoryListName", "application_release"})
public final class ClassificationItem implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "adCategory")
    private java.lang.String classificationName;
    @com.google.gson.annotations.SerializedName(value = "id")
    private int id;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "sexType")
    private java.lang.String sexType;
    @com.google.gson.annotations.SerializedName(value = "bookNum")
    private int bookNum;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "topBook")
    private com.wy.adbook.mvp.model.entity.book.Book topBook;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "childCategoryList")
    private java.util.List<java.lang.String> categoryList;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClassificationName() {
        return null;
    }
    
    public final void setClassificationName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategoryListName() {
        return null;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSexType() {
        return null;
    }
    
    public final void setSexType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getBookNum() {
        return 0;
    }
    
    public final void setBookNum(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.book.Book getTopBook() {
        return null;
    }
    
    public final void setTopBook(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.book.Book p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getCategoryList() {
        return null;
    }
    
    public final void setCategoryList(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> p0) {
    }
    
    public ClassificationItem() {
        super();
    }
}