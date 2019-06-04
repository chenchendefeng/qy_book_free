package com.only.tech.user.service.biz;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.dto.user.CustomerAccountDto;
import com.only.tech.dto.user.UpdateCustomerInfoDto;
import com.only.tech.entity.user.Customer;
import com.only.tech.user.mapper.CustomerMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类: 用户
 * @author shutong
 * @since 2019/04/30
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 根据openid查询用户信息
     */
    @Override
    public Customer selectByBindOpenid(String bindOpenid) {
        return this.customerMapper.selectByBindOpenid(bindOpenid);
    }

    /**
     * 判断设备好是否被封
     * @param imei
     * @return
     */
    @Override
    public boolean checkForzenByImei(String imei) {
        QueryWrapper<Customer> wrapper = new QueryWrapper<Customer>();
        wrapper.eq("imei",imei);
        wrapper.eq("userStatus","frozenByImei");
        List<Customer> userList=super.list(wrapper);
        if(userList!=null && userList.size()>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 根据手机号码查询用户信息
     * @param bindPhone
     * @return
     */
    @Override
    public Customer selectByBindPhone(String bindPhone) {
        return this.customerMapper.selectByBindPhone(bindPhone);
    }

    /**
     * 查询是否有相同imei的游客
     * @param imei
     * @return
     */
    @Override
    public Customer queryVisitorByImei(String imei) {
        return this.customerMapper.queryVisitorByImei(imei);
    }

    @Override
    public Customer getByCuId(Long cuId) {
        QueryWrapper<Customer> qw = new QueryWrapper<Customer>();
        qw.eq("cuId",cuId);
        return this.getOne(qw);
    }

    @Override
    public Customer getByInvitationCode(String invitationCode) {
        QueryWrapper<Customer> qw = new QueryWrapper<Customer>();
        qw.eq("invitationCode",invitationCode);
        return this.getOne(qw);
    }

    @Override
    public boolean updateByCuId(Customer customer) {
        Wrapper uw = new UpdateWrapper<>().eq("cuId",customer.getCuId());
        return this.update(customer,uw);
    }

    /**
     * 分页查询用户
     * @param userType (register | visitor | vip )
     * @param unionMsg
     * @return
     */
    @Override
    public List<Customer> listByCondition(String userType, String unionMsg) {

        QueryWrapper<Customer> wrapper = new QueryWrapper<Customer>();

        //会员类型
        if(StringUtils.isNotBlank(userType)){
            if("vip".equals(userType)){ //VIP
                wrapper.eq("vipFlag",userType);
                wrapper.eq("userType","register");
            }else if("register".equals(userType)){ //注册用户（register）
                wrapper.eq("userType","register");
            }else if("visitor".equals(userType)){
                wrapper.eq("userType","visitor");
            }
        }

        //复合属性
        if(StringUtils.isNotBlank(unionMsg)){
            wrapper.apply("( cuId = '"+unionMsg+"' or bindPhone = '"+unionMsg+"' or invitationCode = '"+unionMsg+"' )");
        }

        return super.list(wrapper);
    }

    /**
     * 获取用户账户信息
     * @param cuId
     * @return
     */
    @Override
    public CustomerAccountDto getCustomerAccountInfo(Long cuId) {
        return this.customerMapper.getCustomerAccountInfo(cuId);
    }

    @Override
    public Boolean isBindWX(Long cuId) {
        Customer customer = getByCuId(cuId);
        if(customer == null){
            return false;
        }
        String bindOpenid = customer.getBindOpenid();

        return StringUtils.isNotBlank(bindOpenid);
    }

    /**
     * 根据用户ID(uid)修改用户状态
     * @param uid
     * @param customerStatus
     */
    @Override
    public void updateCustomerStatusByID(Long uid, String customerStatus) {
        this.customerMapper.updateCustomerStatusByID(uid,customerStatus);
    }


    /**
     * 根据机器编码(imei)修改用户状态
     * @param imei
     * @param customerStatus
     */
    @Override
    public void updateCustomerStatusByImei(String imei, String customerStatus) {
        this.customerMapper.updateCustomerStatusByImei(imei,customerStatus);
    }

    @Override
    public List<Customer> queryByImei(String imei) {
        return this.customerMapper.queryByImei(imei);
    }

    /**
     * 注销用户（删除qq号、微信号、手机号）
     * @param cuId
     */
    @Override
    public void drawdownCustomer(Long cuId) {
        this.customerMapper.drawdownCustomer(cuId);
    }

    @Override
    public void updateBindPhone(Long cuId, String bindPhone) {
      this.customerMapper.updateBindPhone(cuId,bindPhone);
    }


    /**
     * 修改用户呢称、性别、头像
     * @param customer
     */
    @Override
    public Customer update(UpdateCustomerInfoDto customer) {

        //修改
        this.customerMapper.update(customer);

        //返回customer
        return this.getByCuId(customer.getCuId());

    }

}
