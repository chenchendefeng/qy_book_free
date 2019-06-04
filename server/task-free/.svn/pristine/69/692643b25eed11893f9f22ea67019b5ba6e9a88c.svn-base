package com.only.tech.task.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.payment.api.DedutionInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/21
 */
@Slf4j
@Service
public class WXAutoDedutionOrderTaskManager {

    @Reference
    private DedutionInfz dedutionInfz;

    public void checkOrder() {
        dedutionInfz.checkOrder();
    }
}
