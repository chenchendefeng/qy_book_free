package com.wy.adbook.mvp.model

import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.wy.adbook.mvp.contranct.ReadFooterContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.NetDeleteReadFooter
import com.wy.adbook.mvp.model.entity.NetReadFooterPage
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-28.
 */
@ActivityScope
class ReadFooterModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    ReadFooterContract.Model {
    override fun getReadFooterPage(cuid: Int, pageNo: Int, pageSize: Int): Observable<NetReadFooterPage> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).getReadFooterPage(cuid, pageNo, pageSize)
    }

    override fun deleteReadFooter(id: Int): Observable<NetDeleteReadFooter> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).deleteReadFooter(id)
    }


}