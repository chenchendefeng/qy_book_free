package com.wy.adbook.mvp.model.entity

import com.google.gson.annotations.SerializedName
import com.wy.adbook.app.base.BaseEntity
import java.io.Serializable

/**
 * Created by leafye on 2019-05-28.
 */

class NetReadFooterPage : BaseEntity<ReadFooterPage>()

class ReadFooterPage : Serializable {

    /**
     * "count": 0,
    "data": [
    {
    "bid": 0,
    "coverImg": "string",
    "createDate": "2019-05-28T09:30:34.121Z",
    "cuId": 0,
    "id": 0,
    "name": "string"
    }
    ],
    "otherData": [
    {
    "bid": 0,
    "coverImg": "string",
    "createDate": "2019-05-28T09:30:34.121Z",
    "cuId": 0,
    "id": 0,
    "name": "string"
    }
    ],
    "pageNo": 0,
    "pageSize": 0,
    "pages": 0
     */
    @SerializedName("count")
    var count: Int = 0
    @SerializedName("pageNo")
    var pageNo: Int = 1
    @SerializedName("pages")
    var pages: Int = 0
    @SerializedName("data")
    var readFooterItemList: MutableList<ReadFooterItem>? = null

}

/**
 * {
"bid": 0,
"coverImg": "string",
"createDate": "2019-05-28T09:30:34.121Z",
"cuId": 0,
"id": 0,
"name": "string"
}
 */
class ReadFooterItem : Serializable {
    @SerializedName("bID")
    var bid: Int = 0
    @SerializedName("coverImg")
    var coverImg: String = ""
    @SerializedName("createDate")
    var createDate: String = ""
    @SerializedName("cuId")
    var cuId: Int = 0
    @SerializedName("name")
    var name: String = ""
}