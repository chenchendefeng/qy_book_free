package com.wy.adbook.app.manager;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-08.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\b\u0010\u000e\u001a\u00020\bH\u0002J\u0006\u0010\u000f\u001a\u00020\nJ\b\u0010\u0010\u001a\u00020\bH\u0002J\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\u0018J\u0006\u0010#\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&J\u0010\u0010\'\u001a\u00020\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/wy/adbook/app/manager/QYAccount;", "", "()V", "isRegister", "", "userInfo", "Lcom/wy/adbook/mvp/model/entity/accout/UserInfo;", "userToken", "", "cashNum", "", "getGender", "getInviteCode", "getInviteQrCode", "getTodayReadKey", "getTodayReadMinute", "getTodayWatchVideoKey", "getUserInfo", "getUserToken", "goldBeanNum", "isLogin", "isTodayWatchVideo", "isVip", "loginSuccess", "", "Lcom/wy/adbook/mvp/model/entity/accout/LoginSuccess;", "logoutSuccess", "postLoginSuccess", "setGender", "gender", "setRegister", "register", "setUserInfo", "setUserToke", "todayIsWatchVideoSuccess", "uid", "updateTodayReadMinute", "minutes", "", "updateUserCustomerBizInfo", "application_debug"})
public final class QYAccount {
    private static com.wy.adbook.mvp.model.entity.accout.UserInfo userInfo;
    private static java.lang.String userToken;
    private static boolean isRegister;
    public static final com.wy.adbook.app.manager.QYAccount INSTANCE = null;
    
    public final void setRegister(boolean register) {
    }
    
    public final boolean isRegister() {
        return false;
    }
    
    public final void setUserToke(@org.jetbrains.annotations.NotNull()
    java.lang.String userToken) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserToken() {
        return null;
    }
    
    public final void setUserInfo(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.accout.UserInfo userInfo) {
    }
    
    /**
     * *"avatar": "string",
     *    "cuId": 0,
     *    "cuName": "string",
     *    "freeAdvTime": "2019-05-28T08:50:18.095Z",
     *    "nickName": "string",
     *    "userStatus": "string",
     *    "userType": "string",
     *    "vipEndDate": "2019-05-28T08:50:18.095Z",
     *    "vipFlag": "string",
     *    "vipStartDate": "2019-05-28T08:50:18.095Z"
     */
    public final void updateUserCustomerBizInfo(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.accout.UserInfo userInfo) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.model.entity.accout.UserInfo getUserInfo() {
        return null;
    }
    
    public final int uid() {
        return 0;
    }
    
    public final boolean isLogin() {
        return false;
    }
    
    /**
     * * 设置gender
     */
    public final void setGender(int gender) {
    }
    
    /**
     * * 获取gender
     */
    public final int getGender() {
        return 0;
    }
    
    /**
     * * 金豆
     */
    public final int goldBeanNum() {
        return 0;
    }
    
    /**
     * * 现金
     */
    public final int cashNum() {
        return 0;
    }
    
    /**
     * * 今日阅读
     */
    public final int getTodayReadMinute() {
        return 0;
    }
    
    public final void updateTodayReadMinute(long minutes) {
    }
    
    private final java.lang.String getTodayReadKey() {
        return null;
    }
    
    public final void loginSuccess(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.accout.LoginSuccess loginSuccess) {
    }
    
    public final void postLoginSuccess() {
    }
    
    public final void logoutSuccess() {
    }
    
    public final void todayIsWatchVideoSuccess() {
    }
    
    public final boolean isTodayWatchVideo() {
        return false;
    }
    
    private final java.lang.String getTodayWatchVideoKey() {
        return null;
    }
    
    /**
     * * 是否vip
     */
    public final boolean isVip() {
        return false;
    }
    
    /**
     * * 获取用户红包码
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getInviteCode() {
        return null;
    }
    
    /**
     * * 获取下载图片二维码
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getInviteQrCode() {
        return null;
    }
    
    private QYAccount() {
        super();
    }
}