package com.freebookqy.application.mvp.model.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019/5/5.
 */
class Classification(var category: String = "") : Serializable {

    var isSelected: Boolean = false

    @SerializedName("pageNo")
    var pageNo: Int = 1

    @SerializedName("pageSize")
    var pageSize: Int = 0

    @SerializedName("pages")
    var pages: Int = 0

    @SerializedName("data")
    var itemList: MutableList<ClassificationItem>? = null

    @SerializedName("count")
    var count: Int = 0

}