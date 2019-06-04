package com.only.tech.activity.service.facade;

import com.only.tech.activity.service.biz.ExtraBonusService;
import com.only.tech.entity.activity.ExtraBonus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/17
 */
@Slf4j
@Service
public class ExtraBonusFacade {

    @Autowired
    private ExtraBonusService extraBonusService;

    public void addReadAwards(Long cuId, long gold) {

        try {
            ExtraBonus extraBonus = extraBonusService.getByCuidAndStatus(cuId,0);
            if (extraBonus != null){
                Long amount = extraBonus.getAmount();
                extraBonus.setAmount(amount+gold);
                extraBonusService.updateById(extraBonus);
            }
        } catch (Exception e) {
            log.error("添加额外奖励错误：cuid:[{}];gold:[{}]",cuId,gold,e);
        }

    }
}
