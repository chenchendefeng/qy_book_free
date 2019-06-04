package com.only.tech.task.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.payment.api.OrderAddVipTimeInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/1
 */
@Slf4j
@Service
public class OrderAddVipTimeTaskManager {

    @Reference
    private OrderAddVipTimeInfz orderAddVipTimeInfz;


    public void executeAddVipTime() {
        orderAddVipTimeInfz.orderAddVipTime();
    }
}
