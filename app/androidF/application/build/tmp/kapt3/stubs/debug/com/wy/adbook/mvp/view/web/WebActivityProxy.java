package com.wy.adbook.mvp.view.web;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-23.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0006\u0010\f\u001a\u00020\u0006J \u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/wy/adbook/mvp/view/web/WebActivityProxy;", "", "mWebActivity", "Lcom/wy/adbook/mvp/view/web/act/WebActivity;", "(Lcom/wy/adbook/mvp/view/web/act/WebActivity;)V", "WebViewResponseEvent", "", "response", "Lcom/wy/adbook/mvp/view/web/bean/WebViewMessageEvent$WebViewResponseEvent;", "jsCallJavaEvent", "event", "Lcom/wy/adbook/mvp/view/web/bean/WebViewMessageEvent$JSCallJavaEvent;", "loadJsToH5", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onSaveInstanceState", "outState", "Landroid/os/Bundle;", "release", "application_debug"})
public final class WebActivityProxy {
    private final com.wy.adbook.mvp.view.web.act.WebActivity mWebActivity = null;
    
    public final void release() {
    }
    
    @org.simple.eventbus.Subscriber(mode = org.simple.eventbus.ThreadMode.MAIN)
    public final void WebViewResponseEvent(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.web.bean.WebViewMessageEvent.WebViewResponseEvent response) {
    }
    
    @org.simple.eventbus.Subscriber(mode = org.simple.eventbus.ThreadMode.MAIN)
    public final void jsCallJavaEvent(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.web.bean.WebViewMessageEvent.JSCallJavaEvent event) {
    }
    
    /**
     * * 这里加载js代码到h5中 主要用于初始化h5中的方法
     */
    public final void loadJsToH5() {
    }
    
    public final void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
    }
    
    public WebActivityProxy(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.web.act.WebActivity mWebActivity) {
        super();
    }
}