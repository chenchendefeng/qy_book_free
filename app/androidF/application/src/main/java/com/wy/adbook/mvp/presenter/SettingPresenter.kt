package com.wy.adbook.mvp.presenter

import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.utils.DeviceUtils
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.manager.CacheManager
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.rx.ServerRetException
import com.wy.adbook.app.rx.net
import com.wy.adbook.mvp.contranct.SettingContract
import com.wy.adbook.mvp.model.entity.accout.NetVisitorLoginSuccess
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-29.
 */
@ActivityScope
class SettingPresenter
@Inject
constructor(model: SettingContract.Model, view: SettingContract.View) :
    QYBasePresenter<SettingContract.Model, SettingContract.View>(model, view) {

    fun getCacheSize(): String {
        return CacheManager.getCacheSize()
    }

    fun clearCache() {
        CacheManager.clearCache(false, false)
        mRootView.refreshView()
    }

    fun logout() {
        mRootView.showLoading()
        mModel.logout(QYAccount.uid())
            .net(mRootView)
            .concatMap {
                if (it.isOk()) {
                    val imei = DeviceUtils.getIMEI(mRootView.getContext())
                    mModel.visitorLogin(imei)
                } else {
                    throw ServerRetException(it.result, it.msg)
                }
            }

            .subscribe(object : ErrorHandleSubscriber<NetVisitorLoginSuccess>(mErrorHandler) {
                override fun onNext(t: NetVisitorLoginSuccess) {
                    if (t.isOk()) {
                        mRootView.showSuccess("退出登录成功")
                        mRootView.refreshView()
                        QYAccount.logoutSuccess()
                        QYAccount.loginSuccess(t.data!!)
                    } else {
                        mRootView.showError(t.msg)
                    }
                }

                override fun onError(t: Throwable) {
                    mRootView.showError(t.message ?: "网络错误")
                }

            })
    }


}