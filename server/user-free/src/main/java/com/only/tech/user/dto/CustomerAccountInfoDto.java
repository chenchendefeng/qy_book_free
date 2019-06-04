package com.only.tech.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/29
 */
@Data
@ApiModel("用户账户信息")
public class CustomerAccountInfoDto implements Serializable {

    @ApiModelProperty("用户id")
    private Long cuId;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像路径")
    private String avatar;

    @ApiModelProperty("邀请码")
    private String invitationCode;

    @ApiModelProperty("人民币")
    private Long rmb;

   @ApiModelProperty("金豆")
    private Long gold;

   @ApiModelProperty("阅读时间")
    private Integer readTime;
}
