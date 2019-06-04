package com.wy.adbook.mvp.model

import com.wy.adbook.mvp.contranct.SignCalenderContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.NetAttendanceStatus
import com.wy.adbook.mvp.model.entity.NetCompensateChance
import com.wy.adbook.mvp.model.entity.NetVideoForGole
import com.wy.adbook.mvp.model.entity.accout.NetAttendancePage
import com.wy.adbook.mvp.model.entity.accout.NetCompensateSign
import com.wy.adbook.mvp.model.entity.accout.NetSign
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-08.
 */
@ActivityScope
class SignCalenderModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    SignCalenderContract.Model {
    override fun attendanceStatus(cuid: Int): Observable<NetAttendanceStatus> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).attendanceStatus(cuid)
    }

    override fun videoForGole(cuid: Int): Observable<NetVideoForGole> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).videoForGole(cuid)
    }

    override fun compensateChanceReceive(cuid: Int): Observable<NetCompensateChance> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .compensateChanceReceive(cuid, "video")
    }

    override fun compensateSign(cuid: Int, date: String): Observable<NetCompensateSign> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).compensateSign(cuid, date)
    }

    override fun sign(uid: Int): Observable<NetSign> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).sign(uid)
    }

    override fun attendancePage(cuid: Int): Observable<NetAttendancePage> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).attendancePage(cuid)
    }


}