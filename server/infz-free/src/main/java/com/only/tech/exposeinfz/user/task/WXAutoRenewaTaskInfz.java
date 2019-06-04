package com.only.tech.exposeinfz.user.task;

import com.only.tech.exposeinfz.ExecuteService;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/18
 */
public interface WXAutoRenewaTaskInfz extends ExecuteService {
    void autoDeduction(String date);
}
