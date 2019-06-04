package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.ReadTimePerday;

/**
 * 服务类: 每日阅读时长
 * @author shutong
 * @since 2019/05/08
 */
public interface ReadTimePerdayService extends IService<ReadTimePerday> {

    /**
     * 查询用户每日阅读时长
     * @param cuId
     * @param ymd
     * @return
     */
    ReadTimePerday getOneByCondition(Long cuId, String ymd);

    Integer getReadTime(Long cuId, String date);
}
