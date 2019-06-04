package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.NetBanner
import com.wy.adbook.mvp.model.entity.NetSubjectType
import com.wy.adbook.view.status.IStatusCoverView
import com.jess.arms.integration.IRepositoryManager
import io.reactivex.Observable

/**
 * Created by leafye on 2019/4/30.
 */

interface ProjectContract {

    interface View : QYView {

        fun refreshStatus(isRefresh: Boolean)

        fun refreshBanner()

        fun changeStatusCoverView(status: IStatusCoverView.Status)
    }

    interface Model : QYModel {

        fun getRM(): IRepositoryManager

        fun fetchSubject(subject: String): Observable<NetSubjectType>

//        fun subjectCache(subject: String): Observable<NetSubjectType>

        fun bannerList(subject: String): Observable<NetBanner>

//        fun bannerCache(subject: String): Observable<NetBanner>
    }

}