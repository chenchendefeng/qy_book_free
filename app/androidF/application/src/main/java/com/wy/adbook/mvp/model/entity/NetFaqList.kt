package com.wy.adbook.mvp.model.entity

import com.google.gson.annotations.SerializedName
import com.wy.adbook.app.base.BaseEntity
import java.io.Serializable

/**
 * Created by leafye on 2019-05-28.
 */
class NetFaqList : BaseEntity<FaqList>()

class FaqList : Serializable {
    @SerializedName("count")
    var count: Int = 0
    @SerializedName("pageNo")
    var pageNo: Int = 1

    @SerializedName("pages")
    var pages: Int = 0

    @SerializedName("data")
    var faqItemList: MutableList<FaqItem>? = null

}

class FaqItem : Serializable {
    /**
     * 是否展开
     */
    var isOpen = false

    @SerializedName("answer")
    var answer: String = ""
    @SerializedName("question")
    var question: String = ""
}