package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 云通讯账户表
 * </p>
 *
 * @author ZHI
 * @since 2019-03-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CloudCommunication extends SuperEntity<CloudCommunication> {

    private static final long serialVersionUID = 1L;

    /**
     * cuId
     */
    @TableField("cuId")
    private Long cuId;

    /**
     * 用户名
     */
    private String identifier;

    private Integer gender;

    /**
     * 昵称
     */
    private String nick;

    /**
     * 用户头像
     */
    @TableField("faceUrl")
    private String faceUrl;

    /**
     * 类型（开发者默认无需填写，值 0 表示普通帐号，1 表示机器人帐号）
     */
    private Integer type;

    /**
     * 签名
     */
    private String usersig;

    /**
     * 过期时间
     */
    @TableField("expireDate")
    private Date expireDate;

    @TableField("createDate")
    private Date createDate;

}
