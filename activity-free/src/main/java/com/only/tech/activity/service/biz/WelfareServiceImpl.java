package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.activity.mapper.WelfareMapper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.activity.Welfare;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 福利配置 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-10
 */
@Service
public class WelfareServiceImpl extends ServiceImpl<WelfareMapper, Welfare> implements WelfareService {

    @Override
    public List<Welfare> getByType(String type, Integer showTime) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("type",type);
        qw.eq("status",1);
        if (showTime != null){
            qw.ge("showTime",showTime);
        }

        qw.orderByAsc("sort");

        return this.list(qw);
    }

    @Override
    public PageData<Welfare> pageData(String type, Integer status, String rewardType, PageReq pageReq) {
        QueryWrapper qw = new QueryWrapper();
        if (StringUtils.isNotBlank(type)){
            qw.eq("type",type);
        }
        if (status != null){
            qw.eq("status",status);
        }
        if (StringUtils.isNotBlank(rewardType)){
            qw.eq("rewardType",rewardType);
        }
        Page page = PageHelper.startPage(pageReq.getPageNo(),pageReq.getPageSize());
        this.list(qw);

        return new PageData<>(page);
    }

    @Override
    public boolean insert(Welfare welfare) {
        if (welfare == null){
            return false;
        }
        Date now = new Date();
        welfare.setCreateTime(now);
        welfare.setUpdateTime(now);
        return this.save(welfare);
    }

    @Override
    public boolean update(Welfare welfare) {
        if (welfare == null){
            return false;
        }
        Welfare welfareDb = this.getById(welfare.getId());
        if (welfareDb == null){
            return false;
        }

        BeanUtils.copyProperties(welfare,welfareDb);
        welfareDb.setUpdateTime(new Date());

        return this.updateById(welfareDb);
    }

    @Override
    public boolean updateStatus(Integer id, Integer status) {
        Welfare welfare = getById(id);
        if (welfare == null) {
            return false;
        }
        welfare.setStatus(status);
        return this.updateById(welfare);
    }
}
