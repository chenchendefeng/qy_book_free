package com.freebookqy.application.mvp.account.Login

import android.Manifest
import com.freebookqy.application.app.QYApplication
import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.constant.Constant
import com.freebookqy.application.app.utils.ChannelUtils
import com.freebookqy.application.app.utils.PermissionHelper
import com.freebookqy.application.mvp.contranct.LoginContract
import com.freebookqy.application.mvp.model.api.service.QYService
import com.freebookqy.application.mvp.model.entity.accout.PhoneLoginSuccess
import com.freebookqy.application.mvp.model.entity.accout.WechatLoginSuccess
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.jess.arms.utils.DeviceUtils
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-08.
 */
@ActivityScope
class LoginModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    LoginContract.Model {
    override fun loginWx(code: String): Observable<BaseEntity<WechatLoginSuccess>> {
        val permission = PermissionHelper.checkPermission(Manifest.permission.READ_PHONE_STATE)
        val iemi = if (permission) DeviceUtils.getIMEI(QYApplication.cxt()) else ""
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .mainwechatLogin(
                code, iemi, Constant.DEF_SOURCE,
                ChannelUtils.getChannel()
            )
    }

    override fun loginPhone(phone: String, code: String): Observable<BaseEntity<PhoneLoginSuccess>> {
        val permission = PermissionHelper.checkPermission(Manifest.permission.READ_PHONE_STATE)
        val iemi = if (permission) DeviceUtils.getIMEI(QYApplication.cxt()) else ""
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .phoneLogin(
                phone, Constant.DEF_PHONE_ZONE, code,
                iemi,
                Constant.DEF_SOURCE,
                ChannelUtils.getChannel()
            )
    }


}