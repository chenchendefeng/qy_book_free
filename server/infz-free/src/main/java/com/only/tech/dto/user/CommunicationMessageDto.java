package com.only.tech.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/15
 */
@Data
@ApiModel("推送消息模型")
public class CommunicationMessageDto implements Serializable {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("发送方")
    private String fromIdentifier;

    @ApiModelProperty("接收方")
    private String toIdentifier;

    @ApiModelProperty("接收方用户名")
    private String toUserName;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("文件类型(picture:图片；video：视频)")
    private String fileType;

    @ApiModelProperty("文件路径")
    private String fileUrl;

    @ApiModelProperty("跳转类型(page,url)")
    private String jumpType;

    @ApiModelProperty("跳转地址")
    private String directionPath;

    @ApiModelProperty("消息类型（0：群发：1：单聊）")
    private Integer msgType;

    @ApiModelProperty("性别（1：男；2：女）")
    private Integer gender;

    @ApiModelProperty("是否定时 0:不是；1：是")
    private Integer timing;

    @ApiModelProperty("发送时间")
    private Date sendTime;

    @ApiModelProperty("发送状态（0：未发送；1：已发送；2：撤销")
    private Integer sendStatus;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("创建人id")
    private Integer createUid;

    @ApiModelProperty("创建人")
    private String createName;
}
