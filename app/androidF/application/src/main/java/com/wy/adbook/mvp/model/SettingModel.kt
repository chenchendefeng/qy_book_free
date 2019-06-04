package com.wy.adbook.mvp.model

import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.utils.ChannelUtils
import com.wy.adbook.mvp.contranct.SettingContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.accout.NetLogOut
import com.wy.adbook.mvp.model.entity.accout.NetVisitorLoginSuccess
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-29.
 */
@ActivityScope
class SettingModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    SettingContract.Model {
    override fun visitorLogin(imei: String): Observable<NetVisitorLoginSuccess> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .visitorLogin(imei, Constant.DEF_SOURCE, ChannelUtils.getChannel())
    }

    override fun logout(cuid: Int): Observable<NetLogOut> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .logout(QYAccount.uid(), QYAccount.getUserToken())
    }


}