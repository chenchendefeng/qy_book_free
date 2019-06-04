package com.only.tech.dto.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 搜索关键字
 * @author shutong
 * @since 2019-02-26
 */
@Data
@ApiModel
public class SearchWordDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("ID")
	private Long id;

	@ApiModelProperty("关键词")
	private String word;

	@ApiModelProperty("是否启用（ 1:启用 | 0:停用 ）")
	private Integer status;

	@ApiModelProperty("客服端类型 （ ios | Android ）")
	private String clientType;

	@ApiModelProperty(" 渠道编号array ( 多个渠道号用\",\"分隔 )")
	private String channelCodes;

	@ApiModelProperty("有效期-开始时间")
	private Date beginDate;

	@ApiModelProperty("有效期-结束时间")
	private Date endDate;

}
