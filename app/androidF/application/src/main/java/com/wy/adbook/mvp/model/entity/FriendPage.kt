package com.wy.adbook.mvp.model.entity

import com.google.gson.annotations.SerializedName
import com.wy.adbook.app.base.BaseEntity
import java.io.Serializable

/**
 * Created by leafye on 2019-05-29.
 */
class NetFriendPage : BaseEntity<FriendPage>()

class FriendPage : Serializable {

    @SerializedName("count")
    var count: Int = 0
    @SerializedName("pageNo")
    var pageNo: Int = 0

    @SerializedName("pageSize")
    var pageSize = 0

    @SerializedName("data")
    var friendList: MutableList<FriendItem>? = null

}

class FriendItem : Serializable {
    /*
    {
        "avatar": "string",
        "cuId": 0,
        "identifier": "string",
        "nickName": "string",
        "notifyStatus": 0,
        "timeMsg": "string",
        "upTime": "2019-05-29T09:17:19.939Z"
      }
     */
    @SerializedName("avatar")
    var avatar: String = ""
    @SerializedName("cuId")
    var cuId: Int = 0

    @SerializedName("identifier")
    var identifier: String = ""
    @SerializedName("nickName")
    var nickName: String = ""
    @SerializedName("notifyStatus")
    var notifyStatus: Int = 0
    @SerializedName("timeMsg")
    var timeMsg: String = ""
    @SerializedName("upTime")
    var upTime: String = ""


}