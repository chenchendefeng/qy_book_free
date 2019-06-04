package com.wy.adbook.app.manager;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-24.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J(\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/wy/adbook/app/manager/SchemeManager;", "", "()V", "BOOK_SCHEME_BOOK", "", "getAttendanceStatus", "", "rootView", "Lcom/wy/adbook/app/base/QYView;", "rm", "Lcom/jess/arms/integration/IRepositoryManager;", "handler", "Lme/jessyan/rxerrorhandler/core/RxErrorHandler;", "isAdScheme", "", "url", "parseScheme", "share", "context", "Landroid/content/Context;", "Scheme", "application_release"})
public final class SchemeManager {
    
    /**
     * * 进入书籍界面的scheme
     */
    private static final java.lang.String BOOK_SCHEME_BOOK = "book://";
    public static final com.wy.adbook.app.manager.SchemeManager INSTANCE = null;
    
    /**
     * * 判断链接是否为广告
     */
    public final boolean isAdScheme(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return false;
    }
    
    /**
     * url:"http://www.baidu.com"  (h5)
     *    url:"bookshelf"  (书架页)
     *    url:"bindPhone" (绑定手机)
     *    url:"rewardCode" (填红包码)
     *    url:"wallet" (我的钱包)
     *    url:"withdraw"   (我要提现)
     *    url:"invite"   (邀请好友)
     *    url:"checkIn"   (签到页)
     *    url:"welfare"   (福利页)
     *    url:"book://1234"  (书籍详情)
     */
    public final void parseScheme(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.app.base.QYView rootView, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    com.jess.arms.integration.IRepositoryManager rm, @org.jetbrains.annotations.NotNull()
    me.jessyan.rxerrorhandler.core.RxErrorHandler handler) {
    }
    
    private final void getAttendanceStatus(com.wy.adbook.app.base.QYView rootView, com.jess.arms.integration.IRepositoryManager rm, me.jessyan.rxerrorhandler.core.RxErrorHandler handler) {
    }
    
    private final void share(android.content.Context context) {
    }
    
    private SchemeManager() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/wy/adbook/app/manager/SchemeManager$Scheme;", "", "()V", "linkType", "", "getLinkType", "()Ljava/lang/String;", "setLinkType", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "application_release"})
    public static final class Scheme {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "linkType")
        private java.lang.String linkType;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "url")
        private java.lang.String url;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLinkType() {
            return null;
        }
        
        public final void setLinkType(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUrl() {
            return null;
        }
        
        public final void setUrl(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public Scheme() {
            super();
        }
    }
}