package com.wy.adbook.mvp.model.entity.accout

import com.google.gson.annotations.SerializedName
import com.wy.adbook.app.base.BaseEntity
import com.wy.adbook.app.manager.QYAccount
import java.io.Serializable

/**
 * Created by leafye on 2019-05-10.
 */
class NetUserInfo : BaseEntity<UserInfo>()

class UserInfo : Serializable {


    @SerializedName("address")
    var address: String = ""

    @SerializedName("avatar")
    var avatar: String = ""

    @SerializedName("bindOpenid")
    var bindOpenid: String = ""

    @SerializedName("bindPhone")
    var bindPhone: String = ""

    @SerializedName("bindQq")
    var bindQq: String = ""

    @SerializedName("bindSource")
    var bindSource: Int = 0

    @SerializedName("cuId")
    var cuId: Int = 0

    @SerializedName("token")
    var token = QYAccount.getUserToken()
    /**
     * 2019-05-28T08:52:17.050Z
     */
    @SerializedName("freeAdvTime")
    var freeAdvTime = ""

    @SerializedName("vipEndDate")
    var vipEndDate = ""

    @SerializedName("vipFlag")
    var vipFlag = ""

    @SerializedName("vipStartDate")
    var vipStartDate = ""

    @SerializedName("cuName")
    var cuName: String = ""

    @SerializedName("imei")
    var imei: String = ""

    @SerializedName("nickName")
    var nickName: String = ""

    @SerializedName("password")
    var password: String = ""

    @SerializedName("phoneModel")
    var phoneModel: String = ""
    /**
     * format :2019-05-10 18:00:47
     */
    @SerializedName("regDate")
    var regDate: String = ""

    @SerializedName("regVersion")
    var regVersion: String = ""

    @SerializedName("registChannel")
    var registChannel: String = ""

    @SerializedName("sex")
    var sex: Int = -1

    @SerializedName("source")
    var source: String = ""

    @SerializedName("userStatus")
    var userStatus: String = ""

    @SerializedName("userType")
    var userType: String = ""

    @SerializedName("invitationCode")
    var invitationCode:String = ""

    /*
 {
 "userInfo": {
   "address": "",
   "avatar": "http://qy-pic.oss-cn-shenzhen.aliyuncs.com/head/default.png",
   "bindOpenid": "",
   "bindPhone": "18588268421",
   "bindQq": "",
   "bindSource": 0,
   "cuId": "118815",
   "cuName": "18588268421",
   "imei": "",
   "nickName": "爱读8421",
   "password": "",
   "phoneModel": "",
   "regDate": "2019-05-10 18:00:47",
   "regVersion": "",
   "registChannel": "",
   "sex": 3,
   "source": "Android",
   "userStatus": "normal",
   "userType": "register"
 },
 "userToken": "b83cdfd1b60fb3dacfdcebfedee7c760",
 "isRegister": true
}
  */


}