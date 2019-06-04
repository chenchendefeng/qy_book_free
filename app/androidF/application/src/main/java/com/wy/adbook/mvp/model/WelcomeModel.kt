package com.wy.adbook.mvp.model

import android.Manifest
import com.wy.adbook.app.QYApplication
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.app.utils.ChannelUtils
import com.wy.adbook.app.utils.PermissionHelper
import com.wy.adbook.mvp.contranct.IWelcomeContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.NetStartPage
import com.wy.adbook.mvp.model.entity.accout.NetVisitorLoginSuccess
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.jess.arms.utils.DeviceUtils
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/29.
 */
@ActivityScope
class WelcomeModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    IWelcomeContract.Model {

    override fun getCurStartPage(clientType: String, channelCode: String): Observable<NetStartPage> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .getCurStartPage(clientType, channelCode)
    }

    override fun visitorLogin(): Observable<NetVisitorLoginSuccess> {
        val permission = PermissionHelper.checkPermission(Manifest.permission.READ_PHONE_STATE)
        val iemi = if (permission) DeviceUtils.getIMEI(QYApplication.cxt()) else ""
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .visitorLogin(iemi, Constant.DEF_SOURCE, ChannelUtils.getChannel())
    }

}