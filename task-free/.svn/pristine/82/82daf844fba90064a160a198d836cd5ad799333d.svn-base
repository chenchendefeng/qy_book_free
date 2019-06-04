package com.only.tech.task.manager;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.payment.task.OrderAnalysisTaskInfz;

import lombok.extern.slf4j.Slf4j;

/**
 *支付宝支付定时任务
 */
@Slf4j
@Service
public class OrderAnalysisTaskManager {

    @Reference(async = true)
    private OrderAnalysisTaskInfz orderAnalysisTaskInfz;


    public void executeOrderAnalysis(String payDate)
    {
        log.info("begin execute executeOrderAnalysis");
        orderAnalysisTaskInfz.executeOrderAnalysis(payDate);;
        log.info("end execute executeOrderAnalysis");
    }
}