package com.only.tech.task.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.user.api.VisitorStatisticsInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/2/26
 */
@Slf4j
@Service
public class VisitorStatisticsTaskManager {

    @Reference
    private VisitorStatisticsInfz visitorStatisticsInfz;

    public void visitorStatistics(String param) {
        visitorStatisticsInfz.visitorStatistics(param);
    }
}
