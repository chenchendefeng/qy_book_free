package com.freebookqy.application.mvp.model.entity

import com.freebookqy.application.mvp.model.entity.book.Book
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019/5/5.
 */
class GuessYouLike : Serializable {

    @SerializedName("count")
    var count: Int = 0

    @SerializedName("data")
    var bookList: MutableList<Book>? = null

    /*
    "otherData": [],
    "pageNo": 1,
    "pageSize": 2,
    "pages": 252
     */
    //@SerializedName("otherData")

    @SerializedName("pageNo")
    var pageNo: Int = 0
    @SerializedName("pageSize")
    var pageSize: Int = 0
    @SerializedName("pages")
    var pages: Int = 0

}