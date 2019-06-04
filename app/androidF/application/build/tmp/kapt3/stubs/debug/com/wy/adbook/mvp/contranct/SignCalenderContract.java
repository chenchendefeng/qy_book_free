package com.wy.adbook.mvp.contranct;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-08.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/mvp/contranct/SignCalenderContract;", "", "Model", "View", "application_debug"})
public abstract interface SignCalenderContract {
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&\u00a8\u0006\r"}, d2 = {"Lcom/wy/adbook/mvp/contranct/SignCalenderContract$View;", "Lcom/wy/adbook/app/base/QYView;", "changeStatus", "", "status", "Lcom/wy/adbook/view/status/IStatusCoverView$Status;", "refreshView", "setRefreshStatus", "isRefresh", "", "showContinuousSignDialog", "showSignSuccessDialog", "showTipWatchVideoDialog", "application_debug"})
    public static abstract interface View extends com.wy.adbook.app.base.QYView {
        
        public abstract void refreshView();
        
        public abstract void setRefreshStatus(boolean isRefresh);
        
        /**
         * * 显示签到成功对话框
         */
        public abstract void showSignSuccessDialog();
        
        public abstract void changeStatus(@org.jetbrains.annotations.NotNull()
        com.wy.adbook.view.status.IStatusCoverView.Status status);
        
        public abstract void showContinuousSignDialog();
        
        /**
         * * 显示提示查看视频对话框
         */
        public abstract void showTipWatchVideoDialog();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH&J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0014"}, d2 = {"Lcom/wy/adbook/mvp/contranct/SignCalenderContract$Model;", "Lcom/wy/adbook/app/base/QYModel;", "attendancePage", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/accout/NetAttendancePage;", "cuid", "", "attendanceStatus", "Lcom/wy/adbook/mvp/model/entity/NetAttendanceStatus;", "compensateChanceReceive", "Lcom/wy/adbook/mvp/model/entity/NetCompensateChance;", "compensateSign", "Lcom/wy/adbook/mvp/model/entity/accout/NetCompensateSign;", "date", "", "sign", "Lcom/wy/adbook/mvp/model/entity/accout/NetSign;", "uid", "videoForGole", "Lcom/wy/adbook/mvp/model/entity/NetVideoForGole;", "application_debug"})
    public static abstract interface Model extends com.wy.adbook.app.base.QYModel {
        
        /**
         * * 签到状态获取
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetAttendanceStatus> attendanceStatus(int cuid);
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetAttendancePage> attendancePage(int cuid);
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetSign> sign(int uid);
        
        /**
         * * 领取补签机会
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetCompensateChance> compensateChanceReceive(int cuid);
        
        /**
         * * 补签
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetCompensateSign> compensateSign(int cuid, @org.jetbrains.annotations.NotNull()
        java.lang.String date);
        
        /**
         * * 看视频领取奖励
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetVideoForGole> videoForGole(int cuid);
    }
}