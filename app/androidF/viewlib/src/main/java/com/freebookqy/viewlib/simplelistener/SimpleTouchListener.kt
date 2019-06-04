package com.freebookqy.viewlib.simplelistener

import android.view.MotionEvent
import android.view.View

/**
 * Created by leafye on 2019-05-09.
 */
abstract class SimpleTouchListener() :
    View.OnTouchListener {

    private var downX: Float = 0F
    private var downY: Float = 0F

    override fun onTouch(view: View?, event: MotionEvent?): Boolean {
        val e = event ?: return false
        when (e.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = e.x
                downY = e.y
            }
            MotionEvent.ACTION_UP -> {
                val absX = Math.abs(e.x - downX)
                val absY = Math.abs(e.y - downY)
                if (absX < 10 && absY < 10) {
                    touchEnable()
                }
            }
        }
        return true
    }

    abstract fun touchEnable()

}