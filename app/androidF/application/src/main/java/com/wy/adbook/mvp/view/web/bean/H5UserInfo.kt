package com.wy.adbook.mvp.view.web.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by leafye on 2019-05-27.
 */
class H5UserInfo {

    companion object {

        const val METHOD_NAME = "getUserInfo"

    }

    @SerializedName("uid")
    var uid: Int = 0

    @SerializedName("token")
    var token = ""

}