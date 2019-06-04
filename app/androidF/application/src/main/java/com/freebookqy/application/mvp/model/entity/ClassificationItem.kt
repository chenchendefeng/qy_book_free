package com.freebookqy.application.mvp.model.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019/5/5.
 */
class ClassificationItem : Serializable {

    @SerializedName("url")
    var classificationCoverUrl: String = ""

    @SerializedName("className")
    var classificationName: String = ""

    fun getCategoryListName(): String {
        val builder = StringBuilder()
        categoryList?.forEachIndexed { index, category ->
            builder.append(category.className)
            if (index < categoryList?.size ?: 0)
                builder.append("|")
        }
        return builder.toString()
    }

    @SerializedName("")
    var bookNum: Int = 0

    @SerializedName("categoryList")
    var categoryList: MutableList<Category>? = null

    class Category : Serializable {
        @SerializedName("category")
        var category: String = ""
        @SerializedName("className")
        var className: String = ""
        @SerializedName("id")
        var id: Int = 0
    }

}