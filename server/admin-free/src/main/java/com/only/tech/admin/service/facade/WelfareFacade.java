package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.entity.activity.Welfare;
import com.only.tech.exposeinfz.activity.api.WelfareInfz;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/13
 */
@Service
public class WelfareFacade {

    @Reference
    private WelfareInfz welfareInfz;

    public PageData<Welfare> pageData(String type, Integer status, String rewardType, PageReq pageReq) {
        return welfareInfz.pageData(type,status,rewardType,pageReq);
    }

    public Welfare getById(Integer id) {
        return welfareInfz.getById(id);
    }

    public ResultDto insert(Welfare welfare) {
        return welfareInfz.insert(welfare);
    }

    public ResultDto update(Welfare welfare) {
        return welfareInfz.update(welfare);
    }

    public boolean updateStatus(Integer id, Integer status) {
        return welfareInfz.updateStatus(id,status);
    }

    public boolean remove(Integer id) {
        return welfareInfz.remove(id);
    }
}
