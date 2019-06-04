package com.only.tech.payment.service.listener;

import java.util.Date;

import com.only.tech.entity.payment.Goods;
import com.only.tech.entity.payment.GoodsOrder;
import com.only.tech.entity.user.Customer;
import com.only.tech.exposeinfz.user.api.CustomerInfz;
import com.only.tech.payment.service.biz.GoodsService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.only.tech.exposeinfz.user.api.UserVipInfz;
import com.only.tech.exposeinfz.common.utils.AmountUtils;
import com.only.tech.payment.service.biz.GoodsOrderService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RabbitListener(queues = com.only.tech.payment.configuration.RabbitQueues.ORDER_DETAIL_CHANGE)
public class OrderDetailListener {

	@Autowired
	private GoodsOrderService goodsOrderService;

	@Autowired
	private GoodsService goodsService;

	@Reference
	CustomerInfz customerInfz;

	@Reference
	UserVipInfz userVipInfz;

    @RabbitHandler
    public void process(String context) {
        JSONObject json = JSONObject.parseObject(context);
        String orderNum=json.getString("orderNum");
        Long uid = json.getLong("cuId");
        Long goodsId = json.getLong("goodsId");
        Integer money = json.getInteger("money");

        StringBuilder sb = new StringBuilder(100);
        GoodsOrder order = new GoodsOrder();
        if(orderNum == null || uid == null || money == null)
        {
        	log.error("prodess OrderDetailListener param error, orderNum or money or uid is null");
        	return;
        }
        order.setOrderNum(orderNum);
    	Customer customer = customerInfz.getOneByCuid(uid);
    	if(customer!=null)
    	{
    		order.setName(customer.getCuName());
    	}

		Goods goods=this.goodsService.getOneById(goodsId);
		long bookMoney = goods.getGoodsPrice();
		String moneyForYuan = null;
		try {
			moneyForYuan = AmountUtils.changeF2Y(money.longValue());
		} catch (Exception e) {
			log.error("AmountUtils.changeF2Y error",money,e);
		}
		sb.append("书币").append(moneyForYuan).append("元").append("/").append(bookMoney).append("个");
        order.setGoodsName(sb.toString());
        order.setUpdateDate(new Date());
        goodsOrderService.updateOrderByOrderNum(order);
    }
}
