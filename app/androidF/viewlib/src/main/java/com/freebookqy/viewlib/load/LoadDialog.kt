package com.freebookqy.viewlib.load

import android.content.Context
import android.view.View
import com.freebookqy.viewlib.R
import com.freebookqy.viewlib.dialog.BaseFullDialog
import kotlinx.android.synthetic.main.dialog_loading.*

/**
 * Created by leafye on 2019-05-23.
 */
class LoadDialog : BaseFullDialog {
    override fun getDialogLayoutId(): Int {
        return R.layout.dialog_loading
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, themeResId: Int) : super(context, themeResId)

    companion object {
        private const val DELAY_DISMISS = 1500L
    }

    init {
        setContentView(R.layout.dialog_loading)
        setCanceledOnTouchOutside(false)
        setCancelable(false)
    }

    fun showLoading() {
        if (isShowing) return
        load_progress_bar.visibility = View.VISIBLE
        progress_container.visibility = View.VISIBLE
        msg_tv.visibility = View.GONE
        show()
    }

    fun showMsg(msg: String) {
        msg_tv.text = msg
        msg_tv.visibility = View.VISIBLE
        progress_container.visibility = View.GONE
        show()
        msg_tv.postDelayed({
            try {
                if (isShowing)
                    dismiss()
            } catch (e: Exception) {

            }
        }, DELAY_DISMISS)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

    }


}