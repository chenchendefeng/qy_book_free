package com.wy.adbook.app.manager

import android.app.Activity
import android.content.Context
import android.os.SystemClock
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.freebookqy.application.R
import com.freebookqy.viewlib.dialog.CommonDialog
import com.qq.e.ads.cfg.MultiProcessFlag
import com.qq.e.ads.cfg.VideoOption
import com.qq.e.ads.nativ.*
import com.qq.e.ads.nativ.widget.NativeAdContainer
import com.qq.e.ads.rewardvideo.RewardVideoAD
import com.qq.e.ads.rewardvideo.RewardVideoADListener
import com.qq.e.ads.splash.SplashAD
import com.qq.e.ads.splash.SplashADListener
import com.qq.e.comm.util.AdError
import com.wy.adbook.app.base.QYView
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import java.util.*

object ADManager {

    val APPID = "1108159501"

    val POSID_READ = "6020253554516280"//书籍阅读全屏广告
    val POSID_READ_VIDOE = "3000457922598807"//书籍阅读全屏广告
    val POSID_VIDOE = "8090559903402387"//书籍阅读全屏广告
    val POSID_FREEPAGE = "4010458599581858"//免费专区分类
    val POSID_COMMIT = "4080655579093059"//更多评论页广告
    val POSID_START = "5070054514010043"//开屏广告位

    val SPLASH_DELAY_TIME = 4000

    interface NativeADListener {
        fun onADClosed()

        fun onNoAD()
    }

    interface QYRewardVideoAdListener {
        fun onVideoComplete()

        fun onVideoAdClose()
    }

    private var rewardVideoAD: RewardVideoAD? = null
    private var adLoaded: Boolean = false
    private var isLoadAd: Boolean = false

    fun showWatchingVideoDialog(rootView: QYView, l: QYRewardVideoAdListener) {
        val dialogView = View.inflate(rootView.getContext(), R.layout.common_dialog_layout, null).apply {
            find<TextView>(R.id.title).text = "友情提示"
            find<TextView>(R.id.content_tv).let {
                it.text = "观看小视频可获全场20分钟免广告特权，需看完才能获得哦！"
                it.visibility = View.VISIBLE
            }
            find<TextView>(R.id.dialog_exit).text = "取消"
            find<TextView>(R.id.dialog_continue).text = "去观看"
        }
        CommonDialog
            .Builder()
            .contentView(dialogView)
            .setOnClick(R.id.dialog_exit, R.id.dialog_continue)
            .onClick { dialog, view ->
                if (view.id == R.id.dialog_continue) {
                    watchingVideo(rootView, l)
                }
                dialog.dismiss()
            }
            .build(rootView.getContext())
            .show()
    }

    @Synchronized
    fun watchingVideo(rootView: QYView, l: QYRewardVideoAdListener) {
        //看视频
        if (isLoadAd) return
        isLoadAd = true
        adLoaded = false
        if (rewardVideoAD == null) {
            rewardVideoAD = RewardVideoAD(
                rootView.getContext(),
                ADManager.APPID,
                ADManager.POSID_VIDOE,
                object : RewardVideoADListener {
                    override fun onADExpose() {
                    }

                    override fun onADClick() {

                    }

                    override fun onVideoCached() {
                        isLoadAd = false
                        showAd(rootView)
                    }

                    override fun onReward() {
                    }

                    override fun onADClose() {
                        l.onVideoAdClose()
                    }

                    override fun onADLoad() {
                        adLoaded = true
                        isLoadAd = false
                    }

                    override fun onVideoComplete() {
                        l.onVideoComplete()
                    }

                    override fun onError(adError: AdError?) {
                        val msg = String.format(
                            Locale.getDefault(), "onError, error code: %d, error msg: %s",
                            adError?.errorCode ?: 0, adError?.errorMsg ?: 0
                        )
                        rootView.getContext().toast(msg)
                        isLoadAd = false
                    }

                    override fun onADShow() {
                    }
                }
            )
        }
        rewardVideoAD?.loadAD()
    }

    fun showAd(rootView: QYView) {
        if (adLoaded) {//广告展示检查1：广告成功加载，此处也可以使用videoCached来实现视频预加载完成后再展示激励视频广告的逻辑
            if (rewardVideoAD?.hasShown() != true) {//广告展示检查2：当前广告数据还没有展示过
                val delta: Long = 1000//建议给广告过期时间加个buffer，单位ms，这里demo采用1000ms的buffer
                //广告展示检查3：展示广告前判断广告数据未过期
                if (SystemClock.elapsedRealtime() < rewardVideoAD?.expireTimestamp ?: 0 - delta) {
                    rewardVideoAD?.showAD()
                } else {
                    rootView.getContext().toast("激励视频广告已过期，请再次请求广告后进行广告展示！")
                    rewardVideoAD?.loadAD()
                }
            } else {
                rootView.getContext().toast("此条广告已经展示过，请再次请求广告后进行广告展示！")
                rewardVideoAD?.loadAD()
            }
        } else {
            rootView.getContext().toast("成功加载广告后再进行广告展示！")
            rewardVideoAD?.loadAD()
        }
    }

