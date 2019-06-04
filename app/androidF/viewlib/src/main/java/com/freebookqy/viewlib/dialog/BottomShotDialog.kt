package com.freebookqy.viewlib.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.view.*
import android.widget.TextView
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.utilslib.ScreenUtils
import com.freebookqy.viewlib.R
import com.freebookqy.viewlib.simplelistener.SimpleTouchListener
import kotlinx.android.synthetic.main.dialog_bottom_shot.*

/**
 * Created by leafye on 2019-05-21.
 */
class BottomShotDialog private constructor(context: Context) : Dialog(context) {

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_bottom_shot)
        window?.let {
            it.setWindowAnimations(R.style.dialogWindowAnim)
            it.setBackgroundDrawableResource(android.R.color.transparent)
            val lp = it.attributes
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.MATCH_PARENT
            it.attributes = lp
        }
        setOutTouch()
        cancel_btn.setOnClickListener {
            dismiss()
            mCancelL?.cancel()
        }
    }

    var isTouchOutCancel: Boolean = true

    var isShowCancel: Boolean = true

    private var mCancelL: OnCancelListener? = null

    private fun setOutTouch() {
        bg.setOnTouchListener(object : SimpleTouchListener() {
            override fun touchEnable() {
                if (isTouchOutCancel)
                    dismiss()
            }
        })
    }

    fun setShowCancelBtn(isShowCancel: Boolean) {
        this.isShowCancel = isShowCancel
        cancel_btn.visibility = if (this.isShowCancel) View.VISIBLE else View.GONE
    }

    fun setCancelL(l: OnCancelListener?) {
        mCancelL = l
    }

    fun addItemList(itemList: MutableList<Item>) {
        content_container.removeAllViews()
        itemList.forEach { item ->
            val textView = TextView(context).apply {
                textSize = 16F
                setBackgroundColor(ResUtils.getColor(R.color.read_theme_white))
                gravity = Gravity.CENTER
                layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtils.dpToPx(50))
                text = item.text
                setTextColor(item.colorInt)
                setOnClickListener {
                    dismiss()
                    item.click?.onClick(this@apply)
                }
            }
            content_container.addView(textView)
        }
    }

    class Builder {

        private val itemList = mutableListOf<Item>()

        private var isShowCancel = true

        private var isTouchOutCancel = true

        private var isBackpressCancel = true

        private var mCancelL: OnCancelListener? = null

        fun addItem(item: Item): Builder {
            itemList.add(item)
            return this
        }

        fun setShowCancel(isShowCancel: Boolean): Builder {
            this.isShowCancel = isShowCancel
            return this
        }

        fun setTouchOutCancel(isTouchOutCancel: Boolean): Builder {
            this.isTouchOutCancel = isTouchOutCancel
            return this
        }

        fun setBackpressCancel(isBackpressCancel: Boolean): Builder {
            this.isBackpressCancel = isBackpressCancel
            return this
        }

        fun cancel(l: OnCancelListener) {
            mCancelL = l
        }

        fun build(context: Context): BottomShotDialog {
            return BottomShotDialog(context).apply {
                setCancelable(isBackpressCancel)
                this.isTouchOutCancel = this@Builder.isTouchOutCancel
                this.isShowCancel = this@Builder.isShowCancel
                setCancelL(mCancelL)
                setShowCancelBtn(isShowCancel)
                addItemList(itemList)
            }
        }
    }

    class Item(
        val text: String,
        var colorInt: Int = Color.parseColor("#292929"),
        var click: View.OnClickListener? = null
    )

    interface OnCancelListener {
        fun cancel()
    }

}