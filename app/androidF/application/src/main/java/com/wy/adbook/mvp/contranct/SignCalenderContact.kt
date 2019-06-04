package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.NetAttendanceStatus
import com.wy.adbook.mvp.model.entity.NetCompensateChance
import com.wy.adbook.mvp.model.entity.NetVideoForGole
import com.wy.adbook.mvp.model.entity.accout.NetAttendancePage
import com.wy.adbook.mvp.model.entity.accout.NetCompensateSign
import com.wy.adbook.mvp.model.entity.accout.NetSign
import com.wy.adbook.view.status.IStatusCoverView
import io.reactivex.Observable

/**
 * Created by leafye on 2019-05-08.
 */
interface SignCalenderContract {

    interface View : QYView {
        fun refreshView()

        fun setRefreshStatus(isRefresh: Boolean)
        /**
         * 显示签到成功对话框
         */
        fun showSignSuccessDialog()

        fun changeStatus(status: IStatusCoverView.Status)

        fun showContinuousSignDialog()

        /**
         * 显示提示查看视频对话框
         */
        fun showTipWatchVideoDialog()
    }

    interface Model : QYModel {
        /**
         * 签到状态获取
         */
        fun attendanceStatus(
            cuid: Int
        ): Observable<NetAttendanceStatus>

        fun attendancePage(
            cuid: Int
        ): Observable<NetAttendancePage>

        fun sign(uid: Int): Observable<NetSign>
        /**
         * 领取补签机会
         */
        fun compensateChanceReceive(
            cuid: Int
        ): Observable<NetCompensateChance>

        /**
         * 补签
         */
        fun compensateSign(
            cuid: Int,
            date: String
        ): Observable<NetCompensateSign>

        /**
         * 看视频领取奖励
         */
        fun videoForGole(
            cuid: Int
        ): Observable<NetVideoForGole>

    }

}