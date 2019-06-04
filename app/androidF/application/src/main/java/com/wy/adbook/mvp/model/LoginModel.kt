package com.wy.adbook.mvp.model

import android.Manifest
import com.wy.adbook.app.QYApplication
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.app.utils.ChannelUtils
import com.wy.adbook.app.utils.PermissionHelper
import com.wy.adbook.mvp.contranct.LoginContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.accout.NetPhoneLoginSuccess
import com.wy.adbook.mvp.model.entity.accout.NetWechatLoginSuccess
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
    override fun loginWx(code: String): Observable<NetWechatLoginSuccess> {
        val permission = PermissionHelper.checkPermission(Manifest.permission.READ_PHONE_STATE)
        val iemi = if (permission) DeviceUtils.getIMEI(QYApplication.cxt()) else ""
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .mainwechatLogin(
                code, iemi, Constant.DEF_SOURCE,
                ChannelUtils.getChannel()
            )
    }

    override fun loginPhone(phone: String, code: String): Observable<NetPhoneLoginSuccess> {
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