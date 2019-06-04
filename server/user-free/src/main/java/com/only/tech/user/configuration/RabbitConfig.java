package com.only.tech.user.configuration;

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
	 * 用户首充
	 *
	 * @return
	 */
	@Bean
	public Queue Queue_UserFirstPay_Change() {
		return new Queue(RabbitQueues.USER_FIRST_PAY);
	}

}