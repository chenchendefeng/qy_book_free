package com.wy.adbook.mvp.view.web;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-24.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0003J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/wy/adbook/mvp/view/web/QYWebView;", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDebugEnabled", "", "getMDebugEnabled", "()Z", "setMDebugEnabled", "(Z)V", "initWebView", "", "setWebViewDebugEnabled", "value", "application_debug"})
public final class QYWebView extends android.webkit.WebView {
    private boolean mDebugEnabled;
    private java.util.HashMap _$_findViewCache;
    
    public final boolean getMDebugEnabled() {
        return false;
    }
    
    public final void setMDebugEnabled(boolean p0) {
    }
    
    @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled"})
    private final void initWebView() {
    }
    
    private final void setWebViewDebugEnabled(boolean value) {
    }
    
    public QYWebView(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        super(null);
    }
    
    public QYWebView(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
}