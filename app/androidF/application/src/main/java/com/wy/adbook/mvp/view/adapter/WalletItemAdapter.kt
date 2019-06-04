package com.wy.adbook.mvp.view.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.wy.adbook.mvp.model.entity.accout.FlowItem

/**
 * Created by leafye on 2019/5/6.
 */
class WalletItemAdapter(list: MutableList<FlowItem>?) :
    BaseQuickAdapter<FlowItem, BaseViewHolder>(R.layout.item_wallet, list) {
    override fun convert(helper: BaseViewHolder, item: FlowItem) {
        helper.getView<TextView>(R.id.title_tv).text = item.title
        helper.getView<TextView>(R.id.time_tv).text
        helper.getView<TextView>(R.id.add_num_tv).text = "+${item.amount}"
    }
}

