package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 云通信管理账户
 * </p>
 *
 * @author ZHI
 * @since 2019-03-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CommunicationMrgAcount extends SuperEntity<CommunicationMrgAcount> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String identifier;

    /**
     * 昵称
     */
    private String nick;

    /**
     * 类型（开发者默认无需填写值 0 表示普通帐号，1 表示机器人帐号）
     */
    private Integer type;

    /**
     * 头像
     */
    @TableField("faceUrl")
    private String faceUrl;

    /**
     * 状态（0：停用；1：启用）
     */
    private Integer status;

    @TableField("createDate")
    private Date createDate;


}
