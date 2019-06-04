package com.freebookqy.application.dialog

import android.content.Context
import android.content.DialogInterface
import com.freebookqy.application.R
import com.freebookqy.application.app.constant.Constant
import kotlinx.android.synthetic.main.dialog_share_book.*

/**
 * Created by leafye on 2019-05-10.
 */
class ShareBookDialog : BaseFullDialog {
    override fun getDialogLayoutId(): Int {
        return R.layout.dialog_share_book
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, themeResId: Int) : super(context, themeResId)
    constructor(context: Context, cancelable: Boolean, cancelListener: DialogInterface.OnCancelListener?) : super(
        context,
        cancelable,
        cancelListener
    )

    init {
        wx_hy_tv.setOnClickListener { mL?.share(Constant.ShareType.SHARE_TYPE_WX_HY) }
        wx_pyq_tv.setOnClickListener { mL?.share(Constant.ShareType.SHARE_TYPE_WX_PYQ) }
        qq_tv.setOnClickListener { mL?.share(Constant.ShareType.SHARE_TYPE_QQ) }
        cancel_btn.setOnClickListener { dismiss() }
    }

    //设置图片的二维码
    fun setData() {

    }

    private var mL: ShareListener? = null

    fun setShareListener(l: ShareListener) {
        mL = l
    }

    interface ShareListener {
        fun share(@Constant.ShareType shareType: Int)
    }


}

