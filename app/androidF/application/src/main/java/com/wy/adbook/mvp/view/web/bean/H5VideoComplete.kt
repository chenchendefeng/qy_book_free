package com.wy.adbook.mvp.view.web.bean

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-27.
 */
class H5VideoComplete : Serializable {

    companion object {
        const val METHOD_NAME = "viewVideo"
    }

    @SerializedName("complete")
    var complete = false


}