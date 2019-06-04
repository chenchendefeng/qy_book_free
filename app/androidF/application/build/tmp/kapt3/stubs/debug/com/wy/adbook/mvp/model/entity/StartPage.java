package com.wy.adbook.mvp.model.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/StartPage;", "Ljava/io/Serializable;", "()V", "beginDate", "", "getBeginDate", "()Ljava/lang/String;", "setBeginDate", "(Ljava/lang/String;)V", "channelCodes", "getChannelCodes", "setChannelCodes", "clientType", "getClientType", "setClientType", "endDate", "getEndDate", "setEndDate", "fileType", "getFileType", "setFileType", "fileUrl", "getFileUrl", "setFileUrl", "id", "", "getId", "()I", "setId", "(I)V", "status", "getStatus", "setStatus", "application_debug"})
public final class StartPage implements java.io.Serializable {
    
    /**
     * * 有效期-开始时间
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "beginDate")
    private java.lang.String beginDate;
    
    /**
     * * 渠道编号array ( 多个渠道号用","分隔 )
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "channelCodes")
    private java.lang.String channelCodes;
    
    /**
     * * 渠道编号array ( 多个渠道号用","分隔 )
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "clientType")
    private java.lang.String clientType;
    
    /**
     * * 有效期-结束时间
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "endDate")
    private java.lang.String endDate;
    
    /**
     * * 文件类型 （ pic-图片 | gif-动图 | video-视频 )
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "fileType")
    private java.lang.String fileType;
    
    /**
     * * 文件地址
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "fileUrl")
    private java.lang.String fileUrl;
    
    /**
     * *
     */
    @com.google.gson.annotations.SerializedName(value = "id")
    private int id;
    
    /**
     * * 是否启用 （ 1-启用 | 0-停用 ）
     */
    @com.google.gson.annotations.SerializedName(value = "status")
    private int status;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBeginDate() {
        return null;
    }
    
    public final void setBeginDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChannelCodes() {
        return null;
    }
    
    public final void setChannelCodes(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClientType() {
        return null;
    }
    
    public final void setClientType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEndDate() {
        return null;
    }
    
    public final void setEndDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFileType() {
        return null;
    }
    
    public final void setFileType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFileUrl() {
        return null;
    }
    
    public final void setFileUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    public StartPage() {
        super();
    }
}