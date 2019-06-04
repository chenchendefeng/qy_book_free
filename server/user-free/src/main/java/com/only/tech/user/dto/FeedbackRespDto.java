package com.only.tech.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class FeedbackRespDto implements Serializable {

    /**
     * 主键
     */
    @ApiModelProperty(value = "反馈ID", name = "fid")
    private Long fid;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID", name = "cuId")
    private Long cuId;

    /**
     * 反馈内容
     */
    @ApiModelProperty(value = "反馈内容", name = "content")
    private String content;

    @ApiModelProperty(value = "反馈内容类型", name = "contentType")
    private Integer contentType;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", name = "createDate")
    private Date createDate;

    /**
     * 反馈回复列表
     */
    @ApiModelProperty(value = "反馈回复列表", name = "replyList")
    private List<FeedbackReplyRespDto> replyList;
}
