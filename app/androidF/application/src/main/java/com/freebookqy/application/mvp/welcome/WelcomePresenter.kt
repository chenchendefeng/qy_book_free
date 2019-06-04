package com.freebookqy.application.mvp.welcome

import android.Manifest
import com.freebookqy.application.app.QYAccount
import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.app.rx.RxUtils
import com.freebookqy.application.app.rx.netReq
import com.freebookqy.application.mvp.contranct.IWelcomeContract
import com.freebookqy.application.mvp.gender.GenderSelectActivity
import com.freebookqy.application.mvp.main.MainActivity
import com.freebookqy.application.mvp.model.entity.accout.VisitorLoginSuccess
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.utils.PermissionUtil
import com.jess.arms.utils.RxLifecycleUtils
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/29.
 */
@ActivityScope
class WelcomePresenter
@Inject
constructor(
    model: IWelcomeContract.Model,
    rootView: IWelcomeContract.View
) : QYBasePresenter<IWelcomeContract.Model, IWelcomeContract.View>(model, rootView) {

    companion object {
        const val DELAY_TIME = 1L
        const val DELAY_AD_TIME = 5L
        const val DELAY_NO_AD_TIME = 3L
    }

    fun checkAdAndCuntDown() {
        if (hasAd()) {
            RxUtils.delay(mRootView, 1, TimeUnit.SECONDS, this::showAd)
        } else {
            startCountDown(DELAY_TIME, false)
        }
    }

    private fun showAd() {
        mRootView.showAd()
    }

    /**
     * 计时
     */
    fun startCountDown(delayTime: Long, isShowInSkip: Boolean) {
        Observable.intervalRange(1, delayTime, 0, 1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<Long>(mErrorHandler) {
                override fun onNext(t: Long) {
                    val currentCount = delayTime - t
                    if (isShowInSkip) {
                        mRootView.showSkipCount(currentCount)
                    }
                    if (currentCount == 0L) {
                        checkAccoutStatusAndEnterMain()
                    }
                }
            })
    }

    fun checkAccoutStatusAndEnterMain() {
        if (QYAccount.getGender() == -1) {
            GenderSelectActivity.startActivity(mRootView.getContext())
            mRootView.finish()
        } else {
            //查询是否有账户,没有账户进行游客登录
            if (QYAccount.isLogin()) {
                enterMain()
                mRootView.finish()
            } else {
                startVisitorLogin()
            }
        }
    }

    private fun startVisitorLogin() {
        mModel
            .visitorLogin()
            .netReq(mRootView)
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<VisitorLoginSuccess>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<VisitorLoginSuccess>) {
                    t.data?.let {
                        QYAccount.loginSuccess(it)
                    }
                    enterMain()
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    enterMain()
                }
            })
    }

    //登录成功 进入界面
    private fun enterMain() {
        MainActivity.startActivity(mRootView.getContext())
    }

    fun handlePermission() {
        PermissionUtil.requestPermission(
            object : PermissionUtil.RequestPermission {
                override fun onRequestPermissionSuccess() {
                    checkAdAndCuntDown()
                }

                override fun onRequestPermissionFailure(permissions: MutableList<String>?) {
                    checkAdAndCuntDown()
                }

                override fun onRequestPermissionFailureWithAskNeverAgain(permissions: MutableList<String>?) {
                    checkAdAndCuntDown()
                }
            }, RxPermissions(mRootView.getContext() as WelcomeActivity), mErrorHandler,
            Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

//        PermissionUtil.readPhonestate(object : PermissionUtil.RequestPermission {
//            override fun onRequestPermissionSuccess() {
//                checkAdAndCuntDown()
//            }
//
//            override fun onRequestPermissionFailure(permissions: MutableList<String>?) {
//                checkAdAndCuntDown()
//            }
//
//            override fun onRequestPermissionFailureWithAskNeverAgain(permissions: MutableList<String>?) {
//                checkAdAndCuntDown()
//            }
//        }, RxPermissions(mRootView.getContext() as WelcomeActivity), mErrorHandler)
    }


    private fun hasAd(): Boolean {
        return true
    }

}