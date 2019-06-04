package com.wy.adbook.view.status;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-23.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0003\t\n\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\f"}, d2 = {"Lcom/wy/adbook/view/status/IStatusCoverView;", "", "changeStatus", "", "status", "Lcom/wy/adbook/view/status/IStatusCoverView$Status;", "showError", "showLoading", "showSuccess", "ReTryClickListener", "Status", "StatusChangeListener", "application_release"})
public abstract interface IStatusCoverView {
    
    public abstract void showError();
    
    public abstract void showLoading();
    
    public abstract void showSuccess();
    
    public abstract void changeStatus(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.view.status.IStatusCoverView.Status status);
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/wy/adbook/view/status/IStatusCoverView$Status;", "", "(Ljava/lang/String;I)V", "ERROR", "LOADING", "SUCCESS", "application_release"})
    public static enum Status {
        /*public static final*/ ERROR /* = new ERROR() */,
        /*public static final*/ LOADING /* = new LOADING() */,
        /*public static final*/ SUCCESS /* = new SUCCESS() */;
        
        Status() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2 = {"Lcom/wy/adbook/view/status/IStatusCoverView$StatusChangeListener;", "", "error", "", "loading", "success", "application_release"})
    public static abstract interface StatusChangeListener {
        
        public abstract void error();
        
        public abstract void loading();
        
        public abstract void success();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/view/status/IStatusCoverView$ReTryClickListener;", "", "reTry", "", "application_release"})
    public static abstract interface ReTryClickListener {
        
        public abstract void reTry();
    }
}