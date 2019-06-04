package com.wy.adbook.mvp.view.adapter

import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.wy.adbook.ext.toIntS
import com.wy.adbook.mvp.model.entity.accout.RewardItem
import com.freebookqy.utilslib.ResUtils

/**
 * Created by leafye on 2019-05-09.
 */
class ContinuousSignInAdapter(list: MutableList<RewardItem>?) :
    BaseQuickAdapter<RewardItem, BaseViewHolder>(R.layout.item_continuous_sign_in, list) {

    private var continuousDays: Int = 0

    fun setContinuousDays(days: Int) {
        continuousDays = days
        if (!data.isEmpty())
            notifyDataSetChanged()
    }

    override fun convert(helper: BaseViewHolder, item: RewardItem) {
        val leftLine = helper.getView<View>(R.id.left_line)
        val rightLine = helper.getView<View>(R.id.right_line)
        leftLine.visibility = View.VISIBLE
        rightLine.visibility = View.VISIBLE
        val index = data.indexOf(item)
        if (index == 0) {
            leftLine.visibility = View.GONE
        } else if (index == data.size - 1) {
            rightLine.visibility = View.GONE
        }
        helper.getView<TextView>(R.id.reward_tv).apply {
            textSize = if (item.gold.toIntS() > 9999) 10F else 13F
            text = if (item.days <= continuousDays) {
                setBackgroundResource(R.mipmap.cir_yiling)
                "已领\n${item.gold}"
            } else if (item.days == 30 || item.days == 50 || item.days == 100) {
                setBackgroundResource(R.mipmap.icon_cir_big)
                item.gold
            } else {
                setBackgroundResource(R.mipmap.icon_cir_small)
                item.gold
            }
        }
        helper.getView<TextView>(R.id.continuous_sign_rv).text = ResUtils.getString(R.string.n_tian, item.days)
    }
}