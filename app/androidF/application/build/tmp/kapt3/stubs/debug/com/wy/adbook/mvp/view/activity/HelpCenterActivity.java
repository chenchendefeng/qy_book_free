package com.wy.adbook.mvp.view.activity;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002#$B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/HelpCenterActivity;", "Lcom/wy/adbook/app/base/QYBaseActivity;", "Lcom/wy/adbook/mvp/presenter/HelpCenterPresenter;", "Lcom/wy/adbook/mvp/contranct/HelpCenterContract$View;", "()V", "commonQuestionFragment", "Lcom/wy/adbook/mvp/view/fragment/CommonQuestionFragment;", "getCommonQuestionFragment", "()Lcom/wy/adbook/mvp/view/fragment/CommonQuestionFragment;", "setCommonQuestionFragment", "(Lcom/wy/adbook/mvp/view/fragment/CommonQuestionFragment;)V", "feedbackFragment", "Lcom/wy/adbook/mvp/view/fragment/FeedbackFragment;", "getFeedbackFragment", "()Lcom/wy/adbook/mvp/view/fragment/FeedbackFragment;", "setFeedbackFragment", "(Lcom/wy/adbook/mvp/view/fragment/FeedbackFragment;)V", "indicatorList", "", "", "getIndicatorList", "()Ljava/util/List;", "setIndicatorList", "(Ljava/util/List;)V", "initData", "", "savedInstanceState", "Landroid/os/Bundle;", "initMagicIndicator", "initView", "", "initVp", "setupActivityComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "Companion", "HelpCenterVpAdapter", "application_debug"})
public final class HelpCenterActivity extends com.wy.adbook.app.base.QYBaseActivity<com.wy.adbook.mvp.presenter.HelpCenterPresenter> implements com.wy.adbook.mvp.contranct.HelpCenterContract.View {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public java.util.List<java.lang.String> indicatorList;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.fragment.CommonQuestionFragment commonQuestionFragment;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.fragment.FeedbackFragment feedbackFragment;
    public static final com.wy.adbook.mvp.view.activity.HelpCenterActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void setupActivityComponent(@org.jetbrains.annotations.NotNull()
    com.jess.arms.di.component.AppComponent appComponent) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getIndicatorList() {
        return null;
    }
    
    public final void setIndicatorList(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.fragment.CommonQuestionFragment getCommonQuestionFragment() {
        return null;
    }
    
    public final void setCommonQuestionFragment(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.fragment.CommonQuestionFragment p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.fragment.FeedbackFragment getFeedbackFragment() {
        return null;
    }
    
    public final void setFeedbackFragment(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.fragment.FeedbackFragment p0) {
    }
    
    @java.lang.Override()
    public int initView(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return 0;
    }
    
    @java.lang.Override()
    public void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initMagicIndicator() {
    }
    
    private final void initVp() {
    }
    
    public HelpCenterActivity() {
        super();
    }
    
    public static final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/HelpCenterActivity$HelpCenterVpAdapter;", "Landroid/support/v4/app/FragmentStatePagerAdapter;", "fm", "Landroid/support/v4/app/FragmentManager;", "(Lcom/wy/adbook/mvp/view/activity/HelpCenterActivity;Landroid/support/v4/app/FragmentManager;)V", "getCount", "", "getItem", "Landroid/support/v4/app/Fragment;", "p0", "application_debug"})
    public final class HelpCenterVpAdapter extends android.support.v4.app.FragmentStatePagerAdapter {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.support.v4.app.Fragment getItem(int p0) {
            return null;
        }
        
        @java.lang.Override()
        public int getCount() {
            return 0;
        }
        
        public HelpCenterVpAdapter(@org.jetbrains.annotations.NotNull()
        android.support.v4.app.FragmentManager fm) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/HelpCenterActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "application_debug"})
    public static final class Companion {
        
        public final void startActivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        private Companion() {
            super();
        }
    }
}