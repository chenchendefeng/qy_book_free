package com.wy.adbook.mvp.view.fragment;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/5.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001#B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0014J\b\u0010\u0019\u001a\u00020\rH\u0016J\u0012\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\rH\u0014J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0017H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006$"}, d2 = {"Lcom/wy/adbook/mvp/view/fragment/BookFragment;", "Lcom/wy/adbook/app/base/QYBaseFragment;", "Lcom/wy/adbook/mvp/presenter/BookPresenter;", "Lcom/wy/adbook/mvp/contranct/BookContract$View;", "()V", "bookAdapter", "Lcom/wy/adbook/mvp/view/adapter/ClassificationDetailBookAdapter;", "getBookAdapter", "()Lcom/wy/adbook/mvp/view/adapter/ClassificationDetailBookAdapter;", "bookAdapter$delegate", "Lkotlin/Lazy;", "getAdapter", "initData", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "isHandlerStatusBarHeight", "", "loadData", "refreshView", "setData", "data", "", "setupFragmentComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "startInitView", "startRefreshLayout", "isRefresh", "Companion", "application_debug"})
public final class BookFragment extends com.wy.adbook.app.base.QYBaseFragment<com.wy.adbook.mvp.presenter.BookPresenter> implements com.wy.adbook.mvp.contranct.BookContract.View {
    private final kotlin.Lazy bookAdapter$delegate = null;
    private static final java.lang.String BOOK_TYPE = "bookType";
    public static final com.wy.adbook.mvp.view.fragment.BookFragment.Companion Companion = null;
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
    
    @java.lang.Override()
    protected void startInitView() {
    }
    
    @java.lang.Override()
    public boolean isHandlerStatusBarHeight() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View initView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final com.wy.adbook.mvp.view.adapter.ClassificationDetailBookAdapter getBookAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.wy.adbook.mvp.view.adapter.ClassificationDetailBookAdapter getAdapter() {
        return null;
    }
    
    @java.lang.Override()
    protected void loadData() {
    }
    
    @java.lang.Override()
    public void startRefreshLayout(boolean isRefresh) {
    }
    
    @java.lang.Override()
    public void refreshView() {
    }
    
    public BookFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/wy/adbook/mvp/view/fragment/BookFragment$Companion;", "", "()V", "BOOK_TYPE", "", "newInstance", "Lcom/wy/adbook/mvp/view/fragment/BookFragment;", "bookType", "", "application_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.wy.adbook.mvp.view.fragment.BookFragment newInstance(@com.wy.adbook.mvp.model.entity.book.Book.FinishFlag()
        int bookType) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}