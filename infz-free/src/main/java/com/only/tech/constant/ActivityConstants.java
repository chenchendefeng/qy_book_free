package com.only.tech.constant;

/**
 * 常量: activity
 * @author shutong
 * @since 2019/05/08
 */
public interface ActivityConstants {

    /** 阅读奖励 **/
    int WELFARE_30S_READ_NUMBER_MAX= 66;  //阅读30秒奖励金豆_数量_上限


    /** 时长 **/
    int SECOND_30=30;        //30秒
    int SECOND_900=900;   //15分钟（900秒）
    int SECOND_1800=1800;   //30分钟（1800秒）
    int SECOND_3600=3600;   //60分钟（3600秒）
    int SECOND_5400=5400;   //90分钟（5400秒）
    int SECOND_10800=10800; //90分钟（10800秒）

    /** 时长对应的金豆 **/
    int GOLDBEAN_180=100;   //30分钟（100金豆）
    int GOLDBEAN_150=150;   //60分钟（150金豆）
    int GOLDBEAN_300=300;   //90分钟（300金豆）
    int GOLDBEAN_500=500;  //90分钟（500金豆）

    /** 时长对应的金豆 **/
    int AWARD_STATUS_30=30;     //30分钟福利
    int AWARD_STATUS_60=60;     //60分钟福利
    int AWARD_STATUS_90=90;     //90分钟福利
    int AWARD_STATUS_180=180;   //180分钟福利

    /** 奖励描述 **/
    String AWARD_MARK_30="今日累计阅读30分钟，奖励金豆100";     //30分钟福利
    String AWARD_MARK_60="今日累计阅读60分钟，奖励金豆150";     //60分钟福利
    String AWARD_MARK_90="今日累计阅读90分钟，奖励金豆300";     //90分钟福利
    String AWARD_MARK_180="今日累计阅读180分钟，奖励金豆500";   //180分钟福利
    String AWARD_MARK_NORMAL="阅读30秒，奖励金豆";            //30秒随机福利

    /**福利类型*/
    String NOVICE = "novice";//新人福利
    String READ = "read";//阅读福利
    String DAILY = "daily";//日常福利

    /**看视频奖励100*/
    long VIDEO_FOR_GOLD_100 = 100;

    /**转盘抽奖*/
    long TURNAROUND_AWARD_50 = 50;

}
