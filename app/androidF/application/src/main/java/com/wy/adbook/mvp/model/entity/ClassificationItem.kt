package com.wy.adbook.mvp.model.entity

import com.wy.adbook.mvp.model.entity.book.Book
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019/5/5.
 */
class ClassificationItem : Serializable {

    @SerializedName("adCategory")
    var classificationName: String = ""

    fun getCategoryListName(): String {
        val builder = StringBuilder()
        categoryList?.forEachIndexed { index, category ->
            builder.append(category)
            if (index < categoryList?.size ?: 0)
                builder.append("|")
        }
        return builder.toString()
    }

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("sexType")
    var sexType: String = ""

    @SerializedName("bookNum")
    var bookNum: Int = 0

    @SerializedName("topBook")
    var topBook: Book? = null

    @SerializedName("childCategoryList")
    var categoryList: MutableList<String>? = null

//    class Category : Serializable {
//        @SerializedName("category")
//        var category: String = ""
//        @SerializedName("className")
//        var className: String = ""
//        @SerializedName("id")
//        var id: Int = 0
//    }

}