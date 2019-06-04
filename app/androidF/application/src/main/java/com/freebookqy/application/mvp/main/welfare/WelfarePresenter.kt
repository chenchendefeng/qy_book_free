package com.freebookqy.application.mvp.main.welfare

import android.os.SystemClock
import android.text.TextUtils
import com.freebookqy.application.app.ADManager
import com.freebookqy.application.app.QYAccount
import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.app.rx.RxUtils
import com.freebookqy.application.mvp.contranct.WelfareContract
import com.freebookqy.application.mvp.model.entity.WatchForFreeAdv
import com.freebookqy.application.mvp.model.entity.Welfare
import com.freebookqy.application.mvp.model.entity.WelfareItem
import com.freebookqy.application.mvp.model.entity.accout.Sign
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.utils.RxLifecycleUtils
import com.qq.e.ads.rewardvideo.RewardVideoAD
import com.qq.e.ads.rewardvideo.RewardVideoADListener
import com.qq.e.comm.util.AdError
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import org.jetbrains.anko.toast
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


/**
 * Created by leafye on 2019/4/30.
 */
@ActivityScope
class WelfarePresenter
@Inject constructor(model: WelfareContract.Model, view: WelfareContract.View) :
    QYBasePresenter<WelfareContract.Model, WelfareContract.View>(model, view) {

    var welfare: Welfare? = null

    private var rewardVideoAD: RewardVideoAD? = null
    private var videoCached: Boolean = false
    private var adLoaded: Boolean = false


    private fun watchingVideo() {
        //看视频
        if (rewardVideoAD == null) {
            rewardVideoAD = RewardVideoAD(
                mRootView.getContext(),
                ADManager.APPID,
                ADManager.POSID_VIDOE,
                object : RewardVideoADListener {
                    override fun onADExpose() {
                    }

                    override fun onADClick() {

                    }

                    override fun onVideoCached() {
                        videoCached = true
                        showAd()
                    }

                    override fun onReward() {
                    }

                    override fun onADClose() {
                    }

                    override fun onADLoad() {
                        adLoaded = true
                    }

                    override fun onVideoComplete() {
                        submitVideoWatched()
                    }

                    override fun onError(adError: AdError?) {
                        val msg = String.format(
                            Locale.getDefault(), "onError, error code: %d, error msg: %s",
                            adError?.errorCode ?: 0, adError?.errorMsg ?: 0
                        )
                        mRootView.getContext().toast(msg)
                    }

                    override fun onADShow() {
                    }

                }
            )
        }
        rewardVideoAD?.loadAD()
    }

    private fun submitVideoWatched() {
        mModel.watchForFreeAdv(QYAccount.getUserInfo().getCuid())
            .subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<WatchForFreeAdv>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<WatchForFreeAdv>) {
                    mRootView.getContext().toast(t.msg)
                    //本地存储数据今日已经看过视频
                    QYAccount.todayIsWatchVideoSuccess()
                    mRootView.refreshView()
                }
            })
    }


    fun showAd() {
        if (adLoaded) {//广告展示检查1：广告成功加载，此处也可以使用videoCached来实现视频预加载完成后再展示激励视频广告的逻辑
            if (rewardVideoAD?.hasShown() != true) {//广告展示检查2：当前广告数据还没有展示过
                val delta: Long = 1000//建议给广告过期时间加个buffer，单位ms，这里demo采用1000ms的buffer
                //广告展示检查3：展示广告前判断广告数据未过期
                if (SystemClock.elapsedRealtime() < rewardVideoAD?.expireTimestamp ?: 0 - delta) {
                    rewardVideoAD?.showAD()
                } else {
                    mRootView.getContext().toast("激励视频广告已过期，请再次请求广告后进行广告展示！")
                    rewardVideoAD?.loadAD()
                }
            } else {
                mRootView.getContext().toast("此条广告已经展示过，请再次请求广告后进行广告展示！")
                rewardVideoAD?.loadAD()
            }
        } else {
            mRootView.getContext().toast("成功加载广告后再进行广告展示！")
            rewardVideoAD?.loadAD()
        }
    }

    fun share() {

    }

    fun toRead() {

    }

    fun toAnswer() {

    }

    fun toInvite() {

    }

    fun toFillInRed() {

    }

    fun toBind() {

    }

    fun handleSkip(welfareItem: WelfareItem) {
        watchingVideo()
    }

    fun fetchData() {
        val cuId = QYAccount.uid()
        mModel.welfareList(cuId)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                mRootView.setRefresh(true)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<Welfare>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<Welfare>) {
                    if (TextUtils.equals(BaseEntity.RESULT_OK, t.result)) {
                        welfare = t.data
                    } else {

                    }
                    initWelfare()
                    mRootView.refreshView()
                    RxUtils.delay(mRootView, 1, TimeUnit.SECONDS, this@WelfarePresenter::hideRefresh)
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.setRefresh(false)
                }

                override fun onComplete() {
                    super.onComplete()
                    mRootView.setRefresh(false)
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
        welfare?.readList?.none { it.mainTitle == "每日阅读" }?.let {
            val index = welfare?.readList?.size ?: 0
            welfare?.readList?.add(index, WelfareItem().apply {
                mainTitle = "每日阅读"
                mainTitleColor = "#292929"
                subTitle = "完成阅读时常任务获得额外奖励"
                subTitleColor = "#FF8D8D8D"
                iconTex = "会员奖励x2"
                buttonTex = "去阅读"
                skipType = "app"
                skipPage = "bookshelf"
            })
        }
    }

    fun hideRefresh() {
        mRootView.setRefresh(false)
    }

    fun toTodaySign() {
        mModel.sign(QYAccount.uid())
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { mRootView.showLoading() }
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .doFinally { mRootView.hideLoading() }
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<Sign>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<Sign>) {
                    if(BaseEntity.RESULT_OK == t.result){
                        //今天签到成功
                        mRootView.refreshHeader(WelfareFragment.HEAD_TYPE_CONTINUOUS_SIGN_IN)
                    }
                }
            })
    }

    fun hasCompensateSign(): Boolean {
        return false
    }

    fun leakageSignDays(): Int {
        return 1
    }

    fun canContinueSignDays(): Int {
        return 2
    }

    fun getContinueSignDays(): Int {
        return 1
    }


}