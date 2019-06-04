package com.wy.adbook.view

import android.content.Context
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.freebookqy.application.R
import com.wy.adbook.ext.onClick
import kotlinx.android.synthetic.main.item_welfare.view.*

/**
 * Created by leafye on 2019/5/6.
 */
class WelfareItemView : LinearLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    init {
        View.inflate(context, R.layout.item_welfare, this)
    }

    fun setTitle(charSequence: CharSequence?) {
        title_name_tv.text = charSequence
    }

    fun setTitleColor(@ColorInt intColor: Int) {
        title_name_tv.setTextColor(intColor)
    }

    fun setRedTipText(charSequence: CharSequence?) {
        red_tip_tv.text = charSequence
    }

    fun setRedTipTextColor(@ColorInt intColor: Int) {
        red_tip_tv.setTextColor(intColor)
    }

    fun setRedTipBg(@DrawableRes dRes: Int) {
        red_tip_tv.setBackgroundResource(dRes)
    }

    fun setRedTipIv(@DrawableRes dRes: Int) {
        red_tip_iv.setImageResource(dRes)
    }

    fun setItemDesText(charSequence: CharSequence?) {
        item_des_tv.text = charSequence
    }

    fun setItemDesColor(@ColorInt intColor: Int) {
        item_des_tv.setTextColor(intColor)
    }

    fun setRightBtnText(charSequence: CharSequence?) {
        right_btn.text = charSequence
    }

    fun setOnRightClickListener(l: View.OnClickListener) {
        right_btn.onClick(l)
    }

    fun redTipVisible(isVisible: Boolean) {
        right_red_tip_container.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

}