package com.wy.adbook.di.module;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u0003H\u0007J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/wy/adbook/di/module/HelpCenterModule;", "", "view", "Lcom/wy/adbook/mvp/contranct/HelpCenterContract$View;", "(Lcom/wy/adbook/mvp/contranct/HelpCenterContract$View;)V", "commonQuestionFragment", "Lcom/wy/adbook/mvp/view/fragment/CommonQuestionFragment;", "feedbackFragment", "Lcom/wy/adbook/mvp/view/fragment/FeedbackFragment;", "provideAboutModel", "Lcom/wy/adbook/mvp/contranct/HelpCenterContract$Model;", "model", "Lcom/wy/adbook/mvp/model/HelpCenterModel;", "provideAboutView", "provideIndicatorList", "", "", "application_release"})
@dagger.Module()
public final class HelpCenterModule {
    private final com.wy.adbook.mvp.contranct.HelpCenterContract.View view = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.HelpCenterContract.View provideAboutView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.HelpCenterContract.Model provideAboutModel(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.HelpCenterModel model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final java.util.List<java.lang.String> provideIndicatorList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.view.fragment.CommonQuestionFragment commonQuestionFragment() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.view.fragment.FeedbackFragment feedbackFragment() {
        return null;
    }
    
    public HelpCenterModule(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.HelpCenterContract.View view) {
        super();
    }
}