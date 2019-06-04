package com.only.tech.constant;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/17
 */
public interface UserRedisKeyConstants {

    /**
     * user:
     */
    String USER = "user:";

    /**
     * userToken
     */
    String USER_TOKEN = USER + "token:" ;

    /**
     * 畅读卡
     */
    String READ_CARD = USER + "readCard:";

    /**
     * 今日邀请榜单
     */
    String INVITE_RANK_LIST_TODAY_KEY = "user:inviteRankList:today:";

    /**
     * 今日邀请榜单-用户邀请数据
     */
    String INVITE_RANK_DATA_TODAY_KEY = "user:inviteRankData:today:";

    /**
     * 会员赠送书币的领取状态
     */
	String VIP_RECEIVE_STATUS_KEY = "user:vip_receice:";

    /**
     * 昨日邀请榜单
     */
	String INVITE_RANK_LIST_YESTERDAY_KEY = "user:inviteRankList:yesterday:";

    /**
     * 昨日邀请榜单-用户邀请数据
     */
	String INVITE_RANK_DATA_YESTERDAY_KEY = "user:inviteRankData:yesterday:";

	/**兑换提现订单*/
	String EXCHANGE_ORDERNO_KEY = "user:exchangeOrderNo:";
}
