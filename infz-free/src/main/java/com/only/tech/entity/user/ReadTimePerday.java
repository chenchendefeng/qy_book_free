package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 用户每日阅读时长
 * @author shutong
 * @since 2019/05/08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel
public class ReadTimePerday extends SuperEntity<ReadTimePerday> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    private Long cuId;

    @ApiModelProperty("阅读时间（yyyy-MM-dd）")
    private String readDate;

    @ApiModelProperty("最近阅读时间（yyyy-MM-dd HH:mm:ss）")
    private Date lastReadTime;

    @ApiModelProperty("阅读时长（秒）")
    private Integer timeCount;

    @ApiModelProperty("阅读奖励状态（0：常规福利 | 30：已经发放30分钟福利 | 60 | 90 | 180 ）")
    private Integer awardStatus;



}
