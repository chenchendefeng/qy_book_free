package com.only.tech.admin.controller;

import com.only.tech.admin.service.facade.CustomerFacade;
import com.only.tech.admin.service.facade.GoodsOrderFacade;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.user.CustomerAccountDto;
import com.only.tech.dto.user.CustomerBizInfoDto;
import com.only.tech.entity.payment.GoodsOrder;
import com.only.tech.entity.user.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import ooh.chaos.targetMethod.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ctr: APP用户管理
 * @author shutong
 *
 */
@Slf4j
@RestController
@RequestMapping("/customer")
@Api(tags="APP用户管理")
public class CustomerMgrController extends BaseController {
	

	@Autowired
	private CustomerFacade customerFacade;

	/**
	 * 分页查询APP用户
	 * @param pageReq
	 * @param userType
	 * @param unionMsg
	 * @return
	 */
	@ApiOperation(value = "分页查询APP用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "unionMsg", dataType = "string", value = " 属性选其一 ( 用户ID or 电话 or 红包码 )" ),
		@ApiImplicitParam(name = "userType", dataType = "string", value = " 用户类型 ( visitor: 游客 | register:注册用户 | vip: 会员)")
	})
	@RequestMapping(value = "/pageListGoodsOrder", method = RequestMethod.POST)
	public ResultDto<Customer> pageListGoodsOrder(PageReq pageReq, String userType, String unionMsg){
		try {

			PageData<CustomerAccountDto> pageData=this.customerFacade.pageListByCondition(pageReq,userType,unionMsg);
			return ResultDto.succesResult(pageData);

		} catch (Exception e) {
			log.error("查询用户异常" ,e);
			return ResultDto.errorResult("查询用户异常");
		}
	}

	/**
	 * 获取用户账户信息
	 */
	@Access
	@ApiOperation(value = "获取用户账户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "cuId", value = "用户ID", dataType = "String", required = true )
	})
	@RequestMapping(value = "/getCustomerAccountInfo", method = RequestMethod.POST)
	public ResultDto<CustomerAccountDto> getCustomerAccountInfo(Long cuId) {
		try {
			CustomerAccountDto customerAccountDto = this.customerFacade.getCustomerAccountInfo(cuId);
			return ResultDto.succesResult(customerAccountDto);
		} catch (Exception e) {
			log.error("获取用户业务信息失败",e);
			return ResultDto.errorResult("获取用户业务信息失败");
		}
	}

	/**
	 * 管理员充值（金豆）
	 */
	@Access
	@ApiOperation(value = "管理员充值（ 金豆 or 现金 ）")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "cuId", value = "用户ID", dataType = "string", required = true ),
			@ApiImplicitParam(name = "num", value = "充值数量", dataType = "int", required = true ),
			@ApiImplicitParam(name = "rechargeType", value = "充值类型 ( gold:金豆 | rmb:现金)", dataType = "string", required = true ),
			@ApiImplicitParam(name = "remark", value = "备注", dataType = "string", required = true )
	})
	@RequestMapping(value = "/recharge", method = RequestMethod.POST)
	public ResultDto recharge(Long cuId, Long num, String remark, String rechargeType ) {
		try {
			this.customerFacade.recharge(cuId,num,remark,rechargeType);
			return ResultDto.succesResult("充值成功");
		} catch (Exception e) {
			log.error("充值失败",e);
			return ResultDto.errorResult("充值失败");
		}
	}


	@ApiOperation(value = "修改用户状态")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "uid", dataType = "Long", value = "用户ID", required = true),
			@ApiImplicitParam(name = "customerStatus", dataType = "string", value = "用户状态 ( frozen:封号| unFrozen:解封号 | frozenByImei:封设备 | unFrozenByImei: 解封设备 " +
					" | drawdown:账户注销 )", required = true)
	})
	@RequestMapping(value = "/updateCustomerStatus", method = RequestMethod.POST)
	public ResultDto updateCustomerStatus(Long uid,String customerStatus)
	{
		try {
			this.customerFacade.updateCustomerStatus(uid,customerStatus);
			return ResultDto.succesResult("修改成功");
		}catch (Exception e){
			log.error("修改用户状态失败", e);
			return  ResultDto.errorResult("修改用户状态失败");
		}
	}

	@ApiOperation(value = "修改用户手机")
	@RequestMapping(value = "/updateBindPhone", method = RequestMethod.POST)
	public ResultDto updateBindPhone(Long cuId, String bindPhone)
	{
		try {
			this.customerFacade.updateBindPhone(cuId,bindPhone);
			return ResultDto.succesResult("修改成功");
		}catch (Exception e){
			log.error("修改用户失败", e);
			return  ResultDto.errorResult("修改用户失败");
		}
	}
}
