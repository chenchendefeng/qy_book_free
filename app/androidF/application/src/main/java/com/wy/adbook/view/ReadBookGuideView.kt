package com.wy.adbook.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.FrameLayout
import com.freebookqy.application.R
import com.wy.adbook.ext.onClick

/**
 * Created by leafye on 2019/5/7.
 */
class ReadBookGuideView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    var isAnim = false

    private var callback: DismissCallback? = null

    init {
        View.inflate(context, R.layout.view_read_book_guide, this)
        onClick {
            //关闭界面
            closeView()
        }
    }


    @Synchronized
    private fun closeView() {
        if (isAnim) return
        val alphaAnimation = AlphaAnimation(1F, 0F).apply {
            duration = 500
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(animation: Animation?) {

                }

                override fun onAnimationEnd(animation: Animation?) {
                    isAnim = false
                    clearAnimation()
                    visibility = View.GONE
                    callback?.dismiss()
                }

                override fun onAnimationStart(animation: Animation?) {
                    isAnim = true
                }
            })
        }
        startAnimation(alphaAnimation)
    }

    fun setDismissCallback(c: DismissCallback) {
        callback = c
    }

    interface DismissCallback {
        fun dismiss()
    }

}