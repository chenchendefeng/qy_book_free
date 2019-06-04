package com.wy.adbook.mvp.contranct;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/mvp/contranct/BookcaseContract;", "", "Model", "View", "application_release"})
public abstract interface BookcaseContract {
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0005H&\u00a8\u0006\f"}, d2 = {"Lcom/wy/adbook/mvp/contranct/BookcaseContract$View;", "Lcom/wy/adbook/app/base/QYView;", "getAdapter", "Lcom/wy/adbook/mvp/view/adapter/BookcaseAdapter;", "loadMoreStatus", "", "status", "", "refreshStatus", "isRefresh", "", "refreshVIew", "application_release"})
    public static abstract interface View extends com.wy.adbook.app.base.QYView {
        
        public abstract void refreshVIew();
        
        public abstract void refreshStatus(boolean isRefresh);
        
        public abstract void loadMoreStatus(int status);
        
        @org.jetbrains.annotations.NotNull()
        public abstract com.wy.adbook.mvp.view.adapter.BookcaseAdapter getAdapter();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H&J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H&\u00a8\u0006\u000e"}, d2 = {"Lcom/wy/adbook/mvp/contranct/BookcaseContract$Model;", "Lcom/wy/adbook/app/base/QYModel;", "fetchBookcase", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/NetBookcase;", "pageNo", "", "pageSize", "uid", "newBookNumPerWeek", "Lcom/wy/adbook/mvp/model/entity/book/NetNewBookNumPerWeek;", "removeBook", "Lcom/wy/adbook/mvp/model/entity/book/NetRemove;", "bid", "application_release"})
    public static abstract interface Model extends com.wy.adbook.app.base.QYModel {
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetBookcase> fetchBookcase(int pageNo, int pageSize, int uid);
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetNewBookNumPerWeek> newBookNumPerWeek();
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetRemove> removeBook(int uid, int bid);
    }
}