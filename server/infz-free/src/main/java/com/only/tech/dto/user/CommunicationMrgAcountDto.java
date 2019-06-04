package com.only.tech.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/15
 */
@Data
@ApiModel("云通信管理账户模型")
public class CommunicationMrgAcountDto implements Serializable {

    @ApiModelProperty("id")
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String identifier;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nick;

    /**
     * 类型（开发者默认无需填写，值 0 表示普通帐号，1 表示机器人帐号）
     */
    @ApiModelProperty("类型（开发者默认无需填写，值 0 表示普通帐号，1 表示机器人帐号）")
    private Integer type;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String faceUrl;

    /**
     * 状态（0：停用；1：启用）
     */
    @ApiModelProperty("状态（0：停用；1：启用）")
    private Integer status;
}
