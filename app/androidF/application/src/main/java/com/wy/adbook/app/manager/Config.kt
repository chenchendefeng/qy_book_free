package com.wy.adbook.app.manager

import com.wy.adbook.app.QYApplication
import com.jess.arms.utils.DataHelper

/**
 * Created by leafye on 2019-05-17.
 */
object Config {

    fun getWelefareConfig(): WelfareConfig =
        WelfareConfig()

    class WelfareConfig {

        private val spfWatchVideoForGold = "spWatchVideoForGold"
        private val spRetroactiveConsumptionGoldBeans = "spRetroactiveConsumptionGoldBeans"
        /**
         * 看视频可以获取的金豆数
         */
        private val defWatchVideoForGold: Int = 50
        /**
         * 补签要消耗的金豆
         */
        private val defRetroactiveConsumptionGoldBeans = 200


        /**
         * 获取查看视频获取金豆的数额
         */
        fun getWatchVideoGetGold(): Int {
            val gold = DataHelper.getIntergerSF(QYApplication.cxt(), spfWatchVideoForGold)
            if (gold < 0)
                return defWatchVideoForGold
            return gold
        }

        /**
         * 设置查看视频获取金豆的数额
         */
        fun setWatchVideoGetGold(watchVideoGetGold: Int) {
            DataHelper.setIntergerSF(QYApplication.cxt(), spfWatchVideoForGold, watchVideoGetGold)
        }

        /**
         * 获取补签需要的金豆
         */
        fun getRetroactiveConsumptionGoldBeans(): Int {
            val gold = DataHelper.getIntergerSF(QYApplication.cxt(), spRetroactiveConsumptionGoldBeans)
            if (gold < 0)
                return defRetroactiveConsumptionGoldBeans
            return gold
        }

        /**
         * 设置补签需要的金豆
         */
        fun setRetroactiveConsumptionGoldBeans(consumptionGoldBeans: Int) {
            DataHelper.setIntergerSF(QYApplication.cxt(), spRetroactiveConsumptionGoldBeans, consumptionGoldBeans)
        }

    }
}


