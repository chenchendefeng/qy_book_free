package com.wy.adbook.mvp.presenter

import android.text.TextUtils
import com.freebookqy.application.R
import com.freebookqy.utilslib.ResUtils
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.utils.RxLifecycleUtils
import com.wy.adbook.app.base.BaseEntity
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.manager.ShareManager
import com.wy.adbook.app.rx.RxUtils
import com.wy.adbook.app.rx.ServerRetException
import com.wy.adbook.mvp.contranct.WelfareContract
import com.wy.adbook.mvp.model.entity.*
import com.wy.adbook.mvp.view.activity.RemoveAdSuccessActivity
import com.wy.adbook.mvp.view.web.act.WebActivity
import com.wy.adbook.view.status.IStatusCoverView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import org.jetbrains.anko.toast
import java.util.concurrent.TimeUnit
import javax.inject.Inject


/**
 * Created by leafye on 2019/4/30.
 */
@FragmentScope
class WelfarePresenter
@Inject constructor(model: WelfareContract.Model, view: WelfareContract.View) :
    QYBasePresenter<WelfareContract.Model, WelfareContract.View>(model, view) {

    var welfare: Welfare? = null

    var attendanceStatus: AttendanceStatus? = null

    private fun submitVideoWatched() {
        mModel.watchForFreeAdv(QYAccount.uid())
            .subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<NetWatchForFreeAdv>(mErrorHandler) {
                override fun onNext(t: NetWatchForFreeAdv) {
                    mRootView.getContext().toast(t.msg)
                    //本地存储数据今日已经看过视频
                    QYAccount.todayIsWatchVideoSuccess()
                    mRootView.refreshView()
                    RemoveAdSuccessActivity.startActivity(mRootView.getContext())
                }
            })
    }

    fun shareSuccess() {
        ShareManager.shareSuccess(mRootView, mModel.getRm(), QYAccount.uid(), mErrorHandler)
    }

    fun toLucky() {
        WebActivity.startActivity(mRootView.getContext(), ResUtils.getString(R.string.url_lottery), "抽奖")
    }

    fun handleSkip(welfareItem: WelfareItem) {
        WebActivity.startActivity(mRootView.getContext(), ResUtils.getString(R.string.url_lottery), "抽奖")
//        if (!QYAccount.isLogin()) {
//            LoginActivity.startActivity(mRootView.getContext())
//        } else {
//            if (SchemeManager.isAdScheme(welfareItem.skipPage)) {
//                ADManager.showWatchingVideoDialog(mRootView, object : ADManager.QYRewardVideoAdListener {
//                    override fun onVideoComplete() {
//                        submitVideoWatched()
//                    }
//                })
//            } else {
//                SchemeManager.parseScheme(mRootView, welfareItem.skipPage, mModel.getRm(), mErrorHandler)
//            }
//        }
    }

    fun fetchData() {
        val cuId = QYAccount.uid()
        mRootView.setRefresh(true)
        mRootView.changeStatusCover(IStatusCoverView.Status.LOADING)
        mModel.attendanceStatus(cuId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .doOnNext {
                if (it.isOk()) {
                    attendanceStatus = it.data
                } else {
                    throw ServerRetException(result = it.result, msg = it.msg)
                }
            }
            .concatMap {
                mModel.welfareList(cuId)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .doOnNext {
                if (!TextUtils.equals(BaseEntity.RESULT_OK, it.result)) {
                    throw ServerRetException(result = it.result, msg = it.msg)
                }
            }
            .subscribe(object : ErrorHandleSubscriber<NetWelfare>(mErrorHandler) {
                override fun onNext(t: NetWelfare) {
                    mRootView.changeStatusCover(IStatusCoverView.Status.SUCCESS)
                    welfare = t.data
                    initWelfare()
                    mRootView.refreshView()
                    RxUtils.delay(mRootView, 1, TimeUnit.SECONDS, mRootView.setRefresh(false))
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.setRefresh(false)
                    if (attendanceStatus == null) {
                        mRootView.changeStatusCover(IStatusCoverView.Status.ERROR)
                    }
                }
            })
    }

    private fun initWelfare() {
        if (welfare == null) {
            welfare = Welfare()
        }
        if (welfare?.readList == null) {
            welfare?.readList = mutableListOf()
        }
    }

    fun hasCompensateSign(): Boolean {
        return attendanceStatus?.missedTimes ?: 0 > 0
    }

    fun leakageSignDays(): Int {
        return attendanceStatus?.missedTimes ?: 0
    }

    fun canContinueSignDays(): Int {
        return attendanceStatus?.afterCompensateTimes ?: 0
    }

    fun getContinueSignDays(): Int {
        return attendanceStatus?.times ?: 0
    }

    fun isToadySign(): Boolean {
        return attendanceStatus?.status == 1
    }

    fun getSignGoldCount() = attendanceStatus?.goldAmount ?: 100

    fun getMaxSignGoldCount() = attendanceStatus?.maxAmount ?: Constant.maxSignGoldBean

    fun getFirstSignGold() = 100

    fun todaySignSuccess(obj: Any?) {
        if (obj == null) {
            fetchData()
        } else {
            if (obj is AttendanceStatus) {
                attendanceStatus = obj
                mRootView.refreshView()
            }
        }
    }


}