package com.only.tech.task.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.user.api.UserStatisticsInfz;
import com.only.tech.exposeinfz.user.task.CustomerStatisticsTaskInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2018/12/22
 */
@Slf4j
@Service
public class CustomerActiveStatisticsTaskManage {

    @Reference
    private CustomerStatisticsTaskInfz customerStatisticsTaskInfz;

    /**
     * 用户活跃统计
     */
    public void execute(String dateTime) {

        log.info("开始执行[用户活跃统计]定时任务");
        customerStatisticsTaskInfz.execute(dateTime);
        log.info("结束执行[用户活跃统计]定时任务");
    }
}
