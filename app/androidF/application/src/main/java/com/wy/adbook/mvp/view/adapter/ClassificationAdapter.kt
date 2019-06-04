package com.wy.adbook.mvp.view.adapter

import android.widget.CheckBox
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.wy.adbook.mvp.model.entity.Classification

/**
 * Created by leafye on 2019/5/5.
 */
class ClassificationAdapter(list: MutableList<Classification>?) :
    BaseQuickAdapter<Classification, BaseViewHolder>(R.layout.item_classification, list) {
    override fun convert(helper: BaseViewHolder, item: Classification) {
        helper.getView<CheckBox>(R.id.classification_item_tv).apply {
            text = item.category
            isChecked = item.isSelected
        }
    }
}

