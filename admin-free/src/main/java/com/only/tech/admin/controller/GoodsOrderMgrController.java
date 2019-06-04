package com.only.tech.admin.controller;

import com.only.tech.admin.service.facade.GoodsFacade;
import com.only.tech.admin.service.facade.GoodsOrderFacade;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.payment.GoodsDto;
import com.only.tech.entity.payment.Goods;
import com.only.tech.entity.payment.GoodsOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ctr: 商品订单
 * @author shutong
 *
 */
@Slf4j
@RestController
@RequestMapping("/goodsOrder")
@Api(tags="订单管理")
public class GoodsOrderMgrController extends BaseController {
	

	@Autowired
	private GoodsOrderFacade goodsOrderFacade;

	/**
	 * 分页查询订单列表
	 * @param pageReq
	 * @param createDateStart
	 * @param createDateEnd
	 * @param cuId
	 * @param paymentStatus
	 * @return
	 */
	@ApiOperation(value = "分页查询订单列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "createDateStart", dataType = "string", value = "创建时间范围-start" ),
		@ApiImplicitParam(name = "createDateEnd", dataType = "string", value = "创建时间范围-end" ),
		@ApiImplicitParam(name = "cuId", dataType = "int", value = "会员ID" ),
		@ApiImplicitParam(name = "paymentStatus", dataType = "int", value = "订单支付状态 ( 0：未支付|1：支付完成 | 2：支付失败 )")
	})
	@RequestMapping(value = "/pageListGoods", method = RequestMethod.POST)
	public ResultDto<GoodsOrder> pageListGoodsOrder(PageReq pageReq, String createDateStart, String createDateEnd, Long cuId,Integer paymentStatus){
		try {

			PageData<GoodsOrder> pageData=this.goodsOrderFacade.pageListByCondition(pageReq,createDateStart,createDateEnd,cuId,paymentStatus);
			return ResultDto.succesResult(pageData);

		} catch (Exception e) {
			log.error("订单查询异常" ,e);
			return ResultDto.errorResult("订单查询异常");
		}
	}

}
