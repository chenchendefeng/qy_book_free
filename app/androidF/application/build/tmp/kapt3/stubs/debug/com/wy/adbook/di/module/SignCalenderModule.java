package com.wy.adbook.di.module;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-08.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u0003H\u0007J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\bH\u0007J\r\u0010\u0011\u001a\u00020\u0012H\u0001\u00a2\u0006\u0002\b\u0013J\r\u0010\u0014\u001a\u00020\u0015H\u0001\u00a2\u0006\u0002\b\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0016\u0010\u0018\u001a\u00020\u00192\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00100\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/wy/adbook/di/module/SignCalenderModule;", "", "view", "Lcom/wy/adbook/mvp/contranct/SignCalenderContract$View;", "(Lcom/wy/adbook/mvp/contranct/SignCalenderContract$View;)V", "continuousSignInAdapter", "Lcom/wy/adbook/mvp/view/adapter/ContinuousSignInAdapter;", "dataList", "", "Lcom/wy/adbook/mvp/model/entity/accout/RewardItem;", "provideAboutModel", "Lcom/wy/adbook/mvp/contranct/SignCalenderContract$Model;", "model", "Lcom/wy/adbook/mvp/model/SignCalenderModel;", "provideAboutView", "provideAttendanceCalendarDataList", "Lcom/wy/adbook/mvp/model/entity/accout/AttendanceCalendarItem;", "provideLayoutManager1", "Lcom/freebookqy/viewlib/rv/layoutmanager/FullyLinearLayoutManager;", "provideLayoutManager1$application_debug", "provideLayoutManager2", "Lcom/freebookqy/viewlib/rv/layoutmanager/FullyGridLayoutManager;", "provideLayoutManager2$application_debug", "provideRewardDataList", "signCalendarAdapter", "Lcom/wy/adbook/mvp/view/adapter/SignCalendarAdapter;", "application_debug"})
@dagger.Module()
public final class SignCalenderModule {
    private final com.wy.adbook.mvp.contranct.SignCalenderContract.View view = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.SignCalenderContract.View provideAboutView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.SignCalenderContract.Model provideAboutModel(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.SignCalenderModel model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.freebookqy.viewlib.rv.layoutmanager.FullyLinearLayoutManager provideLayoutManager1$application_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager provideLayoutManager2$application_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final java.util.List<com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem> provideAttendanceCalendarDataList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.view.adapter.SignCalendarAdapter signCalendarAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem> dataList) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final java.util.List<com.wy.adbook.mvp.model.entity.accout.RewardItem> provideRewardDataList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.view.adapter.ContinuousSignInAdapter continuousSignInAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.accout.RewardItem> dataList) {
        return null;
    }
    
    public SignCalenderModule(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.SignCalenderContract.View view) {
        super();
    }
}