package com.only.tech.task.handler;

import com.only.tech.task.manager.CustomerActiveStatisticsTaskManage;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZHI ZUN BAO
 * @since 2018/12/22
 */
@JobHandler(value = "customerActiveStatisticsHandler")
@Component
public class CustomerActiveStatisticsHandler extends IJobHandler {

    @Autowired
    private CustomerActiveStatisticsTaskManage customerActiveStatisticsTaskManage;


    @Override
    public ReturnT<String> execute(String dateTime) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello BookInitJobHandler.");

        customerActiveStatisticsTaskManage.execute(dateTime);
        return SUCCESS;
    }
}
