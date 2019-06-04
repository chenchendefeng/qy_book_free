package com.only.tech.payment.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mq配置
 * 
 * @date 2018/11/08
 * @version 1.0
 */
@Configuration
public class RabbitConfig {

	/**
	 * 订单详情补充(商品详情和用户姓名等)
	 * 
	 * @return
	 */
	@Bean
	public Queue Queue_OrderDetail_Change() {
		return new Queue(RabbitQueues.ORDER_DETAIL_CHANGE);
	}

}