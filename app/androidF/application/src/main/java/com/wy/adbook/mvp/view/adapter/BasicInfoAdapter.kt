package com.wy.adbook.mvp.view.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.wy.adbook.mvp.model.view.BasicInfo
import com.wy.adbook.view.InfoItemView

/**
 * Created by leafye on 2019-05-30.
 */
class BasicInfoAdapter(list: MutableList<BasicInfo>) :
    BaseQuickAdapter<BasicInfo, BaseViewHolder>(R.layout.item_basic_info, list) {
    override fun convert(helper: BaseViewHolder, item: BasicInfo) {
        val infoItemView = helper.getView<InfoItemView>(R.id.basic_item_info_view)
        infoItemView.setData(item)
    }
}