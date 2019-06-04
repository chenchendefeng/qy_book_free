package com.wy.adbook.wxapi;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-12.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0002\u0015\u0016B\u0005\u00a2\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH\u0014J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0014H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/wy/adbook/wxapi/WXEntryActivity;", "Landroid/support/v4/app/FragmentActivity;", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "()V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "onReq", "p0", "Lcom/tencent/mm/opensdk/modelbase/BaseReq;", "onResp", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "Companion", "WxEventBusKey", "application_release"})
public final class WXEntryActivity extends android.support.v4.app.FragmentActivity implements com.tencent.mm.opensdk.openapi.IWXAPIEventHandler {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WX_LOGIN_KEY = "wxLogin";
    public static final com.wy.adbook.wxapi.WXEntryActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    protected void onNewIntent(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    @java.lang.Override()
    public void onResp(@org.jetbrains.annotations.Nullable()
    com.tencent.mm.opensdk.modelbase.BaseResp p0) {
    }
    
    @java.lang.Override()
    public void onReq(@org.jetbrains.annotations.Nullable()
    com.tencent.mm.opensdk.modelbase.BaseReq p0) {
    }
    
    public WXEntryActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lcom/wy/adbook/wxapi/WXEntryActivity$WxEventBusKey;", "", "key", "", "args", "strArgs", "", "obj", "(IILjava/lang/String;Ljava/lang/Object;)V", "getArgs", "()I", "setArgs", "(I)V", "getKey", "getObj", "()Ljava/lang/Object;", "setObj", "(Ljava/lang/Object;)V", "getStrArgs", "()Ljava/lang/String;", "setStrArgs", "(Ljava/lang/String;)V", "Companion", "application_release"})
    public static final class WxEventBusKey {
        private final int key = 0;
        private int args;
        @org.jetbrains.annotations.NotNull()
        private java.lang.String strArgs;
        @org.jetbrains.annotations.Nullable()
        private java.lang.Object obj;
        
        /**
         * * 微信登录成功
         */
        public static final int WX_LOGIN_SUCCESS = 100;
        
        /**
         * * 分享成功
         */
        public static final int WX_SHARE_SUCCESS = 101;
        public static final com.wy.adbook.wxapi.WXEntryActivity.WxEventBusKey.Companion Companion = null;
        
        public final int getKey() {
            return 0;
        }
        
        public final int getArgs() {
            return 0;
        }
        
        public final void setArgs(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getStrArgs() {
            return null;
        }
        
        public final void setStrArgs(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getObj() {
            return null;
        }
        
        public final void setObj(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        public WxEventBusKey(int key, int args, @org.jetbrains.annotations.NotNull()
        java.lang.String strArgs, @org.jetbrains.annotations.Nullable()
        java.lang.Object obj) {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/wy/adbook/wxapi/WXEntryActivity$WxEventBusKey$Companion;", "", "()V", "WX_LOGIN_SUCCESS", "", "WX_SHARE_SUCCESS", "application_release"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/wy/adbook/wxapi/WXEntryActivity$Companion;", "", "()V", "WX_LOGIN_KEY", "", "application_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}