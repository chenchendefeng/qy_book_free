package com.wy.adbook.dialog.share

import android.content.Context
import android.graphics.Bitmap
import com.freebookqy.application.R
import com.wy.adbook.ext.loadImage
import com.wy.adbook.ext.onClick
import com.freebookqy.utilslib.ViewUtils
import kotlinx.android.synthetic.main.dialog_share_book.*

/**
 * Created by leafye on 2019-05-10.
 */
class ShareBookDialog : ShareDialog {
    override fun getDialogLayoutId(): Int {
        return R.layout.dialog_share_book
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, themeResId: Int) : super(context, themeResId)

    init {
        cancel_btn.onClick { dismiss() }
    }

    //设置图片的二维码
    fun setData(code: String, imgUrl: String) {
        share_center_iv.loadImage(imgUrl)
        red_package_tv.text = code
    }

    fun getShareBitmap(): Bitmap {
        return ViewUtils.getBitmap(center_container)
    }


}

