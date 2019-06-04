package com.wy.adbook.mvp.view.activity;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/5.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002#$B\u0005\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006%"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/ClassificationDetailActivity;", "Lcom/wy/adbook/app/base/QYBaseActivity;", "Lcom/wy/adbook/mvp/presenter/ClassificationDetailPresenter;", "Lcom/wy/adbook/mvp/contranct/ClassificationDetailContract$View;", "()V", "bookVpAdapter", "Lcom/wy/adbook/mvp/view/activity/ClassificationDetailActivity$BookVpAdapter;", "getBookVpAdapter", "()Lcom/wy/adbook/mvp/view/activity/ClassificationDetailActivity$BookVpAdapter;", "bookVpAdapter$delegate", "Lkotlin/Lazy;", "fragmentList", "", "Landroid/support/v4/app/Fragment;", "getFragmentList", "()Ljava/util/List;", "fragmentList$delegate", "indicatorList", "", "getIndicatorList", "indicatorList$delegate", "getToolbar", "Landroid/view/View;", "initData", "", "savedInstanceState", "Landroid/os/Bundle;", "initIndicator", "initTitle", "initView", "", "refreshView", "setupActivityComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "BookVpAdapter", "Companion", "application_debug"})
public final class ClassificationDetailActivity extends com.wy.adbook.app.base.QYBaseActivity<com.wy.adbook.mvp.presenter.ClassificationDetailPresenter> implements com.wy.adbook.mvp.contranct.ClassificationDetailContract.View {
    private final kotlin.Lazy fragmentList$delegate = null;
    private final kotlin.Lazy bookVpAdapter$delegate = null;
    private final kotlin.Lazy indicatorList$delegate = null;
    private static final java.lang.String EXTRA_CLASSIFICATION_ITEM = "extraClassificationItem";
    public static final com.wy.adbook.mvp.view.activity.ClassificationDetailActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void setupActivityComponent(@org.jetbrains.annotations.NotNull()
    com.jess.arms.di.component.AppComponent appComponent) {
    }
    
    private final java.util.List<android.support.v4.app.Fragment> getFragmentList() {
        return null;
    }
    
    private final com.wy.adbook.mvp.view.activity.ClassificationDetailActivity.BookVpAdapter getBookVpAdapter() {
        return null;
    }
    
    private final java.util.List<java.lang.String> getIndicatorList() {
        return null;
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
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View getToolbar() {
        return null;
    }
    
    private final void initTitle() {
    }
    
    private final void initIndicator() {
    }
    
    @java.lang.Override()
    public void refreshView() {
    }
    
    public ClassificationDetailActivity() {
        super();
    }
    
    public static final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.ClassificationItem classificationItem) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/ClassificationDetailActivity$BookVpAdapter;", "Landroid/support/v4/app/FragmentStatePagerAdapter;", "fragmentList", "", "Landroid/support/v4/app/Fragment;", "fm", "Landroid/support/v4/app/FragmentManager;", "(Ljava/util/List;Landroid/support/v4/app/FragmentManager;)V", "getCount", "", "getItem", "p0", "getItemPosition", "object", "", "application_debug"})
    public static final class BookVpAdapter extends android.support.v4.app.FragmentStatePagerAdapter {
        private final java.util.List<android.support.v4.app.Fragment> fragmentList = null;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.support.v4.app.Fragment getItem(int p0) {
            return null;
        }
        
        @java.lang.Override()
        public int getCount() {
            return 0;
        }
        
        @java.lang.Override()
        public int getItemPosition(@org.jetbrains.annotations.NotNull()
        java.lang.Object object) {
            return 0;
        }
        
        public BookVpAdapter(@org.jetbrains.annotations.NotNull()
        java.util.List<android.support.v4.app.Fragment> fragmentList, @org.jetbrains.annotations.NotNull()
        android.support.v4.app.FragmentManager fm) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/ClassificationDetailActivity$Companion;", "", "()V", "EXTRA_CLASSIFICATION_ITEM", "", "startActivity", "", "context", "Landroid/content/Context;", "classificationItem", "Lcom/wy/adbook/mvp/model/entity/ClassificationItem;", "application_debug"})
    public static final class Companion {
        
        public final void startActivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.wy.adbook.mvp.model.entity.ClassificationItem classificationItem) {
        }
        
        private Companion() {
            super();
        }
    }
}