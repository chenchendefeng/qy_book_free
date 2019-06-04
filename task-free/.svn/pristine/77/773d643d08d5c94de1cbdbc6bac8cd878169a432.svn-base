package com.only.tech.task.manager;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.payment.task.OrderCountTaskInfz;

import lombok.extern.slf4j.Slf4j;

/**
 *支付宝支付定时任务
 */
@Slf4j
@Service
public class OrderCountTaskManager {

    @Reference(async = true)
    private OrderCountTaskInfz orderCountTaskInfz;


    public void executeOrderCount(String payDate)
    {
        log.info("begin execute executeOrderCount");
        orderCountTaskInfz.executeOrderCount(payDate);;
        log.info("end execute executeOrderCount");
    }
}