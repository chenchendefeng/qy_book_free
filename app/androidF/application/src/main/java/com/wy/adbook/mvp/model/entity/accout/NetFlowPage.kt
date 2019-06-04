package com.wy.adbook.mvp.model.entity.accout

import com.google.gson.annotations.SerializedName
import com.wy.adbook.app.base.BaseEntity
import java.io.Serializable

/**
 * Created by leafye on 2019-05-12.
 */

class NetFlowPage : BaseEntity<FlowPage>()

class FlowPage : Serializable {
    @SerializedName("count")
    var count: Int = 0

    @SerializedName("data")
    var data: MutableList<FlowItem>? = null

    @SerializedName("otherData")
    var otherData: MutableList<FlowItem>? = null

    @SerializedName("pageNo")
    var pageNo: Int = 1

    @SerializedName("pages")
    var pages: Int = 0
}

class FlowItem : Serializable {
    @SerializedName("amount")
    var amount: Int = 0
    @SerializedName("currencyType")
    var currencyType: String = ""
    @SerializedName("img")
    var img: String = ""

    @SerializedName("title")
    var title: String = ""
}