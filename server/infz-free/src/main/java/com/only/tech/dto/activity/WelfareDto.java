package com.only.tech.dto.activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/10
 */
@Data
@ApiModel("福利数据")
public class WelfareDto implements Serializable {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("类型(novice:新手;read:阅读；daily：日常）")
    private String type;

    @ApiModelProperty("福利类型")
    private String welfareType;

    @ApiModelProperty("奖励类型（rmb:人民币，gold:金豆）")
    private String rewardType;

    @ApiModelProperty("主标题")
    private String mainTitle;

    @ApiModelProperty("主标题字色")
    private String mainTitleColor;

    @ApiModelProperty("副标题")
    private String subTitle;

    @ApiModelProperty("副标题字色")
    private String subTitleColor;

    @ApiModelProperty("最小数")
    private Double minNum;

    @ApiModelProperty("最大数")
    private Double maxNum;

    @ApiModelProperty("跳转类型(app,h5）")
    private String skipType;

    @ApiModelProperty("跳转地址")
    private String skipPage;

    @ApiModelProperty("按钮文案")
    private String buttonTex;

    @ApiModelProperty("图标文案")
    private String iconTex;


}
