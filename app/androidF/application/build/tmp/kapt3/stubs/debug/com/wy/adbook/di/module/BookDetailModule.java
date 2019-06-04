package com.wy.adbook.di.module;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/7.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0003H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/wy/adbook/di/module/BookDetailModule;", "", "view", "Lcom/wy/adbook/mvp/contranct/BookDetailContract$View;", "(Lcom/wy/adbook/mvp/contranct/BookDetailContract$View;)V", "provideAboutModel", "Lcom/wy/adbook/mvp/contranct/BookDetailContract$Model;", "model", "Lcom/wy/adbook/mvp/model/BookDetailModel;", "provideAboutView", "application_debug"})
@dagger.Module()
public final class BookDetailModule {
    private final com.wy.adbook.mvp.contranct.BookDetailContract.View view = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.BookDetailContract.View provideAboutView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.BookDetailContract.Model provideAboutModel(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.BookDetailModel model) {
        return null;
    }
    
    public BookDetailModule(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.BookDetailContract.View view) {
        super();
    }
}