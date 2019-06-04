package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0002J\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bJ\b\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/wy/adbook/mvp/presenter/WelcomePresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/IWelcomeContract$Model;", "Lcom/wy/adbook/mvp/contranct/IWelcomeContract$View;", "model", "rootView", "(Lcom/wy/adbook/mvp/contranct/IWelcomeContract$Model;Lcom/wy/adbook/mvp/contranct/IWelcomeContract$View;)V", "isFetchDataSuccess", "", "isPermissionChecked", "checkAccoutStatusAndEnterMain", "", "checkAdAndCuntDown", "enterMain", "fetchData", "handlePermission", "hasAd", "showAd", "startCountDown", "delayTime", "", "isShowInSkip", "startVisitorLogin", "tryHandlerNetStartPage", "Companion", "application_release"})
@com.jess.arms.di.scope.ActivityScope()
public final class WelcomePresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.IWelcomeContract.Model, com.wy.adbook.mvp.contranct.IWelcomeContract.View> {
    private boolean isPermissionChecked;
    private boolean isFetchDataSuccess;
    public static final long DELAY_TIME = 1L;
    public static final long DELAY_AD_TIME = 5L;
    public static final long DELAY_NO_AD_TIME = 3L;
    public static final com.wy.adbook.mvp.presenter.WelcomePresenter.Companion Companion = null;
    
    public final void checkAdAndCuntDown() {
    }
    
    private final void showAd() {
    }
    
    /**
     * * 计时
     */
    public final void startCountDown(long delayTime, boolean isShowInSkip) {
    }
    
    public final void checkAccoutStatusAndEnterMain() {
    }
    
    private final void startVisitorLogin() {
    }
    
    private final void enterMain() {
    }
    
    public final void fetchData() {
    }
    
    private final void tryHandlerNetStartPage() {
    }
    
    public final void handlePermission() {
    }
    
    private final boolean hasAd() {
        return false;
    }
    
    @javax.inject.Inject()
    public WelcomePresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.IWelcomeContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.IWelcomeContract.View rootView) {
        super(null, null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/mvp/presenter/WelcomePresenter$Companion;", "", "()V", "DELAY_AD_TIME", "", "DELAY_NO_AD_TIME", "DELAY_TIME", "application_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}