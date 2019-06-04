package com.only.tech.activity.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.tech.activity.service.biz.WelfareService;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.entity.activity.Welfare;
import com.only.tech.exposeinfz.activity.api.WelfareInfz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/13
 */
@Component
@Service(interfaceClass = WelfareInfz.class)
public class WelfareInfzImpl implements WelfareInfz {

    @Autowired
    private WelfareService welfareService;

    @Override
    public PageData<Welfare> pageData(String type, Integer status, String rewardType, PageReq pageReq) {
        return welfareService.pageData(type,status,rewardType,pageReq);
    }

    @Override
    public Welfare getById(Integer id) {
        return welfareService.getById(id);
    }

    @Override
    public ResultDto insert(Welfare welfare) {
        String welfareType = welfare.getWelfareType();
        QueryWrapper qw = new QueryWrapper();
        qw.eq("welfareType",welfareType);

        Welfare one = welfareService.getOne(qw);
        if (one != null){
            return ResultDto.errorResult("福利类型【"+welfareType+"】已经存在");
        }
        boolean insert = welfareService.insert(welfare);
        return insert? ResultDto.succesResult(): ResultDto.errorResult();
    }

    @Override
    public ResultDto update(Welfare welfare) {
        String welfareType = welfare.getWelfareType();
        QueryWrapper qw = new QueryWrapper();
        qw.eq("welfareType",welfareType);

        Welfare welfareDB = welfareService.getOne(qw);

        if (welfareDB != null){
            Integer id = welfareDB.getId();
            if (!id.equals(welfare.getId())) {
                return ResultDto.errorResult("福利类型【"+welfareType+"】已经存在");
            }
        }

        boolean update = welfareService.update(welfare);
        return update ? ResultDto.succesResult("修改成功"):ResultDto.errorResult("修改失败");
    }

    @Override
    public boolean updateStatus(Integer id, Integer status) {
        return welfareService.updateStatus(id,status);
    }

    @Override
    public boolean remove(Integer id) {
        return welfareService.removeById(id);
    }
}
