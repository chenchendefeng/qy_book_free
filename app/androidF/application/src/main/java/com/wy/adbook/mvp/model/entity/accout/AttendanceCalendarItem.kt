package com.wy.adbook.mvp.model.entity.accout

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-16.
 * 签到日历item
 */
class AttendanceCalendarItem : Serializable {


    /**
     * 补签状态
     */
    @SerializedName("compensateStatus")
    var compensateStatus: Int = 0
    /**
     * 格式:2019-05-15
     */
    @SerializedName("date")
    var date: String = ""
    /**
     * 签到状态
     */
    @SerializedName("status")
    var status: Int = 0

}