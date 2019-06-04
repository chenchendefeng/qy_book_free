package com.only.tech.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.dto.user.CustomerAccountDto;
import com.only.tech.dto.user.UpdateCustomerInfoDto;
import com.only.tech.entity.user.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper: 用户
 * @author shutong
 * @since 2019/04/30
 */
@Repository
public interface CustomerMapper extends BaseMapper<Customer> {

    /**
     * 根据openid查询用户信息
     * @param bindOpenid
     * @return
     */
    Customer selectByBindOpenid(@Param("bindOpenid")String bindOpenid);

    /**
     * 根据手机号码查询用户信息
     * @param bindPhone
     * @return
     */
    Customer selectByBindPhone(@Param("bindPhone")String bindPhone);

    /**
     * 根据imei查询游客
     * @param imei
     * @return
     */
    Customer queryVisitorByImei(@Param("imei")String imei);

    /**
     * 获取用户账户信息
     * @param cuId
     * @return
     */
    CustomerAccountDto getCustomerAccountInfo(@Param("cuId")Long cuId);

    /**
     * 根据用户ID(uid)修改用户状态
     * @param uid
     * @param customerStatus
     */
    void updateCustomerStatusByID(@Param(value = "uid")Long uid, @Param(value = "customerStatus")String customerStatus);

    /**
     * 根据机器编码(imei)修改用户状态
     * @param imei
     * @param customerStatus
     */
    void updateCustomerStatusByImei(@Param(value = "imei")String imei, @Param(value = "customerStatus")String customerStatus);

    /**
     * 根据机器编码查询用户
     * @param imei
     * @return
     */
    List<Customer> queryByImei(@Param(value = "imei")String imei);


    /**
     * 注销用户（删除qq号、微信号、手机号）
     * @param cuId
     */
    void drawdownCustomer(@Param(value = "cuId")Long cuId);

    void updateBindPhone(@Param(value = "cuId")Long cuId, @Param(value = "bindPhone")String bindPhone);

    /**
     * 修改用户呢称、性别、头像
     * @param customer
     */
    void update(UpdateCustomerInfoDto customer);
}
