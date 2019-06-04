package com.only.tech.activity.common.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/9
 */
@Data
@ApiModel("签到奖励")
public class AttendanceRewardDto implements Serializable {

    @ApiModelProperty("类型（firstSign:首签；dailySign：日常；continuitySign：连续）")
    private String type;

    @ApiModelProperty("金豆数")
    private Long gold;

    @ApiModelProperty("天数")
    private Integer days;

}
