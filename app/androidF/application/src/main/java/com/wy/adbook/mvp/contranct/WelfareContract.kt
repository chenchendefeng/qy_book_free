package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.NetAttendanceStatus
import com.wy.adbook.mvp.model.entity.NetWatchForFreeAdv
import com.wy.adbook.mvp.model.entity.NetWelfare
import com.wy.adbook.mvp.model.entity.accout.NetSign
import com.wy.adbook.view.status.IStatusCoverView
import com.jess.arms.integration.IRepositoryManager
import io.reactivex.Observable

/**
 * Created by leafye on 2019/4/30.
 */
interface WelfareContract {

    interface View : QYView {

        fun refreshView()

        fun setRefresh(isRefresh: Boolean)

        fun refreshHeader(headViewType: Int)

        fun changeStatusCover(status: IStatusCoverView.Status)
    }

    interface Model : QYModel {

        fun getRm(): IRepositoryManager

        fun welfareList(cid: Int): Observable<NetWelfare>

        fun watchForFreeAdv(cid: Int): Observable<NetWatchForFreeAdv>

        fun sign(cid: Int): Observable<NetSign>

        fun attendanceStatus(uid: Int): Observable<NetAttendanceStatus>
    }

}