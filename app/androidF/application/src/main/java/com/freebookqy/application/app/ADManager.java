package com.freebookqy.application.app;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.cfg.MultiProcessFlag;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.*;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;

import java.util.List;

public class ADManager {

    public static final String APPID = "1108159501";

    public static final String POSID_READ = "6020253554516280";//书籍阅读全屏广告
     public static final String POSID_READ_VIDOE = "3000457922598807";//书籍阅读全屏广告
     public static final String POSID_VIDOE = "8090559903402387";//书籍阅读全屏广告
    public static final String POSID_FREEPAGE = "4010458599581858";//免费专区分类
    public static final String POSID_COMMIT = "4080655579093059";//更多评论页广告
    public static final String POSID_START = "5070054514010043";//开屏广告位

    public static final int SPLASH_DELAY_TIME = 4000;

    private static ADManager mADManage;

    public static ADManager getInstance() {
        if (mADManage == null) {
            synchronized (ADManager.class) {
                if (mADManage == null) {
                    mADManage = new ADManager();
                }
            }
        }
        return mADManage;
    }


    public interface NativeADListener {
        void onADClosed();

        void onNoAD();
    }

    public static void displayNativeExpressAD(Context context, ViewGroup content, String id, NativeADListener listener) {
        MultiProcessFlag.setMultiProcess(true);
        NativeExpressAD nativeExpressAD = new NativeExpressAD(
                context,
                new com.qq.e.ads.nativ.ADSize(
                        com.qq.e.ads.nativ.ADSize.FULL_WIDTH,
                        com.qq.e.ads.nativ.ADSize.AUTO_HEIGHT),
                APPID,
                id,
                new NativeExpressAD.NativeExpressADListener() {
                    @Override
                    public void onADLoaded(List<NativeExpressADView> list) {
                        if (list != null && list.size() > 0) {
                            content.removeAllViews();
                            NativeExpressADView view = list.get(0);
                            content.addView(view);
//                    if (view.getBoundData().getAdPatternType() == AdPatternType.NATIVE_VIDEO) {
//                        view.setMediaListener(mediaListener);
//                    }
                            view.render();
                        }
                    }

                    @Override
                    public void onRenderFail(NativeExpressADView nativeExpressADView) {

                    }

                    @Override
                    public void onRenderSuccess(NativeExpressADView nativeExpressADView) {

                    }

                    @Override
                    public void onADExposure(NativeExpressADView nativeExpressADView) {

                    }

                    @Override
                    public void onADClicked(NativeExpressADView nativeExpressADView) {

                    }

                    @Override
                    public void onADClosed(NativeExpressADView nativeExpressADView) {
                        if (listener != null) {
                            listener.onADClosed();
                        }
                    }

                    @Override
                    public void onADLeftApplication(NativeExpressADView nativeExpressADView) {

                    }

                    @Override
                    public void onADOpenOverlay(NativeExpressADView nativeExpressADView) {

                    }

                    @Override
                    public void onADCloseOverlay(NativeExpressADView nativeExpressADView) {

                    }

                    @Override
                    public void onNoAD(AdError adError) {
                        if (listener != null) {
                            listener.onNoAD();
                        }
                    }
                }); // 传入Activity
        // 注意：如果您在联盟平台上新建原生模板广告位时，选择了支持视频，那么可以进行个性化设置（可选）
        nativeExpressAD.setVideoOption(new VideoOption.Builder()
                .setAutoPlayPolicy(VideoOption.AutoPlayPolicy.WIFI) // WIFI 环境下可以自动播放视频
                .setAutoPlayMuted(true) // 自动播放时为静音
                .build()); //
        nativeExpressAD.loadAD(1);


    }

    public static void displaySplashAD(Activity activity, ViewGroup adContainer, View skip,
                                       String posId, SplashADListener adListener, int fetchDelay) {
        SplashAD splashAD = new SplashAD(activity, adContainer, skip, APPID, posId, adListener, fetchDelay);
    }


    public static void displayVideoAD(Context context, NativeAdContainer content, String id, NativeADListener listener) {
        NativeUnifiedAD rewardVideoAD = new NativeUnifiedAD(context, APPID, id, new NativeADUnifiedListener() {
            @Override
            public void onNoAD(AdError adError) {
                if (listener != null) {
                    listener.onNoAD();
                }
            }

            @Override
            public void onADLoaded(List<NativeUnifiedADData> list) {
                if (list != null && list.size() > 0) {
                    initNativeUnifiedAD(context, content, list.get(0), listener);
                }
            }
        });
        rewardVideoAD.loadData(1);

    }

    private static void initNativeUnifiedAD(Context context, NativeAdContainer content, NativeUnifiedADData ad, NativeADListener listener) {

        // 将布局与广告进行绑定
        ad.bindAdToView(context, content, null, null);
        // 设置广告事件监听
        ad.setNativeAdEventListener(new NativeADEventListener() {
            @Override
            public void onADExposed() {

            }

            @Override
            public void onADClicked() {

            }

            @Override
            public void onADError(AdError error) {

            }

            @Override
            public void onADStatusChanged() {

            }
        });

    }
}