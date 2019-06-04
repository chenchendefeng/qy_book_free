package com.only.tech.exposeinfz.user.api;

/**
 * 服务暴露接口：用户充值相关接口（消费方可以根据此调用自己需要的服务）
 * 
 * @author xiaoshiyilang
 * @date 2018/11/17
 * @version 1.0
 */
public interface UserRechargeInfz {

	/**
	 * 用户充值
	 * @param uid
	 * @param bookMoney
	 * @param orderNum
	 * @param orderMoney
	 * @param systemType
	 * @return
	 */
	boolean userRecharge(Long uid, Long bookMoney, String orderNum, Integer orderMoney, String systemType);

	/**
	 * 活动送书币
	 * @param uid
	 * @param amount
	 * @param activityType
	 * @return
	 */
	boolean activityAward(Long uid, Integer amount, String activityType);
}
