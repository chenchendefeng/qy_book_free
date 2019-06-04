package com.only.tech.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/12
 */
@Data
@ApiModel("云通信模型")
public class CloudCommunicationDto implements Serializable {

    /**
     * uid
     */
    @ApiModelProperty("用户id")
    private Long cuId;

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
     * 用户头像
     */
    @ApiModelProperty("用户头像")
    private String faceUrl;

    /**
     * 类型（开发者默认无需填写，值 0 表示普通帐号，1 表示机器人帐号）
     */
    @ApiModelProperty("类型（开发者默认无需填写，值 0 表示普通帐号，1 表示机器人帐号）")
    private Integer type;

    /**
     * 签名
     */
    @ApiModelProperty("签名")
    private String usersig;

}
