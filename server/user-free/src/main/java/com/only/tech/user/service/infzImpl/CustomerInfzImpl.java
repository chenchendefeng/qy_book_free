package com.only.tech.user.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.constant.Constants;
import com.only.tech.constant.UserRedisKeyConstants;
import com.only.tech.dto.user.CustomerAccountDto;
import com.only.tech.entity.payment.GoodsOrder;
import com.only.tech.entity.user.AccountFlowRecord;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.CustomerAccount;
import com.only.tech.entity.user.PersonalCenter;
import com.only.tech.exposeinfz.user.api.CustomerInfz;
import com.only.tech.exposeinfz.user.api.PersonalCenterInfz;
import com.only.tech.user.service.biz.*;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.service.OSSPicService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * infz实现类： 用户
 * @author shutong
 * @since 2019/05/08
 */
@Slf4j
@Component
@Service(interfaceClass = CustomerInfz.class)
public class CustomerInfzImpl implements CustomerInfz {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerBizService bizService;

    @Autowired
    private CustomerAccountService accountService;

    @Autowired
    private AccountFlowRecordService accountFlowRecordService;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private InvitationRecordService invitationRecordService;

    /**
     * 查询用户
     * @param cuId
     * @return
     */
    @Override
    public Customer getOneByCuid(Long cuId) {
       return  this.customerService.getByCuId(cuId);
    }

    /**
     * 看视频免广告20分钟
     * @param cuId
     * @param timeMinute
     */
    @Override
    public void watchForFreeAdv(Long cuId, int timeMinute) {
        this.bizService.updateFreeAdbTime(cuId,timeMinute);
    }

    /**
     * 分页查询用户
     * @param pageReq
     * @param userType
     * @param unionMsg
     * @return
     */
    @Override
    public PageData<CustomerAccountDto> pageListByCondition(PageReq pageReq, String userType, String unionMsg) {

        Page page = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());
        List<CustomerAccountDto> dtoList=new ArrayList<CustomerAccountDto>();
        List<Customer> customerList = this.customerService.listByCondition(userType,unionMsg);
        for (Customer customer: customerList){
            CustomerAccountDto dto=this.customerService.getCustomerAccountInfo(customer.getCuId());
            dtoList.add(dto);
        }
        PageData pageData = new PageData(page);
        pageData.setData(dtoList);
        return pageData;
    }

    /**
     * 获取用户账户信息
     * @param cuId
     * @return
     */
    @Override
    public CustomerAccountDto getCustomerAccountInfo(Long cuId) {
        return this.customerService.getCustomerAccountInfo(cuId);
    }


    /**
     * 管理员充值（ 金豆 or 现金 ）
     * @param cuId
     * @param num
     * @param remark
     * @param rechargeType
     */
    @Transactional
    @Override
    public void recharge(Long cuId, Long num, String remark, String rechargeType) {

        CustomerAccount account=this.accountService.getCuId(cuId);

        //修改账户信息
        if(account==null){
            account = new CustomerAccount();
            account.setCuId(cuId);
            account.setRmb(0L);
            if("gold".equals(rechargeType)){
                account.setGold(num);
            }else if("rmb".equals(rechargeType)){
                account.setRmbTotal(num);
                account.setRmb(num);
            }


        }else{
            if("golb".equals(rechargeType)){
                account.setGold(num);
            }else if("rmb".equals(rechargeType)){
                account.setRmbTotal(account.getRmbTotal()==null?0:account.getRmbTotal()+num);
                account.setRmb(account.getRmb()==null?0:account.getRmb()+num);
            }
        }
        this.accountService.saveOrUpdate(account);

        //添加账户流水
        AccountFlowRecord accountFlow=new AccountFlowRecord();
        accountFlow.setCuId(cuId);
        accountFlow.setTitle("管理员充值");
        accountFlow.setChangeType("recharge");
        accountFlow.setSpecificType("recharege_admin");
        accountFlow.setCurrencyType(rechargeType);
        accountFlow.setAmount(num);
        accountFlow.setCreateTime(new Date());
        accountFlow.setRemark(remark);
        this.accountFlowRecordService.save(accountFlow);
    }



    /**
     * 修改用户状态
     * @param uid
     * @param customerStatus ("用户状态：  frozen:封号 | frozenByImei:封设备  | drawdown:账户注销 ")
     */
    @Override
    public void updateCustomerStatus(Long uid, String customerStatus) {

        //封号
        /* 1. 修改用户状态为：frozen */
        /* 2. redis中，清空用户信息 */
        if("frozen".equals(customerStatus)){

            this.customerService.updateCustomerStatusByID(uid,"frozen");

            //redis中，清空用户信息
            String tokenKey = DigestUtils.md5Hex(Constants.TOKEN_KEY_PRE + uid);
            String redisKey = UserRedisKeyConstants.USER_TOKEN + tokenKey;
            redisTemplate.delete(redisKey); //删除token

        }

        //解封号
        /* 1.修改用户状态为：normal */
        else if("unFrozen".equals(customerStatus)){
            this.customerService.updateCustomerStatusByID(uid,"normal");
        }

        //封设备
        /* 1.修改该用户机器码关联的所有用户状态为：frozenByImei */
        /* 2.redis中，清空关联的所有用户信息 */
        else if("frozenByImei".equals(customerStatus)){

            Customer customer=this.customerService.getById(uid);
            if(customer==null) return;
            String imei=customer.getImei();
            this.customerService.updateCustomerStatusByImei(imei,"frozenByImei");

            //redis中，清空用户信息
            List<Customer> userList=this.customerService.queryByImei(imei);
            if(userList!=null && userList.size()>0){
                for(Customer customerImei:userList){
                    String tokenKey = DigestUtils.md5Hex(Constants.TOKEN_KEY_PRE + customerImei.getCuId());
                    String redisKey = UserRedisKeyConstants.USER_TOKEN + tokenKey;
                    redisTemplate.delete(redisKey);
                }
            }

        }

        //解封设备
        /* 1.修改该用户机器码关联的所有用户状态为：normal */
        else if("unFrozenByImei".equals(customerStatus)){

            Customer customer=this.customerService.getById(uid);
            if(customer==null) return;
            String imei=customer.getImei();
            this.customerService.updateCustomerStatusByImei(imei,"normal");

        }

        //注销
        /* 1.修改用户状态为：drawdown */
        /* 2.解绑用户注册信息：如qq号、微信号、手机号 */
        else if("drawdown".equals(customerStatus)){
            this.customerService.updateCustomerStatusByID(uid,"drawdown");

            //解绑用户注册信息：如qq号、微信号、手机号
            this.customerService.drawdownCustomer(uid);

            //redis中，清空用户信息
            String tokenKey = DigestUtils.md5Hex(Constants.TOKEN_KEY_PRE + uid);
            String redisKey = UserRedisKeyConstants.USER_TOKEN + tokenKey;
            redisTemplate.delete(redisKey); //删除token
        }

    }

    @Override
    public void updateCustomerInfo(Customer customer) {
        Long cuId = customer.getCuId();
        Customer user=this.customerService.getByCuId(cuId);
        BeanUtils.copyProperties(customer,user);
        this.customerService.saveOrUpdate(user);
    }

    @Override
    public void updateBindPhone(Long cuId, String bindPhone) {
        this.customerService.updateBindPhone(cuId,bindPhone);
    }

    /**
     * 邀请好友ID信息
     * @param cuId
     * @return
     */
    @Override
    public List<Long> listInvitedCuid(Long cuId) {
        return this.invitationRecordService.listInvitedCuid(cuId);
    }


}
