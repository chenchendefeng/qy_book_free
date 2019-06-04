package com.only.tech.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 会员商品表
 * </p>
 *
 * @author shoujun.yang
 * @since 2019-01-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class UVipGoodsDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
	private Long id;

    @ApiModelProperty("商品编码")
    private String productId;

    @ApiModelProperty("商品名")
    private String productName;

    @ApiModelProperty("描述")
    private String productDesc;

    @ApiModelProperty("价格，单位分")
    private Integer price;

    @ApiModelProperty("有效天数")
    private Integer effectiveDays;

    @ApiModelProperty("商品图片")
    private String ioc;

    @ApiModelProperty("会员类型 0：普通商品 1：续费商品")
    private Integer type;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("修改时间")
    private Date updateDate;

    @ApiModelProperty("产品状态 （ 1:上架 | 0:下架 ）")
    private Integer status;

    @ApiModelProperty("发布状态 （ unpublished:未发布 | all:发布所有 | Android:安卓 | ios:发布ios ）")
    private String  publishedStatus;

    @ApiModelProperty("备用价格（续费会员会用到）")
    private Integer sharePrice;

    @ApiModelProperty("折扣")
    private String discount;

    @ApiModelProperty("标签")
    private String label;

    @ApiModelProperty("渠道（all:全渠道 | 多个渠道用逗号分隔）")
    private String channel;



}
