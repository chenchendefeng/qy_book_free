package com.only.tech.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/3
 */
@Data
@ApiModel(value = "版本更新")
public class VersionManageDto implements Serializable {

    /**
     * 更新方式（0:不更新 ,1：提示更新，2：强制更新）
     */
    @ApiModelProperty(value = "更新方式（0:不更新 ,1：提示更新，2：强制更新）")
    public Integer type;


    /**
     * apk下载地址
     */
    @ApiModelProperty(value = "apk下载地址")
    public String url;

    @ApiModelProperty(value = "更新描述")
    public String des;


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
