package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.user.CustomerAccountDto;
import com.only.tech.entity.user.AccountFlowRecord;
import com.only.tech.entity.user.Customer;
import com.only.tech.exposeinfz.user.api.AccountFlowRecordInfz;
import com.only.tech.exposeinfz.user.api.CustomerInfz;
import org.springframework.stereotype.Service;

/**
 * facade: 账户流水
 * @author shutong
 * @since 2019/05/30
 */
@Service
public class AccountFlowFacade {

	@Reference
	private AccountFlowRecordInfz accountFlowInfz;

	/**
	 * 分页查询账户流水（金豆or现金）
	 * @param pageReq
	 * @param cuId
	 * @param currentType (gold or rmb )
	 * @return
	 */
	public PageData<AccountFlowRecord> pageListByCondition(PageReq pageReq, Long cuId , String currentType ) {
		return this.accountFlowInfz.pageListByCondition(pageReq,cuId,currentType);
	}

}
