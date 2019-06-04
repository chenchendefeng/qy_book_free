package com.wy.adbook.mvp.presenter

import android.content.Intent
import com.freebookqy.application.R
import com.freebookqy.utilslib.ResUtils
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.utils.LogUtils
import com.jess.arms.utils.RxLifecycleUtils
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.manager.ADManager
import com.wy.adbook.app.manager.Config
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.rx.ServerRetException
import com.wy.adbook.app.rx.net
import com.wy.adbook.mvp.contranct.SignCalenderContract
import com.wy.adbook.mvp.model.entity.AttendanceStatus
import com.wy.adbook.mvp.model.entity.NetAttendanceStatus
import com.wy.adbook.mvp.model.entity.NetCompensateChance
import com.wy.adbook.mvp.model.entity.NetVideoForGole
import com.wy.adbook.mvp.model.entity.accout.*
import com.wy.adbook.mvp.model.event.SignEvent
import com.wy.adbook.mvp.view.activity.SignCalenderActivity
import com.wy.adbook.mvp.view.adapter.ContinuousSignInAdapter
import com.wy.adbook.mvp.view.adapter.SignCalendarAdapter
import com.wy.adbook.view.status.IStatusCoverView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import org.jetbrains.anko.toast
import org.simple.eventbus.EventBus
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-08.
 */
