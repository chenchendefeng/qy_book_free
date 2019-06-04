package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntityWithIntegerID;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 兑换商品
 * </p>
 *
 * @author zzb
 * @since 2019-05-22
 */
@Data
@ApiModel("礼品数据模型")
public class ExchangeGoods extends SuperEntityWithIntegerID {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("标记")
    private String marker;


    @TableField("exchangeType")
    @ApiModelProperty("兑换类型（gold:金豆 | rmb:人民币）")
    private String exchangeType;


    @ApiModelProperty("条件（VIP:会员 | readTime| all:所有）")
    private String requirement;

    @TableField("requirementNumber")
    @ApiModelProperty("条件数量")
    private Integer requirementNumber;

    @ApiModelProperty("费用")
    private Integer cost;

    @ApiModelProperty("状态（0：下架 | 1:上架）")
    private Integer status;

    @ApiModelProperty("排序")
    private Integer sort;

    @TableField("createTime")
    @ApiModelProperty("创建时间")
    private Date createTime;

    @TableField("updateTime")
    @ApiModelProperty("更新时间")
    private Date updateTime;


}
