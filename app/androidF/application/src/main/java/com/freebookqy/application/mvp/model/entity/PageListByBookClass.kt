package com.freebookqy.application.mvp.model.entity

import com.freebookqy.application.mvp.model.entity.book.Book
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-10.
 */
class PageListByBookClass : Serializable {

    /*
        "otherData": [],
    "pageNo": 1,
    "pageSize": 10,
    "pages": 1
     */

    @SerializedName("pageNo")
    var pageNo: Int = 1

    @SerializedName("pageSize")
    var pageSize: Int = 0

    @SerializedName("pages")
    var pages: Int = 0

    @SerializedName("data")
    var bookList: MutableList<Book>? = null


}