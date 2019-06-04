package com.only.tech.task.manager;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.user.task.FirstPayTaskInfz;

import lombok.extern.slf4j.Slf4j;

/**
 *用户首充
 */
@Slf4j
@Service
public class UserFirstPayTaskManager {

    @Reference(async = true)
    private FirstPayTaskInfz firstPayTaskInfz;


    public void executeOrderAnalysis(String payDate)
    {
        log.info("begin execute executeFirstPay");
        firstPayTaskInfz.executeFirstPay(payDate);
        log.info("end execute executeFirstPay");
    }
}