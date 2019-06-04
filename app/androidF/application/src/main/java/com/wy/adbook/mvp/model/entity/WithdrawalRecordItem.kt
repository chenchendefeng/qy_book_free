package com.wy.adbook.mvp.model.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-29.
 */
class WithdrawalRecordItem:Serializable{

    @SerializedName("status")
    var status:Int = 0

    @SerializedName("amount")
    var amount:Int = 0

    @SerializedName("time")
    var time:String = ""

}