package com.freebookqy.application.mvp.model.entity.accout

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-16.
 */
class RewardItem : Serializable {

    /*
     {
        "days": 1,
        "gold": "100",
        "type": "firstSign"
      }
     */

    @SerializedName("days")
    var days: Int = 0

    @SerializedName("gold")
    var gold: String = ""
    /**
     * 值的类型:firstSign|continuitySign
     */
    @SerializedName("type")
    var type: String = ""

}