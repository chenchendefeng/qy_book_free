package com.only.tech.entity.activity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import com.only.tech.base.SuperEntityWithIntegerID;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 福利配置
 * </p>
 *
 * @author zzb
 * @since 2019-05-10
 */
@Data
@ApiModel("福利数据模型")
public class Welfare extends SuperEntityWithIntegerID {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("类型(novice:新手;read:阅读；daily：日常）")
    private String type;

    @TableField("welfareType")
    @ApiModelProperty("福利类型")
    private String welfareType;

    @TableField("rewardType")
    @ApiModelProperty("奖励类型（rmb:人民币，gold:金豆）")
    private String rewardType;


    @TableField("mainTitle")
    @ApiModelProperty("主标题")
    private String mainTitle;


    @TableField("mainTitleColor")
    @ApiModelProperty("主标题字色")
    private String mainTitleColor;


    @TableField("subTitle")
    @ApiModelProperty("副标题")
    private String subTitle;


    @TableField("subTitleColor")
    @ApiModelProperty("副标题字色")
    private String subTitleColor;

    @TableField("minNum")
    @ApiModelProperty("最小值")
    private Double minNum;

    @TableField("maxNum")
    @ApiModelProperty("最大值")
    private Double maxNum;


    @TableField("skipType")
    @ApiModelProperty("跳转类型(app,h5）")
    private String skipType;


    @TableField("skipPage")
    @ApiModelProperty("跳转地址")
    private String skipPage;


    @TableField("buttonTex")
    @ApiModelProperty("按钮文案")
    private String buttonTex;


    @TableField("iconTex")
    @ApiModelProperty("图标文案")
    private String iconTex;


    @ApiModelProperty("状态（0：停用；1：启用）")
    private Integer status;


    @ApiModelProperty("排序")
    private Integer sort;

    @TableField("createTime")
    @ApiModelProperty("创建时间")
    private Date createTime;

    @TableField("updateTime")
    @ApiModelProperty("更新时间")
    private Date updateTime;

    @TableField("showTime")
    @ApiModelProperty("展示时间(分钟)")
    private Integer showTime;

}
