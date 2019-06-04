package com.wy.adbook.mvp.view.adapter

import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.model.entity.FaqItem

/**
 * Created by leafye on 2019-05-28.
 */
class CommonQuestionAdapter(list: MutableList<FaqItem>) :
    BaseQuickAdapter<FaqItem, BaseViewHolder>(R.layout.item_faq, list) {
    override fun convert(helper: BaseViewHolder, item: FaqItem) {
        helper.getView<TextView>(R.id.question_tv).apply {
            onClick {
                item.isOpen = !item.isOpen
                notifyDataSetChanged()
            }
            setCompoundDrawablesRelativeWithIntrinsicBounds(
                0,
                0,
                if (item.isOpen) R.mipmap.arrow_up else R.mipmap.arrow_down,
                0
            )
        }.text = item.question
        helper.getView<TextView>(R.id.answer_tv).apply {
            visibility = if (item.isOpen) View.VISIBLE else View.GONE
        }.text = item.answer
    }

}