package com.wy.adbook.mvp.model

import android.Manifest
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.jess.arms.utils.DeviceUtils
import com.wy.adbook.app.QYApplication
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.utils.ChannelUtils
import com.wy.adbook.app.utils.PermissionHelper
import com.wy.adbook.mvp.contranct.MyContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.accout.NetPersonalCenterPage
import com.wy.adbook.mvp.model.entity.accout.NetUserInfo
import com.wy.adbook.mvp.model.entity.accout.NetWechatLoginSuccess
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */
@FragmentScope
class MyModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    MyContract.Model {
    override fun getCustomerBizInfo(cid: Int): Observable<NetUserInfo> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).getCustomeBizInfo(cid)
    }

    override fun wxLogin(code: String): Observable<NetWechatLoginSuccess> {
        val permission = PermissionHelper.checkPermission(Manifest.permission.READ_PHONE_STATE)
        val iemi = if (permission) DeviceUtils.getIMEI(QYApplication.cxt()) else ""
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).mainwechatLogin(
            code,
            iemi,
            Constant.DEF_SOURCE,
            ChannelUtils.getChannel()
        )
    }

    override fun personalCenterPage(): Observable<NetPersonalCenterPage> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).personalCenterPage(QYAccount.uid())
    }


}