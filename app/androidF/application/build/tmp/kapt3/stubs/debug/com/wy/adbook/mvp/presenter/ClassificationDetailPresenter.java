package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/5.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0017\u001a\u00020\u0015R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/wy/adbook/mvp/presenter/ClassificationDetailPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/ClassificationDetailContract$Model;", "Lcom/wy/adbook/mvp/contranct/ClassificationDetailContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/ClassificationDetailContract$Model;Lcom/wy/adbook/mvp/contranct/ClassificationDetailContract$View;)V", "bookList", "", "Lcom/wy/adbook/mvp/model/entity/book/Book;", "getBookList", "()Ljava/util/List;", "setBookList", "(Ljava/util/List;)V", "classificationItem", "Lcom/wy/adbook/mvp/model/entity/ClassificationItem;", "getClassificationItem", "()Lcom/wy/adbook/mvp/model/entity/ClassificationItem;", "setClassificationItem", "(Lcom/wy/adbook/mvp/model/entity/ClassificationItem;)V", "enterBookDetail", "", "book", "fetchData", "application_debug"})
@com.jess.arms.di.scope.ActivityScope()
public final class ClassificationDetailPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.ClassificationDetailContract.Model, com.wy.adbook.mvp.contranct.ClassificationDetailContract.View> {
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.wy.adbook.mvp.model.entity.book.Book> bookList;
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.entity.ClassificationItem classificationItem;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.wy.adbook.mvp.model.entity.book.Book> getBookList() {
        return null;
    }
    
    public final void setBookList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.wy.adbook.mvp.model.entity.book.Book> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.ClassificationItem getClassificationItem() {
        return null;
    }
    
    public final void setClassificationItem(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.ClassificationItem p0) {
    }
    
    public final void fetchData() {
    }
    
    public final void enterBookDetail(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.book.Book book) {
    }
    
    @javax.inject.Inject()
    public ClassificationDetailPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.ClassificationDetailContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.ClassificationDetailContract.View view) {
        super(null, null);
    }
}