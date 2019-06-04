package com.wy.adbook.app.rx;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0015\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0015\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0016R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/wy/adbook/app/rx/SimpleErrorSubscribe;", "T", "Lio/reactivex/Observer;", "rootView", "Lcom/wy/adbook/app/base/QYView;", "(Lcom/wy/adbook/app/base/QYView;)V", "loadingStr", "", "(Lcom/wy/adbook/app/base/QYView;Ljava/lang/String;)V", "handlerError", "Lcom/wy/adbook/app/impl/ResponseErrorListenerImpl;", "getHandlerError", "()Lcom/wy/adbook/app/impl/ResponseErrorListenerImpl;", "handlerError$delegate", "Lkotlin/Lazy;", "onComplete", "", "onError", "e", "", "onNext", "t", "(Ljava/lang/Object;)V", "onServerError", "Lcom/wy/adbook/app/rx/ServerRetException;", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "success", "application_release"})
public abstract class SimpleErrorSubscribe<T extends java.lang.Object> implements io.reactivex.Observer<T> {
    private final com.wy.adbook.app.base.QYView rootView = null;
    private java.lang.String loadingStr;
    private final kotlin.Lazy handlerError$delegate = null;
    
    private final com.wy.adbook.app.impl.ResponseErrorListenerImpl getHandlerError() {
        return null;
    }
    
    @java.lang.Override()
    public void onComplete() {
    }
    
    @java.lang.Override()
    public void onNext(T t) {
    }
    
    @java.lang.Override()
    public void onSubscribe(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable d) {
    }
    
    @java.lang.Override()
    public void onError(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable e) {
    }
    
    public abstract void success(T t);
    
    public final void onServerError(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.app.rx.ServerRetException e) {
    }
    
    public SimpleErrorSubscribe(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.app.base.QYView rootView) {
        super();
    }
    
    public SimpleErrorSubscribe(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.app.base.QYView rootView, @org.jetbrains.annotations.NotNull()
    java.lang.String loadingStr) {
        super();
    }
}