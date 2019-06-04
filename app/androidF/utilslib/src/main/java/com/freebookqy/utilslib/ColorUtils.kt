package com.freebookqy.utilslib

import android.graphics.Color
import android.support.annotation.ColorInt

/**
 * Created by leafye on 2019-05-15.
 */
object ColorUtils {

    @ColorInt
    fun getColorInt(colorStr: String, @ColorInt defColor: Int): Int {
        try {
            return Color.parseColor(colorStr)
        } catch (e: IllegalArgumentException) {

        } catch (e: Exception) {

        }
        return defColor
    }

}