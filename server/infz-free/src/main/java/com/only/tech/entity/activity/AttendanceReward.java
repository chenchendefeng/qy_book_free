package com.only.tech.entity.activity;

import com.only.tech.base.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntityWithIntegerID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 签到奖励配置
 * </p>
 *
 * @author zzb
 * @since 2019-05-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AttendanceReward extends SuperEntityWithIntegerID<AttendanceReward> {

    private static final long serialVersionUID = 1L;

    /**
     * 类型（firstSign:首签；dailySign：日常；continuitySign：连续）
     */
    private String type;

    /**
     * 金豆数
     */
    private Long gold;

    /**
     * 天数
     */
    private Integer days;

    /**
     * 递增数量
     */
    @TableField("addNum")
    private Long addNum;


}