    fun displayNativeExpressAD(
        context: Context,
        id: String,
        listener: NativeExpressAD.NativeExpressADListener
    ) {
        MultiProcessFlag.setMultiProcess(true)
        val nativeExpressAD = NativeExpressAD(
            context,
            com.qq.e.ads.nativ.ADSize(
                com.qq.e.ads.nativ.ADSize.FULL_WIDTH,
                com.qq.e.ads.nativ.ADSize.AUTO_HEIGHT
            ),
            APPID,
            id,
            listener
        ) // 传入Activity
        // 注意：如果您在联盟平台上新建原生模板广告位时，选择了支持视频，那么可以进行个性化设置（可选）
        nativeExpressAD.setVideoOption(
            VideoOption.Builder()
                .setAutoPlayPolicy(VideoOption.AutoPlayPolicy.WIFI) // WIFI 环境下可以自动播放视频
                .setAutoPlayMuted(true) // 自动播放时为静音
                .build()
        ) //
        nativeExpressAD.loadAD(1)
    }

    fun displayNativeExpressAD(
        context: Context,
        content: ViewGroup,
        id: String,
        listener: NativeADListener?
    ) {
        MultiProcessFlag.setMultiProcess(true)
        val nativeExpressAD = NativeExpressAD(
            context,
            com.qq.e.ads.nativ.ADSize(
                com.qq.e.ads.nativ.ADSize.FULL_WIDTH,
                com.qq.e.ads.nativ.ADSize.AUTO_HEIGHT
            ),
            APPID,
            id,
            object : NativeExpressAD.NativeExpressADListener {
                override fun onADLoaded(list: List<NativeExpressADView>?) {
                    if (list != null && list.size > 0) {
                        content.removeAllViews()
                        val view = list[0]
                        content.addView(view)
                        content.visibility = View.VISIBLE
                        //                    if (view.getBoundData().getAdPatternType() == AdPatternType.NATIVE_VIDEO) {
                        //                        view.setMediaListener(mediaListener);
                        //                    }
                        view.render()
                        content.invalidate()
                    }
                }

                override fun onRenderFail(nativeExpressADView: NativeExpressADView) {

                }

                override fun onRenderSuccess(nativeExpressADView: NativeExpressADView) {

                }

                override fun onADExposure(nativeExpressADView: NativeExpressADView) {

                }

                override fun onADClicked(nativeExpressADView: NativeExpressADView) {

                }

                override fun onADClosed(nativeExpressADView: NativeExpressADView) {
                    listener?.onADClosed()
                }

                override fun onADLeftApplication(nativeExpressADView: NativeExpressADView) {

                }

                override fun onADOpenOverlay(nativeExpressADView: NativeExpressADView) {

                }

                override fun onADCloseOverlay(nativeExpressADView: NativeExpressADView) {

                }

                override fun onNoAD(adError: AdError) {
                    listener?.onNoAD()
                }
            }) // 传入Activity
        // 注意：如果您在联盟平台上新建原生模板广告位时，选择了支持视频，那么可以进行个性化设置（可选）
        nativeExpressAD.setVideoOption(
            VideoOption.Builder()
                .setAutoPlayPolicy(VideoOption.AutoPlayPolicy.WIFI) // WIFI 环境下可以自动播放视频
                .setAutoPlayMuted(true) // 自动播放时为静音
                .build()
        ) //
        nativeExpressAD.loadAD(1)
    }

    fun displaySplashAD(
        activity: Activity, adContainer: ViewGroup, skip: View,
        posId: String, adListener: SplashADListener, fetchDelay: Int
    ) {
        val splashAD = SplashAD(activity, adContainer, skip, APPID, posId, adListener, fetchDelay)
    }


    fun displayVideoAD(context: Context, content: NativeAdContainer, id: String, listener: NativeADListener?) {
        val rewardVideoAD = NativeUnifiedAD(context, APPID, id, object : NativeADUnifiedListener {
            override fun onNoAD(adError: AdError) {
                listener?.onNoAD()
            }

            override fun onADLoaded(list: List<NativeUnifiedADData>?) {
                if (list != null && list.size > 0) {
                    initNativeUnifiedAD(context, content, list[0], listener)
                }
            }
        })
        rewardVideoAD.loadData(1)
    }

    private fun initNativeUnifiedAD(
        context: Context,
        content: NativeAdContainer,
        ad: NativeUnifiedADData,
        listener: NativeADListener?
    ) {

        // 将布局与广告进行绑定
        ad.bindAdToView(context, content, null, null)
        // 设置广告事件监听
        ad.setNativeAdEventListener(object : NativeADEventListener {
            override fun onADExposed() {

            }

            override fun onADClicked() {

            }

            override fun onADError(error: AdError) {

            }

            override fun onADStatusChanged() {

            }
        })

    }
}