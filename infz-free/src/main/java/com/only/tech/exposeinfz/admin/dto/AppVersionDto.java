package com.only.tech.exposeinfz.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/3
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ApiModel(value = "版本")
public class AppVersionDto implements Serializable {

    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty(value = "版本code")
    private Integer versionCode;

    /**
     * 审核状态（0:未审核；1：已审核）
     */
    @ApiModelProperty(value = "审核状态（0:未审核；1：已审核）")
    private Integer audit;

    /**
     * 是否启用（0：未启用；1：启用）
     */
    @ApiModelProperty(value = "是否启用（0：未启用；1：启用）")
    private Integer enable;

    /**
     * 客户端类型（IOS;Android）
     */
    @ApiModelProperty(value = "客户端类型（IOS;Android）")
    private String clientType;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    /**
     * 最低版本
     */
    @ApiModelProperty(value = "最低版本")
    private String miniVersion;

    /**
     * 下载路径
     */
    @ApiModelProperty(value = "下载路径")
    private String downloadUrl;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String des;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    /**
     * 主题
     */
    @ApiModelProperty(value = "主题")
    private String title;

    /**
     * 提示间隔时间
     */
    @ApiModelProperty(value = "提示间隔时间")
    private Integer intervalTime;

}
