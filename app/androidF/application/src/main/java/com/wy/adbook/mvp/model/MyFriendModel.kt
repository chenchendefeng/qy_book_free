package com.wy.adbook.mvp.model

import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.wy.adbook.mvp.contranct.MyFriendContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.NetFriendPage
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-29.
 */
@ActivityScope
class MyFriendModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    MyFriendContract.Model {
    override fun friendPage(cuid: Int, pageNo: Int, pageSize: Int): Observable<NetFriendPage> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).friendPage(cuid, pageNo, pageSize)
    }


}