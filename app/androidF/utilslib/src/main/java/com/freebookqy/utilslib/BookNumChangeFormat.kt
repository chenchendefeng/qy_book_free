package com.freebookqy.utilslib

/**
 * Created by leafye on 2019/5/7.
 */
class BookNumChangeFormat {
    companion object {

        fun formatBookNum(num: Int): String {
            return if (num > 10000) {
                "" + num / 10000 + "万"
            } else {
                "" + num
            }

        }


    }
}