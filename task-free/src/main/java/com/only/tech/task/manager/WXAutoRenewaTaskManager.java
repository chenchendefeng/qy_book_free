package com.only.tech.task.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.user.task.WXAutoRenewaTaskInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/18
 */
@Slf4j
@Service
public class WXAutoRenewaTaskManager {

    @Reference
    private WXAutoRenewaTaskInfz wxAutoRenewaTaskInfz;

    /**
     * 自动扣费
     */
    public void autoDeduction(String date){
        log.info("微信自动扣费任务  开始");
        wxAutoRenewaTaskInfz.autoDeduction(date);

        log.info("微信自动扣费任务  开始");
    }
}
