package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 反馈回复
 * </p>
 *
 * @author HUA MAN LOU
 * @since 2019-05-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class FeedbackReply extends SuperEntity {

    private static final long serialVersionUID = 1L;

    @TableField("feedbackId")
    private Long feedbackId;

    /**
     * 反馈内容
     */
    private String content;

    /**
     * 反馈内容类型(1:文本 2:图片)
     */
    private Integer contentType;

    @TableField("createUid")
    private Long createUid;

    @TableField("createTime")
    private LocalDateTime createTime;


}
