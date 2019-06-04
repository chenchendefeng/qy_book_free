package com.freebookqy.application.mvp.model.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-15.
 */
class Welfare : Serializable {

    @SerializedName("dailyList")
    var dailyList: MutableList<WelfareItem>? = null

    @SerializedName("noviceList")
    var noviceList: MutableList<WelfareItem>? = null

    @SerializedName("readList")
    var readList: MutableList<WelfareItem>? = null


}