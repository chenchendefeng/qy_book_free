package com.freebookqy.application.mvp.main.my.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.freebookqy.application.mvp.model.entity.WalletItem

/**
 * Created by leafye on 2019/5/6.
 */
class WalletItemAdapter(list: MutableList<WalletItem>?) :
    BaseQuickAdapter<WalletItem, BaseViewHolder>(R.layout.item_wallet, list) {
    override fun convert(helper: BaseViewHolder, item: WalletItem) {
        helper.getView<TextView>(R.id.title_tv)
        helper.getView<TextView>(R.id.time_tv)
        helper.getView<TextView>(R.id.add_num_tv)
    }
}

