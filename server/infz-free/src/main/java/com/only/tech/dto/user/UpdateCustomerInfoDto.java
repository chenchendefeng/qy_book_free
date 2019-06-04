package com.only.tech.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类：用户实体类
 *
 * @author shutong
 * @date 2019/04/28
 */
@Data
@ApiModel
public class UpdateCustomerInfoDto implements Serializable {

	@ApiModelProperty("用户id")
	private Long cuId;

	@ApiModelProperty("昵称")
	private String nickName;

	@ApiModelProperty("头像路径")
	private String avatar;

	@ApiModelProperty("性别 1:男，2：女，3:其他")
	private Integer sex;

}