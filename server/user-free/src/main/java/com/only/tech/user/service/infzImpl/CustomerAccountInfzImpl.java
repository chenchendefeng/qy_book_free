package com.only.tech.user.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.CustomerAccount;
import com.only.tech.enums.AccountChangeSpecificTypeEnum;
import com.only.tech.enums.AccountChangeTypeEnum;
import com.only.tech.enums.CurrencyTypeEnum;
import com.only.tech.exposeinfz.user.api.CustomerAccountInfz;
import com.only.tech.exposeinfz.user.api.CustomerInfz;
import com.only.tech.user.service.biz.CustomerAccountService;
import com.only.tech.user.service.facade.AccountFlowRecordFacade;
import com.only.tech.user.service.facade.CustomerAccountFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * infz实现类： 用户账户
 * @author shutong
 * @since 2019/05/08
 */
@Slf4j
@Component
@Service(interfaceClass = CustomerAccountInfz.class)
public class CustomerAccountInfzImpl implements CustomerAccountInfz {

    @Autowired
    private CustomerAccountService accountService;

    @Autowired
    private CustomerAccountFacade customerAccountFacade;

    @Autowired
    private AccountFlowRecordFacade accountFlowRecordFacade;

    /**
     * 查询账户
     * @param cuId
     * @return
     */
    @Override
    public CustomerAccount getOneByCuid(Long cuId) {
        return this.accountService.getCuId(cuId);
    }

    /**
     * 修改账户信息
     * @param account
     */
    @Override
    public void saveOrUpdate(CustomerAccount account) {
        this.accountService.saveOrUpdate(account);
    }



    @Override
    public boolean attendanceChange(Long cuId, CurrencyTypeEnum currencyTypeEnum, Long amount, AccountChangeTypeEnum changeTypeEnum, AccountChangeSpecificTypeEnum specificTypeEnum) {
        boolean chanage = customerAccountFacade.goldChanage(cuId, amount);
        if (chanage){
            return accountFlowRecordFacade.record(cuId,currencyTypeEnum,amount,changeTypeEnum,specificTypeEnum,null);
        }
        return false;
    }
}
