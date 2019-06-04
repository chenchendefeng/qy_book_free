package com.wy.adbook.mvp.model.entity

import com.wy.adbook.app.base.BaseEntity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-21.
 */
class NetBanner : BaseEntity<MutableList<BannerItem>>()

class BannerItem : Serializable {
    /*
    "associatedId": "3",
      "beginTime": "2019-05-09 14:07:58",
      "bgColor": "https://qy-pic.oss-cn-shenzhen.aliyuncs.com/banner/a_banner5_bg.png",
      "channel": "200",
      "createTime": "2019-05-17 17:32:58",
      "endTime": "2019-12-31 15:08:09",
      "id": "4",
      "img": "https://qy-pic.oss-cn-shenzhen.aliyuncs.com/banner/a_banner_5.png",
      "orderIndex": 0,
      "position": "recommend",
      "type": "app",
      "updateTime": "2019-05-17 17:32:58",
      "url": "{\"linkType\":\"app\",\"url\":\"rewardCode\"}",
      "validStatus": 1
     */

    @SerializedName("url")
    var url: String = ""

    @SerializedName("img")
    var img: String = ""


}