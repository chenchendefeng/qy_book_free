package com.only.tech.exposeinfz.activity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * DTO： 活动的规则
 * @author shutong
 * @since 2019/03/12
 */
@Data
@ApiModel
public class ActivityRuleDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("规则名称")
    private String ruleName;

    @ApiModelProperty("规则描述")
    private String ruleDesc;

    @ApiModelProperty("规则编码")
    private String ruleCode;

    @ApiModelProperty("阈值1")
    private Integer value1;

    @ApiModelProperty("阈值2")
    private Integer value2;

    @ApiModelProperty("阈值1描述")
    private String value1Desc;

    @ApiModelProperty("阈值2描述")
    private String value2Desc;



}
