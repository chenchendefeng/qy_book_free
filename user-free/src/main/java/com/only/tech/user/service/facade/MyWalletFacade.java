package com.only.tech.user.service.facade;

import com.only.tech.base.result.ResultDto;
import com.only.tech.entity.user.CustomerAccount;
import com.only.tech.user.dto.WalletDto;
import com.only.tech.user.service.biz.CustomerAccountService;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.NumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/5
 */
@Slf4j
@Service
public class MyWalletFacade {

    @Autowired
    private CustomerAccountService customerAccountService;

    public WalletDto balance(Long cuId) {
        CustomerAccount account = customerAccountService.getCuId(cuId);
        if (account != null){
            WalletDto dto = new WalletDto();
            dto.setGoldBalance(account.getGold());
            Long rmb = account.getRmb();
            dto.setRmbalance(NumUtil.div(rmb, 100));
            Long rmbTotal = account.getRmbTotal();
            dto.setRmbTotal(NumUtil.div(rmbTotal, 100));

            return dto;
        }

        return null;
    }
}
