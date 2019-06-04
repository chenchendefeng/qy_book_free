package com.wy.adbook.dialog.prompt

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.freebookqy.application.R
import com.freebookqy.utilslib.SpanUtils
import com.wy.adbook.ext.gif
import com.wy.adbook.ext.onClick
import kotlinx.android.synthetic.main.dialog_view_sign_success_prompt.view.*

/**
 * Created by leafye on 2019-05-20.
 * 签到成功提示
 */
class SignSuccessPromptView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        View.inflate(context, R.layout.dialog_view_sign_success_prompt, this)
        watch_video_btn.onClick { mL?.watchVideo() }
        watch_video_btn.gif(R.mipmap.gif_sign_success_pop_btn)
        center_iv.gif(R.mipmap.gif_sign_success_pop_center)
    }

    fun setData(goldGet: Int) {
        setGoldGetTv(goldGet)
    }

    fun setGoldGetTv(goldGet: Int) {
        gold_get_tv.text = SpanUtils()
            .append("签到成功，获").setFontSize(14, true)
            .append("$goldGet").setFontSize(27, true)
            .append("金豆").setFontSize(14, true)
            .create()
    }

    private var mL: SignSuccessPromptListener? = null

    fun setSignSuccessPromptListener(l: SignSuccessPromptListener) {
        this.mL = l
    }

    interface SignSuccessPromptListener {
        fun watchVideo()
    }

}