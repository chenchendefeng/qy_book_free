package com.only.tech.user.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/30
 */
@Data
@ApiModel("兑换礼品数据")
public class ExchangeGoodsPageDto implements Serializable {

    private Long gold;

    private Double goldToRmb;

    private Double rmb;

    private List<ExchangeGoodsDto> goldGoodsList;

    private List<ExchangeGoodsDto> rmbGoodsList;

}
