package com.wy.adbook.mvp.model;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/7.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/wy/adbook/mvp/model/BookDetailModel;", "Lcom/jess/arms/mvp/BaseModel;", "Lcom/wy/adbook/mvp/contranct/BookDetailContract$Model;", "repositoryManager", "Lcom/jess/arms/integration/IRepositoryManager;", "(Lcom/jess/arms/integration/IRepositoryManager;)V", "bookDetail", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/book/NetBook;", "bid", "", "getChapterList", "Lcom/wy/adbook/mvp/model/entity/NetChapterList;", "getRm", "pageListTogetherRead", "Lcom/wy/adbook/mvp/model/entity/NetTogetherRead;", "pageNo", "pageSize", "category", "", "putOn", "Lcom/wy/adbook/mvp/model/entity/book/NetPutOn;", "uid", "application_release"})
@com.jess.arms.di.scope.ActivityScope()
public final class BookDetailModel extends com.jess.arms.mvp.BaseModel implements com.wy.adbook.mvp.contranct.BookDetailContract.Model {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.jess.arms.integration.IRepositoryManager getRm() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetChapterList> getChapterList(int bid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetPutOn> putOn(int uid, int bid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetBook> bookDetail(int bid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetTogetherRead> pageListTogetherRead(int pageNo, int pageSize, @org.jetbrains.annotations.NotNull()
    java.lang.String category) {
        return null;
    }
    
    @javax.inject.Inject()
    public BookDetailModel(@org.jetbrains.annotations.NotNull()
    com.jess.arms.integration.IRepositoryManager repositoryManager) {
        super(null);
    }
}