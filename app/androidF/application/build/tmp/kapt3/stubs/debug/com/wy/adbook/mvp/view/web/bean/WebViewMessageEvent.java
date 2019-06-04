package com.wy.adbook.mvp.view.web.bean;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-23.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/wy/adbook/mvp/view/web/bean/WebViewMessageEvent;", "", "()V", "JSCallJavaEvent", "WebViewResponseEvent", "WebViewResponseEvent_GoBack", "application_debug"})
public final class WebViewMessageEvent {
    
    public WebViewMessageEvent() {
        super();
    }
    
    /**
     * * java调用js 发出的消息
     */
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/wy/adbook/mvp/view/web/bean/WebViewMessageEvent$WebViewResponseEvent;", "", "()V", "obj", "getObj", "()Ljava/lang/Object;", "setObj", "(Ljava/lang/Object;)V", "value", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "application_debug"})
    public static final class WebViewResponseEvent {
        @org.jetbrains.annotations.NotNull()
        private java.lang.String value;
        @org.jetbrains.annotations.Nullable()
        private java.lang.Object obj;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getValue() {
            return null;
        }
        
        public final void setValue(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getObj() {
            return null;
        }
        
        public final void setObj(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        public WebViewResponseEvent() {
            super();
        }
    }
    
    /**
     * * js调用java 发出的消息
     */
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/wy/adbook/mvp/view/web/bean/WebViewMessageEvent$JSCallJavaEvent;", "", "()V", "obj", "getObj", "()Ljava/lang/Object;", "setObj", "(Ljava/lang/Object;)V", "value", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "application_debug"})
    public static final class JSCallJavaEvent {
        @org.jetbrains.annotations.NotNull()
        private java.lang.String value;
        @org.jetbrains.annotations.Nullable()
        private java.lang.Object obj;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getValue() {
            return null;
        }
        
        public final void setValue(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getObj() {
            return null;
        }
        
        public final void setObj(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        public JSCallJavaEvent() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/wy/adbook/mvp/view/web/bean/WebViewMessageEvent$WebViewResponseEvent_GoBack;", "", "()V", "info", "Lcom/wy/adbook/mvp/view/web/bean/ExitInfo;", "getInfo", "()Lcom/wy/adbook/mvp/view/web/bean/ExitInfo;", "setInfo", "(Lcom/wy/adbook/mvp/view/web/bean/ExitInfo;)V", "application_debug"})
    public static final class WebViewResponseEvent_GoBack {
        @org.jetbrains.annotations.Nullable()
        private com.wy.adbook.mvp.view.web.bean.ExitInfo info;
        
        @org.jetbrains.annotations.Nullable()
        public final com.wy.adbook.mvp.view.web.bean.ExitInfo getInfo() {
            return null;
        }
        
        public final void setInfo(@org.jetbrains.annotations.Nullable()
        com.wy.adbook.mvp.view.web.bean.ExitInfo p0) {
        }
        
        public WebViewResponseEvent_GoBack() {
            super();
        }
    }
}