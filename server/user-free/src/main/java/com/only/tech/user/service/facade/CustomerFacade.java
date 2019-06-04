package com.only.tech.user.service.facade;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.tech.dto.user.CustomerBizInfoDto;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.CustomerBiz;
import com.only.tech.user.service.biz.CustomerBizService;
import com.only.tech.user.service.biz.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * facade: 用户
 * @author shutong
 * @since 2019/04/30
 */
@Slf4j
@Service
public class CustomerFacade {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerBizService customerBizService;

    public String getUserType(Long cuId) {
        Customer customer = customerService.getByCuId(cuId);
        if (customer == null){
            return null;
        }
        return customer.getUserType();
    }

    /**
     * 获取用户业务信息
     * @param cuId
     * @return
     */
    public CustomerBizInfoDto getCustomerBizInfo(Long cuId) {

        CustomerBizInfoDto bizInfoDto=new CustomerBizInfoDto();

        //用户基本信息
        Customer customer=this.customerService.getByCuId(cuId);
        BeanUtils.copyProperties(customer,bizInfoDto);

        //用户业务信息（包含：看视频免广告截止时间....）
        CustomerBiz customerBiz=this.customerBizService.getByCuId(cuId);
        BeanUtils.copyProperties(customerBiz,bizInfoDto);

        return bizInfoDto;
    }

    public Customer getByCuid(Long cuId) {
        return customerService.getByCuId(cuId);
    }

    public String getUserAvatar(Long cuId) {
        Customer customer = getByCuid(cuId);
        if (customer == null){
            return null;
        }
        return customer.getAvatar();
    }

    public boolean isVIP(Long cuId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("cuId",cuId);
        Date date = new Date();
        qw.le("vipStartDate",date);
        qw.ge("vipEndDate",date);
        Customer customer = customerService.getOne(qw);
        return customer != null;
    }
}
