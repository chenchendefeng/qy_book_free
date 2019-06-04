package com.only.tech.book.configuration;

public interface RabbitQueues {

	/**
	 * 异常书籍队列名称
	 */
	String UNUSUALBOOKCHANGE = "unusualBookChange";

	/**
	 * 异常书籍章节队列
	 */
	String UNUSUALCHAPTERCHANGE = "unusualChapterChange";

	/**
	 * 初始化书籍队列名称
	 */
	String BOOKINFOCHANGE = "bookinfoChange";
	/**
	 * 初始化章节队列名称
	 */
	String CHAPTERCHANGE = "chapterChange";
	/**
	 * 初始化卷队列名称
	 */
	String VOLUMECHANGE = "volumeChange";

	/**
	 * 热点书籍队列
	 */
	String HOTSPOTBOOKCHANGE = "hotspotBookChange";
	/**
	 * 热点书籍卷队列
	 */
	String HOTSPOTVOLUMECHANGE = "hotspotVolumeChange";
	/**
	 * 热点书籍卷章队列
	 */
	String HOTSPOTCHAPTERCHANGE = "hotspotChapterChange";

	/**
	 * 触发书籍队列
	 */
	String TOUCHOFFBOOKCHANGE = "touchoffBookChange";
	/**
	 * 触发书籍卷队列
	 */
	String TOUCHOFFVOLUMECHANGE = "touchoffVolumeChange";
	/**
	 * 触发书籍卷章队列
	 */
	String TOUCHOFFCHAPTERCHANGE = "touchoffChapterChange";

	/**
	 * 通知触发书籍同步
	 */
	String NOTIFYTOUCHOFFBOOKCHANGE = "notifyTouchoffBookChange";


	/**
	 * 新增书籍更新时间
	 */
	String INIT_BOOK_TIME = "initBookTime";


	/**
	 * 修改书籍更新时间
	 */
	String UPDATE_BOOK_TIME = "updateBookTime";

}
