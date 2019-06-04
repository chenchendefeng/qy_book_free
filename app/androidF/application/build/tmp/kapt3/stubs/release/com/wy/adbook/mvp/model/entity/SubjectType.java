package com.wy.adbook.mvp.model.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b#\u0018\u0000 12\u00020\u0001:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001e\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001e\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001e\u0010\"\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001e\u0010%\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b\'\u0010\u0013R\u001e\u0010(\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010\u0013R\u001e\u0010+\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u0013R\u001e\u0010.\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0011\"\u0004\b0\u0010\u0013\u00a8\u00062"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/SubjectType;", "Ljava/io/Serializable;", "()V", "bidList", "", "", "getBidList", "()Ljava/util/List;", "setBidList", "(Ljava/util/List;)V", "bookList", "Lcom/wy/adbook/mvp/model/entity/book/Book;", "getBookList", "setBookList", "createTime", "", "getCreateTime", "()Ljava/lang/String;", "setCreateTime", "(Ljava/lang/String;)V", "displayOrder", "getDisplayOrder", "()I", "setDisplayOrder", "(I)V", "id", "getId", "setId", "status", "getStatus", "setStatus", "subjectType", "getSubjectType", "setSubjectType", "title", "getTitle", "setTitle", "title2", "getTitle2", "setTitle2", "title2RGB", "getTitle2RGB", "setTitle2RGB", "titleRGB", "getTitleRGB", "setTitleRGB", "updateTime", "getUpdateTime", "setUpdateTime", "Companion", "application_release"})
public final class SubjectType implements java.io.Serializable {
    
    /**
     * * 格式:2019-04-28 08:41:43
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "createTime")
    private java.lang.String createTime;
    @com.google.gson.annotations.SerializedName(value = "displayOrder")
    private int displayOrder;
    @com.google.gson.annotations.SerializedName(value = "id")
    private int id;
    @com.google.gson.annotations.SerializedName(value = "status")
    private int status;
    
    /**
     * * boy|girl|recommend
     *     * @link SUBJECT_TYPE_BOY
     *     * @link SUBJECT_TYPE_GIRL
     *     * @link SUBJECT_TYPE_RECOMMEND
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "subjectType")
    private java.lang.String subjectType;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "title")
    private java.lang.String title;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "title2")
    private java.lang.String title2;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "title2RGB")
    private java.lang.String title2RGB;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "titleRGB")
    private java.lang.String titleRGB;
    
    /**
     * * 2019-04-28 08:41:45
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "updateTime")
    private java.lang.String updateTime;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "bookList")
    private java.util.List<com.wy.adbook.mvp.model.entity.book.Book> bookList;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "bidList")
    private java.util.List<java.lang.Integer> bidList;
    
    /**
     * * 男生
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SUBJECT_TYPE_BOY = "boy";
    
    /**
     * * 女生
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SUBJECT_TYPE_GIRL = "girl";
    
    /**
     * * 推荐
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SUBJECT_TYPE_RECOMMEND = "recommend";
    public static final com.wy.adbook.mvp.model.entity.SubjectType.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreateTime() {
        return null;
    }
    
    public final void setCreateTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getDisplayOrder() {
        return 0;
    }
    
    public final void setDisplayOrder(int p0) {
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    public final int getStatus() {
        return 0;
    }
    
    public final void setStatus(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSubjectType() {
        return null;
    }
    
    public final void setSubjectType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle2() {
        return null;
    }
    
    public final void setTitle2(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle2RGB() {
        return null;
    }
    
    public final void setTitle2RGB(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitleRGB() {
        return null;
    }
    
    public final void setTitleRGB(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUpdateTime() {
        return null;
    }
    
    public final void setUpdateTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.wy.adbook.mvp.model.entity.book.Book> getBookList() {
        return null;
    }
    
    public final void setBookList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.wy.adbook.mvp.model.entity.book.Book> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.Integer> getBidList() {
        return null;
    }
    
    public final void setBidList(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.Integer> p0) {
    }
    
    public SubjectType() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/SubjectType$Companion;", "", "()V", "SUBJECT_TYPE_BOY", "", "SUBJECT_TYPE_GIRL", "SUBJECT_TYPE_RECOMMEND", "application_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}