package com.only.tech.task.manager;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.user.task.UserSourceTaskInfz;

import lombok.extern.slf4j.Slf4j;

/**
 *用户来源统计
 */
@Slf4j
@Service
public class UserSourceTaskManager {

    @Reference(async = true)
    private UserSourceTaskInfz userSourceTaskInfz;


    public void executeUserSource(String param)
    {
        log.info("begin execute executeUserSource");
        userSourceTaskInfz.executeUserSource(param);
        log.info("end execute executeUserSource");
    }
}