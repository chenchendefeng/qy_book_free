package com.freebookqy.application.mvp.model.entity

import com.freebookqy.application.mvp.model.entity.book.Book
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019/5/7.
 */
class TogetherRead : Serializable {
    /*
    "count": 0,
    "data": [],
    "otherData": [],
    "pageNo": 1,
    "pageSize": 3,
    "pages": 0
     */
    @SerializedName("count")
    var count: Int = 0

    @SerializedName("data")
    var bookList: MutableList<Book>? = null

    @SerializedName("otherData")
    var otherData: MutableList<Book>? = null

    @SerializedName("pageNo")
    var pageNo: Int = 0

    @SerializedName("pageSize")
    var pageSize: Int = 0

    @SerializedName("pages")
    var pages: Int = 0


}