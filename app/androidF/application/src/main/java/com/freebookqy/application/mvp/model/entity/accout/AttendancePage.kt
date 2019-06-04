package com.freebookqy.application.mvp.model.entity.accout

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-16.
 */
class AttendancePage : Serializable {
    /**
     * 签到日历
     */
    @SerializedName("attendanceCalendar")
    var attendanceCalendar: MutableList<AttendanceCalendarItem>? = null
    /**
     * 签到天数奖励
     */
    @SerializedName("rewardList")
    var rewardList: MutableList<RewardItem>? = null

}

