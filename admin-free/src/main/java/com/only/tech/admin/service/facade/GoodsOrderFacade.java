package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.payment.GoodsDto;
import com.only.tech.entity.payment.Goods;
import com.only.tech.entity.payment.GoodsOrder;
import com.only.tech.exposeinfz.payment.api.GoodsInfz;
import com.only.tech.exposeinfz.payment.api.GoodsOrderInfz;
import org.springframework.stereotype.Service;

/**
 * facade: 商品订单
 * @author shutong
 * @since 2019/05/20
 */
@Service
public class GoodsOrderFacade {

	@Reference
	private GoodsOrderInfz orderInfz;

	/**
	 * 分页查询
	 * @param pageReq
	 * @param createDateStart
	 * @param createDateEnd
	 * @param cuId
	 * @param paymentStatus
	 * @return
	 */
	public PageData<GoodsOrder> pageListByCondition(PageReq pageReq, String createDateStart, String createDateEnd, Long cuId, Integer paymentStatus) {
		return this.orderInfz.pageListByCondition(pageReq,createDateStart,createDateEnd,cuId,paymentStatus);
	}
}
