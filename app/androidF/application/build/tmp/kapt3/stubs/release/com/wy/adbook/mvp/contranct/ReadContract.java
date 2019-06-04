package com.wy.adbook.mvp.contranct;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/7.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/mvp/contranct/ReadContract;", "", "Model", "View", "application_release"})
public abstract interface ReadContract {
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/wy/adbook/mvp/contranct/ReadContract$View;", "Lcom/wy/adbook/app/base/QYView;", "errorChapters", "", "finishChapters", "getGoldTipTv", "Landroid/widget/TextView;", "getReadPageLoader", "Lcom/wy/adbook/view/page/PageLoader;", "initReadView", "refreshChapter", "refreshProgressBar", "progress", "", "application_release"})
    public static abstract interface View extends com.wy.adbook.app.base.QYView {
        
        public abstract void refreshChapter();
        
        public abstract void finishChapters();
        
        public abstract void errorChapters();
        
        public abstract void initReadView();
        
        @org.jetbrains.annotations.Nullable()
        public abstract com.wy.adbook.view.page.PageLoader getReadPageLoader();
        
        public abstract void refreshProgressBar(float progress);
        
        @org.jetbrains.annotations.NotNull()
        public abstract android.widget.TextView getGoldTipTv();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J.\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H&\u00a8\u0006\u0016"}, d2 = {"Lcom/wy/adbook/mvp/contranct/ReadContract$Model;", "Lcom/wy/adbook/app/base/QYModel;", "addToBookcase", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/book/NetPutOn;", "uid", "", "bid", "bookDetail", "Lcom/wy/adbook/mvp/model/entity/book/NetBook;", "chapterContent", "Lcom/wy/adbook/mvp/model/entity/NetChapter;", "cid", "get30sWelfareRead", "Lcom/wy/adbook/mvp/model/entity/NetGet30sWelfareRead;", "listChapter", "Lcom/wy/adbook/mvp/model/entity/NetChapterList;", "recordBook", "Lcom/wy/adbook/mvp/model/entity/NetReadFooterRecord;", "updateBookProgress", "Lcom/wy/adbook/mvp/model/entity/NetBookProgress;", "readCount", "application_release"})
    public static abstract interface Model extends com.wy.adbook.app.base.QYModel {
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetChapterList> listChapter(int bid);
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetBook> bookDetail(int bid);
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetChapter> chapterContent(int bid, int cid);
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetPutOn> addToBookcase(int uid, int bid);
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetBookProgress> updateBookProgress(int uid, int bid, int cid, int readCount);
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetGet30sWelfareRead> get30sWelfareRead(int uid);
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetReadFooterRecord> recordBook(int uid, int bid);
    }
}