package com.freebookqy.application.mvp.model.entity.accout

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-12.
 */
class PersonalCenterPage : Serializable {

    /*
    {
    "banners": [
      "string"
    ],
    "modules": [
      {
        "direction": "string",
        "directionPath": "string",
        "mainTitle": "string",
        "mainTitleColor": "string",
        "picUrl": "string",
        "subTitle": "string",
        "subTitleColor": "string",
        "threeTitle": "string",
        "threeTitleColor": "string"
      }
    ],
    "walletRedDot": 0
  }
     */

    @SerializedName("banners")
    var banners: MutableList<String>? = null

    @SerializedName("modules")
    var modules: MutableList<PersonalCenterModule>? = null

    @SerializedName("walletRedDot")
    var walletRedDot: Int = 0

}

class PersonalCenterModule : Serializable {
    @SerializedName("direction")
    var direction: String = ""
    @SerializedName("directionPath")
    var directionPath: String = ""

    @SerializedName("mainTitle")
    var mainTitle: String = ""
    @SerializedName("mainTitleColor")
    var mainTitleColor: String = ""

    @SerializedName("picUrl")
    var picUrl: String = ""

    @SerializedName("subTitle")
    var subTitle: String = ""
    @SerializedName("subTitleColor")
    var subTitleColor: String = ""
    @SerializedName("threeTitle")
    var threeTitle: String = ""

    @SerializedName("threeTitleColor")
    var threeTitleColor: String = ""
}