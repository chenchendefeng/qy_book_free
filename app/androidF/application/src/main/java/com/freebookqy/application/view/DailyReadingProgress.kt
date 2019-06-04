package com.freebookqy.application.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.freebookqy.application.R
import kotlinx.android.synthetic.main.view_daily_reading_progress.view.*

/**
 * Created by leafye on 2019/5/6.
 */
class DailyReadingProgress : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    init {
        View.inflate(context, R.layout.view_daily_reading_progress, this)
    }

    fun setWelfareTv1(text: String) {
        welfare_tv_1.text = text
    }

    fun setWelfareTv2(text: String) {
        welfare_tv_2.text = text
    }

    fun setWelfareTv3(text: String) {
        welfare_tv_3.text = text
    }

    fun setWelfareTv4(text: String) {
        welfare_tv_4.text = text
    }

    fun setWelfareTimeTv1(text: String) {
        progress_time_1.text = text
    }

    fun setWelfareTimeTv2(text: String) {
        progress_time_2.text = text
    }

    fun setWelfareTimeTv3(text: String) {
        progress_time_3.text = text
    }

    fun setWelfareTimeTv4(text: String) {
        progress_time_4.text = text
    }
}
