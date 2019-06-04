package com.wy.adbook.mvp.model.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u0000 52\u00020\u0001:\u00015B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001e\u0010#\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR\u001e\u0010&\u001a\u00020\'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001e\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\u001e\u00102\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\b\u00a8\u00066"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/Chapter;", "Ljava/io/Serializable;", "()V", "bid", "", "getBid", "()I", "setBid", "(I)V", "chapterTitle", "", "getChapterTitle", "()Ljava/lang/String;", "setChapterTitle", "(Ljava/lang/String;)V", "cid", "getCid", "setCid", "displayOrder", "getDisplayOrder", "setDisplayOrder", "id", "getId", "setId", "importContent", "getImportContent", "setImportContent", "isSelected", "", "()Z", "setSelected", "(Z)V", "originalBid", "getOriginalBid", "setOriginalBid", "ossUrl", "getOssUrl", "setOssUrl", "updateTime", "", "getUpdateTime", "()J", "setUpdateTime", "(J)V", "vid", "getVid", "setVid", "vipStatus", "getVipStatus", "setVipStatus", "wordNum", "getWordNum", "setWordNum", "Companion", "application_debug"})
public final class Chapter implements java.io.Serializable {
    private boolean isSelected;
    
    /**
     * * 书籍id
     */
    @com.google.gson.annotations.SerializedName(value = "bid")
    private int bid;
    
    /**
     * * 章节标题
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "chapterTitle")
    private java.lang.String chapterTitle;
    
    /**
     * * 章节ID
     */
    @com.google.gson.annotations.SerializedName(value = "cid")
    private int cid;
    
    /**
     * * 排序
     */
    @com.google.gson.annotations.SerializedName(value = "displayOrder")
    private int displayOrder;
    @com.google.gson.annotations.SerializedName(value = "id")
    private int id;
    
    /**
     * *
     *     * 是否导入内容 （0：否 | 1：是）
     *     * @link IMPORT_OFF
     *     * @link IMPORT_ON
     */
    @com.google.gson.annotations.SerializedName(value = "importContent")
    private int importContent;
    
    /**
     * * 原书籍ID
     */
    @com.google.gson.annotations.SerializedName(value = "originalBid")
    private int originalBid;
    
    /**
     * * 修改时间
     */
    @com.google.gson.annotations.SerializedName(value = "updateTime")
    private long updateTime;
    
    /**
     * * vip  id
     */
    @com.google.gson.annotations.SerializedName(value = "vid")
    private int vid;
    
    /**
     * * VIP状态 （0：否 | 1：是）
     */
    @com.google.gson.annotations.SerializedName(value = "vipStatus")
    private int vipStatus;
    
    /**
     * * 字数
     */
    @com.google.gson.annotations.SerializedName(value = "wordNum")
    private int wordNum;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ossUrl")
    private java.lang.String ossUrl;
    
    /**
     * * 是否导入内容 否
     */
    public static final int IMPORT_OFF = 0;
    
    /**
     * * 是否导入内容 是
     */
    public static final int IMPORT_ON = 1;
    public static final com.wy.adbook.mvp.model.entity.Chapter.Companion Companion = null;
    
    public final boolean isSelected() {
        return false;
    }
    
    public final void setSelected(boolean p0) {
    }
    
    public final int getBid() {
        return 0;
    }
    
    public final void setBid(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChapterTitle() {
        return null;
    }
    
    public final void setChapterTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getCid() {
        return 0;
    }
    
    public final void setCid(int p0) {
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
    
    public final int getImportContent() {
        return 0;
    }
    
    public final void setImportContent(int p0) {
    }
    
    public final int getOriginalBid() {
        return 0;
    }
    
    public final void setOriginalBid(int p0) {
    }
    
    public final long getUpdateTime() {
        return 0L;
    }
    
    public final void setUpdateTime(long p0) {
    }
    
    public final int getVid() {
        return 0;
    }
    
    public final void setVid(int p0) {
    }
    
    public final int getVipStatus() {
        return 0;
    }
    
    public final void setVipStatus(int p0) {
    }
    
    public final int getWordNum() {
        return 0;
    }
    
    public final void setWordNum(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOssUrl() {
        return null;
    }
    
    public final void setOssUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public Chapter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/Chapter$Companion;", "", "()V", "IMPORT_OFF", "", "IMPORT_ON", "application_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}