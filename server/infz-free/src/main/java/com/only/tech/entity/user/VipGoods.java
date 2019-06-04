package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;

/**
 * 会员商品表
 * @author shoujun.yang
 * @since 2019-01-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel
public class VipGoods extends SuperEntity<VipGoods> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品唯一编码")
    @TableField("productId")
    private String productId;

    @ApiModelProperty("商品名")
    @TableField("productName")
    private String productName;

    @ApiModelProperty("描述")
    private String productDesc;

    @ApiModelProperty("价格，单位分")
    private Integer price;

    @ApiModelProperty("有效天数")
    @TableField("effectiveDays")
    private Integer effectiveDays;

    @ApiModelProperty("商品图片")
    private String ioc;

    @ApiModelProperty("会员类型 1：普通商品 2：续费商品")
    private Integer type;

    @ApiModelProperty("产品状态 （ 1:上架 | 0:下架 ）")
    private Integer status;

    @ApiModelProperty("发布状态 （ unpublished:未发布 | all:发布所有 | Android:安卓 | ios:发布ios ）")
    private String  publishedStatus;

    @ApiModelProperty("创建时间")
    @TableField("createDate")
    private LocalDateTime createDate;

    @ApiModelProperty("修改时间")
    @TableField("updateDate")
    private LocalDateTime updateDate;

    @ApiModelProperty("备用价格（续费会员会用到）")
    @TableField(exist = false)
    private Integer sharePrice;

    @ApiModelProperty("折扣")
    private String discount;

    @ApiModelProperty("标签")
    private String label;

    @ApiModelProperty("渠道（all:全渠道 | 多个渠道用逗号分隔）")
    private String channel;
}
