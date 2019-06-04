package com.only.tech.task.manager;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.user.task.RegistAnalysisTaskInfz;

import lombok.extern.slf4j.Slf4j;

/**
 *用户首充
 */
@Slf4j
@Service
public class RegistAnalysisTaskManager {

    @Reference(async = true)
    private RegistAnalysisTaskInfz registAnalysisTaskInfz;


    public void executeRegistAnalysis(String countDate)
    {
        log.info("begin execute executeRegistAnalysis");
        registAnalysisTaskInfz.executeRegistAnalysis(countDate);
        log.info("end execute executeRegistAnalysis");
    }
}