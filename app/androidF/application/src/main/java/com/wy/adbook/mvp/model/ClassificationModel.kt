package com.wy.adbook.mvp.model

import com.wy.adbook.mvp.contranct.ClassificationContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.NetBanner
import com.wy.adbook.mvp.model.entity.NetClassification
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/5.
 */
@ActivityScope
class ClassificationModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    ClassificationContract.Model {

    override fun fetchBanner(systemType: String, position: String, channel: String): Observable<NetBanner> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .bannerList(systemType, position, channel)
    }

    override fun categoryData(
        pageNo: Int,
        pageSize: Int,
        sexType: String
    ): Observable<NetClassification> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .pageListBySexType(pageNo, pageSize, sexType)
    }


}