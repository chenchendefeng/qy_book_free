package com.only.tech.task.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.book.NewBookUpdateTaskInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2018/11/28
 */
@Slf4j
@Service
public class NewBookUpdateTaskManager {


    @Reference
    private NewBookUpdateTaskInfz newBookUpdateTaskInfz;

    /**
     * 更新新书
     */
    public void updateNewBook() {
        log.info("开始执行[--更新新书--]定时任务");

        try {
            newBookUpdateTaskInfz.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("结束执行[--更新新书--]定时任务");

    }
}
