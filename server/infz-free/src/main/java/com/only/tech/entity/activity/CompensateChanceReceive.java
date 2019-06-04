package com.only.tech.entity.activity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 补签机会领取记录
 * </p>
 *
 * @author zzb
 * @since 2019-05-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CompensateChanceReceive extends SuperEntity<CompensateChanceReceive> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableField("cuId")
    private Long cuId;

    /**
     * 类型(video：视频）
     */
    private String type;

    /**
     * 领取时间
     */
    @TableField("receiveDate")
    private String receiveDate;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;


}
