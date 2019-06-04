package com.wy.adbook.mvp.model.entity.accout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/accout/AttendancePage;", "Ljava/io/Serializable;", "()V", "attendanceCalendar", "", "Lcom/wy/adbook/mvp/model/entity/accout/AttendanceCalendarItem;", "getAttendanceCalendar", "()Ljava/util/List;", "setAttendanceCalendar", "(Ljava/util/List;)V", "rewardList", "Lcom/wy/adbook/mvp/model/entity/accout/RewardItem;", "getRewardList", "setRewardList", "times", "", "getTimes", "()I", "setTimes", "(I)V", "application_release"})
public final class AttendancePage implements java.io.Serializable {
    
    /**
     * * 签到日历
     */
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "attendanceCalendar")
    private java.util.List<com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem> attendanceCalendar;
    
    /**
     * * 签到天数奖励
     */
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "rewardList")
    private java.util.List<com.wy.adbook.mvp.model.entity.accout.RewardItem> rewardList;
    
    /**
     * * 连续签到次数
     */
    @com.google.gson.annotations.SerializedName(value = "times")
    private int times;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem> getAttendanceCalendar() {
        return null;
    }
    
    public final void setAttendanceCalendar(@org.jetbrains.annotations.Nullable()
    java.util.List<com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.wy.adbook.mvp.model.entity.accout.RewardItem> getRewardList() {
        return null;
    }
    
    public final void setRewardList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.wy.adbook.mvp.model.entity.accout.RewardItem> p0) {
    }
    
    public final int getTimes() {
        return 0;
    }
    
    public final void setTimes(int p0) {
    }
    
    public AttendancePage() {
        super();
    }
}