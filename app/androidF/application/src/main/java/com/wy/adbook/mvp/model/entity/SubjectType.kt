package com.wy.adbook.mvp.model.entity

import com.wy.adbook.app.base.BaseEntity
import com.wy.adbook.mvp.model.entity.book.Book
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019/5/5.
 */
class NetSubjectType : BaseEntity<MutableList<SubjectType>>()


class SubjectType : Serializable {

    /**
     * 格式:2019-04-28 08:41:43
     */
    @SerializedName("createTime")
    var createTime: String = ""

    @SerializedName("displayOrder")
    var displayOrder: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("status")
    var status: Int = 0
    /**
     * boy|girl|recommend
     * @link SUBJECT_TYPE_BOY
     * @link SUBJECT_TYPE_GIRL
     * @link SUBJECT_TYPE_RECOMMEND
     */
    @SerializedName("subjectType")
    var subjectType: String = ""

    @SerializedName("title")
    var title: String = ""

    @SerializedName("title2")
    var title2: String = ""

    @SerializedName("title2RGB")
    var title2RGB: String = ""

    @SerializedName("titleRGB")
    var titleRGB: String = ""
    /**
     * 2019-04-28 08:41:45
     */
    @SerializedName("updateTime")
    var updateTime: String = ""

    @SerializedName("bookList")
    var bookList: MutableList<Book>? = null

    @SerializedName("bidList")
    var bidList: MutableList<Int>? = null

    companion object {
        /**
         * 男生
         */
        const val SUBJECT_TYPE_BOY = "boy"
        /**
         * 女生
         */
        const val SUBJECT_TYPE_GIRL = "girl"
        /**
         * 推荐
         */
        const val SUBJECT_TYPE_RECOMMEND = "recommend"

    }

}