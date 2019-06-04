package com.wy.adbook.mvp.model;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/7.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J.\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/wy/adbook/mvp/model/ReadModel;", "Lcom/jess/arms/mvp/BaseModel;", "Lcom/wy/adbook/mvp/contranct/ReadContract$Model;", "repositoryManager", "Lcom/jess/arms/integration/IRepositoryManager;", "(Lcom/jess/arms/integration/IRepositoryManager;)V", "addToBookcase", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/book/NetPutOn;", "uid", "", "bid", "bookDetail", "Lcom/wy/adbook/mvp/model/entity/book/NetBook;", "chapterContent", "Lcom/wy/adbook/mvp/model/entity/NetChapter;", "cid", "get30sWelfareRead", "Lcom/wy/adbook/mvp/model/entity/NetGet30sWelfareRead;", "listChapter", "Lcom/wy/adbook/mvp/model/entity/NetChapterList;", "recordBook", "Lcom/wy/adbook/mvp/model/entity/NetReadFooterRecord;", "updateBookProgress", "Lcom/wy/adbook/mvp/model/entity/NetBookProgress;", "readCount", "application_debug"})
@com.jess.arms.di.scope.ActivityScope()
public final class ReadModel extends com.jess.arms.mvp.BaseModel implements com.wy.adbook.mvp.contranct.ReadContract.Model {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetReadFooterRecord> recordBook(int uid, int bid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetGet30sWelfareRead> get30sWelfareRead(int uid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetBookProgress> updateBookProgress(int uid, int bid, int cid, int readCount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetPutOn> addToBookcase(int uid, int bid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetChapter> chapterContent(int bid, int cid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetBook> bookDetail(int bid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetChapterList> listChapter(int bid) {
        return null;
    }
    
    @javax.inject.Inject()
    public ReadModel(@org.jetbrains.annotations.NotNull()
    com.jess.arms.integration.IRepositoryManager repositoryManager) {
        super(null);
    }
}