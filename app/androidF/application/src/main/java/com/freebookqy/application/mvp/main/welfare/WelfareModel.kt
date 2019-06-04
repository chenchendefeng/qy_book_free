package com.freebookqy.application.mvp.main.welfare

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.mvp.contranct.WelfareContract
import com.freebookqy.application.mvp.model.api.service.QYService
import com.freebookqy.application.mvp.model.entity.WatchForFreeAdv
import com.freebookqy.application.mvp.model.entity.Welfare
import com.freebookqy.application.mvp.model.entity.accout.Sign
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */

@ActivityScope
class WelfareModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    WelfareContract.Model {
    override fun sign(cid: Int): Observable<BaseEntity<Sign>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).sign(cid)
    }

    override fun watchForFreeAdv(cid: Int): Observable<BaseEntity<WatchForFreeAdv>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).watchForFreeAdv(cid)
    }

    override fun welfareList(cid: Int): Observable<BaseEntity<Welfare>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .welfareList(cid)
    }


}