package com.wy.adbook.mvp.view.adapter

import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.wy.adbook.mvp.model.entity.WithdrawalRecordItem

/**
 * Created by leafye on 2019-05-29.
 */
class WithdrawalRecordAdapter(list: MutableList<WithdrawalRecordItem>) :
    BaseQuickAdapter<WithdrawalRecordItem, BaseViewHolder>(R.layout.item_record, list) {
    override fun convert(helper: BaseViewHolder, item: WithdrawalRecordItem) {
        helper.getView<TextView>(R.id.withdrawal_money_tv).text = "兑换${item.amount}元"
        helper.getView<TextView>(R.id.withdrawal_time_tv).text = item.time
        val withdrawalStatusIv = helper.getView<ImageView>(R.id.withdrawal_status_iv)
        val withdrawalStatusTv = helper.getView<TextView>(R.id.withdrawal_status_tv)
        when (item.status) {
            0 -> {
                withdrawalStatusIv.setImageResource(R.mipmap.icon_tixian_fair)
                withdrawalStatusTv.text = "提现失败"
            }
            1 -> {
                withdrawalStatusIv.setImageResource(R.mipmap.icon_tixian_chulizhong)
                withdrawalStatusTv.text = "处理中..."
            }
            2 -> {
                withdrawalStatusIv.setImageResource(R.mipmap.icon_tixian_seceed)
                withdrawalStatusTv.text = "提现成功"
            }
        }
    }

}