package com.only.tech.exposeinfz.user.api;

import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.ReadTimePerday;

/**
 * infz: 用户每日阅读时长
 * @author shutong
 * @since 2019/05/08
 */
public interface ReadTimePerdayInfz {


    /**
     * 查询用户每日阅读时长
     * @param cuId
     * @param ymd
     * @return
     */
    ReadTimePerday getOneByCondition(Long cuId, String ymd);

    /**
     * 修改or添加
     * @param readTimePerday
     */
    void saveOrUpdate(ReadTimePerday readTimePerday);
}
