package com.freebookqy.viewlib.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.support.annotation.LayoutRes
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.utilslib.ScreenUtils

/**
 * Created by leafye on 2019-05-10.
 */
abstract class BaseFullDialog : Dialog {
    constructor(context: Context) : super(context)
    constructor(context: Context, themeResId: Int) : super(context, themeResId)
    constructor(context: Context, cancelable: Boolean, cancelListener: DialogInterface.OnCancelListener?) : super(
        context,
        cancelable,
        cancelListener
    )

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(getDialogLayoutId())
        handleCompat()
        window?.let {
            it.setBackgroundDrawableResource(android.R.color.transparent)
            val lp = it.attributes
            lp.width = ScreenUtils.getScreenWidth()
            lp.height = WindowManager.LayoutParams.MATCH_PARENT
            it.attributes = lp
        }
    }

    private fun handleCompat() {
        val divierId = context.resources.getIdentifier("android:id/titleDivider", null, null)
        val divider = findViewById<View>(divierId)
        divider?.setBackgroundColor(ResUtils.getColor(android.R.color.transparent))
    }

    @LayoutRes
    abstract fun getDialogLayoutId(): Int

}