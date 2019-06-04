package com.wy.adbook.mvp.model.entity

import com.wy.adbook.app.base.BaseEntity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-20.
 */
class NetStartPage : BaseEntity<StartPage>()

class StartPage : Serializable {

    /*
    {
        "beginDate": "2019-05-20T11:08:23.245Z",
        "channelCodes": "string",
        "clientType": "string",
        "endDate": "2019-05-20T11:08:23.245Z",
        "fileType": "string",
        "fileUrl": "string",
        "id": 0,
        "status": 0
      }
     */
    /**
     * 有效期-开始时间
     */
    @SerializedName("beginDate")
    var beginDate: String = ""
    /**
     * 渠道编号array ( 多个渠道号用","分隔 )
     */
    @SerializedName("channelCodes")
    var channelCodes: String = ""
    /**
     * 渠道编号array ( 多个渠道号用","分隔 )
     */
    @SerializedName("clientType")
    var clientType: String = ""
    /**
     * 有效期-结束时间
     */
    @SerializedName("endDate")
    var endDate: String = ""
    /**
     * 文件类型 （ pic-图片 | gif-动图 | video-视频 )
     */
    @SerializedName("fileType")
    var fileType: String = ""
    /**
     * 文件地址
     */
    @SerializedName("fileUrl")
    var fileUrl: String = ""
    /**
     *
     */
    @SerializedName("id")
    var id: Int = 0
    /**
     * 是否启用 （ 1-启用 | 0-停用 ）
     */
    @SerializedName("status")
    var status: Int = 0
}