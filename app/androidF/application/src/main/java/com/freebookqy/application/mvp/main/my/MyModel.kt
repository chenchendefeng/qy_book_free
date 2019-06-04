package com.freebookqy.application.mvp.main.my

import android.Manifest
import com.freebookqy.application.app.QYAccount
import com.freebookqy.application.app.QYApplication
import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.constant.Constant
import com.freebookqy.application.app.utils.ChannelUtils
import com.freebookqy.application.app.utils.PermissionHelper
import com.freebookqy.application.mvp.contranct.MyContract
import com.freebookqy.application.mvp.model.api.service.QYService
import com.freebookqy.application.mvp.model.entity.accout.PersonalCenterPage
import com.freebookqy.application.mvp.model.entity.accout.UserInfo
import com.freebookqy.application.mvp.model.entity.accout.WechatLoginSuccess
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.jess.arms.utils.DeviceUtils
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */
@ActivityScope
class MyModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    MyContract.Model {
    override fun getCustomerBizInfo(cid: String): Observable<BaseEntity<UserInfo>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).getCustomeBizInfo(cid)
    }

    override fun wxLogin(code: String): Observable<BaseEntity<WechatLoginSuccess>> {
        val permission = PermissionHelper.checkPermission(Manifest.permission.READ_PHONE_STATE)
        val iemi = if (permission) DeviceUtils.getIMEI(QYApplication.cxt()) else ""
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).mainwechatLogin(
            code,
            iemi,
            Constant.DEF_SOURCE,
            ChannelUtils.getChannel()
        )
    }

    override fun personalCenterPage(): Observable<BaseEntity<PersonalCenterPage>> {
        val cuId = QYAccount.getUserInfo().cuId
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).personalCenterPage(cuId.toInt())
    }


}