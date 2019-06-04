package com.only.tech.activity.common.constants;

public interface ConstantsActivity {

	/** 奖品数额类型 */
	String AWARD_SENDTYPE_FIX= "fix";        //固定数额
	String AWARD_SENDTYPE_RANDOM= "random";  //随机数额

	/** 奖品类型 */
	String AWARDTYPE_VIRTUAL= "virtual";  //虚拟
	String AWARDTYPE_ENTITY = "entity";   //实物

	/** 永久 */
	Integer FOR_EVER= -1;   //永久


	/**签到类型*/

		/** 首签*/
		Integer FIRST_SIGN_CODE = 0;

		/**日常签到*/
		Integer DAILY_SIGN_CODE = 1;

		/**补签*/
		Integer COMPENSATE_SIGN_CODE = 2;

	/**签到类型*/

	/**签到奖品类型*/

		/**首签*/
		String FIRST_SIGN = "firstSign";

		/**日常签到*/
		String DAILY_SIGN = "dailySign";

		/**连续签到*/
		String CONTINUITY_SIGN = "continuitySign";

		/**补签*/
		String COMPENSATE_SIGN = "compensateSign";

	/**签到奖品类型*/

	long signMaxReward = 10000;


}
