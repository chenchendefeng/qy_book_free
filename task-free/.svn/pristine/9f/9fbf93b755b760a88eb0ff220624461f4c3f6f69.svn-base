package com.only.tech.task.manager;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.payment.task.WxPayTaskInfz;

import lombok.extern.slf4j.Slf4j;

/**
 *微信支付定时任务
 */
@Slf4j
@Service
public class WxPayTaskManager {

    @Reference
    private WxPayTaskInfz wxPayTaskInfz;


    public void execute() {
        log.info("begin execute weixin pay query order result");
        wxPayTaskInfz.execute();
        log.info("end execute weixin pay query order result");
    }
    
    public void executeCheckBill(String param)
    {
        log.info("begin execute weixin pay check bill");
        wxPayTaskInfz.executeCheckBill(param);
        log.info("end execute weixin pay check bill");
    }
}