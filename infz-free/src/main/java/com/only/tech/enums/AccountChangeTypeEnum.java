package com.only.tech.enums;

import com.only.tech.constant.AccountChangeTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 账户操作类型
 * @author ZHI ZUN BAO
 * @since 2019/5/5
 */
@Getter
@AllArgsConstructor
public enum AccountChangeTypeEnum {

    RECHARGE(AccountChangeTypeConstants.RECHARGE,"充值"),
    REWARD(AccountChangeTypeConstants.REWARD,"奖励"),
    CONSUME(AccountChangeTypeConstants.CONSUME,"消费"),
    CONSUME_RETURN(AccountChangeTypeConstants.CONSUME_RETURN,"消费退回"),
    EXCHANGE(AccountChangeTypeConstants.EXCHANGE,"兑换"),
    EXCHANGE_RETURN(AccountChangeTypeConstants.EXCHANGE_RETURN,"兑换退回"),
    WITHDRAWAL(AccountChangeTypeConstants.WITHDRAWAL,"提现"),
    WITHDRAWAL_RETURN(AccountChangeTypeConstants.WITHDRAWAL_RETURN,"提现退回"),
    ;

    private String type;

    private String name;
}
