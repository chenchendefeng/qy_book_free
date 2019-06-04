package com.wy.adbook.mvp.view.fragment;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00014B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020!H\u0002J$\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020&2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010-\u001a\u00020!H\u0002J\u0012\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00101\u001a\u00020!2\u0006\u00102\u001a\u000203H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0017\u0010\u0014R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001b\u0010\u000fR\u001b\u0010\u001d\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\u0014\u00a8\u00065"}, d2 = {"Lcom/wy/adbook/mvp/view/fragment/BookCityFragment;", "Lcom/wy/adbook/app/base/QYBaseFragment;", "Lcom/wy/adbook/mvp/presenter/BookCityPresenter;", "Lcom/wy/adbook/mvp/contranct/BookCityContract$View;", "()V", "bookCityAdapter", "Lcom/wy/adbook/mvp/view/fragment/BookCityAdapter;", "getBookCityAdapter", "()Lcom/wy/adbook/mvp/view/fragment/BookCityAdapter;", "bookCityAdapter$delegate", "Lkotlin/Lazy;", "fragmentList", "", "Landroid/support/v4/app/Fragment;", "getFragmentList", "()Ljava/util/List;", "fragmentList$delegate", "manFragment", "Lcom/wy/adbook/mvp/view/fragment/ProjectFragment;", "getManFragment", "()Lcom/wy/adbook/mvp/view/fragment/ProjectFragment;", "manFragment$delegate", "recommendFragment", "getRecommendFragment", "recommendFragment$delegate", "titleDataList", "", "getTitleDataList", "titleDataList$delegate", "womanFragment", "getWomanFragment", "womanFragment$delegate", "initData", "", "savedInstanceState", "Landroid/os/Bundle;", "initIndicator", "initView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "refreshView", "setData", "data", "", "setupFragmentComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "Companion", "application_debug"})
public final class BookCityFragment extends com.wy.adbook.app.base.QYBaseFragment<com.wy.adbook.mvp.presenter.BookCityPresenter> implements com.wy.adbook.mvp.contranct.BookCityContract.View {
    private final kotlin.Lazy recommendFragment$delegate = null;
    private final kotlin.Lazy manFragment$delegate = null;
    private final kotlin.Lazy womanFragment$delegate = null;
    private final kotlin.Lazy fragmentList$delegate = null;
    private final kotlin.Lazy bookCityAdapter$delegate = null;
    private final kotlin.Lazy titleDataList$delegate = null;
    public static final com.wy.adbook.mvp.view.fragment.BookCityFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void setupFragmentComponent(@org.jetbrains.annotations.NotNull()
    com.jess.arms.di.component.AppComponent appComponent) {
    }
    
    @java.lang.Override()
    public void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void setData(@org.jetbrains.annotations.Nullable()
    java.lang.Object data) {
    }
    
    private final com.wy.adbook.mvp.view.fragment.ProjectFragment getRecommendFragment() {
        return null;
    }
    
    private final com.wy.adbook.mvp.view.fragment.ProjectFragment getManFragment() {
        return null;
    }
    
    private final com.wy.adbook.mvp.view.fragment.ProjectFragment getWomanFragment() {
        return null;
    }
    
    private final java.util.List<android.support.v4.app.Fragment> getFragmentList() {
        return null;
    }
    
    private final com.wy.adbook.mvp.view.fragment.BookCityAdapter getBookCityAdapter() {
        return null;
    }
    
    private final java.util.List<java.lang.String> getTitleDataList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View initView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initIndicator() {
    }
    
    private final void refreshView() {
    }
    
    public BookCityFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/wy/adbook/mvp/view/fragment/BookCityFragment$Companion;", "", "()V", "newInstance", "Lcom/wy/adbook/mvp/view/fragment/BookCityFragment;", "application_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.wy.adbook.mvp.view.fragment.BookCityFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}