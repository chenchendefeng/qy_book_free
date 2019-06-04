package com.wy.adbook.mvp.model.entity;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-15.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010-\u001a\u00020\u0013H\u0007J\b\u0010(\u001a\u00020\u0013H\u0007R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010\'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\b\u00a8\u0006."}, d2 = {"Lcom/wy/adbook/mvp/model/entity/WelfareItem;", "Ljava/io/Serializable;", "()V", "buttonTex", "", "getButtonTex", "()Ljava/lang/String;", "setButtonTex", "(Ljava/lang/String;)V", "iconTex", "getIconTex", "setIconTex", "mainTitle", "getMainTitle", "setMainTitle", "mainTitleColor", "getMainTitleColor", "setMainTitleColor", "maxNum", "", "getMaxNum", "()I", "setMaxNum", "(I)V", "minNum", "getMinNum", "setMinNum", "rewardType", "getRewardType", "setRewardType", "skipPage", "getSkipPage", "setSkipPage", "skipType", "getSkipType", "setSkipType", "subTitle", "getSubTitle", "setSubTitle", "subTitleColor", "getSubTitleColor", "setSubTitleColor", "type", "getType", "setType", "getMainTitleColorInt", "application_debug"})
public final class WelfareItem implements java.io.Serializable {
    
    /**
     * * 按钮文案
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "buttonTex")
    private java.lang.String buttonTex;
    
    /**
     * * 图标文案
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "iconTex")
    private java.lang.String iconTex;
    
    /**
     * * 主标题
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "mainTitle")
    private java.lang.String mainTitle;
    
    /**
     * * 主标题字色
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "mainTitleColor")
    private java.lang.String mainTitleColor;
    
    /**
     * * 最大数
     */
    @com.google.gson.annotations.SerializedName(value = "maxNum")
    private int maxNum;
    
    /**
     * * 最小数
     */
    @com.google.gson.annotations.SerializedName(value = "minNum")
    private int minNum;
    
    /**
     * * 奖励类型（rmb:人民币，gold:金豆）
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "rewardType")
    private java.lang.String rewardType;
    
    /**
     * * 跳转地址
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "skipPage")
    private java.lang.String skipPage;
    
    /**
     * * 跳转类型(app,h5）
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "skipType")
    private java.lang.String skipType;
    
    /**
     * * 副标题
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "subTitle")
    private java.lang.String subTitle;
    
    /**
     * * 副标题字色
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "subTitleColor")
    private java.lang.String subTitleColor;
    
    /**
     * * 类型(novice:新手;read:阅读；daily：日常）
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "type")
    private java.lang.String type;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getButtonTex() {
        return null;
    }
    
    public final void setButtonTex(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIconTex() {
        return null;
    }
    
    public final void setIconTex(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMainTitle() {
        return null;
    }
    
    public final void setMainTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMainTitleColor() {
        return null;
    }
    
    public final void setMainTitleColor(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getMaxNum() {
        return 0;
    }
    
    public final void setMaxNum(int p0) {
    }
    
    public final int getMinNum() {
        return 0;
    }
    
    public final void setMinNum(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRewardType() {
        return null;
    }
    
    public final void setRewardType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSkipPage() {
        return null;
    }
    
    public final void setSkipPage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSkipType() {
        return null;
    }
    
    public final void setSkipType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSubTitle() {
        return null;
    }
    
    public final void setSubTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSubTitleColor() {
        return null;
    }
    
    public final void setSubTitleColor(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @android.support.annotation.ColorInt()
    public final int getMainTitleColorInt() {
        return 0;
    }
    
    @android.support.annotation.ColorInt()
    public final int getSubTitleColor() {
        return 0;
    }
    
    public WelfareItem() {
        super();
    }
}