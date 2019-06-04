package com.only.tech.entity.user;

import java.time.LocalDateTime;
import java.util.Date;

import com.only.tech.base.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 邀请记录
 * </p>
 *
 * @author zzb
 * @since 2019-05-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class InvitationRecord extends SuperEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableField("cuId")
    private Long cuId;

    /**
     * 被邀请人
     */
    @TableField("invitedCuid")
    private Long invitedCuid;

    @TableField("createTime")
    private Date createTime;

    /**
     * 任务状态（0：未完成任务;1：完成1；2：完成2；3：完成3）
     */
    @TableField("taskStatus")
    private Integer taskStatus;

    /**
     * 任务到期时间
     */
    @TableField("taskExpiryTime")
    private Date taskExpiryTime;

}
