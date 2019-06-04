package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u0016J\u0006\u0010\u001c\u001a\u00020\u0016J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!J\u0006\u0010#\u001a\u00020\u0016J\u0006\u0010$\u001a\u00020\u0016J\u000e\u0010%\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/wy/adbook/mvp/presenter/BookcasePresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/BookcaseContract$Model;", "Lcom/wy/adbook/mvp/contranct/BookcaseContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/BookcaseContract$Model;Lcom/wy/adbook/mvp/contranct/BookcaseContract$View;)V", "bookcase", "Lcom/wy/adbook/mvp/model/entity/Bookcase;", "getBookcase", "()Lcom/wy/adbook/mvp/model/entity/Bookcase;", "setBookcase", "(Lcom/wy/adbook/mvp/model/entity/Bookcase;)V", "newBookNum", "", "getNewBookNum", "()I", "setNewBookNum", "(I)V", "pageNo", "pageSize", "addBook", "", "book", "Lcom/wy/adbook/mvp/model/entity/book/Book;", "bookContentClick", "cashCheckClick", "enterBookCity", "enterSearch", "fetchBookcaseList", "isRefresh", "", "getBookItem", "", "Lcom/wy/adbook/mvp/view/adapter/MultiBookcaseItem;", "getCashEveryDay", "makeLotMoney", "removeBook", "application_release"})
@com.jess.arms.di.scope.FragmentScope()
public final class BookcasePresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.BookcaseContract.Model, com.wy.adbook.mvp.contranct.BookcaseContract.View> {
    private int pageNo;
    private int pageSize;
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.entity.Bookcase bookcase;
    private int newBookNum;
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.Bookcase getBookcase() {
        return null;
    }
    
    public final void setBookcase(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.Bookcase p0) {
    }
    
    public final int getNewBookNum() {
        return 0;
    }
    
    public final void setNewBookNum(int p0) {
    }
    
    public final void fetchBookcaseList(boolean isRefresh) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.view.adapter.MultiBookcaseItem> getBookItem() {
        return null;
    }
    
    public final void cashCheckClick() {
    }
    
    public final void getCashEveryDay() {
    }
    
    public final void makeLotMoney() {
    }
    
    public final void enterSearch() {
    }
    
    public final void enterBookCity() {
    }
    
    public final void removeBook(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.book.Book book) {
    }
    
    public final void addBook(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.book.Book book) {
    }
    
    public final void bookContentClick(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.book.Book book) {
    }
    
    @javax.inject.Inject()
    public BookcasePresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.BookcaseContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.BookcaseContract.View view) {
        super(null, null);
    }
}