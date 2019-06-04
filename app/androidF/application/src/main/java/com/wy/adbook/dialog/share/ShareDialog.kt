package com.wy.adbook.dialog.share

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import com.freebookqy.application.R
import com.freebookqy.viewlib.dialog.BaseFullDialog
import com.freebookqy.viewlib.simplelistener.SimpleTouchListener
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.mvp.view.adapter.ShareItem
import com.wy.adbook.mvp.view.adapter.ShareItemAdapter
import kotlinx.android.synthetic.main.dialog_share_view.*
import kotlinx.android.synthetic.main.layout_share.*

/**
 * Created by leafye on 2019-05-20.
 */
open class ShareDialog : BaseFullDialog {
    override fun getDialogLayoutId(): Int = R.layout.dialog_share_view

    constructor(context: Context) : super(context)
    constructor(context: Context, themeResId: Int) : super(context, themeResId)

    init {
        window?.setWindowAnimations(R.style.dialogWindowAnim)

        bg?.setOnTouchListener(object : SimpleTouchListener() {
            override fun touchEnable() {
                dismiss()
            }
        })
    }

    fun setData(list: MutableList<ShareItem>) {
        if (share_rv.layoutManager ==null){
            share_rv.layoutManager = GridLayoutManager(context, 3)
            share_rv.adapter = adapter
        }
        adapter.setNewData(list)
    }

    val adapter by lazy {
        ShareItemAdapter(null).apply {
            setOnItemClickListener { adapter, view, position ->
                val shareItem = adapter.data[position] as ShareItem
                mL?.share(this@ShareDialog, shareItem.type)
            }
        }
    }



    private var mL: ShareListener? = null

    fun setShareListener(l: ShareListener) {
        mL = l
    }
}