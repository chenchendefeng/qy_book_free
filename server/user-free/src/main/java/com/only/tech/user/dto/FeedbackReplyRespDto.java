package com.only.tech.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FeedbackReplyRespDto implements Serializable {

    @ApiModelProperty(value = "反馈ID", name = "feedbackId")
    private Long feedbackId;

    @ApiModelProperty(value = "反馈内容", name = "content")
    private String content;

    @ApiModelProperty(value = "反馈内容类型", name = "contentType")
    private Integer contentType;

    @ApiModelProperty(value = "创建人ID", name = "createUid")
    private Long createUid;

    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Date createTime;
}
