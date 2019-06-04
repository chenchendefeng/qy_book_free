package com.only.tech.constant;

/**
 * 用户常量
 * @author ZHI ZUN BAO
 * @since 2018/12/24
 */
public interface UserConstants {

    /**打开app**/
    Integer ACTIVE_TYPE_OPEN_APP = 0;

    /**登录app**/
    Integer ACTIVE_TYPE_LOGIN_APP = 1;

    /**注册奖励金豆**/
    Long REGISTER_AWARD_GOLD_1W = 10000L;

    /**邀请任务*/
    Integer INVITATION_TASK_UN_START = 0;
    Integer INVITATION_TASK_ONE = 1;
    Integer INVITATION_TASK_TWO = 2;
    Integer INVITATION_TASK_THREE = 3;
    /**邀请任务*/

    /**邀请第一天任务完成奖励 人民币1元*/
    long INVITATION_TASK_ONE_AWARD = 100;

    /**邀请第二天任务完成奖励 人民币1元*/
    long INVITATION_TASK_TWO_AWARD = 100;

    /**邀请第三天任务完成奖励 人民币3元*/
    long INVITATION_TASK_THREE_AWARD = 300;


    /**时间*/
    int HOUR_TO_MINUTES_1 = 60;
    int HOUR_TO_MINUTES_24 = 1440;
    int HOUR_TO_MINUTES_72 = 4320;
    int HOUR_TO_MINUTES_120 = 7200;

    /**兑换条件*/
    String VIP = "VIP";
    String READTIME = "readTime";
    String ALL = "all";

    /**兑换提现订单前缀*/
    String EXCHANGE_PREFIX = "exo";

    /** 下划线分隔符 */
    String SPIL_LINE = "_";

}
