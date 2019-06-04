package com.only.tech.payment.service.biz;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.payment.Goods;
import com.only.tech.entity.payment.GoodsOrder;

public interface GoodsOrderService extends IService<GoodsOrder> {

	void updateOrderByOrderNum(GoodsOrder order);

	GoodsOrder queryOrderByOutTradeNo(String orderNo);

	Set<String> queryOutTradeNoAndMoney(String billDate, Integer payMethod);

	/**
	 * 条件查询订单
	 * @param createDateStart
	 * @param createDateEnd
	 * @param cuId
	 * @param paymentStatus
	 * @return
	 */
    List<GoodsOrder> listByCondition(String createDateStart, String createDateEnd, Long cuId, Integer paymentStatus);
}
