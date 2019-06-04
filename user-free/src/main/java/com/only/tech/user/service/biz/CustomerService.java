package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.dto.user.CustomerAccountDto;
import com.only.tech.dto.user.UpdateCustomerInfoDto;
import com.only.tech.entity.user.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 服务类: 用户
 * @author shutong
 * @since 2019/04/30
 */
public interface CustomerService extends IService<Customer> {

    /**
     * 根据openid查询用户
     * @param openid
     * @return
     */
    Customer selectByBindOpenid(String openid);

    /**
     * 判断设备好是否被封
     * @param imei
     * @return
     */
    boolean checkForzenByImei(String imei);

    /**
     * 根据手机号码查询用户信息
     * @param phone
     * @return
     */
    Customer selectByBindPhone(String phone);

    /**
     * 查询是否有相同imei的游客
     * @param imei
     * @return
     */
    Customer queryVisitorByImei(String imei);

    /**
     * 根据cuId查询
     * @param cuId
     * @return
     */
    Customer getByCuId(Long cuId);

    Customer getByInvitationCode(String invitationCode);

    boolean updateByCuId(Customer customer);

    /**
     * 分页查询用户
     * @param userType
     * @param unionMsg
     * @return
     */
    List<Customer> listByCondition(String userType, String unionMsg);

    /**
     * 获取用户账户信息
     * @param cuId
     * @return
     */
    CustomerAccountDto getCustomerAccountInfo(Long cuId);

    Boolean isBindWX(Long cuId);


    /**
     * 根据用户ID(uid)修改用户状态
     * @param uid
     * @param customerStatus
     */
    void updateCustomerStatusByID(Long uid, String customerStatus);

    /**
     * 根据机器编码(imei)修改用户状态
     * @param imei
     * @param customerStatus
     */
    void updateCustomerStatusByImei(String imei, String customerStatus);

    /**
     * 根据机器编码查询用户
     * @param imei
     * @return
     */
    List<Customer> queryByImei(String imei);

    /**
     * 注销用户（删除qq号、微信号、手机号）
     * @param cuId
     */
    void drawdownCustomer(Long cuId);

    void updateBindPhone(Long cuId, String bindPhone);

    /**
     * 修改用户呢称、性别、头像
     * @param customer
     */
    Customer update(UpdateCustomerInfoDto customer);
}
