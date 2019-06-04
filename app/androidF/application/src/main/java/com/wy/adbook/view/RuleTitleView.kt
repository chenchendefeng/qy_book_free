package com.wy.adbook.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.freebookqy.application.R
import kotlinx.android.synthetic.main.view_rule_title.view.*

/**
 * Created by leafye on 2019-05-17.
 */
class RuleTitleView : LinearLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    init {
        View.inflate(context, R.layout.view_rule_title, this)
    }

    fun setTitleTv(title: String) {
        rule_title_tv.text = title
    }
}