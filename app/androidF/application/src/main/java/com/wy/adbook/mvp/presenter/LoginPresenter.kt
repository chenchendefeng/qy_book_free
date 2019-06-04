package com.wy.adbook.mvp.presenter

import cn.smssdk.SMSSDK
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.utils.RxLifecycleUtils
import com.tencent.mm.opensdk.modelmsg.SendAuth
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.rx.SimpleErrorSubscribe
import com.wy.adbook.mvp.contranct.LoginContract
import com.wy.adbook.mvp.model.entity.accout.NetPhoneLoginSuccess
import com.wy.adbook.mvp.model.entity.accout.NetWechatLoginSuccess
import com.wy.adbook.wxapi.WXEntryActivity
import com.wy.adbook.wxapi.WxManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import javax.inject.Inject


/**
 * Created by leafye on 2019-05-08.
 */
@ActivityScope
class LoginPresenter
@Inject
constructor(model: LoginContract.Model, view: LoginContract.View) :
    QYBasePresenter<LoginContract.Model, LoginContract.View>(model, view) {
    /**
     * 手机登录
     */
    fun login(phone: String, code: String) {
        mModel.loginPhone(phone, code)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : SimpleErrorSubscribe<NetPhoneLoginSuccess>(mRootView) {
                override fun success(t: NetPhoneLoginSuccess) {
                    if (t.isOk()) {
                        //登录成功
                        t.data?.let {
                            QYAccount.loginSuccess(it)
                        }
                        mRootView.finish()
                    } else {
                        mRootView.showError(t.msg)
                    }
                }
            })
    }

    /**
     * 请求微信进行登录
     */
    fun requestWx() {
        val req = SendAuth.Req()
        req.scope = "snsapi_userinfo"//
        //req.scope = "snsapi_login";//提示 scope参数错误，或者没有scope权限
        req.state = WXEntryActivity.WX_LOGIN_KEY
        WxManager.wxApi().sendReq(req)
    }

    /**
     * 请求后台记录微信登录信息
     */
    fun loginWx(code: String) {
        mRootView.showLoading()
        mModel.loginWx(code)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<NetWechatLoginSuccess>(mErrorHandler) {
                override fun onNext(t: NetWechatLoginSuccess) {
                    if (t.isOk()) {
                        t.data?.let {
                            QYAccount.loginSuccess(it)
                        }
                        mRootView.hideLoading()
                        mRootView.finish()
                    } else {
                        mRootView.showError(t.msg)
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.hideLoading()
                }
            })
    }

    /**
     * 进入用户协议
     */
    fun enterUserProtocol() {

    }

    /**
     * 进入隐私协议
     */
    fun enterPrivacyAgreement() {

    }


    /**
     * 请求接口  获取验证码
     */
    fun getVerificationCode(country: String, phone: String) {
        SMSSDK.getVerificationCode(country, phone)
        mRootView.showLoading()
    }


}