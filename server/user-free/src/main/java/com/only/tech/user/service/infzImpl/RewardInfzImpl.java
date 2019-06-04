package com.only.tech.user.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.entity.activity.ExtraBonus;
import com.only.tech.enums.AccountChangeSpecificTypeEnum;
import com.only.tech.enums.AccountChangeTypeEnum;
import com.only.tech.enums.CurrencyTypeEnum;
import com.only.tech.exposeinfz.user.api.RewardInfz;
import com.only.tech.user.service.facade.AccountFlowRecordFacade;
import com.only.tech.user.service.facade.CustomerAccountFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/17
 */
@Component
@Service(interfaceClass = RewardInfz.class)
public class RewardInfzImpl implements RewardInfz {

    @Autowired
    private CustomerAccountFacade customerAccountFacade;

    @Autowired
    private AccountFlowRecordFacade flowRecordFacade;

    @Override
    public boolean invitationReadReward(ExtraBonus bonus) {
        Integer multiple = bonus.getMultiple();
        if (multiple > 10){
            multiple = 10;
        }
        Long amount = bonus.getAmount();
        long gold = multiple.longValue() * amount;
        Long cuId = bonus.getCuId();
        boolean chanage = customerAccountFacade.goldChanage(cuId, gold);
        if (chanage){
            flowRecordFacade.record(cuId, CurrencyTypeEnum.GOLD,gold, AccountChangeTypeEnum.REWARD, AccountChangeSpecificTypeEnum.NEWUSER_INVITATION_REWARD_MULTIPLE,null);
        }

        return chanage;
    }
}
