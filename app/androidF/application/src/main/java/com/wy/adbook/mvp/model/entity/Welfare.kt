package com.wy.adbook.mvp.model.entity

import com.google.gson.annotations.SerializedName
import com.wy.adbook.app.base.BaseEntity
import java.io.Serializable

/**
 * Created by leafye on 2019-05-15.
 */
class NetWelfare : BaseEntity<Welfare>()

class Welfare : Serializable {
    /**
     * 日常福利
     */
    @SerializedName("dailyList")
    var dailyList: MutableList<WelfareItem>? = null
    /**
     * 新人福利
     */
    @SerializedName("noviceList")
    var noviceList: MutableList<WelfareItem>? = null
    /**
     * 阅读福利
     */
    @SerializedName("readList")
    var readList: MutableList<WelfareItem>? = null


}