package com.only.tech.exposeinfz.user.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.user.CustomerAccountDto;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.PersonalCenter;

import java.util.List;

/**
 * infz: 用户
 * @author shutong
 * @since 2019/05/08
 */
public interface CustomerInfz {

    /**
     * 查询用户
     * @param cuId
     * @return
     */
    Customer getOneByCuid(Long cuId);

    /**
     * 看视频免广告20分钟
     * @param cuId
     * @param timeMinute
     */
    void watchForFreeAdv(Long cuId, int timeMinute);

    /**
     * 分页查询用户
     * @param pageReq
     * @param userType
     * @param unionMsg
     * @return
     */
    PageData<CustomerAccountDto> pageListByCondition(PageReq pageReq, String userType, String unionMsg);

    /**
     * 获取用户账户信息
     * @param cuId
     * @return
     */
    CustomerAccountDto getCustomerAccountInfo(Long cuId);

    /**
     * 管理员充值（ 金豆 or 现金 ）
     * @param cuId
     * @param num
     * @param remark
     * @param rechargeType
     */
    void recharge(Long cuId, Long num, String remark, String rechargeType);


    /**
     * 修改用户状态
     * @param uid
     * @param customerStatus ("用户状态：  frozen:封号 | frozenByImei:封设备  | drawdown:账户注销  | normal:正常")
     */
    void updateCustomerStatus(Long uid, String customerStatus);


    /**
     * 修改用户信息
     * @param customer
     */
    void updateCustomerInfo(Customer customer);

    void updateBindPhone(Long cuId, String bindPhone);

    /**
     * 邀请好友ID信息
     * @param cuId
     * @return
     */
    List<Long> listInvitedCuid(Long cuId);
}
