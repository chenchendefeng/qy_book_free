package com.only.tech.exposeinfz.activity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 活动配置表
 * @author shutong
 * @since 2019-02-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class ActivitysConfigDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("活动名称")
    private String title;

    @ApiModelProperty("启用状态（0：关闭；1；启用）")
    private Integer enabled;

    @ApiModelProperty("活动开始时间")
    private String startDate;

    @ApiModelProperty("活动结束时间")
    private String endDate;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("更新时间")
    private Date updateDate;

    @ApiModelProperty("活动编码（类型）")
    private String type;

    @ApiModelProperty("规则ID数组")
    private String ruleIds;

    @ApiModelProperty("位置ID数组")
    private String positionIds;

    @ApiModelProperty("奖品ID数组")
    private String awardIds;

    /****************附加属性*********************/
    @ApiModelProperty("奖品信息")
    private List<AwardInfoDto> awardList;


}
