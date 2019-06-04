package com.only.tech.entity.user;

import lombok.Data;

import java.util.Date;

@Data
public class Feedback {

    /**
     * 主键
     */
    private Long fid;

    /**
     * 用户ID
     */
    private Long cuId;

    /**
     * 反馈内容
     */
    private String content;

    /**
     * 反馈内容类型(1:文本 2:图片)
     */
    private Integer contentType;

    /**
     * QQ号码
     */
    private String qq;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 创建时间
     */
    private Date createDate;

}
