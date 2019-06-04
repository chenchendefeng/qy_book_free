package com.wy.adbook.mvp.view.activity;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/7.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001$B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0012H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006%"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/BookDetailActivity;", "Lcom/wy/adbook/app/base/QYBaseActivity;", "Lcom/wy/adbook/mvp/presenter/BookDetailPresenter;", "Lcom/wy/adbook/mvp/contranct/BookDetailContract$View;", "()V", "everyoneWatchingAdapter", "Lcom/wy/adbook/mvp/view/adapter/EveryoneWatchingAdapter;", "getEveryoneWatchingAdapter", "()Lcom/wy/adbook/mvp/view/adapter/EveryoneWatchingAdapter;", "everyoneWatchingAdapter$delegate", "Lkotlin/Lazy;", "getNumFormatSpan", "Landroid/text/SpannableStringBuilder;", "collectionCount", "", "getToolbar", "Landroid/view/View;", "initData", "", "savedInstanceState", "Landroid/os/Bundle;", "initListener", "initView", "isRefresh", "", "onNewIntent", "intent", "Landroid/content/Intent;", "refreshAd", "refreshBookInfo", "isShowBtm", "refreshGuessYouLike", "setupActivityComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "showShareDialog", "Companion", "application_debug"})
public final class BookDetailActivity extends com.wy.adbook.app.base.QYBaseActivity<com.wy.adbook.mvp.presenter.BookDetailPresenter> implements com.wy.adbook.mvp.contranct.BookDetailContract.View {
    private final kotlin.Lazy everyoneWatchingAdapter$delegate = null;
    private static final java.lang.String EXTRA_BOOK = "extraBook";
    private static final java.lang.String EXTRA_BOOK_ID = "extraBookId";
    public static final com.wy.adbook.mvp.view.activity.BookDetailActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void setupActivityComponent(@org.jetbrains.annotations.NotNull()
    com.jess.arms.di.component.AppComponent appComponent) {
    }
    
    private final com.wy.adbook.mvp.view.adapter.EveryoneWatchingAdapter getEveryoneWatchingAdapter() {
        return null;
    }
    
    @java.lang.Override()
    public int initView(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View getToolbar() {
        return null;
    }
    
    @java.lang.Override()
    protected void onNewIntent(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    @java.lang.Override()
    public void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initListener() {
    }
    
    private final void showShareDialog() {
    }
    
    @java.lang.Override()
    public void refreshBookInfo(boolean isShowBtm) {
    }
    
    private final android.text.SpannableStringBuilder getNumFormatSpan(int collectionCount) {
        return null;
    }
    
    @java.lang.Override()
    public void refreshGuessYouLike() {
    }
    
    @java.lang.Override()
    public void refreshAd() {
    }
    
    @java.lang.Override()
    public void isRefresh(boolean isRefresh) {
    }
    
    public BookDetailActivity() {
        super();
    }
    
    public static final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.book.Book book) {
    }
    
    public static final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int bookId) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/BookDetailActivity$Companion;", "", "()V", "EXTRA_BOOK", "", "EXTRA_BOOK_ID", "startActivity", "", "context", "Landroid/content/Context;", "book", "Lcom/wy/adbook/mvp/model/entity/book/Book;", "bookId", "", "application_debug"})
    public static final class Companion {
        
        public final void startActivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.wy.adbook.mvp.model.entity.book.Book book) {
        }
        
        public final void startActivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context, int bookId) {
        }
        
        private Companion() {
            super();
        }
    }
}