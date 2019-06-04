package com.wy.adbook.app.manager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002<=B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020%J6\u0010&\u001a\u00020\u001d2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0014J(\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u0002012\u0006\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$J*\u00102\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u0002012\u0006\u00103\u001a\u0002042\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u000e\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u000207J\u0016\u00108\u001a\u00020\u001d2\u0006\u00106\u001a\u0002072\u0006\u00109\u001a\u00020:J\u0016\u0010;\u001a\u00020\u001d2\u0006\u00106\u001a\u0002072\u0006\u00109\u001a\u00020:R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0014X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lcom/wy/adbook/app/manager/ADManager;", "", "()V", "APPID", "", "getAPPID", "()Ljava/lang/String;", "POSID_COMMIT", "getPOSID_COMMIT", "POSID_FREEPAGE", "getPOSID_FREEPAGE", "POSID_READ", "getPOSID_READ", "POSID_READ_VIDOE", "getPOSID_READ_VIDOE", "POSID_START", "getPOSID_START", "POSID_VIDOE", "getPOSID_VIDOE", "SPLASH_DELAY_TIME", "", "getSPLASH_DELAY_TIME", "()I", "adLoaded", "", "isLoadAd", "rewardVideoAD", "Lcom/qq/e/ads/rewardvideo/RewardVideoAD;", "displayNativeExpressAD", "", "context", "Landroid/content/Context;", "content", "Landroid/view/ViewGroup;", "id", "listener", "Lcom/wy/adbook/app/manager/ADManager$NativeADListener;", "Lcom/qq/e/ads/nativ/NativeExpressAD$NativeExpressADListener;", "displaySplashAD", "activity", "Landroid/app/Activity;", "adContainer", "skip", "Landroid/view/View;", "posId", "adListener", "Lcom/qq/e/ads/splash/SplashADListener;", "fetchDelay", "displayVideoAD", "Lcom/qq/e/ads/nativ/widget/NativeAdContainer;", "initNativeUnifiedAD", "ad", "Lcom/qq/e/ads/nativ/NativeUnifiedADData;", "showAd", "rootView", "Lcom/wy/adbook/app/base/QYView;", "showWatchingVideoDialog", "l", "Lcom/wy/adbook/app/manager/ADManager$QYRewardVideoAdListener;", "watchingVideo", "NativeADListener", "QYRewardVideoAdListener", "application_release"})
public final class ADManager {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String APPID = "1108159501";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String POSID_READ = "6020253554516280";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String POSID_READ_VIDOE = "3000457922598807";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String POSID_VIDOE = "8090559903402387";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String POSID_FREEPAGE = "4010458599581858";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String POSID_COMMIT = "4080655579093059";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String POSID_START = "5070054514010043";
    private static final int SPLASH_DELAY_TIME = 4000;
    private static com.qq.e.ads.rewardvideo.RewardVideoAD rewardVideoAD;
    private static boolean adLoaded;
    private static boolean isLoadAd;
    public static final com.wy.adbook.app.manager.ADManager INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAPPID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPOSID_READ() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPOSID_READ_VIDOE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPOSID_VIDOE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPOSID_FREEPAGE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPOSID_COMMIT() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPOSID_START() {
        return null;
    }
    
    public final int getSPLASH_DELAY_TIME() {
        return 0;
    }
    
    public final void showWatchingVideoDialog(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.app.base.QYView rootView, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.app.manager.ADManager.QYRewardVideoAdListener l) {
    }
    
    public final synchronized void watchingVideo(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.app.base.QYView rootView, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.app.manager.ADManager.QYRewardVideoAdListener l) {
    }
    
    public final void showAd(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.app.base.QYView rootView) {
    }
    
    public final void displayNativeExpressAD(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener listener) {
    }
    
    public final void displayNativeExpressAD(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup content, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    com.wy.adbook.app.manager.ADManager.NativeADListener listener) {
    }
    
    public final void displaySplashAD(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup adContainer, @org.jetbrains.annotations.NotNull()
    android.view.View skip, @org.jetbrains.annotations.NotNull()
    java.lang.String posId, @org.jetbrains.annotations.NotNull()
    com.qq.e.ads.splash.SplashADListener adListener, int fetchDelay) {
    }
    
    public final void displayVideoAD(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.qq.e.ads.nativ.widget.NativeAdContainer content, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    com.wy.adbook.app.manager.ADManager.NativeADListener listener) {
    }
    
    private final void initNativeUnifiedAD(android.content.Context context, com.qq.e.ads.nativ.widget.NativeAdContainer content, com.qq.e.ads.nativ.NativeUnifiedADData ad, com.wy.adbook.app.manager.ADManager.NativeADListener listener) {
    }
    
    private ADManager() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/wy/adbook/app/manager/ADManager$NativeADListener;", "", "onADClosed", "", "onNoAD", "application_release"})
    public static abstract interface NativeADListener {
        
        public abstract void onADClosed();
        
        public abstract void onNoAD();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/app/manager/ADManager$QYRewardVideoAdListener;", "", "onVideoComplete", "", "application_release"})
    public static abstract interface QYRewardVideoAdListener {
        
        public abstract void onVideoComplete();
    }
}