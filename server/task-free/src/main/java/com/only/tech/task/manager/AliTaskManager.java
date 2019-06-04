package com.only.tech.task.manager;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.payment.task.AliPayTaskInfz;

import lombok.extern.slf4j.Slf4j;

/**
 *支付宝支付定时任务
 */
@Slf4j
@Service
public class AliTaskManager {

    @Reference(async = true)
    private AliPayTaskInfz aliPayTaskInfz;


    public void executeCheckMonthBill(String param) {
        log.info("begin execute ali executeCheckMonthBill");
        aliPayTaskInfz.executeCheckMonthBill(param);
        log.info("end execute ali executeCheckMonthBill");
    }
    
    public void executeCheckDayBill(String param)
    {
        log.info("begin execute ali executeCheckDayBill");
        aliPayTaskInfz.executeCheckDayBill(param);
        log.info("end execute ali executeCheckDayBill");
    }
}