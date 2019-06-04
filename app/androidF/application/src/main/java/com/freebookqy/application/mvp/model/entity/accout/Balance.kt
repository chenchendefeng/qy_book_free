package com.freebookqy.application.mvp.model.entity.accout

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-12.
 */
class Balance : Serializable {

    /*
    {
    "goldBalance": 0,
    "rmbTotal": 0,
    "rmbalance": 0
  }
     */
    /**
     * 金币余额
     */
    @SerializedName("goldBalance")
    var goldBalance: Int = 0
    /**
     * 人民币总额
     */
    @SerializedName("rmbTotal")
    var rmbTotal: Int = 0
    /**
     * 人民币余额
     */
    @SerializedName("rmbalance")
    var rmbalance: Int = 0

}