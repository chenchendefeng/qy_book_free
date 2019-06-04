package com.wy.adbook.mvp.model.entity

import android.support.annotation.ColorInt
import com.freebookqy.application.R
import com.freebookqy.utilslib.ColorUtils
import com.freebookqy.utilslib.ResUtils
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-15.
 */
class WelfareItem : Serializable {
    /*
    {
        "buttonTex": "日常福利",
        "iconTex": "日常福利",
        "mainTitle": "日常福利",
        "mainTitleColor": "#333",
        "maxNum": 30,
        "minNum": 3,
        "rewardType": "rmb",
        "skipPage": "",
        "skipType": "app",
        "subTitle": "日常福利",
        "subTitleColor": "#333",
        "type": "daily"
      }
     */

    /**
     * 按钮文案
     */
    @SerializedName("buttonTex")
    var buttonTex: String = ""
    /**
     * 图标文案
     */
    @SerializedName("iconTex")
    var iconTex: String = ""
    /**
     * 主标题
     */
    @SerializedName("mainTitle")
    var mainTitle: String = ""
    /**
     * 主标题字色
     */
    @SerializedName("mainTitleColor")
    var mainTitleColor: String = ""
    /**
     * 最大数
     */
    @SerializedName("maxNum")
    var maxNum: Int = 0
    /**
     * 最小数
     */
    @SerializedName("minNum")
    var minNum: Int = 0
    /**
     * 奖励类型（rmb:人民币，gold:金豆）
     */
    @SerializedName("rewardType")
    var rewardType: String = ""
    /**
     * 跳转地址
     */
    @SerializedName("skipPage")
    var skipPage: String = ""
    /**
     * 跳转类型(app,h5）
     */
    @SerializedName("skipType")
    var skipType: String = ""
    /**
     * 副标题
     */
    @SerializedName("subTitle")
    var subTitle: String = ""
    /**
     * 副标题字色
     */
    @SerializedName("subTitleColor")
    var subTitleColor: String = ""
    /**
     * 类型(novice:新手;read:阅读；daily：日常）
     */
    @SerializedName("type")
    var type: String = ""

    @ColorInt
    fun getMainTitleColorInt(): Int {
        return ColorUtils.getColorInt(
            mainTitleColor,
            ResUtils.getColor(R.color.black_text_color)
        )
    }

    @ColorInt
    fun getSubTitleColor(): Int {
        return ColorUtils.getColorInt(
            subTitleColor,
            ResUtils.getColor(R.color.second_black_text_color)
        )
    }


}