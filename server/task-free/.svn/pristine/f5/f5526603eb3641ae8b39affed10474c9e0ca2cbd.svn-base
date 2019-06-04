package com.only.tech.task.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.book.CategoryTaskInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
/**
 *一分类信息拉取
 */
public class CategoryTaskManager {

    @Reference
    private CategoryTaskInfz categoryTaskInfz;


    //@Scheduled(cron = "0 0 0 * * ?")
    public void execute() {
        log.info("开始执行[分类信息拉取]定时任务");
        categoryTaskInfz.execute();
        log.info("结束执行[分类信息拉取]定时任务");
    }
}