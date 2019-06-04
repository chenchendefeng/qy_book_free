package com.only.tech.dto.payment;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class BookMoneyRelativeDto implements Serializable{
	private Long id;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
     * 书币
     */
    @ApiModelProperty(value = "书币",name="bookMoney")
    private Long bookMoney;
    
    /**
     * 赠送书币
     */
    @ApiModelProperty(value = "赠送书币",name="bookBonus")
    private Long bookBonus;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序",name="sort")
    private Integer sort;
    
    /**
     * 标签
     */
    private String label;
    
    /**
     * 
     */
    @ApiModelProperty(value = "金额，单位元",name="valueYuan")
	private String valueYuan;

    private String productId;
    
    /**
     * 商品名
     */
    private String productName;

    /**
     * 描述
     */
    private String productDesc;
    
    private String discount;

	/**
	 * 状态 0：未发布 1：发布所有 2：下架3：发布ios4：发布安卓
	 */
    private Integer status;
    
    private String channel;
}
