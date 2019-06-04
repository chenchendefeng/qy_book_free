package com.only.tech.entity.activity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 福利领取记录
 * </p>
 *
 * @author zzb
 * @since 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ReceiveWelfare extends SuperEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableField("cuId")
    private Long cuId;

    /**
     * 福利类型(novice:新手;read:阅读；daily：日常）
     */
    private String type;

    /**
     * 福利类型（videoForGold：看视频奖励金豆 | dailyShareForGold：每日分享奖励1-100 | turnaroundDraw：转盘抽奖
     */
    private String welfareType;

    /**
     * 领取时间
     */
    private String date;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;


}
