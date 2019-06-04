package com.wy.adbook.mvp.model

import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.wy.adbook.mvp.contranct.BasicInfoContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.accout.NetChangeNick
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-30.
 */
@ActivityScope
class BasicInfoModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    BasicInfoContract.Model {
    override fun changeNickName(uid: Int, nickname: String): Observable<NetChangeNick> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).changeNickname(uid, nickname)
    }


}