package com.only.tech.exposeinfz.activity.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.entity.activity.Welfare;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/13
 */
public interface WelfareInfz {
    PageData<Welfare> pageData(String type, Integer status, String rewardType, PageReq pageReq);

    Welfare getById(Integer id);

    ResultDto insert(Welfare welfare);

    ResultDto update(Welfare welfare);

    boolean updateStatus(Integer id, Integer status);

    boolean remove(Integer id);
}
