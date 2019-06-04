package com.freebookqy.application.mvp.main.my.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R

/**
 * Created by leafye on 2019-05-08.
 */
class SignCalendarAdapter(list: MutableList<SignCalendarItem>?) :
    BaseQuickAdapter<SignCalendarItem, BaseViewHolder>(R.layout.item_sign_calendar, list) {
    override fun convert(helper: BaseViewHolder, item: SignCalendarItem) {
        val dayTv = helper.getView<TextView>(R.id.day_tv)
        val signDayIv = helper.getView<ImageView>(R.id.sign_day_iv)
        val fillTv = helper.getView<ImageView>(R.id.fill_tv)
        dayTv.text = "" + item.day
        if (item.isSign) {
            signDayIv.visibility = View.VISIBLE
            dayTv.visibility = View.VISIBLE
        } else {
            signDayIv.visibility = View.GONE
            if (item.isCanSign) {
                dayTv.visibility = View.GONE
                fillTv.visibility = View.VISIBLE
            } else {
                dayTv.visibility = View.VISIBLE
                fillTv.visibility = View.GONE
            }
        }
    }

}

class SignCalendarItem(
    var day: Int,
    /**
     * 补签了吗
     */
    var isSign: Boolean,
    /**
     * 是否能补签
     */
    var isCanSign: Boolean
)
