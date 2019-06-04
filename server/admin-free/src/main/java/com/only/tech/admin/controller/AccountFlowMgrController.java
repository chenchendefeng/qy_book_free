package com.only.tech.admin.controller;

import com.only.tech.admin.service.facade.AccountFlowFacade;
import com.only.tech.admin.service.facade.CustomerFacade;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.user.CustomerAccountDto;
import com.only.tech.entity.user.AccountFlowRecord;
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
 * ctr: 账户流水
 * @author shutong
 *
 */
@Slf4j
@RestController
@RequestMapping("/accountFlow")
@Api(tags="账户流水管理")
public class AccountFlowMgrController extends BaseController {
	

	@Autowired
	private AccountFlowFacade accountFlowFacade;

	/**
	 * 分页查询
	 * @param pageReq
	 * @param cuId
	 * @param currentType
	 * @return
	 */
	@ApiOperation(value = "分页查询APP用户流水（现金or金豆）")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "cuId", dataType = "int", value = "用户ID" ),
		@ApiImplicitParam(name = "currentType", dataType = "string", value = "流水类型（good: 金豆 | rmb: 现金(人民币，单位：分) ）")
	})
	@RequestMapping(value = "/pageListAccountFlow", method = RequestMethod.POST)
	public ResultDto<Customer> pageListAccountFlow(PageReq pageReq, Long cuId, String currentType){
		try {

			PageData<AccountFlowRecord> pageData=this.accountFlowFacade.pageListByCondition(pageReq,cuId,currentType);
			return ResultDto.succesResult(pageData);

		} catch (Exception e) {
			log.error("查询异常" ,e);
			return ResultDto.errorResult("查询异常");
		}
	}

}
