package com.only.tech.activity.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.activity.service.biz.ExtraBonusService;
import com.only.tech.entity.activity.ExtraBonus;
import com.only.tech.exposeinfz.activity.api.ExtraBonusInfz;
import com.only.tech.exposeinfz.user.api.RewardInfz;
import ooh.chaos.util.DateFormatUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/17
 */
@Component
@Service(interfaceClass = ExtraBonusInfz.class)
public class ExtraBonusInfzImpl implements ExtraBonusInfz {

    @Autowired
    private ExtraBonusService extraBonusService;

    @Reference
    private RewardInfz rewardInfz;


    @Override
    public void addMultiple(Long cuId, Date expiryTime) {
        ExtraBonus extraBonus = extraBonusService.getByCuidAndStatus(cuId, 0);
        if (extraBonus == null){
            extraBonus = new ExtraBonus();
            extraBonus.setCuId(cuId);
            extraBonus.setStatus(0);
            extraBonus.setMultiple(2);
            extraBonus.setAmount(0L);
            extraBonus.setExpiryTime(expiryTime);

            extraBonusService.save(extraBonus);
        }else {
            Integer multiple = extraBonus.getMultiple();
            extraBonus.setMultiple(++multiple);
            extraBonusService.updateById(extraBonus);
        }
    }

    @Override
    public void reward(String dateTime) {
        Date date = null;
        if (StringUtils.isNotBlank(dateTime)){
            date = DateFormatUtil.parse(dateTime);
        }
        if (date == null){
            date = new Date();
            date = DateFormatUtil.addHour(date,-1);
        }
        List<ExtraBonus> bonusList = extraBonusService.listByDate(date);
        if (!bonusList.isEmpty()) {
            for (ExtraBonus bonus: bonusList) {
                boolean reward = rewardInfz.invitationReadReward(bonus);
                if (reward) {
                    bonus.setStatus(1);
                }
            }
            extraBonusService.updateBatchById(bonusList);
        }

    }
}
