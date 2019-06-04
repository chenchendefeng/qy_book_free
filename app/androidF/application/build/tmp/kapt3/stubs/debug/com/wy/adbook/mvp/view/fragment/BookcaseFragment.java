package com.wy.adbook.mvp.view.fragment;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001:B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\"\u001a\u00020\u001aH\u0014J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010\'\u001a\u00020\u001aH\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001aH\u0016J\u0012\u0010,\u001a\u00020\u001a2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u001aH\u0014J\u0010\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u000208H\u0007J\b\u00109\u001a\u00020*H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006;"}, d2 = {"Lcom/wy/adbook/mvp/view/fragment/BookcaseFragment;", "Lcom/wy/adbook/app/base/QYBaseFragment;", "Lcom/wy/adbook/mvp/presenter/BookcasePresenter;", "Lcom/wy/adbook/mvp/contranct/BookcaseContract$View;", "()V", "bookcaseAdapter", "Lcom/wy/adbook/mvp/view/adapter/BookcaseAdapter;", "getBookcaseAdapter", "()Lcom/wy/adbook/mvp/view/adapter/BookcaseAdapter;", "bookcaseAdapter$delegate", "Lkotlin/Lazy;", "footerView", "Landroid/view/View;", "getFooterView", "()Landroid/view/View;", "footerView$delegate", "headerView", "getHeaderView", "headerView$delegate", "newBooksTv", "Landroid/widget/TextView;", "getNewBooksTv", "()Landroid/widget/TextView;", "newBooksTv$delegate", "getAdapter", "initData", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "loadData", "loadMoreStatus", "status", "", "refreshAdapter", "refreshHeader", "refreshStatus", "isRefresh", "", "refreshVIew", "setData", "data", "", "setupFragmentComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "showRemoveDialog", "book", "Lcom/wy/adbook/mvp/model/entity/book/Book;", "startInitView", "subscribeBookEvent", "event", "Lcom/wy/adbook/mvp/model/event/BookEvent;", "useEventBus", "Companion", "application_debug"})
public final class BookcaseFragment extends com.wy.adbook.app.base.QYBaseFragment<com.wy.adbook.mvp.presenter.BookcasePresenter> implements com.wy.adbook.mvp.contranct.BookcaseContract.View {
    private final kotlin.Lazy newBooksTv$delegate = null;
    private final kotlin.Lazy headerView$delegate = null;
    private final kotlin.Lazy footerView$delegate = null;
    private final kotlin.Lazy bookcaseAdapter$delegate = null;
    public static final com.wy.adbook.mvp.view.fragment.BookcaseFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.wy.adbook.mvp.view.adapter.BookcaseAdapter getAdapter() {
        return null;
    }
    
    @java.lang.Override()
    public boolean useEventBus() {
        return false;
    }
    
    @java.lang.Override()
    public void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void setData(@org.jetbrains.annotations.Nullable()
    java.lang.Object data) {
    }
    
    private final android.widget.TextView getNewBooksTv() {
        return null;
    }
    
    private final android.view.View getHeaderView() {
        return null;
    }
    
    private final android.view.View getFooterView() {
        return null;
    }
    
    private final com.wy.adbook.mvp.view.adapter.BookcaseAdapter getBookcaseAdapter() {
        return null;
    }
    
    private final void showRemoveDialog(com.wy.adbook.mvp.model.entity.book.Book book) {
    }
    
    @java.lang.Override()
    public void setupFragmentComponent(@org.jetbrains.annotations.NotNull()
    com.jess.arms.di.component.AppComponent appComponent) {
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
    protected void startInitView() {
    }
    
    @java.lang.Override()
    protected void loadData() {
    }
    
    @java.lang.Override()
    public void refreshVIew() {
    }
    
    private final void refreshHeader() {
    }
    
    private final void refreshAdapter() {
    }
    
    @java.lang.Override()
    public void refreshStatus(boolean isRefresh) {
    }
    
    @java.lang.Override()
    public void loadMoreStatus(int status) {
    }
    
    @org.simple.eventbus.Subscriber(mode = org.simple.eventbus.ThreadMode.MAIN)
    public final void subscribeBookEvent(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.event.BookEvent event) {
    }
    
    public BookcaseFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/wy/adbook/mvp/view/fragment/BookcaseFragment$Companion;", "", "()V", "newInstance", "Lcom/wy/adbook/mvp/view/fragment/BookcaseFragment;", "application_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.wy.adbook.mvp.view.fragment.BookcaseFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}