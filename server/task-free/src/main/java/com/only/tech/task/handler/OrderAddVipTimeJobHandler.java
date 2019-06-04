package com.only.tech.task.handler;

import com.only.tech.task.manager.OrderAddVipTimeTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/1
 */
@Component
@JobHandler(value = "orderAddVipTimeJobHandler")
public class OrderAddVipTimeJobHandler extends IJobHandler {

    @Autowired
    private OrderAddVipTimeTaskManager manager;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello OrderAddVipTimeJobHandler.");
        manager.executeAddVipTime();
        return SUCCESS;
    }
}
