package com.wy.adbook.app.rx;

import java.lang.System;

/**
 * * ================================================
 * * 放置便于使用 RxJava 的一些工具方法
 * *
 * *
 * * Created by MVPArmsTemplate on 04/29/2019 11:35
 * * [Contact me](mailto:jess.yan.effort@gmail.com)
 * * [Follow me](https://github.com/JessYanCoding)
 * * ================================================
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J,\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eJ+\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000fJ\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0011\"\u0004\b\u0000\u0010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0013H\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/wy/adbook/app/rx/RxUtils;", "", "()V", "applySchedulers", "Lio/reactivex/ObservableTransformer;", "T", "view", "Lcom/jess/arms/mvp/IView;", "delay", "", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "fun1", "Lkotlin/Function0;", "(Lcom/jess/arms/mvp/IView;JLjava/util/concurrent/TimeUnit;Lkotlin/Unit;)V", "toSimpleSingle", "Lio/reactivex/SingleSource;", "upstream", "Lio/reactivex/Single;", "application_release"})
public final class RxUtils {
    public static final com.wy.adbook.app.rx.RxUtils INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>io.reactivex.ObservableTransformer<T, T> applySchedulers(@org.jetbrains.annotations.NotNull()
    com.jess.arms.mvp.IView view) {
        return null;
    }
    
    public final void delay(@org.jetbrains.annotations.NotNull()
    com.jess.arms.mvp.IView view, long delay, @org.jetbrains.annotations.NotNull()
    java.util.concurrent.TimeUnit timeUnit, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> fun1) {
    }
    
    public final void delay(@org.jetbrains.annotations.NotNull()
    com.jess.arms.mvp.IView view, long delay, @org.jetbrains.annotations.NotNull()
    java.util.concurrent.TimeUnit timeUnit, @org.jetbrains.annotations.NotNull()
    kotlin.Unit fun1) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>io.reactivex.SingleSource<T> toSimpleSingle(@org.jetbrains.annotations.NotNull()
    io.reactivex.Single<T> upstream) {
        return null;
    }
    
    private RxUtils() {
        super();
    }
}