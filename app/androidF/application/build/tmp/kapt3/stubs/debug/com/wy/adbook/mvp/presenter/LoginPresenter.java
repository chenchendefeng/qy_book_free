package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-08.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\b\u00a8\u0006\u0012"}, d2 = {"Lcom/wy/adbook/mvp/presenter/LoginPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/LoginContract$Model;", "Lcom/wy/adbook/mvp/contranct/LoginContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/LoginContract$Model;Lcom/wy/adbook/mvp/contranct/LoginContract$View;)V", "enterPrivacyAgreement", "", "enterUserProtocol", "getVerificationCode", "country", "", "phone", "login", "code", "loginWx", "requestWx", "application_debug"})
@com.jess.arms.di.scope.ActivityScope()
public final class LoginPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.LoginContract.Model, com.wy.adbook.mvp.contranct.LoginContract.View> {
    
    /**
     * * 手机登录
     */
    public final void login(@org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    java.lang.String code) {
    }
    
    /**
     * * 请求微信进行登录
     */
    public final void requestWx() {
    }
    
    /**
     * * 请求后台记录微信登录信息
     */
    public final void loginWx(@org.jetbrains.annotations.NotNull()
    java.lang.String code) {
    }
    
    /**
     * * 进入用户协议
     */
    public final void enterUserProtocol() {
    }
    
    /**
     * * 进入隐私协议
     */
    public final void enterPrivacyAgreement() {
    }
    
    /**
     * * 请求接口  获取验证码
     */
    public final void getVerificationCode(@org.jetbrains.annotations.NotNull()
    java.lang.String country, @org.jetbrains.annotations.NotNull()
    java.lang.String phone) {
    }
    
    @javax.inject.Inject()
    public LoginPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.LoginContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.LoginContract.View view) {
        super(null, null);
    }
}