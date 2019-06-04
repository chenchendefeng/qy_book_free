package com.only.tech.exposeinfz.activity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * DTO: 卡片
 * @author shutong
 * @since 2019/03/08
 */
@Data
@ApiModel
public class CardDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("卡片类型（ activity:活动卡片 | famousAuthor 大神卡片 ）")
    private String cardType;

    @ApiModelProperty("主标题")
    private String title1;

    @ApiModelProperty("主标题字体颜色")
    private String  title1FontColor;

    @ApiModelProperty("副标题")
    private String title2;

    @ApiModelProperty("副标题字体颜色")
    private String  title2FontColor;

    @ApiModelProperty("次副标题")
    private String title3;

    @ApiModelProperty("副标题字体颜色")
    private String  title3FontColor;


    @ApiModelProperty("链接地址")
    private String linkUrl;

    @ApiModelProperty("生效时间-起始")
    private String startTime;

    @ApiModelProperty("生效时间-终止")
    private String endTime;

    @ApiModelProperty("是否启用 （ 1: 是  | 0: 否 ）")
    private Integer status;

    @ApiModelProperty("跳转方式 （ h5: h5跳转  | app: app跳转 | book: 书籍详情跳转 ）")
    private String  linkType;

    @ApiModelProperty("初始化活动参与人数")
    private Integer initNum;

    @ApiModelProperty("图片1")
    private String pic1;

    @ApiModelProperty("图片1背景")
    private String pic1Bg;

    @ApiModelProperty("图片2")
    private String pic2;

    @ApiModelProperty("图片2背景")
    private String pic2Bg;

    @ApiModelProperty("图片3")
    private String pic3;

    @ApiModelProperty("图片3背景")
    private String pic3Bg;

    @ApiModelProperty("创建时间")
    private Date createTime;


}
