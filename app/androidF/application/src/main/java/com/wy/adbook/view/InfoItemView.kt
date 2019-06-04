package com.wy.adbook.view

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.freebookqy.application.R
import com.wy.adbook.ext.loadImageCircle
import com.wy.adbook.mvp.model.view.BasicInfo
import kotlinx.android.synthetic.main.item_info_view.view.*

/**
 * Created by leafye on 2019-05-30.
 */
class InfoItemView : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    init {
        View.inflate(context, R.layout.item_info_view, this)
    }

    fun setData(info: BasicInfo) {
        line.visibility = if (info.isShowTopLine) View.VISIBLE else View.GONE
        enter_iv.visibility = if (info.isEnter) View.VISIBLE else View.GONE
        info_title_tv.text = info.title
        if (TextUtils.isEmpty(info.imageUrl)) {
            info_iv.visibility = View.GONE
            info_content.visibility = View.VISIBLE
            info_content.text = info.content
        } else {
            info_iv.visibility = View.VISIBLE
            info_iv.loadImageCircle(info.imageUrl)
        }
    }
}