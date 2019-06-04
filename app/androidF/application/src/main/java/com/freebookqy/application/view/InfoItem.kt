package com.freebookqy.application.view

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.freebookqy.application.R
import kotlinx.android.synthetic.main.item_info.view.*

/**
 * Created by leafye on 2019/5/6.
 */
class InfoItem : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    init {
        View.inflate(context, R.layout.item_info, this)
    }

    fun setInfoTitle(charSequence: CharSequence?) {
        info_title_tv.text = charSequence
    }

    fun setInfoContent(charSequence: CharSequence?) {
        info_content_tv.text = charSequence
    }

    fun setInfoTip(charSequence: CharSequence?) {
        if (TextUtils.isEmpty(charSequence)) {
            info_tip_tv.visibility = View.GONE
        } else {
            info_tip_tv.visibility = View.VISIBLE
            info_tip_tv.text = charSequence
        }
    }
}