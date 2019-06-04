package com.wy.adbook.mvp.model;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\u00040\u0004H\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u000f\u001a\u00020\nH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/wy/adbook/mvp/model/WelfareModel;", "Lcom/jess/arms/mvp/BaseModel;", "Lcom/wy/adbook/mvp/contranct/WelfareContract$Model;", "repositoryManager", "Lcom/jess/arms/integration/IRepositoryManager;", "(Lcom/jess/arms/integration/IRepositoryManager;)V", "attendanceStatus", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/NetAttendanceStatus;", "uid", "", "getRm", "kotlin.jvm.PlatformType", "sign", "Lcom/wy/adbook/mvp/model/entity/accout/NetSign;", "cid", "watchForFreeAdv", "Lcom/wy/adbook/mvp/model/entity/NetWatchForFreeAdv;", "welfareList", "Lcom/wy/adbook/mvp/model/entity/NetWelfare;", "application_release"})
@com.jess.arms.di.scope.FragmentScope()
public final class WelfareModel extends com.jess.arms.mvp.BaseModel implements com.wy.adbook.mvp.contranct.WelfareContract.Model {
    
    @java.lang.Override()
    public com.jess.arms.integration.IRepositoryManager getRm() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetAttendanceStatus> attendanceStatus(int uid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetSign> sign(int cid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetWatchForFreeAdv> watchForFreeAdv(int cid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetWelfare> welfareList(int cid) {
        return null;
    }
    
    @javax.inject.Inject()
    public WelfareModel(@org.jetbrains.annotations.NotNull()
    com.jess.arms.integration.IRepositoryManager repositoryManager) {
        super(null);
    }
}