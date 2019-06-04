package com.wy.adbook.mvp.model.entity.accout;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-16.
 * * 签到日历item
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/accout/AttendanceCalendarItem;", "Ljava/io/Serializable;", "()V", "compensateStatus", "", "getCompensateStatus", "()I", "setCompensateStatus", "(I)V", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "application_debug"})
public final class AttendanceCalendarItem implements java.io.Serializable {
    
    /**
     * * 补签状态
     */
    @com.google.gson.annotations.SerializedName(value = "compensateStatus")
    private int compensateStatus;
    
    /**
     * * 格式:2019-05-15
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "date")
    private java.lang.String date;
    
    /**
     * * 签到状态
     */
    @com.google.gson.annotations.SerializedName(value = "status")
    private int status;
    
    public final int getCompensateStatus() {
        return 0;
    }
    
    public final void setCompensateStatus(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDate() {
        return null;
    }
    
    public final void setDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getStatus() {
        return 0;
    }
    
    public final void setStatus(int p0) {
    }
    
    public AttendanceCalendarItem() {
        super();
    }
}