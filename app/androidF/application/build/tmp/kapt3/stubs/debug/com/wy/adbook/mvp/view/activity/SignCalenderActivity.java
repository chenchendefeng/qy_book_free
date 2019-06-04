package com.wy.adbook.mvp.view.activity;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-08.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001<B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010\'\u001a\u00020\u001eH\u0002J\u0012\u0010(\u001a\u00020)2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\b\u0010/\u001a\u00020\u001eH\u0002J\b\u00100\u001a\u00020\u001eH\u0002J\b\u00101\u001a\u00020\u001eH\u0016J\u0010\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020\u001eH\u0016J\b\u00109\u001a\u00020\u001eH\u0002J\b\u0010:\u001a\u00020\u001eH\u0016J\b\u0010;\u001a\u00020\u001eH\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006="}, d2 = {"Lcom/wy/adbook/mvp/view/activity/SignCalenderActivity;", "Lcom/wy/adbook/app/base/QYBaseActivity;", "Lcom/wy/adbook/mvp/presenter/SignCalenderPresenter;", "Lcom/wy/adbook/mvp/contranct/SignCalenderContract$View;", "()V", "mContinuousSignInAdapter", "Lcom/wy/adbook/mvp/view/adapter/ContinuousSignInAdapter;", "getMContinuousSignInAdapter", "()Lcom/wy/adbook/mvp/view/adapter/ContinuousSignInAdapter;", "setMContinuousSignInAdapter", "(Lcom/wy/adbook/mvp/view/adapter/ContinuousSignInAdapter;)V", "mLayoutManager1", "Lcom/freebookqy/viewlib/rv/layoutmanager/FullyLinearLayoutManager;", "getMLayoutManager1", "()Lcom/freebookqy/viewlib/rv/layoutmanager/FullyLinearLayoutManager;", "setMLayoutManager1", "(Lcom/freebookqy/viewlib/rv/layoutmanager/FullyLinearLayoutManager;)V", "mLayoutManager2", "Lcom/freebookqy/viewlib/rv/layoutmanager/FullyGridLayoutManager;", "getMLayoutManager2", "()Lcom/freebookqy/viewlib/rv/layoutmanager/FullyGridLayoutManager;", "setMLayoutManager2", "(Lcom/freebookqy/viewlib/rv/layoutmanager/FullyGridLayoutManager;)V", "mSignCalendarAdapter", "Lcom/wy/adbook/mvp/view/adapter/SignCalendarAdapter;", "getMSignCalendarAdapter", "()Lcom/wy/adbook/mvp/view/adapter/SignCalendarAdapter;", "setMSignCalendarAdapter", "(Lcom/wy/adbook/mvp/view/adapter/SignCalendarAdapter;)V", "changeStatus", "", "status", "Lcom/wy/adbook/view/status/IStatusCoverView$Status;", "getToolbar", "Landroid/view/View;", "initData", "savedInstanceState", "Landroid/os/Bundle;", "initListener", "initRv", "initView", "", "refreshContinueSignTip", "refreshRuleContent", "refreshSignBtnEnable", "refreshSignInTipTv", "refreshTopSignBtnEnable", "refreshTopSignBtnTv", "refreshTopSignBtnUnEnable", "refreshView", "setRefreshStatus", "isRefresh", "", "setupActivityComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "showContinuousSignDialog", "showRetroactiveChanceDialog", "showSignSuccessDialog", "showTipWatchVideoDialog", "Companion", "application_debug"})
public final class SignCalenderActivity extends com.wy.adbook.app.base.QYBaseActivity<com.wy.adbook.mvp.presenter.SignCalenderPresenter> implements com.wy.adbook.mvp.contranct.SignCalenderContract.View {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.freebookqy.viewlib.rv.layoutmanager.FullyLinearLayoutManager mLayoutManager1;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager mLayoutManager2;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.SignCalendarAdapter mSignCalendarAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.ContinuousSignInAdapter mContinuousSignInAdapter;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_ATTENDANCE_PAGE = "attendancePage";
    public static final com.wy.adbook.mvp.view.activity.SignCalenderActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void setupActivityComponent(@org.jetbrains.annotations.NotNull()
    com.jess.arms.di.component.AppComponent appComponent) {
    }
    
    @java.lang.Override()
    public int initView(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.freebookqy.viewlib.rv.layoutmanager.FullyLinearLayoutManager getMLayoutManager1() {
        return null;
    }
    
    public final void setMLayoutManager1(@org.jetbrains.annotations.NotNull()
    com.freebookqy.viewlib.rv.layoutmanager.FullyLinearLayoutManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager getMLayoutManager2() {
        return null;
    }
    
    public final void setMLayoutManager2(@org.jetbrains.annotations.NotNull()
    com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.SignCalendarAdapter getMSignCalendarAdapter() {
        return null;
    }
    
    public final void setMSignCalendarAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.SignCalendarAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.ContinuousSignInAdapter getMContinuousSignInAdapter() {
        return null;
    }
    
    public final void setMContinuousSignInAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.ContinuousSignInAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View getToolbar() {
        return null;
    }
    
    @java.lang.Override()
    public void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void refreshSignInTipTv() {
    }
    
    private final void refreshTopSignBtnTv() {
    }
    
    private final void refreshTopSignBtnEnable() {
    }
    
    private final void refreshTopSignBtnUnEnable() {
    }
    
    private final void refreshRuleContent() {
    }
    
    private final void initRv() {
    }
    
    private final void initListener() {
    }
    
    @java.lang.Override()
    public void refreshView() {
    }
    
    private final void refreshContinueSignTip() {
    }
    
    private final void refreshSignBtnEnable() {
    }
    
    @java.lang.Override()
    public void showSignSuccessDialog() {
    }
    
    /**
     * * 显示连续签到对话框
     *     * 内容:连续签到可提现
     */
    @java.lang.Override()
    public void showContinuousSignDialog() {
    }
    
    /**
     * * 显示补签提示对话框
     */
    private final void showRetroactiveChanceDialog() {
    }
    
    @java.lang.Override()
    public void showTipWatchVideoDialog() {
    }
    
    @java.lang.Override()
    public void changeStatus(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.view.status.IStatusCoverView.Status status) {
    }
    
    @java.lang.Override()
    public void setRefreshStatus(boolean isRefresh) {
    }
    
    public SignCalenderActivity() {
        super();
    }
    
    public static final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.AttendanceStatus attendanceStatus) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/SignCalenderActivity$Companion;", "", "()V", "EXTRA_ATTENDANCE_PAGE", "", "startActivity", "", "context", "Landroid/content/Context;", "attendanceStatus", "Lcom/wy/adbook/mvp/model/entity/AttendanceStatus;", "application_debug"})
    public static final class Companion {
        
        public final void startActivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.wy.adbook.mvp.model.entity.AttendanceStatus attendanceStatus) {
        }
        
        private Companion() {
            super();
        }
    }
}