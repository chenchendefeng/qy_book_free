package com.only.tech.task.manager;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.user.task.UserAliveTaskInfz;

import lombok.extern.slf4j.Slf4j;

/**
 *用户留存统计
 */
@Slf4j
@Service
public class UserAliveTaskManager {

    @Reference(async = true)
    private UserAliveTaskInfz userAliveTaskInfz;


    public void executeUserAliveAnalysis(String param)
    {
        log.info("begin execute executeUserAliveAnalysis");
        userAliveTaskInfz.executeUserAliveAnalysis(param);
        log.info("end execute executeUserAliveAnalysis");
    }
}