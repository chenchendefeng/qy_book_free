package com.wy.adbook.view.status;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-22.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u0000 \'2\u00020\u00012\u00020\u0002:\u0001\'B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u0004\u0018\u00010\fJ\b\u0010\u0019\u001a\u0004\u0018\u00010\fJ\b\u0010\u001a\u001a\u00020\u0017H\u0007J\b\u0010\u001b\u001a\u0004\u0018\u00010\fJ\b\u0010\u001c\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0017H\u0002J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0011J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u000eJ\b\u0010$\u001a\u00020\u0013H\u0016J\b\u0010%\u001a\u00020\u0013H\u0016J\b\u0010&\u001a\u00020\u0013H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/wy/adbook/view/status/StatusCoverView;", "Landroid/widget/FrameLayout;", "Lcom/wy/adbook/view/status/IStatusCoverView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "coverStatus", "Lcom/wy/adbook/view/status/IStatusCoverView$Status;", "errorView", "Landroid/view/View;", "listener", "Lcom/wy/adbook/view/status/IStatusCoverView$StatusChangeListener;", "loadingView", "reTryL", "Lcom/wy/adbook/view/status/IStatusCoverView$ReTryClickListener;", "changeStatus", "", "status", "changeToLoading", "getErrorViewId", "", "getInitErrorView", "getInitLoadingView", "getLoadingVIewId", "getRealErrorView", "getRealLoadingView", "initErrorView", "errorId", "initLoadingView", "loadingId", "setReTryClickListener", "l", "setStatusChangeListener", "showError", "showLoading", "showSuccess", "Companion", "application_release"})
public final class StatusCoverView extends android.widget.FrameLayout implements com.wy.adbook.view.status.IStatusCoverView {
    private android.view.View errorView;
    private android.view.View loadingView;
    private com.wy.adbook.view.status.IStatusCoverView.StatusChangeListener listener;
    private com.wy.adbook.view.status.IStatusCoverView.ReTryClickListener reTryL;
    private com.wy.adbook.view.status.IStatusCoverView.Status coverStatus;
    private static final int DEF_ERROR = 2131492992;
    public static final com.wy.adbook.view.status.StatusCoverView.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final void initLoadingView(int loadingId) {
    }
    
    private final void initErrorView(int errorId) {
    }
    
    @java.lang.Override()
    public void changeStatus(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.view.status.IStatusCoverView.Status status) {
    }
    
    @java.lang.Override()
    public void showError() {
    }
    
    @java.lang.Override()
    public void showLoading() {
    }
    
    private final void changeToLoading() {
    }
    
    @java.lang.Override()
    public void showSuccess() {
    }
    
    public final void setStatusChangeListener(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.view.status.IStatusCoverView.StatusChangeListener l) {
    }
    
    public final void setReTryClickListener(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.view.status.IStatusCoverView.ReTryClickListener l) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.View getInitErrorView() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.View getInitLoadingView() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.View getRealErrorView() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.View getRealLoadingView() {
        return null;
    }
    
    @android.support.annotation.LayoutRes()
    public final int getErrorViewId() {
        return 0;
    }
    
    @android.support.annotation.LayoutRes()
    public final int getLoadingVIewId() {
        return 0;
    }
    
    public StatusCoverView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    public StatusCoverView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/wy/adbook/view/status/StatusCoverView$Companion;", "", "()V", "DEF_ERROR", "", "application_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}