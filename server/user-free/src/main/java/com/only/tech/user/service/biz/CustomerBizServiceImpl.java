package com.only.tech.user.service.biz;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.CustomerBiz;
import com.only.tech.user.mapper.CustomerBizMapper;
import com.only.tech.user.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 服务实现类: 用户业务信息
 * @author shutong
 * @since 2019/05/15
 */
@Service
public class CustomerBizServiceImpl extends ServiceImpl<CustomerBizMapper, CustomerBiz> implements CustomerBizService {

    /**
     * 查询用户业务信息
     * @return
     */
    @Override
    public CustomerBiz getByCuId(Long cuId) {
       QueryWrapper<CustomerBiz>  wrapper=new QueryWrapper<CustomerBiz>();
       wrapper.eq("cuId",cuId);
       return super.getOne(wrapper);
    }

    /**
     * 初始化用户业务信息
     * @param cuId
     */
    @Override
    public void initCustomerBiz(Long cuId) {
        CustomerBiz customerBiz=new CustomerBiz();
        customerBiz.setCuId(cuId);
        customerBiz.setFreeAdvTime(null);
        this.save(customerBiz);
    }

    /**
     * 修改看视频免广告时间
     * @param cuId
     * @param timeMinute 时间（分钟）
     */
    @Override
    public void updateFreeAdbTime(Long cuId, Integer timeMinute) {
        CustomerBiz customerBiz=this.getByCuId(cuId);
        if(customerBiz==null){
           return;
        }

        Calendar now=Calendar.getInstance();
        now.add(Calendar.MINUTE,timeMinute);
        customerBiz.setFreeAdvTime(now.getTime());
        this.saveOrUpdate(customerBiz);
    }


}
