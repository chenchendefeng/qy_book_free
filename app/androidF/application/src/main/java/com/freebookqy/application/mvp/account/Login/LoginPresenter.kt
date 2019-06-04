package com.freebookqy.application.mvp.account.Login

import cn.smssdk.SMSSDK
import com.freebookqy.application.app.QYAccount
import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.app.rx.SimpleErrorSubscribe
import com.freebookqy.application.app.rx.netReq
import com.freebookqy.application.mvp.contranct.LoginContract
import com.freebookqy.application.mvp.model.entity.accout.PhoneLoginSuccess
import com.freebookqy.application.mvp.model.entity.accout.WechatLoginSuccess
import com.freebookqy.application.wxapi.WxManager
import com.jess.arms.di.scope.ActivityScope
import com.tencent.mm.opensdk.modelmsg.SendAuth
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
            .netReq(mRootView)
            .subscribe(object : SimpleErrorSubscribe<BaseEntity<PhoneLoginSuccess>>(mRootView) {
                override fun success(t: BaseEntity<PhoneLoginSuccess>) {
                    //登录成功
                    t.data?.let {
                        QYAccount.loginSuccess(it)
                    }
                    mRootView.finish()
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
        req.state = "wechat_sdk_微信登录"
        WxManager.wxApi().sendReq(req)
    }

    /**
     * 请求后台记录微信登录信息
     */
    fun loginWx(code: String) {
        mModel.loginWx(code)
            .netReq(mRootView)
            .subscribe(object : SimpleErrorSubscribe<BaseEntity<WechatLoginSuccess>>(mRootView) {
                override fun success(t: BaseEntity<WechatLoginSuccess>) {
                    t.data?.let {
                        QYAccount.loginSuccess(it)
                    }
                    mRootView.finish()
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