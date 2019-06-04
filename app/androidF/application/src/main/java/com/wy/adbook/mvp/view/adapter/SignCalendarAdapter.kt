package com.wy.adbook.mvp.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.wy.adbook.app.utils.TimeUtils
import com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem

/**
 * Created by leafye on 2019-05-08.
 */
class SignCalendarAdapter(list: MutableList<AttendanceCalendarItem>?) :
    BaseQuickAdapter<AttendanceCalendarItem, BaseViewHolder>(R.layout.item_sign_calendar, list) {
    override fun convert(helper: BaseViewHolder, item: AttendanceCalendarItem) {
        val dayTv = helper.getView<TextView>(R.id.day_tv)
        val signDayIv = helper.getView<ImageView>(R.id.sign_day_iv)
        val fillTv = helper.getView<TextView>(R.id.fill_tv)
        dayTv.text = "" + TimeUtils.getDayInt(item.date)
        if (item.status == 1) {
            signDayIv.visibility = View.VISIBLE
            dayTv.visibility = View.VISIBLE
        } else {
            signDayIv.visibility = View.GONE
            if (item.compensateStatus == 1) {
                dayTv.visibility = View.GONE
                fillTv.visibility = View.VISIBLE
            } else {
                dayTv.visibility = View.VISIBLE
                fillTv.visibility = View.GONE
            }
        }
    }


}
