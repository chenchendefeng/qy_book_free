package com.wy.adbook.mvp.view.web.bean;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-27.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/wy/adbook/mvp/view/web/bean/H5UserInfo;", "", "()V", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "uid", "", "getUid", "()I", "setUid", "(I)V", "Companion", "application_release"})
public final class H5UserInfo {
    @com.google.gson.annotations.SerializedName(value = "uid")
    private int uid;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "token")
    private java.lang.String token;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String METHOD_NAME = "getUserInfo";
    public static final com.wy.adbook.mvp.view.web.bean.H5UserInfo.Companion Companion = null;
    
    public final int getUid() {
        return 0;
    }
    
    public final void setUid(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getToken() {
        return null;
    }
    
    public final void setToken(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public H5UserInfo() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/wy/adbook/mvp/view/web/bean/H5UserInfo$Companion;", "", "()V", "METHOD_NAME", "", "application_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}