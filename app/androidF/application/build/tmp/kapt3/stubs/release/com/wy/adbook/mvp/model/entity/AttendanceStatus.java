package com.wy.adbook.mvp.model.entity;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-23.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\u001e\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001e\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001e\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001e\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/AttendanceStatus;", "Ljava/io/Serializable;", "()V", "afterCompensateTimes", "", "getAfterCompensateTimes", "()I", "setAfterCompensateTimes", "(I)V", "goldAmount", "getGoldAmount", "setGoldAmount", "isFrist", "setFrist", "maxAmount", "getMaxAmount", "setMaxAmount", "missedTimes", "getMissedTimes", "setMissedTimes", "status", "getStatus", "setStatus", "times", "getTimes", "setTimes", "application_release"})
public final class AttendanceStatus implements java.io.Serializable {
    
    /**
     * * 补签后连续次数
     */
    @com.google.gson.annotations.SerializedName(value = "afterCompensateTimes")
    private int afterCompensateTimes;
    
    /**
     * * 奖励金额
     */
    @com.google.gson.annotations.SerializedName(value = "goldAmount")
    private int goldAmount;
    
    /**
     * * 是否首签
     *     * 0：否；1:是
     */
    @com.google.gson.annotations.SerializedName(value = "isFrist")
    private int isFrist;
    
    /**
     * * 最大奖励
     */
    @com.google.gson.annotations.SerializedName(value = "maxAmount")
    private int maxAmount;
    
    /**
     * * 漏签次数
     */
    @com.google.gson.annotations.SerializedName(value = "missedTimes")
    private int missedTimes;
    
    /**
     * * 状态：0：未签；1：已签
     */
    @com.google.gson.annotations.SerializedName(value = "status")
    private int status;
    
    /**
     * * 连续签到次数
     */
    @com.google.gson.annotations.SerializedName(value = "times")
    private int times;
    
    public final int getAfterCompensateTimes() {
        return 0;
    }
    
    public final void setAfterCompensateTimes(int p0) {
    }
    
    public final int getGoldAmount() {
        return 0;
    }
    
    public final void setGoldAmount(int p0) {
    }
    
    public final int isFrist() {
        return 0;
    }
    
    public final void setFrist(int p0) {
    }
    
    public final int getMaxAmount() {
        return 0;
    }
    
    public final void setMaxAmount(int p0) {
    }
    
    public final int getMissedTimes() {
        return 0;
    }
    
    public final void setMissedTimes(int p0) {
    }
    
    public final int getStatus() {
        return 0;
    }
    
    public final void setStatus(int p0) {
    }
    
    public final int getTimes() {
        return 0;
    }
    
    public final void setTimes(int p0) {
    }
    
    public AttendanceStatus() {
        super();
    }
}