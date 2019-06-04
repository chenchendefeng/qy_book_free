package com.only.tech.dto.activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/29
 */
@Data
@ApiModel("弹窗数据模型")
public class PopupWindowDto implements Serializable {

    @ApiModelProperty("类型（0:大弹窗; 1:小弹窗）")
    private Integer windowType;

    @ApiModelProperty("显示类型 0：点击消失 1：一直显示")
    private Integer showType;

    @ApiModelProperty("显示页面")
    private String showPage;

    @ApiModelProperty("跳转类型 0：app内 1：h5")
    private Integer skipType;

    @ApiModelProperty("跳转页面")
    private String skipPage;

    @ApiModelProperty("图片路径")
    private String img;

    @ApiModelProperty("是否绑定活动 0：否；1：是")
    private Integer bindActivity;

    @ApiModelProperty("活动id")
    private Integer activityId;

}
