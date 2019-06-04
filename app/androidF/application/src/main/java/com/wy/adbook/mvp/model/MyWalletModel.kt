package com.wy.adbook.mvp.model

import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.wy.adbook.mvp.contranct.MyWalletContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.accout.NetBalance
import com.wy.adbook.mvp.model.entity.accout.NetFlowPage
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/6.
 */
@ActivityScope
class MyWalletModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    MyWalletContract.Model {

    override fun accountFLowPage(
        cuId: Int,
        currencyType: String,
        pageNo: Int,
        pageSize: Int
    ): Observable<NetFlowPage> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .accountFLowPage(cuId, currencyType, pageNo, pageSize)
    }

    override fun balance(cuId: Int): Observable<NetBalance> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).balance(cuId)
    }


}