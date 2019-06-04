package com.wy.adbook.mvp.model;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0016J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/wy/adbook/mvp/model/BookcaseModel;", "Lcom/jess/arms/mvp/BaseModel;", "Lcom/wy/adbook/mvp/contranct/BookcaseContract$Model;", "repositoryManager", "Lcom/jess/arms/integration/IRepositoryManager;", "(Lcom/jess/arms/integration/IRepositoryManager;)V", "fetchBookcase", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/NetBookcase;", "pageNo", "", "pageSize", "uid", "newBookNumPerWeek", "Lcom/wy/adbook/mvp/model/entity/book/NetNewBookNumPerWeek;", "removeBook", "Lcom/wy/adbook/mvp/model/entity/book/NetRemove;", "bid", "application_release"})
@com.jess.arms.di.scope.FragmentScope()
public final class BookcaseModel extends com.jess.arms.mvp.BaseModel implements com.wy.adbook.mvp.contranct.BookcaseContract.Model {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetNewBookNumPerWeek> newBookNumPerWeek() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetRemove> removeBook(int uid, int bid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetBookcase> fetchBookcase(int pageNo, int pageSize, int uid) {
        return null;
    }
    
    @javax.inject.Inject()
    public BookcaseModel(@org.jetbrains.annotations.NotNull()
    com.jess.arms.integration.IRepositoryManager repositoryManager) {
        super(null);
    }
}