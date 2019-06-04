package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.user.CustomerAccountDto;
import com.only.tech.entity.payment.GoodsOrder;
import com.only.tech.entity.user.Customer;
import com.only.tech.exposeinfz.payment.api.GoodsOrderInfz;
import com.only.tech.exposeinfz.user.api.CustomerInfz;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * facade: App用户
 * @author shutong
 * @since 2019/05/20
 */
@Service
public class CustomerFacade {

	@Reference
	private CustomerInfz customerInfz;

	/**
	 * 分页查询
	 * @param pageReq
	 * @param userType ( visitor: 游客 | register:注册用户 | vip: 会员)
	 * @param unionMsg (cuId or telephone or redbagCode )
	 * @return
	 */
	public PageData<CustomerAccountDto> pageListByCondition(PageReq pageReq, String userType , String unionMsg ) {
		return this.customerInfz.pageListByCondition(pageReq,userType,unionMsg);
	}

	/**
	 * 获取用户账户信息
	 * @param cuId
	 * @return
	 */
    public CustomerAccountDto getCustomerAccountInfo(Long cuId) {
		CustomerAccountDto dto = this.customerInfz.getCustomerAccountInfo(cuId);

		if(dto==null){
			return dto;
		}

		//邀请好友ID信息
		List<Long> invitedCuidList=this.customerInfz.listInvitedCuid(cuId);
		dto.setInvitedCuidList(invitedCuidList);

		return dto;
    }

	/**
	 * 管理员充值（ 金豆 or 现金 ）
	 * @param cuId
	 * @param num
	 * @param remark
	 * @param rechargeType
	 */
	public void recharge(Long cuId, Long num, String remark, String rechargeType) {
		this.customerInfz.recharge(cuId,num,remark,rechargeType);
	}


	/**
	 * 修改用户状态
	 * @param uid
	 * @param customerStatus 用户状态 (frozen:封号 | frozenByImei:封设备 | drawdown:账户注销  | normal:正常)
	 * @return
	 */
	public void updateCustomerStatus(Long uid,String customerStatus) {
		this.customerInfz.updateCustomerStatus(uid, customerStatus);
	}


    /**
     * 修改用户信息
     * @param customer
     */
    public void updateCustomerInfo(Customer customer) {
        this.customerInfz.updateCustomerInfo(customer);
    }

	/**
	 * 修改手机
	 * @param cuId
	 * @param bindPhone
	 */
	public void updateBindPhone(Long cuId, String bindPhone) {
		this.customerInfz.updateBindPhone(cuId,bindPhone);
	}
}
