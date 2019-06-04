package com.only.tech.entity.activity;

import java.time.LocalDate;
import java.util.Date;

import com.only.tech.base.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 福利领取机会
 * </p>
 *
 * @author zzb
 * @since 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class WelfareChance extends SuperEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableField("cuId")
    private Long cuId;

    /**
     * 类型
     */
    private String type;

    /**
     * 机会次数
     */
    @TableField("restTimes")
    private Integer restTimes;

    /**
     * 已使用
     */
    @TableField("usedTimes")
    private Integer usedTimes;

    /**
     * 日期
     */
    private Date date;


}
