package com.freebookqy.imp

import android.view.View

/**
 * Created by leafye on 2019-05-22.
 */

abstract class OnMultiClickListener : View.OnClickListener {

    abstract fun onMultiClick(v: View)

    override fun onClick(v: View) {
        val curClickTime = System.currentTimeMillis()
        if (curClickTime - lastClickTime >= MIN_CLICK_DELAY_TIME) {
            lastClickTime = curClickTime
            onMultiClick(v)
        }
    }

    companion object {

        private const val MIN_CLICK_DELAY_TIME = 400
        private var lastClickTime: Long = 0
    }
}