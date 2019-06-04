package com.wy.adbook.di.module;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-08.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0003H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/wy/adbook/di/module/LoginModule;", "", "view", "Lcom/wy/adbook/mvp/contranct/LoginContract$View;", "(Lcom/wy/adbook/mvp/contranct/LoginContract$View;)V", "provideAboutModel", "Lcom/wy/adbook/mvp/contranct/LoginContract$Model;", "model", "Lcom/wy/adbook/mvp/model/LoginModel;", "provideAboutView", "application_release"})
@dagger.Module()
public final class LoginModule {
    private final com.wy.adbook.mvp.contranct.LoginContract.View view = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.LoginContract.View provideAboutView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.LoginContract.Model provideAboutModel(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.LoginModel model) {
        return null;
    }
    
    public LoginModule(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.LoginContract.View view) {
        super();
    }
}