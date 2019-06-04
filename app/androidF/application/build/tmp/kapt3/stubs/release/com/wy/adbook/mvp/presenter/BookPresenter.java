package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/5.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u001aR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/wy/adbook/mvp/presenter/BookPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/BookContract$Model;", "Lcom/wy/adbook/mvp/contranct/BookContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/BookContract$Model;Lcom/wy/adbook/mvp/contranct/BookContract$View;)V", "bookList", "", "Lcom/wy/adbook/mvp/model/entity/book/Book;", "getBookList", "()Ljava/util/List;", "setBookList", "(Ljava/util/List;)V", "className", "", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "finishFlag", "", "getFinishFlag", "()I", "pageNo", "enterBookDetail", "", "book", "fetchData", "loadMore", "application_release"})
@com.jess.arms.di.scope.FragmentScope()
public final class BookPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.BookContract.Model, com.wy.adbook.mvp.contranct.BookContract.View> {
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.wy.adbook.mvp.model.entity.book.Book> bookList;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String className;
    private final int finishFlag = 0;
    private int pageNo;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.wy.adbook.mvp.model.entity.book.Book> getBookList() {
        return null;
    }
    
    public final void setBookList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.wy.adbook.mvp.model.entity.book.Book> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClassName() {
        return null;
    }
    
    public final void setClassName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getFinishFlag() {
        return 0;
    }
    
    public final void fetchData() {
    }
    
    public final void loadMore() {
    }
    
    public final void enterBookDetail(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.book.Book book) {
    }
    
    @javax.inject.Inject()
    public BookPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.BookContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.BookContract.View view) {
        super(null, null);
    }
}