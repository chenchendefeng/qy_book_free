package com.wy.adbook.mvp.view.activity;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/3.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e\u00a8\u0006 "}, d2 = {"Lcom/wy/adbook/mvp/view/activity/SearchActivity;", "Lcom/wy/adbook/app/base/QYBaseActivity;", "Lcom/wy/adbook/mvp/presenter/SearchPresenter;", "Lcom/wy/adbook/mvp/contranct/SearchContract$View;", "()V", "searchAdapter", "Lcom/wy/adbook/mvp/view/adapter/SearchAdapter;", "getSearchAdapter", "()Lcom/wy/adbook/mvp/view/adapter/SearchAdapter;", "searchAdapter$delegate", "Lkotlin/Lazy;", "searchGuessLikeAdapter", "Lcom/wy/adbook/mvp/view/adapter/SearchGuessLikeAdapter;", "getSearchGuessLikeAdapter", "()Lcom/wy/adbook/mvp/view/adapter/SearchGuessLikeAdapter;", "searchGuessLikeAdapter$delegate", "initData", "", "savedInstanceState", "Landroid/os/Bundle;", "initListener", "initView", "", "isHandlerStatusBarHeight", "", "loadStatus", "loadMoreStatus", "refreshView", "setupActivityComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "Companion", "application_debug"})
public final class SearchActivity extends com.wy.adbook.app.base.QYBaseActivity<com.wy.adbook.mvp.presenter.SearchPresenter> implements com.wy.adbook.mvp.contranct.SearchContract.View {
    private final kotlin.Lazy searchGuessLikeAdapter$delegate = null;
    private final kotlin.Lazy searchAdapter$delegate = null;
    public static final com.wy.adbook.mvp.view.activity.SearchActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void setupActivityComponent(@org.jetbrains.annotations.NotNull()
    com.jess.arms.di.component.AppComponent appComponent) {
    }
    
    @java.lang.Override()
    public boolean isHandlerStatusBarHeight() {
        return false;
    }
    
    private final com.wy.adbook.mvp.view.adapter.SearchGuessLikeAdapter getSearchGuessLikeAdapter() {
        return null;
    }
    
    private final com.wy.adbook.mvp.view.adapter.SearchAdapter getSearchAdapter() {
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
    
    private final void initListener() {
    }
    
    @java.lang.Override()
    public void refreshView() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.wy.adbook.mvp.view.adapter.SearchAdapter searchAdapter() {
        return null;
    }
    
    @java.lang.Override()
    public void loadStatus(int loadMoreStatus) {
    }
    
    public SearchActivity() {
        super();
    }
    
    public static final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/SearchActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "application_debug"})
    public static final class Companion {
        
        public final void startActivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        private Companion() {
            super();
        }
    }
}