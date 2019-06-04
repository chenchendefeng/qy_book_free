package com.wy.adbook.app.base;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\tB\u0007\b\u0016\u00a2\u0006\u0002\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/wy/adbook/app/base/QYBasePresenter;", "M", "Lcom/jess/arms/mvp/IModel;", "V", "Lcom/jess/arms/mvp/IView;", "Lcom/jess/arms/mvp/BasePresenter;", "model", "rootView", "(Lcom/jess/arms/mvp/IModel;Lcom/jess/arms/mvp/IView;)V", "(Lcom/jess/arms/mvp/IView;)V", "()V", "mErrorHandler", "Lme/jessyan/rxerrorhandler/core/RxErrorHandler;", "getMErrorHandler", "()Lme/jessyan/rxerrorhandler/core/RxErrorHandler;", "setMErrorHandler", "(Lme/jessyan/rxerrorhandler/core/RxErrorHandler;)V", "application_release"})
public abstract class QYBasePresenter<M extends com.jess.arms.mvp.IModel, V extends com.jess.arms.mvp.IView> extends com.jess.arms.mvp.BasePresenter<M, V> {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public me.jessyan.rxerrorhandler.core.RxErrorHandler mErrorHandler;
    
    @org.jetbrains.annotations.NotNull()
    public final me.jessyan.rxerrorhandler.core.RxErrorHandler getMErrorHandler() {
        return null;
    }
    
    public final void setMErrorHandler(@org.jetbrains.annotations.NotNull()
    me.jessyan.rxerrorhandler.core.RxErrorHandler p0) {
    }
    
    public QYBasePresenter(@org.jetbrains.annotations.NotNull()
    M model, @org.jetbrains.annotations.NotNull()
    V rootView) {
        super(null, null);
    }
    
    public QYBasePresenter(@org.jetbrains.annotations.NotNull()
    V rootView) {
        super(null, null);
    }
    
    public QYBasePresenter() {
        super(null, null);
    }
}