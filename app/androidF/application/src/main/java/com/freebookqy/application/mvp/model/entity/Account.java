package com.freebookqy.application.mvp.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by leafye on 2019-05-08.
 */
@Entity
public class Account {
    @Id
    private long id;
    /**
     * 是否当前账户
     */
    private boolean isCurrent;
    /**
     * 电话
     */
    private String mobilePhone;
    /**
     * 性别
     */
    private int gender;
    /**
     * 金豆
     */
    private int goldBean;
    /**
     * 现金
     */
    private int cash;
    /**
     * 今日阅读分钟数
     */
    private int todayReadMinute;
    /**
     * 用户名(可能是微信号)
     */
    private int userName;

    @Generated(hash = 1732738388)
    public Account(long id, boolean isCurrent, String mobilePhone, int gender,
            int goldBean, int cash, int todayReadMinute, int userName) {
        this.id = id;
        this.isCurrent = isCurrent;
        this.mobilePhone = mobilePhone;
        this.gender = gender;
        this.goldBean = goldBean;
        this.cash = cash;
        this.todayReadMinute = todayReadMinute;
        this.userName = userName;
    }

    @Generated(hash = 882125521)
    public Account() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean getIsCurrent() {
        return this.isCurrent;
    }

    public void setIsCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public int getGoldBean() {
        return this.goldBean;
    }

    public void setGoldBean(int goldBean) {
        this.goldBean = goldBean;
    }

    public int getCash() {
        return this.cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getTodayReadMinute() {
        return this.todayReadMinute;
    }

    public void setTodayReadMinute(int todayReadMinute) {
        this.todayReadMinute = todayReadMinute;
    }

    public int getUserName() {
        return this.userName;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

}
