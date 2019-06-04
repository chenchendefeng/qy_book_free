package com.wy.adbook.mvp.model.entity.accout

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
     * 类型（firstSign:首签；dailySign：日常；continuitySign：连续）
     */
    @SerializedName("type")
    var type: String = ""

}