package com.only.tech.exposeinfz.user.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.user.AccountFlowRecord;
import com.only.tech.entity.user.Customer;

/**
 * infz: 账户流水信息
 * @author shutong
 * @since 2019/05/08
 */
public interface AccountFlowRecordInfz {

    /**
     * 添加or修改
     * @param flowRecord
     */
    void saveOrUpdate(AccountFlowRecord flowRecord);

    /**
     * 分页查询账户流水（金豆or现金）
     * @param pageReq
     * @param cuId
     * @param currentType
     * @return
     */
    PageData<AccountFlowRecord> pageListByCondition(PageReq pageReq, Long cuId, String currentType);
}
