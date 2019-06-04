package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.CustomerBiz;

/**
 * 服务类: 用户业务信息
 * @author shutong
 * @since 2019/05/15
 */
public interface CustomerBizService extends IService<CustomerBiz> {

    /**
     * 查询用户业务信息
     * @return
     */
    CustomerBiz getByCuId(Long cuId);

    /**
     * 初始化用户业务信息
     * @param cuId
     */
    void initCustomerBiz(Long cuId);

    /**
     * 修改看视频免广告时间
     * @param cuId
     * @param timeMinute 时间（分钟）
     */
    void updateFreeAdbTime(Long cuId,Integer timeMinute);
}