@ActivityScope
class SignCalenderPresenter
@Inject
constructor(model: SignCalenderContract.Model, view: SignCalenderContract.View) :
    QYBasePresenter<SignCalenderContract.Model, SignCalenderContract.View>(model, view) {

    @Inject
    lateinit var signCalendarAdapter: SignCalendarAdapter

    @Inject
    lateinit var continuousSignInAdapter: ContinuousSignInAdapter

    @Inject
    lateinit var attendanceCalendarList: MutableList<AttendanceCalendarItem>

    @Inject
    lateinit var rewardList: MutableList<RewardItem>
    /**
     * 连续签到
     */
    private var continueSignDays: Int = 0

    var signSuccessGold: Int = 20

    var attendanceStatus: AttendanceStatus? = null

    var clickAttendanceCalendarItem: AttendanceCalendarItem? = null
    /**
     * 看视频获取奖励
     */
    var isWatchVideoForGold: Boolean = false
    /**
     * 看视频获取补签机会
     */
    var isWatchVideoForRetroactive: Boolean = false

    fun fetchData() {
        if (attendanceStatus == null) {
            LogUtils.debugInfo("检查数据是否错误")
            return
        }
        mRootView.changeStatus(IStatusCoverView.Status.LOADING)
        if (attendanceStatus!!.status == 0) {
            toSign()
        } else {
            fetchCalendar()
        }
    }

    /**
     * 签到
     * 签到成功后获取签到状态数据
     * 再请求日历数据
     */
    private fun toSign() {
        mModel.sign(QYAccount.uid())
            .net(mRootView)
            .doOnNext {
                if (it.isOk()) {
                    signSuccessGold = it.data ?: 20
                } else {
                    throw ServerRetException(it.result, it.msg)
                }
            }
            .concatMap {
                mModel.attendanceStatus(QYAccount.uid())
            }
            .net(mRootView)
            .subscribe(object : ErrorHandleSubscriber<NetAttendanceStatus>(mErrorHandler) {
                override fun onNext(t: NetAttendanceStatus) {
                    if (t.isOk()) {
                        attendanceStatus = t.data
                        //弹出对话框
                        mRootView.showSignSuccessDialog()
                        postSignSuccess(t.data!!)
                        fetchCalendar()
                    } else {
                        mRootView.getContext().toast(t.msg)
                        mRootView.changeStatus(IStatusCoverView.Status.ERROR)
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.changeStatus(IStatusCoverView.Status.ERROR)
                }
            })
    }

    private fun postSignSuccess(data: AttendanceStatus) {
        EventBus.getDefault().post(SignEvent(key = SignEvent.EVENT_SIGN_SUCCESS, obj = data))
    }

    private fun fetchCalendar() {
        mModel.attendancePage(QYAccount.uid())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<NetAttendancePage>(mErrorHandler) {
                override fun onNext(t: NetAttendancePage) {
                    if (t.isOk()) {
                        continueSignDays = t.data?.times ?: 0
                        continuousSignInAdapter.setContinuousDays(continueSignDays)
                        t.data?.attendanceCalendar?.let {
                            attendanceCalendarList.clear()
                            attendanceCalendarList.addAll(it)
                        }
                        signCalendarAdapter.setNewData(attendanceCalendarList)
                        t.data?.rewardList?.let {
                            rewardList.clear()
                            rewardList.addAll(it)
                        }
                        continuousSignInAdapter.setNewData(rewardList)
                        mRootView.refreshView()
                        mRootView.changeStatus(IStatusCoverView.Status.SUCCESS)
                    } else {
                        mRootView.getContext().toast(t.msg)
                        mRootView.changeStatus(IStatusCoverView.Status.ERROR)
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.changeStatus(IStatusCoverView.Status.ERROR)
                }
            })
    }

    /**
     * 返回可以连续补签的天数
     */
    fun canRetroactiveDay(): Int {
        return attendanceCalendarList.count {
            it.compensateStatus == 1
        }
    }

    fun continueSignDay(): Int {
        return continueSignDays
    }

    fun watchVideoForGetGold(): Int {
        return Config.getWelefareConfig().getWatchVideoGetGold()
    }

    fun getSignRuleText(): String {
        return ResUtils.getString(R.string.rule_sign_text)
    }

    fun getContinueSIgnRuleText(): String {
        return ResUtils.getString(R.string.retroactive_rule_text)
    }

    fun signToday() {
        //判断今天是否已经签到
        attendanceStatus?.let { status ->
            if (status.status == 0) {
                //进行签到
                mModel.sign(QYAccount.uid())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                    .doOnSubscribe {
                        mRootView.showLoading()
                    }
                    .subscribe(object : ErrorHandleSubscriber<NetSign>(mErrorHandler) {
                        override fun onNext(t: NetSign) {
                            //签到成功 修改本地数据并获取签到日历
                            if (t.isOk()) {
                                mRootView.showSuccess("签到成功")
                                mRootView.refreshView()
                                //请求日历
                                fetchCalendar()
                            } else {
                                mRootView.showError(t.msg)
                                mRootView.getContext().toast(t.msg)
                            }
                        }

                        override fun onError(t: Throwable) {
                            super.onError(t)
                            mRootView.hideLoading()
                        }
                    })
            } else if (!isWatchVideoForGold) {
                mRootView.showTipWatchVideoDialog()
            }
        }
    }

    fun initData(intent: Intent?) {
        intent?.let { i ->
            i.getSerializableExtra(SignCalenderActivity.EXTRA_ATTENDANCE_PAGE)?.let {
                attendanceStatus = it as AttendanceStatus
            }
        }
    }

    fun watchingVideo(isForRetroactive: Boolean) {
        //看视频
        ADManager.watchingVideo(
            mRootView,
            object : ADManager.QYRewardVideoAdListener {
                override fun onVideoAdClose() {
                    if (isForRetroactive) {
                        fetchCompensateChanceReceive()
                    } else {
                        videoForGole()
                    }
                }

                override fun onVideoComplete() {

                }
            })
    }

    /**
     * 获取补签机会
     */
    private fun fetchCompensateChanceReceive() {
        mRootView.showLoading()
        mModel.compensateChanceReceive(QYAccount.uid())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<NetCompensateChance>(mErrorHandler) {
                override fun onNext(t: NetCompensateChance) {
                    if (t.isOk()) {
                        startRetroactive()
                    } else {
                        mRootView.getContext().toast(t.msg)
                        mRootView.hideLoading()
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.hideLoading()
                }
            })
    }

    /**
     * 开始补签
     */
    fun startRetroactive() {
        if (clickAttendanceCalendarItem == null) {
            mRootView.showError("请求错误")
            return
        }
        mRootView.showLoading()
        clickAttendanceCalendarItem?.let {
            mModel.compensateSign(QYAccount.uid(), it.date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(object : ErrorHandleSubscriber<NetCompensateSign>(mErrorHandler) {
                    override fun onNext(t: NetCompensateSign) {
                        if (t.isOk()) {
                            //补签成功 刷新日历
                            fetchCalendar()
                        } else {
                            mRootView.getContext().toast(t.msg)
                            mRootView.hideLoading()
                        }
                    }

                    override fun onError(t: Throwable) {
                        super.onError(t)
                        mRootView.hideLoading()
                    }
                })
        }
    }

    private fun videoForGole() {
        mRootView.showLoading()
        mModel.videoForGole(QYAccount.uid())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<NetVideoForGole>(mErrorHandler) {
                override fun onNext(t: NetVideoForGole) {
                    if (t.isOk()) {
                        mRootView.showSuccess("领取成功")
                    } else {
                        mRootView.getContext().toast(t.msg)
                        mRootView.hideLoading()
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.hideLoading()
                }
            })
    }

    /**
     * 签到成功的金豆
     */
    fun getGoldGet(): Int {
        return signSuccessGold
    }

    /**
     * 用户的金豆
     */
    fun getUserGold(): Int {
        return 10000
    }


}