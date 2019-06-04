package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;


/**
 * <p>
 * 
 * </p>
 *
 * @author ZHI
 * @since 2019-03-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CommunicationMessage extends SuperEntity<CommunicationMessage> {

    private static final long serialVersionUID = 1L;

    /**
     * 发送方
     */
    @TableField("fromIdentifier")
    private String fromIdentifier;

    /**
     * 接收方
     */
    @TableField("toIdentifier")
    private String toIdentifier;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 文件类型(picture:图片；video：视频)
     */
    @TableField("fileType")
    private String fileType;

    /**
     * 文件路径
     */
    @TableField("fileUrl")
    private String fileUrl;

    /**
     * 跳转类型(page,url)
     */
    @TableField("jumpType")
    private String jumpType;

    /**
     * 跳转地址
     */
    @TableField("directionPath")
    private String directionPath;

    /**
     * 消息类型（0：群发：1：单聊）
     */
    @TableField("msgType")
    private Integer msgType;

    /**
     * 性别（1：男；2：女）
     */
    private Integer gender;

    /**
     * 是否定时 0：不是；1：是
     */
    private Integer timing;

    /**
     * 发送时间
     */
    @TableField("sendTime")
    private Date sendTime;

    /**
     * 发送状态（0：未发送；1：已发送；2：撤销）
     */
    @TableField("sendStatus")
    private Integer sendStatus;

    /**
     * 创建时间
     */
    @TableField("createDate")
    private Date createDate;

    /**
     * 创建人id
     */
    @TableField("createUid")
    private Integer createUid;

    /**
     * 创建人
     */
    @TableField("createName")
    private String createName;

}
