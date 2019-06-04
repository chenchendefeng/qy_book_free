package com.only.tech.user.common.constant;

public interface Constants {

    /**
     * 分页默认每页数
     */
    Integer DEFAULT_PAGE_SIZE = 20;

    /**
     * 分页默认页
     */
    Integer DEFAULT_PAGE = 1;

    /**
     * 是
     */
    Integer TRUE = 1;

    /**
     * 否
     */
    Integer FALSE = 0;



    /**
     * 版本更新方式 （0:不更新 ,1：提示更新，2：强制更新）
     * 不更新
     */
    Integer VERSION_NO_UPDATE = 0;

    /**
     * 版本更新方式 （0:不更新 ,1：提示更新，2：强制更新）
     * 提示更新
     */
    Integer VERSION_PROMPT_UPDATE = 1;


    /**
     * 版本更新方式 （0:不更新 ,1：提示更新，2：强制更新）
     * 强制更新
     */
    Integer VERSION_MANDATORY_UPDATE = 2;


    /**
     * 签到奖励码  1
     */
    Integer ATTENDANCE_INCENTIVE_CODE_ONE = 1;

    /**
     * 签到奖励码  2
     */
    Integer ATTENDANCE_INCENTIVE_CODE_TWO = 2;


    /**
     * 签到奖励码  3
     */
    Integer ATTENDANCE_INCENTIVE_CODE_THREE = 3;


    /**
     * 签到奖励码  4
     */
    Integer ATTENDANCE_INCENTIVE_CODE_FOUR = 4;


    /**
     * 签到奖励码  5
     */
    Integer ATTENDANCE_INCENTIVE_CODE_FIVE = 5;

    /**
     * 签到奖励码  6
     */
    Integer ATTENDANCE_INCENTIVE_CODE_SIX = 6;

   /**
     * 签到奖励码  7
     */
    Integer ATTENDANCE_INCENTIVE_CODE_SEVEN = 7;
    
    /**
     * 会员奖励 已领取
     */
    Integer VIP_RECEIVE_STATUS_RECEIVED = 1;
    /**
     * 会员奖励 未领取
     */
    Integer VIP_RECEIVE_STATUS_UNRECEIVED = 0;

    /**
     * 抽奖code 1
     */
    Integer LUCKY_DRAW_CODE_ONE = 1;

    /**
     * 抽奖code 2
     */
    Integer LUCKY_DRAW_CODE_TWO = 2;

    /**
     * 抽奖100书币 code
     */
    Integer LUCKY_DRAW_CODE_HUNDRED = 100;


    /**
     * 签到次数，用于验证抽奖资格
     * 签到3次就能拥有一次抽奖机会
     */
    Integer LUCKY_DRAW_ATTENDANCE_COUNT = 3;
    
    /**
     * 测试账号，登录时不需要校验
     */
    static final String TEST_PHONE1 = "15338702262";
    static final String TEST_PHONE2 = "15323822462";
    static final String TEST_PHONE3 = "13738103755";
    static final String TEST_PASSWORD = "8888";


    /**
     * 邀请未奖励
     */
    Integer INVITE_NO_AWARDED = 0;

    /**
     * 邀请已奖励
     */
    Integer INVITE_AWARDED = 1;


}
