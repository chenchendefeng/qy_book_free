package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0014J\u0006\u0010\u0018\u001a\u00020\u0014J\u0006\u0010\u0019\u001a\u00020\u0014J\u0006\u0010\u001a\u001a\u00020\u0014J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u0016H\u0002J\u0006\u0010!\u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u0014J\u0006\u0010#\u001a\u00020\u0016J\b\u0010$\u001a\u00020\u0016H\u0002J\u0006\u0010%\u001a\u00020\u0016J\u0010\u0010&\u001a\u00020\u00162\b\u0010\'\u001a\u0004\u0018\u00010(R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006)"}, d2 = {"Lcom/wy/adbook/mvp/presenter/WelfarePresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/WelfareContract$Model;", "Lcom/wy/adbook/mvp/contranct/WelfareContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/WelfareContract$Model;Lcom/wy/adbook/mvp/contranct/WelfareContract$View;)V", "attendanceStatus", "Lcom/wy/adbook/mvp/model/entity/AttendanceStatus;", "getAttendanceStatus", "()Lcom/wy/adbook/mvp/model/entity/AttendanceStatus;", "setAttendanceStatus", "(Lcom/wy/adbook/mvp/model/entity/AttendanceStatus;)V", "welfare", "Lcom/wy/adbook/mvp/model/entity/Welfare;", "getWelfare", "()Lcom/wy/adbook/mvp/model/entity/Welfare;", "setWelfare", "(Lcom/wy/adbook/mvp/model/entity/Welfare;)V", "canContinueSignDays", "", "fetchData", "", "getContinueSignDays", "getFirstSignGold", "getMaxSignGoldCount", "getSignGoldCount", "handleSkip", "welfareItem", "Lcom/wy/adbook/mvp/model/entity/WelfareItem;", "hasCompensateSign", "", "initWelfare", "isToadySign", "leakageSignDays", "shareSuccess", "submitVideoWatched", "toLucky", "todaySignSuccess", "obj", "", "application_release"})
@com.jess.arms.di.scope.FragmentScope()
public final class WelfarePresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.WelfareContract.Model, com.wy.adbook.mvp.contranct.WelfareContract.View> {
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.entity.Welfare welfare;
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.entity.AttendanceStatus attendanceStatus;
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.Welfare getWelfare() {
        return null;
    }
    
    public final void setWelfare(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.Welfare p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.AttendanceStatus getAttendanceStatus() {
        return null;
    }
    
    public final void setAttendanceStatus(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.AttendanceStatus p0) {
    }
    
    private final void submitVideoWatched() {
    }
    
    public final void shareSuccess() {
    }
    
    public final void toLucky() {
    }
    
    public final void handleSkip(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.WelfareItem welfareItem) {
    }
    
    public final void fetchData() {
    }
    
    private final void initWelfare() {
    }
    
    public final boolean hasCompensateSign() {
        return false;
    }
    
    public final int leakageSignDays() {
        return 0;
    }
    
    public final int canContinueSignDays() {
        return 0;
    }
    
    public final int getContinueSignDays() {
        return 0;
    }
    
    public final boolean isToadySign() {
        return false;
    }
    
    public final int getSignGoldCount() {
        return 0;
    }
    
    public final int getMaxSignGoldCount() {
        return 0;
    }
    
    public final int getFirstSignGold() {
        return 0;
    }
    
    public final void todaySignSuccess(@org.jetbrains.annotations.Nullable()
    java.lang.Object obj) {
    }
    
    @javax.inject.Inject()
    public WelfarePresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.WelfareContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.WelfareContract.View view) {
        super(null, null);
    }
}