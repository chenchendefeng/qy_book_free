package com.wy.adbook.mvp.model.entity.accout;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-13.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/accout/LoginSuccess;", "Ljava/io/Serializable;", "()V", "isRegister", "", "()Z", "setRegister", "(Z)V", "userInfo", "Lcom/wy/adbook/mvp/model/entity/accout/UserInfo;", "getUserInfo", "()Lcom/wy/adbook/mvp/model/entity/accout/UserInfo;", "setUserInfo", "(Lcom/wy/adbook/mvp/model/entity/accout/UserInfo;)V", "userToken", "", "getUserToken", "()Ljava/lang/String;", "setUserToken", "(Ljava/lang/String;)V", "application_release"})
public class LoginSuccess implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "userToken")
    private java.lang.String userToken;
    @com.google.gson.annotations.SerializedName(value = "isRegister")
    private boolean isRegister;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "userInfo")
    private com.wy.adbook.mvp.model.entity.accout.UserInfo userInfo;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserToken() {
        return null;
    }
    
    public final void setUserToken(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isRegister() {
        return false;
    }
    
    public final void setRegister(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.accout.UserInfo getUserInfo() {
        return null;
    }
    
    public final void setUserInfo(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.accout.UserInfo p0) {
    }
    
    public LoginSuccess() {
        super();
    }
}