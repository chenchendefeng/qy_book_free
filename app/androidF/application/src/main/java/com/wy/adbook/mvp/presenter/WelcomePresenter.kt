package com.wy.adbook.mvp.presenter

import android.Manifest
import android.view.View
import android.widget.TextView
import com.freebookqy.application.R
import com.freebookqy.utilslib.ApkUtils
import com.freebookqy.viewlib.dialog.CommonDialog
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.utils.LogUtils
import com.jess.arms.utils.PermissionUtil
import com.jess.arms.utils.RxLifecycleUtils
import com.tbruyelle.rxpermissions2.RxPermissions
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.manager.StartViewManager
import com.wy.adbook.app.rx.RxUtils
import com.wy.adbook.app.utils.ChannelUtils
import com.wy.adbook.mvp.contranct.IWelcomeContract
import com.wy.adbook.mvp.model.entity.NetStartPage
import com.wy.adbook.mvp.model.entity.accout.NetVisitorLoginSuccess
import com.wy.adbook.mvp.view.activity.GenderSelectActivity
import com.wy.adbook.mvp.view.activity.MainActivity
import com.wy.adbook.mvp.view.activity.WelcomeActivity
import com.wy.adbook.mvp.view.web.callback.QYJavaCallJs
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import org.jetbrains.anko.find
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

    private var isPermissionChecked: Boolean = false
    private var isFetchDataSuccess: Boolean = false

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
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<NetVisitorLoginSuccess>(mErrorHandler) {
                override fun onNext(t: NetVisitorLoginSuccess) {
                    if (t.isOk()) {
                        t.data?.let {
                            QYAccount.loginSuccess(it)
                        }
                        enterMain()
                        mRootView.finish()
                    } else {
                        mRootView.showError(t.msg)
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    enterMain()
                    mRootView.finish()
                }
            })
    }

    //登录成功 进入界面
    private fun enterMain() {
        MainActivity.startActivity(mRootView.getContext())
    }

    fun fetchData() {
        mModel.getCurStartPage("Android", ChannelUtils.getChannel())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<NetStartPage>(mErrorHandler) {
                override fun onNext(t: NetStartPage) {
                    if ( t.isOk() && t.data != null) {
                        StartViewManager.getInstance().saveStartView(t.data!!)
                        isFetchDataSuccess = true
                        tryHandlerNetStartPage()
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    tryHandlerNetStartPage()
                }
            })
    }

    private fun tryHandlerNetStartPage() {
        if (isFetchDataSuccess && isPermissionChecked) {
            val open = StartViewManager.getInstance().isOpen
            val startPage = StartViewManager.getInstance().startView
            if (open) {
                when (startPage.fileType) {
                    StartViewManager.TYPE_IMG -> mRootView.showImg(startPage.fileUrl)
                    StartViewManager.TYPE_GIF -> mRootView.showGif(startPage.fileUrl)
                    StartViewManager.TYPE_VIDEO -> mRootView.showVideo(startPage.fileUrl)
                }
                return
            }
        }
        showAd()
    }

    fun handlePermission() {
        val userInfo = QYAccount.getUserInfo()
        val linkCall = QYJavaCallJs.linkCall("getUserInfo", userInfo)
        LogUtils.debugInfo(linkCall)

        PermissionUtil.requestPermission(
            object : PermissionUtil.RequestPermission {
                override fun onRequestPermissionSuccess() {
                    isPermissionChecked = true
                    tryHandlerNetStartPage()
                }

                override fun onRequestPermissionFailure(permissions: MutableList<String>?) {
                    CommonDialog.Builder()
                        .contentView(View.inflate(mRootView.getContext(), R.layout.common_dialog_layout, null).apply {
                            find<TextView>(R.id.title).text = "电话权限仅仅用来确认用户,存储权限仅用来存储书籍,请放心使用"
                        })
                        .onCancel {
                            mRootView.finish()
                        }
                        .onClick { dialog, view ->
                            //跳转到权限设置界面
                            handlePermission()
                        }
                        .build(mRootView.getContext())
                        .show()
                }

                override fun onRequestPermissionFailureWithAskNeverAgain(
                    permissions: MutableList<String>?
                ) {
                    CommonDialog.Builder()
                        .contentView(View.inflate(mRootView.getContext(), R.layout.common_dialog_layout, null).apply {
                            find<TextView>(R.id.title).text = "电话权限仅仅用来确认用户,存储权限仅用来存储书籍,请放心使用"
                            find<TextView>(R.id.dialog_continue).text = "去设置"
                        })
                        .onCancel {
                            mRootView.finish()
                        }
                        .onClick { _, _ ->
                            //跳转到权限设置界面
                            ApkUtils.showAppDetail(mRootView.getContext(), mRootView.getContext().packageName)
                        }
                        .build(mRootView.getContext())
                        .show()
                }
            }, RxPermissions(mRootView.getContext() as WelcomeActivity), mErrorHandler,
            Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }


    private fun hasAd(): Boolean {
        return true
    }

}