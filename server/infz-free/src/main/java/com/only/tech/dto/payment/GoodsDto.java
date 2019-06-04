package com.only.tech.dto.payment;

import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * dto: 商品
 * @author shutong
 * @since 2019/05/15
 */
@Data
@ApiModel
public class GoodsDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品类型 (vip会员 | ...)")
    private Long id;

    @ApiModelProperty("商品类型 (vip会员 | ...)")
    private String goodsType;

    @ApiModelProperty("商品价格（单位: 分）")
    private Long goodsPrice;

    @ApiModelProperty("数量（ 会员：天 | ..）")
    private Long goodsNum;

    @ApiModelProperty("商品名")
    private String goodsName;

    @ApiModelProperty("商品描述")
    private String goodsMsg;

    @ApiModelProperty("角标")
    private String noticeMsg;

    @ApiModelProperty("商品编号")
    private String goodsCode;

    @ApiModelProperty("是否上架 ( 1:是 | 0：否) )")
    private Integer saleStatus;

}
