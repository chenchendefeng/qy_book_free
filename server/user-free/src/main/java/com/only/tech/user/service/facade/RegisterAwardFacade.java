package com.only.tech.user.service.facade;

import com.only.tech.base.result.ResultDto;
import com.only.tech.constant.CustomerTypeConstants;
import com.only.tech.constant.UserConstants;
import com.only.tech.entity.user.CustomerAccount;
import com.only.tech.enums.AccountChangeSpecificTypeEnum;
import com.only.tech.enums.AccountChangeTypeEnum;
import com.only.tech.enums.CurrencyTypeEnum;
import com.only.tech.user.dto.AccountDto;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.NumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/5
 */
@Slf4j
@Service
public class RegisterAwardFacade {

    @Autowired
    private CustomerFacade customerFacade;

    @Autowired
    private AccountFlowRecordFacade accountFlowRecordFacade;

    @Autowired
    private CustomerAccountFacade customerAccountFacade;

    /**
     * 奖励
     * @param cuId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultDto award(Long cuId) {
        //校验用户类型
        String type = customerFacade.getUserType(cuId);
        if (type == null || !CustomerTypeConstants.USER_TYPE_REGISTER.equals(type)){
            return ResultDto.errorResult("没有奖励资格");
        }

        //校验是否已经奖励
        boolean rewarded = accountFlowRecordFacade.alreadyRegisterRewarded(cuId);
        if (rewarded){
            return ResultDto.errorResult("已经领取奖励");
        }

        //奖励
        Long rmb = getRegisterRmb();
        boolean chanage = customerAccountFacade.chanage(cuId, rmb, UserConstants.REGISTER_AWARD_GOLD_1W);
        if (chanage){
            //账户流水
            accountFlowRecordFacade.record(cuId, CurrencyTypeEnum.RMB,rmb, AccountChangeTypeEnum.REWARD, AccountChangeSpecificTypeEnum.RMB_REGISTER_REDPACK,null);
            accountFlowRecordFacade.record(cuId, CurrencyTypeEnum.GOLD,UserConstants.REGISTER_AWARD_GOLD_1W, AccountChangeTypeEnum.REWARD, AccountChangeSpecificTypeEnum.GOLD_REGISTER_REDPACK,null);
        }

        CustomerAccount account = customerAccountFacade.getCuId(cuId);
        AccountDto dto = new AccountDto();
        dto.setGold(account.getGold());
        dto.setRmb(NumUtil.div(dto.getRmb(),100));

        return ResultDto.succesResult(dto);
    }

    /**
     * 注册奖励-人民币
     * @return
     */
    private Long getRegisterRmb() {
        int random = NumUtil.getRandom(100, 588);
        return Long.valueOf(random);
    }


}
