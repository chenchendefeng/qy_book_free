package com.only.tech.entity.payment;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 实体：商品订单表
 * @author shutong
 * @since 2019/05/15
 *
 */
@Data
@ApiModel("商品订单表")
public class GoodsOrder extends SuperEntity<GoodsOrder> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("订单序列号")
	private String orderNum;

	@ApiModelProperty("用户ID")
	private Long cuId;

	@ApiModelProperty("商品价格(单位：分)")
	private Long goodsPrice;

	@ApiModelProperty("支付方式 （ 1：微信 | ....) ")
	private Integer payMethod;

	@ApiModelProperty("支付状态 （ 0：未支付 | 1：支付完成 | 2：支付失败) ")
	private Integer paymentStatus;

	@ApiModelProperty("支付完成时间")
	private Date payTime;

	@ApiModelProperty("创建时间")
	private Date createDate;

	@ApiModelProperty("修改时间")
	private Date updateDate;
	
	@ApiModelProperty("商品编号")
	private String goodsCode;

	@ApiModelProperty("商品名")
	private String goodsName;

	@ApiModelProperty("用户名")
	private String name;

	@ApiModelProperty("系统类型")
	private String systemType;

}
