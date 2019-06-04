package com.only.tech.task.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.book.BookLoadToEsTaskInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2018/11/17
 */
@Slf4j
@Service
public class BookToEsTaskManager {

    @Reference(retries = 0)
    private BookLoadToEsTaskInfz bookLoadToEsTaskInfz;

    /**
     * 全量加载数据到es
     */
    public void loadBookToEs(){
        log.info("开始执行[全量加载数据到es]定时任务");
        try {
            bookLoadToEsTaskInfz.execute();
        } catch (Exception e) {
            log.error("全量加载数据到es 错误：",e);
        }
    }

    /**
     * 清除ES所有书籍
     */
    public void deleteAll() {
        log.info("清除ES所有书籍");
        try {
            bookLoadToEsTaskInfz.deleteAll();
        } catch (Exception e) {
            log.error("清除ES 所有书籍 错误：",e);
        }
    }
}
