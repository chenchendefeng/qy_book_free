package com.wy.adbook.app.utils

import com.wy.adbook.ext.toIntS
import java.util.*

/**
 * Created by leafye on 2019-05-17.
 */
object TimeUtils {
    /**
     * xxxx-xx-xx
     */
    fun getCalender(date: String): Calendar {
        val split = date.split("-")
        val instance = Calendar.getInstance()
        if (split.size == 3) {
            try {
                instance.set(Calendar.YEAR, split[0].toIntS())
                instance.set(Calendar.MONTH, split[1].toIntS() - 1)
                instance.set(Calendar.DAY_OF_MONTH, split[2].toIntS())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return instance
    }

    /**
     * 获取月份int
     */
    fun getMonthInt(date: String): Int {
        val split = date.split("-")
        if (split.size == 3) {
            return split[1].toIntS()
        }
        return 0
    }

    fun getDayInt(date: String): Int {
        val split = date.split("-")
        if (split.size == 3) {
            return split[2].toIntS()
        }
        return 0
    }

}