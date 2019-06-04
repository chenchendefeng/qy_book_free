package com.only.tech.constant;

/**
 * 账户操作类型
 * @author ZHI ZUN BAO
 * @since 2019/4/30
 */
public interface AccountChangeTypeConstants {

    /** 充值 */
    String RECHARGE = "recharge";

    /** 奖励 */
    String REWARD = "reward";

    /** 消费 */
    String CONSUME = "consume";

    /**
     * 消费退回
     */
    String CONSUME_RETURN = "consumeReturn";

    /** 兑换 */
    String EXCHANGE = "exchange";

    /**兑换退回*/
    String EXCHANGE_RETURN = "exchangeReturn";

    /** 提现 */
    String WITHDRAWAL = "withdrawal";

    /** 提现退回 */
    String WITHDRAWAL_RETURN = "withdrawalReturn";

}
