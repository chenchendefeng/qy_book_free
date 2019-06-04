package com.only.tech.book.configuration;

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
	 * 异常书籍队列
	 *
	 * @return
	 */
	@Bean
	public Queue Queue_UnusualBook_Change() {
		return new Queue(RabbitQueues.UNUSUALBOOKCHANGE);
	}

	/**
	 * 异常书籍章节队列
	 *
	 * @return
	 */
	@Bean
	public Queue Queue_UnusualChapter_Change() {
		return new Queue(RabbitQueues.UNUSUALCHAPTERCHANGE);
	}

	/**
	 * 初始化书籍
	 *
	 * @return
	 */
	@Bean
	public Queue Queue_Bookinfo_Change() {
		return new Queue(RabbitQueues.BOOKINFOCHANGE);
	}

	/**
	 * 初始化书籍卷章节
	 *
	 * @return
	 */
	@Bean
	public Queue Queue_Chapter_Change() {
		return new Queue(RabbitQueues.CHAPTERCHANGE);
	}

	/**
	 * 初始化书籍卷
	 *
	 * @return
	 */
	@Bean
	public Queue Queue_Volume_Change() {
		return new Queue(RabbitQueues.VOLUMECHANGE);
	}

	/**
	 * 热点书籍
	 *
	 * @return
	 */
	@Bean
	public Queue Queue_HotspotBookinfo_Change() {
		return new Queue(RabbitQueues.HOTSPOTBOOKCHANGE);
	}

	/**
	 * 热点书籍卷章
	 *
	 * @return
	 */
	@Bean
	public Queue Queue_HotspotChapter_Change() {
		return new Queue(RabbitQueues.HOTSPOTCHAPTERCHANGE);
	}

	/**
	 * 热点书籍卷
	 *
	 * @return
	 */
	@Bean
	public Queue Queue_HotspotVolume_Change() {
		return new Queue(RabbitQueues.HOTSPOTVOLUMECHANGE);
	}

	/**
	 * 触发书籍
	 *
	 * @return
	 */
	@Bean
	public Queue Queue_TouchoffBookinfo_Change() {
		return new Queue(RabbitQueues.TOUCHOFFBOOKCHANGE);
	}

	/**
	 * 触发书籍卷章
	 *
	 * @return
	 */
	@Bean
	public Queue Queue_TouchoffChapter_Change() {
		return new Queue(RabbitQueues.TOUCHOFFCHAPTERCHANGE);
	}

	/**
	 * 触发书籍卷
	 *
	 * @return
	 */
	@Bean
	public Queue Queue_TouchoffVolume_Change() {
		return new Queue(RabbitQueues.TOUCHOFFVOLUMECHANGE);
	}

	/**
	 * 通知触发书籍同步队列
	 *
	 * @return
	 */
	@Bean
	public Queue Queue_NotifyTouchoffBook_Change() {
		return new Queue(RabbitQueues.NOTIFYTOUCHOFFBOOKCHANGE);
	}

}