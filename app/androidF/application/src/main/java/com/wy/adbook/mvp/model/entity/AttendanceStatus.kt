package com.wy.adbook.mvp.model.entity

import com.wy.adbook.app.base.BaseEntity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-23.
 */


class AttendanceStatus : Serializable {
    /*
     {
    "afterCompensateTimes": 0,
    "goldAmount": "100",
    "isFrist": 1,
    "maxAmount": "10000",
    "missedTimes": 0,
    "status": 0,
    "times": 0
  }
     */
    /**
     * 补签后连续次数
     */
    @SerializedName("afterCompensateTimes")
    var afterCompensateTimes: Int = 0
    /**
     * 奖励金额
     */
    @SerializedName("goldAmount")
    var goldAmount: Int = 0
    /**
     * 是否首签
     * 0：否；1:是
     */
    @SerializedName("isFrist")
    var isFrist: Int = 0
    /**
     * 最大奖励
     */
    @SerializedName("maxAmount")
    var maxAmount: Int = 0
    /**
     * 漏签次数
     */
    @SerializedName("missedTimes")
    var missedTimes: Int = 0
    /**
     * 状态：0：未签；1：已签
     */
    @SerializedName("status")
    var status: Int = 0
    /**
     * 连续签到次数
     */
    @SerializedName("times")
    var times: Int = 0
}

class NetAttendanceStatus : BaseEntity<AttendanceStatus>()