package com.wy.adbook.mvp.model.entity

import com.wy.adbook.app.base.BaseEntity
import com.wy.adbook.mvp.model.entity.book.Book
import com.google.gson.annotations.SerializedName

/**
 * Created by leafye on 2019/5/5.
 */
class NetBookcase : BaseEntity<Bookcase>()

class Bookcase {
    /*
{
"count": 0,
"data": [],
"otherData": [],
"pageNo": 1,
"pageSize": 20,
"pages": 0
}
*/
    @SerializedName("count")
    var count: Int = 0

    @SerializedName("data")
    var data: MutableList<Book>? = null

    @SerializedName("otherData")
    var otherData: MutableList<Book>? = null

    @SerializedName("pageNo")
    var pageNo: Int = 0

    @SerializedName("pageSize")
    var pageSize: Int = 0

    @SerializedName("pages")
    var pages: Int = 0

    override fun toString(): String {
        return "NetBookcase(count=$count, data=$data, otherData=$otherData, pageNo=$pageNo, pageSize=$pageSize, pages=$pages)"
    }
}