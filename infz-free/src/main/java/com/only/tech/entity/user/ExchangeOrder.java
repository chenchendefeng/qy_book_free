package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 兑换订单
 * </p>
 *
 * @author zzb
 * @since 2019-05-22
 */
@Data
@ApiModel("兑换订单数据模型")
public class ExchangeOrder extends SuperEntity {

    private static final long serialVersionUID = 1L;

    @TableField("cuId")
    @ApiModelProperty("用户ID")
    private Long cuId;

    @TableField("orderNo")
    @ApiModelProperty("订单号")
    private String orderNo;

    @TableField("goodsName")
    @ApiModelProperty("礼品名称")
    private String goodsName;

    @TableField("exchangeType")
    @ApiModelProperty("礼品类型（gold:金豆 | rmb:人民币）")
    private String exchangeType;

    @ApiModelProperty("消耗量")
    private Integer cost;

    @TableField("auditTime")
    @ApiModelProperty("审核时间")
    private Date auditTime;

    @TableField("orderStatus")
    @ApiModelProperty("订单状态(0：审核中 | 1：审核成功 | 2：审核失败 | 3：微信发送处理中 | 4：红包发送成功 | 5：红包发送失败 ）")
    private Integer orderStatus;

    @ApiModelProperty("备注")
    private String remark;

    @TableField("createTime")
    @ApiModelProperty("创建时间")
    private Date createTime;

    @TableField("noDeduction")
    @ApiModelProperty("扣除前余额")
    private Long noDeduction;

    @TableField("deductioned")
    @ApiModelProperty("扣除后余额")
    private Long deductioned;

    @TableField("rmbAmount")
    private Integer rmbAmount;

    @TableField("auditorId")
    private Integer auditorId;

}
