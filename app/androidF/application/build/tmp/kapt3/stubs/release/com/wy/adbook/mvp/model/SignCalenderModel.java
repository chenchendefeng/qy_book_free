package com.wy.adbook.mvp.model;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-08.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00072\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/wy/adbook/mvp/model/SignCalenderModel;", "Lcom/jess/arms/mvp/BaseModel;", "Lcom/wy/adbook/mvp/contranct/SignCalenderContract$Model;", "repositoryManager", "Lcom/jess/arms/integration/IRepositoryManager;", "(Lcom/jess/arms/integration/IRepositoryManager;)V", "attendancePage", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/accout/NetAttendancePage;", "cuid", "", "attendanceStatus", "Lcom/wy/adbook/mvp/model/entity/NetAttendanceStatus;", "compensateChanceReceive", "Lcom/wy/adbook/mvp/model/entity/NetCompensateChance;", "compensateSign", "Lcom/wy/adbook/mvp/model/entity/accout/NetCompensateSign;", "date", "", "sign", "Lcom/wy/adbook/mvp/model/entity/accout/NetSign;", "uid", "videoForGole", "Lcom/wy/adbook/mvp/model/entity/NetVideoForGole;", "application_release"})
@com.jess.arms.di.scope.ActivityScope()
public final class SignCalenderModel extends com.jess.arms.mvp.BaseModel implements com.wy.adbook.mvp.contranct.SignCalenderContract.Model {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetAttendanceStatus> attendanceStatus(int cuid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetVideoForGole> videoForGole(int cuid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetCompensateChance> compensateChanceReceive(int cuid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetCompensateSign> compensateSign(int cuid, @org.jetbrains.annotations.NotNull()
    java.lang.String date) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetSign> sign(int uid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetAttendancePage> attendancePage(int cuid) {
        return null;
    }
    
    @javax.inject.Inject()
    public SignCalenderModel(@org.jetbrains.annotations.NotNull()
    com.jess.arms.integration.IRepositoryManager repositoryManager) {
        super(null);
    }
}