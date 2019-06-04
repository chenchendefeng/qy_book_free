package com.only.tech.exposeinfz.activity.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 奖品表
 * @author chongyang.wang
 * @since 2019-01-17
 */
@Data
@ApiModel
public class AwardInfoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("主键ID")
	private Long id;

	@ApiModelProperty("奖品类型 0：书币 1：实物 2：会员  3:书")
	private Integer type;

	@ApiModelProperty("奖品描述")
	private String awardDesc;

	@ApiModelProperty("奖品价值，单位元")
	private String awardValue;

	@ApiModelProperty("奖品数量 -1表示不限量")
	private Integer awardCount;

	@ApiModelProperty("剩余数量 -1表示不限量")
	private Integer remain;

	@ApiModelProperty("奖品金额（如书币个数、会员天数，若是话费单位就是分）")
	private Integer amount;

	@ApiModelProperty("优先级排序")
	private Integer sort;

	@ApiModelProperty("奖品金额随机值上限")
	private Integer amount1;

	@ApiModelProperty("奖品数量类型（ fix:固定值 | random: 随机值 ）")
	private String sendType;

	@ApiModelProperty("发放周期（once:一次 | onceDay: 一天一次 | forever: 永久 ）")
	private String sendPeriod;

	@ApiModelProperty("使用有效周期（-1:永久 | n: 天数 ）")
	private Integer usePeriod;

	@ApiModelProperty("是否启用 （0关闭 | 1启用）")
	private Integer status;

	@ApiModelProperty("奖品类型 （ virtual:虚拟 | entity:实体 ）")
	private String awardType;

	@ApiModelProperty("奖品编码")
	private String awardCode;

	/****************附加属性*********************/
	@ApiModelProperty("实物奖品列表")
	private List<AwardItemDto> awardItemDtoList;



}
