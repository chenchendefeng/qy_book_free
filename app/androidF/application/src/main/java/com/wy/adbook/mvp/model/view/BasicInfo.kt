package com.wy.adbook.mvp.model.view

import android.support.annotation.IntDef

/**
 * Created by leafye on 2019-05-30.
 */
class BasicInfo(
    var title: String = "",
    var content: String = "",
    var imageUrl: String = "",
    var isShowTopLine: Boolean = false,
    var isEnter: Boolean = true,
    @Type var type: Int
) {

    @IntDef(
        Type.TYPE_HEAD,
        Type.TYPE_NICKNAME,
        Type.TYPE_GENDER,
        Type.TYPE_ACCOUNT
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class Type {

        companion object {

            const val TYPE_HEAD = 0
            const val TYPE_NICKNAME = 1
            const val TYPE_GENDER = 2
            const val TYPE_ACCOUNT = 3
        }

    }


}