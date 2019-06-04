package com.only.tech.task.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.BookTaskType;
import com.only.tech.exposeinfz.datasource.task.BookTaskInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookTaskManager {

	@Reference(retries = 0)
	private BookTaskInfz bookTaskInfz;

	/**
	 * 全量更新
	 */
	public void execute() {
		log.info("开始执行[书籍全量更新]定时任务");
		bookTaskInfz.execute();
		log.info("结束执行[书籍全量更新]定时任务");
	}

	/**
	 * 书籍更新
	 * @param date
	 */
	public void bookUpdate(String date) {
		log.info("开始执行[书籍更新]定时任务");
		bookTaskInfz.execute(BookTaskType.BOOK_UPDATE,date);
		log.info("开始执行[书籍更新]定时任务");
	}

	/**
	 * 书籍下架
	 * @param date
	 */
	public void executeUnshelfbook(String date) {
		log.info("开始执行[书籍下架]定时任务");
		bookTaskInfz.execute(BookTaskType.UNSHELF_BOOK,date);
		log.info("结束执行[书籍下架]定时任务");
	}


	// @Scheduled(fixedDelay = 60000 * 5)
	public void executeGroundbook() {
		log.info("开始执行[书籍上架]定时任务");
		bookTaskInfz.execute("groundbook",null);
		log.info("结束执行[书籍上架]定时任务");
	}


	public void executeHotspotBook() {
		log.info("开始执行[热门书籍信息更新]定时任务");
		bookTaskInfz.execute("hotspotbook",null);
		log.info("结束执行[热门书籍信息更新]定时任务");
	}


	public void executeReloadChoiceBookCount() {
		log.info("开始执行[清理精选书籍数量缓存]定时任务");
		bookTaskInfz.execute("choicebookcount",null);
		log.info("结束执行[清理精选书籍数量缓存]定时任务");
	}


}
