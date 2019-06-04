package com.wy.adbook.mvp.contranct;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/7.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/mvp/contranct/BookDetailContract;", "", "Model", "View", "application_debug"})
public abstract interface BookDetailContract {
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/wy/adbook/mvp/contranct/BookDetailContract$View;", "Lcom/wy/adbook/app/base/QYView;", "isRefresh", "", "", "refreshAd", "refreshBookInfo", "isShowBtm", "refreshGuessYouLike", "application_debug"})
    public static abstract interface View extends com.wy.adbook.app.base.QYView {
        
        /**
         * * 刷新大家都在看
         */
        public abstract void refreshGuessYouLike();
        
        /**
         * * 刷新书籍信息
         */
        public abstract void refreshBookInfo(boolean isShowBtm);
        
        /**
         * * 刷新广告内容
         */
        public abstract void refreshAd();
        
        /**
         * * 设置下拉刷新是否显示
         */
        public abstract void isRefresh(boolean isRefresh);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\nH&J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H&J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0014"}, d2 = {"Lcom/wy/adbook/mvp/contranct/BookDetailContract$Model;", "Lcom/wy/adbook/app/base/QYModel;", "bookDetail", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/book/NetBook;", "bid", "", "getChapterList", "Lcom/wy/adbook/mvp/model/entity/NetChapterList;", "getRm", "Lcom/jess/arms/integration/IRepositoryManager;", "pageListTogetherRead", "Lcom/wy/adbook/mvp/model/entity/NetTogetherRead;", "pageNo", "pageSize", "category", "", "putOn", "Lcom/wy/adbook/mvp/model/entity/book/NetPutOn;", "uid", "application_debug"})
    public static abstract interface Model extends com.wy.adbook.app.base.QYModel {
        
        @org.jetbrains.annotations.NotNull()
        public abstract com.jess.arms.integration.IRepositoryManager getRm();
        
        /**
         * * 大家都在看
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetTogetherRead> pageListTogetherRead(int pageNo, int pageSize, @org.jetbrains.annotations.NotNull()
        java.lang.String category);
        
        /**
         * * 书籍详情
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetBook> bookDetail(int bid);
        
        /**
         * * 加入书架
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetPutOn> putOn(int uid, int bid);
        
        /**
         * * 获取章节列表
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetChapterList> getChapterList(int bid);
    }
}