package com.wy.adbook.mvp.model

import com.wy.adbook.mvp.contranct.WelfareContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.NetAttendanceStatus
import com.wy.adbook.mvp.model.entity.NetWatchForFreeAdv
import com.wy.adbook.mvp.model.entity.NetWelfare
import com.wy.adbook.mvp.model.entity.accout.NetSign
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */

@FragmentScope
class WelfareModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    WelfareContract.Model {

    override fun getRm() = mRepositoryManager

    override fun attendanceStatus(uid: Int): Observable<NetAttendanceStatus> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).attendanceStatus(uid)
    }

    override fun sign(cid: Int): Observable<NetSign> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).sign(cid)
    }

    override fun watchForFreeAdv(cid: Int): Observable<NetWatchForFreeAdv> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).watchForFreeAdv(cid)
    }

    override fun welfareList(cid: Int): Observable<NetWelfare> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .welfareList(cid)
    }


}