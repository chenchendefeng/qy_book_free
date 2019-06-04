package com.wy.adbook.mvp.contranct;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-08.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/mvp/contranct/LoginContract;", "", "Model", "View", "application_release"})
public abstract interface LoginContract {
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/mvp/contranct/LoginContract$View;", "Lcom/wy/adbook/app/base/QYView;", "startCountdown", "", "application_release"})
    public static abstract interface View extends com.wy.adbook.app.base.QYView {
        
        /**
         * * 开始倒计时
         */
        public abstract void startCountdown();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/wy/adbook/mvp/contranct/LoginContract$Model;", "Lcom/wy/adbook/app/base/QYModel;", "loginPhone", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/accout/NetPhoneLoginSuccess;", "phone", "", "code", "loginWx", "Lcom/wy/adbook/mvp/model/entity/accout/NetWechatLoginSuccess;", "application_release"})
    public static abstract interface Model extends com.wy.adbook.app.base.QYModel {
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetPhoneLoginSuccess> loginPhone(@org.jetbrains.annotations.NotNull()
        java.lang.String phone, @org.jetbrains.annotations.NotNull()
        java.lang.String code);
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetWechatLoginSuccess> loginWx(@org.jetbrains.annotations.NotNull()
        java.lang.String code);
    }
}