package com.wy.adbook.dialog.prompt

import android.content.Context
import android.view.View
import com.freebookqy.application.R
import com.freebookqy.viewlib.dialog.BaseFullDialog
import kotlinx.android.synthetic.main.dialog_common_prompt.*

/**
 * Created by leafye on 2019-05-20.
 */
class QYCommonPromptDialog : BaseFullDialog {

    constructor(context: Context) : super(context)
    constructor(context: Context, themeResId: Int) : super(context, themeResId)

    override fun getDialogLayoutId(): Int {
        return R.layout.dialog_common_prompt
    }

    init {
        prompt_cancel_iv.setOnClickListener { dismiss() }
        setCanceledOnTouchOutside(false)
        setCancelable(false)
    }

    fun setView(view: View) {
        prompt_container.removeAllViews()
        prompt_container.addView(view)
    }


}