package com.wy.adbook.dialog.prompt

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.freebookqy.application.R
import com.wy.adbook.app.manager.Config
import com.wy.adbook.ext.onClick
import com.freebookqy.utilslib.ResUtils
import kotlinx.android.synthetic.main.dialog_view_retroactive_prompt.view.*

/**
 * Created by leafye on 2019-05-20.
 * 补签提示对话框
 */
class RetroactivePromptView : LinearLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    init {
        View.inflate(context, R.layout.dialog_view_retroactive_prompt, this)
        val consumptionGoldBeans = Config.getWelefareConfig().getRetroactiveConsumptionGoldBeans()
        gold_beans_retroactive_btn.text = ResUtils.getString(R.string.n_gold_beans_retroactive, consumptionGoldBeans)
        watch_video_for_retroactive_btn.onClick { mL?.watchVideo() }
        gold_beans_retroactive_btn.onClick { mL?.goldBeans() }
    }


    fun setData(isWatchVideoForRetroactive: Boolean) {
        watch_video_for_retroactive_btn.visibility = if (isWatchVideoForRetroactive) View.INVISIBLE else View.VISIBLE
    }

    private var mL: RetroactivePromptListener? = null

    fun setData(contentStr: String) {
        content.text = contentStr
    }


    fun setRetroactivePromptListener(l: RetroactivePromptListener) {
        this.mL = l
    }

    interface RetroactivePromptListener {

        fun watchVideo()

        fun goldBeans()

    }

}