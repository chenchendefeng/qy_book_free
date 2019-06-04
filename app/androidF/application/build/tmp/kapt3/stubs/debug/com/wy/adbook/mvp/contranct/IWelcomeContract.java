package com.wy.adbook.mvp.contranct;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/mvp/contranct/IWelcomeContract;", "", "Model", "View", "application_debug"})
public abstract interface IWelcomeContract {
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\f"}, d2 = {"Lcom/wy/adbook/mvp/contranct/IWelcomeContract$View;", "Lcom/wy/adbook/app/base/QYView;", "showAd", "", "showGif", "fileUrl", "", "showImg", "showSkipCount", "currentCount", "", "showVideo", "application_debug"})
    public static abstract interface View extends com.wy.adbook.app.base.QYView {
        
        public abstract void showAd();
        
        public abstract void showSkipCount(long currentCount);
        
        public abstract void showImg(@org.jetbrains.annotations.NotNull()
        java.lang.String fileUrl);
        
        public abstract void showGif(@org.jetbrains.annotations.NotNull()
        java.lang.String fileUrl);
        
        public abstract void showVideo(@org.jetbrains.annotations.NotNull()
        java.lang.String fileUrl);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H&\u00a8\u0006\n"}, d2 = {"Lcom/wy/adbook/mvp/contranct/IWelcomeContract$Model;", "Lcom/jess/arms/mvp/IModel;", "getCurStartPage", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/NetStartPage;", "clientType", "", "channelCode", "visitorLogin", "Lcom/wy/adbook/mvp/model/entity/accout/NetVisitorLoginSuccess;", "application_debug"})
    public static abstract interface Model extends com.jess.arms.mvp.IModel {
        
        /**
         * * 游客登录
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetVisitorLoginSuccess> visitorLogin();
        
        /**
         * * 启动页数据
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetStartPage> getCurStartPage(@org.jetbrains.annotations.NotNull()
        java.lang.String clientType, @org.jetbrains.annotations.NotNull()
        java.lang.String channelCode);
    }
}