package com.only.tech.exposeinfz.user.api;

import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.CustomerAccount;
import com.only.tech.enums.AccountChangeSpecificTypeEnum;
import com.only.tech.enums.AccountChangeTypeEnum;
import com.only.tech.enums.CurrencyTypeEnum;

/**
 * infz: 用户账户
 * @author shutong
 * @since 2019/05/08
 */
public interface CustomerAccountInfz {

    /**
     * 查询账户
     * @param cuId
     * @return
     */
    CustomerAccount getOneByCuid(Long cuId);

    /**
     * 修改账户信息
     * @param account
     */
    void saveOrUpdate(CustomerAccount account);

    boolean attendanceChange(Long cuId, CurrencyTypeEnum gold, Long amount, AccountChangeTypeEnum reward, AccountChangeSpecificTypeEnum specificTypeEnum);
}
