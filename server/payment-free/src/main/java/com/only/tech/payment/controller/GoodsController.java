package com.only.tech.payment.controller;

import com.only.tech.base.result.ResultDto;
import com.only.tech.entity.payment.Goods;
import com.only.tech.payment.service.biz.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import ooh.chaos.targetMethod.Access;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * ctr: 商品（ 会员 | ... ）
 * @author shutong
 *
 */
@Slf4j
@RestController
@RequestMapping("/goods")
@Api(tags="商品管理")
public class GoodsController extends BaseController {
	
	@Autowired
	private GoodsService goodsService;


	/**
	 * 获取商品列表（ 会员| ...）
	 * @param goodsType
	 * @return
	 */
	@ApiOperation(value = "获取会员信息列表（会员商品）")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "goodsType", dataType = "String", value = "商品类型 (vip 会员 | ...)", required = true)
	})
	@RequestMapping(value = "/listGoods", method = RequestMethod.POST)
	@Access
	public ResultDto<Goods> listGoods(String goodsType){
		try {

			if(StringUtils.isBlank(goodsType)){
				ResultDto.errorResult("参数异常");
			}

			List<Goods> goodsList=this.goodsService.listByCondition(goodsType,1);
			return ResultDto.succesResult(goodsList);

		} catch (Exception e) {
			log.error("商品查询异常" ,e);
			return ResultDto.errorResult("商品查询异常");
		}
	}


}
