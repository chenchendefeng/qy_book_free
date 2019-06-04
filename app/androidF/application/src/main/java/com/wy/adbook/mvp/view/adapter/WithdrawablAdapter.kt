package com.wy.adbook.mvp.view.adapter

import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.wy.adbook.mvp.model.entity.WithdrawalItem

/**
 * Created by leafye on 2019-05-26.
 */
class WithdrawablAdapter(list: MutableList<WithdrawalItem>) :
    BaseQuickAdapter<WithdrawalItem, BaseViewHolder>(R.layout.item_withdrawal, list) {
    override fun convert(helper: BaseViewHolder, item: WithdrawalItem) {
        helper.getView<TextView>(R.id.center_tip_tv)
        helper.getView<View>(R.id.new_tip).visibility = if (item.isNew == 1) View.VISIBLE else View.GONE
    }
}