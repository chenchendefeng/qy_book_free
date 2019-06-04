package com.wy.adbook.mvp.model

import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.wy.adbook.mvp.contranct.RedEnvelopesForCodeContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.NetInvitationCode
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-27.
 */
@ActivityScope
class RedEnvelopesForCodeModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    RedEnvelopesForCodeContract.Model {
    override fun fillInCode(cuId: Int, code: String): Observable<NetInvitationCode> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).fillInCode(cuId, code)
    }


}