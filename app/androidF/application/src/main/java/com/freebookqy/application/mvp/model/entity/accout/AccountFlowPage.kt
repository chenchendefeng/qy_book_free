package com.freebookqy.application.mvp.model.entity.accout

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-12.
 */
class AccountFlowPage : Serializable {

    @SerializedName("count")
    var count: Int = 0

    @SerializedName("data")
    var data: MutableList<FlowItem>? = null

    @SerializedName("otherData")
    var otherData: MutableList<FlowItem>? = null


    /*
    {
        "amount": 0,
        "currencyType": "string",
        "img": "string",
        "title": "string"
      }
     */

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

}