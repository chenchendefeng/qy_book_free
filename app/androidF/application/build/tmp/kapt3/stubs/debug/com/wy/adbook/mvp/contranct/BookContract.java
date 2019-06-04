package com.wy.adbook.mvp.contranct;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/5.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/mvp/contranct/BookContract;", "", "Model", "View", "application_debug"})
public abstract interface BookContract {
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/wy/adbook/mvp/contranct/BookContract$View;", "Lcom/wy/adbook/app/base/QYView;", "getAdapter", "Lcom/wy/adbook/mvp/view/adapter/ClassificationDetailBookAdapter;", "refreshView", "", "startRefreshLayout", "isRefresh", "", "application_debug"})
    public static abstract interface View extends com.wy.adbook.app.base.QYView {
        
        public abstract void refreshView();
        
        @org.jetbrains.annotations.NotNull()
        public abstract com.wy.adbook.mvp.view.adapter.ClassificationDetailBookAdapter getAdapter();
        
        public abstract void startRefreshLayout(boolean isRefresh);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/wy/adbook/mvp/contranct/BookContract$Model;", "Lcom/wy/adbook/app/base/QYModel;", "pageListByBookClass", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/NetPageListByBookClass;", "pageNo", "", "pageSize", "finishFlag", "className", "", "application_debug"})
    public static abstract interface Model extends com.wy.adbook.app.base.QYModel {
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetPageListByBookClass> pageListByBookClass(int pageNo, int pageSize, int finishFlag, @org.jetbrains.annotations.NotNull()
        java.lang.String className);
    }
}