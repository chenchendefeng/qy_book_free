package com.only.tech.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/21
 */
@Data
@ApiModel("用户基本信息")
public class CustomerBaseDto implements Serializable {

    @ApiModelProperty("用户id")
    private Long cuId;

    @ApiModelProperty("昵称")
    private String nickName;
}
