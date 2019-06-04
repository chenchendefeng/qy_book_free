package com.only.tech.enums;

import com.only.tech.constant.ActivityConstants;
import com.only.tech.constant.GoldChangeTypeConstants;
import com.only.tech.constant.RmbChangeTypeConstants;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/5
 */
@Getter
@AllArgsConstructor
public enum AccountChangeSpecificTypeEnum {

    /**金豆奖励*/
    GOLD_REGISTER_REDPACK(GoldChangeTypeConstants.REGISTER_AWARD,"注册奖励",""),
    FIRST_ATTENDANCE_AWARD(GoldChangeTypeConstants.FIRST_ATTENDANCE_AWARD,"首次签到奖励",""),
    DAILY_ATTENDANCE_AWARD(GoldChangeTypeConstants.DAILY_ATTENDANCE_AWARD,"日常签到奖励",""),
    CONTINUITY_ATTENDANCE_AWARD(GoldChangeTypeConstants.CONTINUITY_ATTENDANCE_AWARD,"连续签到[]奖励",""),
    COMPENSATE_ATTENDANCE_DEDUCTION(GoldChangeTypeConstants.COMPENSATE_ATTENDANCE_DEDUCTION,"补签扣除",""),
    NEWUSER_INVITATION_REWARD_MULTIPLE(GoldChangeTypeConstants.NEWUSER_INVITATION_REWARD_MULTIPLE,"限时邀请阅读翻倍奖励",""),
    WATCH_SMALL_VIDEO_AWARD(GoldChangeTypeConstants.WATCH_SMALL_VIDEO_AWARD,"观看小视频奖励[]金豆",""+ActivityConstants.VIDEO_FOR_GOLD_100),
    DAILY_SHARING_AWARD(GoldChangeTypeConstants.DAILY_SHARING_AWARD,"每日分享奖励[]金豆",""),
    DRAW_LUCKY_TURNTABLE_AWARD(GoldChangeTypeConstants.DRAW_LUCKY_TURNTABLE_AWARD,"幸运转盘奖励[]金豆",""+ActivityConstants.TURNAROUND_AWARD_50),

    READ_30_SECONDS_AWARD(GoldChangeTypeConstants.READ_30_SECONDS_AWARD,"阅读30秒奖励",""),
    READ_MINUTE_AWARD(GoldChangeTypeConstants.READ_MINUTE_AWARD,"阅读[]分钟奖励",""),

    /**人民币奖励*/
    RMB_REGISTER_REDPACK(RmbChangeTypeConstants.REGISTER_REDPACK,"注册红包",""),
    INVITATION_CODE_REDPACK(RmbChangeTypeConstants.INVITATION_CODE_REDPACK,"填红包码奖励",""),
    INVITATION_REDPACK(RmbChangeTypeConstants.INVITATION_REDPACK,"邀请好友红包",""),
    INVITATION_READ_AWARD(RmbChangeTypeConstants.INVITATION_REDPACK,"邀请好友红包",""),


    ;


    private String type;
    private String name;
    private String remark;

    public String getName() {
        if (StringUtils.isNotBlank(remark)){
            return name.replace("[]",remark);
        }
        return name;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }
}
