package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-08.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u00107\u001a\u00020\u001aJ\u0006\u00108\u001a\u00020\u001aJ\b\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020:H\u0002J\u0006\u0010<\u001a\u00020:J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020\u001aJ\u0006\u0010@\u001a\u00020>J\u0006\u0010A\u001a\u00020\u001aJ\u0010\u0010B\u001a\u00020:2\b\u0010C\u001a\u0004\u0018\u00010DJ\u0010\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020\u000fH\u0002J\u0006\u0010G\u001a\u00020:J\u0006\u0010H\u001a\u00020:J\b\u0010I\u001a\u00020:H\u0002J\b\u0010J\u001a\u00020:H\u0002J\u0006\u0010K\u001a\u00020\u001aJ\u000e\u0010L\u001a\u00020:2\u0006\u0010M\u001a\u00020\"R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b\'\u0010%R$\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000b\"\u0004\b+\u0010\rR\u001e\u0010,\u001a\u00020-8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106\u00a8\u0006N"}, d2 = {"Lcom/wy/adbook/mvp/presenter/SignCalenderPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/SignCalenderContract$Model;", "Lcom/wy/adbook/mvp/contranct/SignCalenderContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/SignCalenderContract$Model;Lcom/wy/adbook/mvp/contranct/SignCalenderContract$View;)V", "attendanceCalendarList", "", "Lcom/wy/adbook/mvp/model/entity/accout/AttendanceCalendarItem;", "getAttendanceCalendarList", "()Ljava/util/List;", "setAttendanceCalendarList", "(Ljava/util/List;)V", "attendanceStatus", "Lcom/wy/adbook/mvp/model/entity/AttendanceStatus;", "getAttendanceStatus", "()Lcom/wy/adbook/mvp/model/entity/AttendanceStatus;", "setAttendanceStatus", "(Lcom/wy/adbook/mvp/model/entity/AttendanceStatus;)V", "clickAttendanceCalendarItem", "getClickAttendanceCalendarItem", "()Lcom/wy/adbook/mvp/model/entity/accout/AttendanceCalendarItem;", "setClickAttendanceCalendarItem", "(Lcom/wy/adbook/mvp/model/entity/accout/AttendanceCalendarItem;)V", "continueSignDays", "", "continuousSignInAdapter", "Lcom/wy/adbook/mvp/view/adapter/ContinuousSignInAdapter;", "getContinuousSignInAdapter", "()Lcom/wy/adbook/mvp/view/adapter/ContinuousSignInAdapter;", "setContinuousSignInAdapter", "(Lcom/wy/adbook/mvp/view/adapter/ContinuousSignInAdapter;)V", "isWatchVideoForGold", "", "()Z", "setWatchVideoForGold", "(Z)V", "isWatchVideoForRetroactive", "setWatchVideoForRetroactive", "rewardList", "Lcom/wy/adbook/mvp/model/entity/accout/RewardItem;", "getRewardList", "setRewardList", "signCalendarAdapter", "Lcom/wy/adbook/mvp/view/adapter/SignCalendarAdapter;", "getSignCalendarAdapter", "()Lcom/wy/adbook/mvp/view/adapter/SignCalendarAdapter;", "setSignCalendarAdapter", "(Lcom/wy/adbook/mvp/view/adapter/SignCalendarAdapter;)V", "signSuccessGold", "getSignSuccessGold", "()I", "setSignSuccessGold", "(I)V", "canRetroactiveDay", "continueSignDay", "fetchCalendar", "", "fetchCompensateChanceReceive", "fetchData", "getContinueSIgnRuleText", "", "getGoldGet", "getSignRuleText", "getUserGold", "initData", "intent", "Landroid/content/Intent;", "postSignSuccess", "data", "signToday", "startRetroactive", "toSign", "videoForGole", "watchVideoForGetGold", "watchingVideo", "isForRetroactive", "application_debug"})
@com.jess.arms.di.scope.ActivityScope()
public final class SignCalenderPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.SignCalenderContract.Model, com.wy.adbook.mvp.contranct.SignCalenderContract.View> {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.SignCalendarAdapter signCalendarAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.ContinuousSignInAdapter continuousSignInAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public java.util.List<com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem> attendanceCalendarList;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public java.util.List<com.wy.adbook.mvp.model.entity.accout.RewardItem> rewardList;
    
    /**
     * * 连续签到
     */
    private int continueSignDays;
    private int signSuccessGold;
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.entity.AttendanceStatus attendanceStatus;
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem clickAttendanceCalendarItem;
    
    /**
     * * 看视频获取奖励
     */
    private boolean isWatchVideoForGold;
    
    /**
     * * 看视频获取补签机会
     */
    private boolean isWatchVideoForRetroactive;
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.SignCalendarAdapter getSignCalendarAdapter() {
        return null;
    }
    
    public final void setSignCalendarAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.SignCalendarAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.ContinuousSignInAdapter getContinuousSignInAdapter() {
        return null;
    }
    
    public final void setContinuousSignInAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.ContinuousSignInAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem> getAttendanceCalendarList() {
        return null;
    }
    
    public final void setAttendanceCalendarList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.model.entity.accout.RewardItem> getRewardList() {
        return null;
    }
    
    public final void setRewardList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.accout.RewardItem> p0) {
    }
    
    public final int getSignSuccessGold() {
        return 0;
    }
    
    public final void setSignSuccessGold(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.AttendanceStatus getAttendanceStatus() {
        return null;
    }
    
    public final void setAttendanceStatus(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.AttendanceStatus p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem getClickAttendanceCalendarItem() {
        return null;
    }
    
    public final void setClickAttendanceCalendarItem(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem p0) {
    }
    
    public final boolean isWatchVideoForGold() {
        return false;
    }
    
    public final void setWatchVideoForGold(boolean p0) {
    }
    
    public final boolean isWatchVideoForRetroactive() {
        return false;
    }
    
    public final void setWatchVideoForRetroactive(boolean p0) {
    }
    
    public final void fetchData() {
    }
    
    /**
     * * 签到
     *     * 签到成功后获取签到状态数据
     *     * 再请求日历数据
     */
    private final void toSign() {
    }
    
    private final void postSignSuccess(com.wy.adbook.mvp.model.entity.AttendanceStatus data) {
    }
    
    private final void fetchCalendar() {
    }
    
    /**
     * * 返回可以连续补签的天数
     */
    public final int canRetroactiveDay() {
        return 0;
    }
    
    public final int continueSignDay() {
        return 0;
    }
    
    public final int watchVideoForGetGold() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSignRuleText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContinueSIgnRuleText() {
        return null;
    }
    
    public final void signToday() {
    }
    
    public final void initData(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    public final void watchingVideo(boolean isForRetroactive) {
    }
    
    /**
     * * 获取补签机会
     */
    private final void fetchCompensateChanceReceive() {
    }
    
    /**
     * * 开始补签
     */
    public final void startRetroactive() {
    }
    
    private final void videoForGole() {
    }
    
    /**
     * * 签到成功的金豆
     */
    public final int getGoldGet() {
        return 0;
    }
    
    /**
     * * 用户的金豆
     */
    public final int getUserGold() {
        return 0;
    }
    
    @javax.inject.Inject()
    public SignCalenderPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.SignCalenderContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.SignCalenderContract.View view) {
        super(null, null);
    }
}