package com.wy.adbook.dialog

import android.content.Context
import com.freebookqy.application.R
import com.freebookqy.viewlib.dialog.BaseFullDialog
import com.wy.adbook.ext.onClick
import kotlinx.android.synthetic.main.dialog_edittext.*

/**
 * Created by leafye on 2019-05-30.
 */
class EditTextDialog : BaseFullDialog {
    override fun getDialogLayoutId(): Int {
        return R.layout.dialog_edittext
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, themeResId: Int) : super(context, themeResId)

    private var mL: EditTextDialogClickListener? = null

    init {
        confirm_btn.onClick {
            val text = edit_text.text.toString()
            mL?.confirm(this@EditTextDialog, text)
        }
        cancel_btn.onClick {
            this.dismiss()
            mL?.cancel(this@EditTextDialog)
        }
    }

    fun setData(title: String, hintText: String) {
        title_name_tv.text = title
        edit_text.hint = hintText
    }

    fun setEditTextDialogClickListener(l: EditTextDialogClickListener) {
        this.mL = l
    }


    interface EditTextDialogClickListener {

        fun cancel(d: EditTextDialog)

        fun confirm(d: EditTextDialog, inputContent: String)

    }


}