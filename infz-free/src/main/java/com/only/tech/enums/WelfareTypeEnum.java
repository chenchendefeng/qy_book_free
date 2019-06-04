package com.only.tech.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/10
 */
@Getter
@AllArgsConstructor
public enum WelfareTypeEnum {

    //新手福利
    FILL_REDPACKET_CODE("fillRedpacketCode","填写红包码"),
    BIND_PHONE_OR_WECHAT("bindPhoneOrWechat","绑定手机或微信"),
    TIME_LIMIT_INVITATION("timeLimitInvitation","限时邀请"),

    //阅读福利
    READ_TIME_30_SECOND("readTime30Second","阅读30秒计时奖励"),
    DAILY_READING("dailyReading","每日阅读"),

    //日常福利
    VIDEO_FOR_GOLD("videoForGold","看视频奖励金豆"),
    DAILY_SHARE_FOR_GOLD("dailyShareForGold","每日分享奖励1-100"),
    TURNAROUND_DRAW("turnaroundDraw","转盘抽奖");

    private String type;
    private String name;
}
