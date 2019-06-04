package com.wy.adbook.mvp.model

import com.wy.adbook.app.constant.Constant
import com.wy.adbook.app.utils.ChannelUtils
import com.wy.adbook.mvp.contranct.ProjectContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.NetBanner
import com.wy.adbook.mvp.model.entity.NetSubjectType
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/29.
 */

@FragmentScope
class ProjectModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    ProjectContract.Model {
    override fun getRM(): IRepositoryManager {
        return mRepositoryManager
    }

    override fun bannerList(subject: String): Observable<NetBanner> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .bannerList(Constant.DEF_SOURCE, subject, ChannelUtils.getChannel())
    }

    override fun fetchSubject(subject: String): Observable<NetSubjectType> {
        //获取本地存储的男女类型
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .listBySubjectType(subject, "boy").subscribeOn(Schedulers.io())
    }

}