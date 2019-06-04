package com.freebookqy.application.mvp.welcome

import android.Manifest
import com.freebookqy.application.app.QYApplication
import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.constant.Constant
import com.freebookqy.application.app.utils.ChannelUtils
import com.freebookqy.application.app.utils.PermissionHelper
import com.freebookqy.application.mvp.contranct.IWelcomeContract
import com.freebookqy.application.mvp.model.api.service.QYService
import com.freebookqy.application.mvp.model.entity.accout.VisitorLoginSuccess
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
    override fun visitorLogin(): Observable<BaseEntity<VisitorLoginSuccess>> {
        val permission = PermissionHelper.checkPermission(Manifest.permission.READ_PHONE_STATE)
        val iemi = if (permission) DeviceUtils.getIMEI(QYApplication.cxt()) else ""
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .visitorLogin(iemi, Constant.DEF_SOURCE, ChannelUtils.getChannel())
    }

}