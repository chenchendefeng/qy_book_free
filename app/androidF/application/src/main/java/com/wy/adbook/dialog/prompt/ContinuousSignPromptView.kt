package com.wy.adbook.dialog.prompt

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.freebookqy.application.R
import com.wy.adbook.ext.onClick
import kotlinx.android.synthetic.main.dialog_view_continuous_sign_prompt.view.*

/**
 * Created by leafye on 2019-05-20.
 * 连续签到提示对话框
 */
class ContinuousSignPromptView : FrameLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    init {
        View.inflate(context, R.layout.dialog_view_continuous_sign_prompt, this)
        to_withdrawal_btn.onClick { mL?.toWithDrawal() }
    }

    private var mL: ContinuousSignPromptListener? = null

    fun setData(continuousDays: Int, gold: Int) {
        continuous_days_tv.text = "(${continuousDays}天)"
        gold_beans_tv.text = "${gold}"
    }

    fun setContinuousSignPromptListener(l: ContinuousSignPromptListener) {
        this.mL = l
    }

    interface ContinuousSignPromptListener {
        fun toWithDrawal()
    }

}