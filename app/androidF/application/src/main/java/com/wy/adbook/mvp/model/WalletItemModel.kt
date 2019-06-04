package com.wy.adbook.mvp.model

import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.wy.adbook.mvp.contranct.WalletItemContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.accout.NetFlowPage
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-28.
 */
@FragmentScope
class WalletItemModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    WalletItemContract.Model {
    override fun accountFLowPage(
        cuId: Int,
        currencyType: String,
        pageNo: Int,
        pageSize: Int
    ): Observable<NetFlowPage> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .accountFLowPage(cuId, currencyType, pageNo, pageSize)
    }


}