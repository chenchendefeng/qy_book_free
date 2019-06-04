package com.freebookqy.application.app

/**
 * Created by leafye on 2019-05-08.
 */
object QYConfig {
    /**
     * 微信的appId
     */
    const val APP_ID_WX = "6bf3ed20191b5f5a93c44ec64abff9b3"

    /**
     * 连续签到最高可获得的金豆数
     */
    const val maxSignGoldBean: Int = 10000

    /**
     * 阅读福利中,阅读xx秒获得奖励
     */
    const val readSecondsToGetReward = 30
    /**
     * 查看视频获取的跳过广告时间
     */
    const val watchingVideoGetSkipAdTimeMinute = 20
    /**
     * 每日分享可获得的金豆
     */
    const val shareGetRewardNum = 100

    const val readLevelReward1 = 30
    const val readLevelReward2 = 60
    const val readLevelReward3 = 80
    const val readLevelReward4 = 100


    const val readLevelMinute1 = 30
    const val readLevelMinute2 = 60
    const val readLevelMinute3 = 90
    const val readLevelMinute4 = 120


}