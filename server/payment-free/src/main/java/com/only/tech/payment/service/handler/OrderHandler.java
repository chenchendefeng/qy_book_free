package com.only.tech.payment.service.handler;

import com.only.tech.exposeinfz.common.constants.RedisCons;
import com.only.tech.exposeinfz.common.constants.RedisCons.SysName;
import com.only.tech.payment.common.utils.DateUtils;
import com.only.tech.payment.service.biz.GoodsOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class OrderHandler {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	private GoodsOrderService goodsOrderService;

	public String getOrderNoByRedis(SysName sysName) {
		String key = sysName.getValue();
		String orderPrefix = null;
		switch (sysName) {
		case BOOK:
			orderPrefix = RedisCons.PREFIX_BOOK;
			break;
		case PAYMENT:
			orderPrefix = RedisCons.PREFIX_PAYMENT;
			break;
		case USER:
			orderPrefix = RedisCons.PREFIX_USER;
			break;
		}
		if (!redisTemplate.hasKey(key)) {
			redisTemplate.opsForValue().set(key, RedisCons.ORDERNO_SUFFER, 1, TimeUnit.DAYS);
		}
		long orderSuffer = redisTemplate.opsForValue().increment(key, 1l);
		String timeStr = DateUtils.getTimeStr(DateUtils.NO_SYMBLE_FORMAT_MILL);
		StringBuilder sb = new StringBuilder(orderPrefix);
		return sb.append(timeStr).append(RedisCons.SPIL_LINE).append(orderSuffer).toString();
	}

}
