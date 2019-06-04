package com.wy.adbook.mvp.contranct;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/5.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/mvp/contranct/ClassificationContract;", "", "Model", "View", "application_release"})
public abstract interface ClassificationContract {
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2 = {"Lcom/wy/adbook/mvp/contranct/ClassificationContract$View;", "Lcom/wy/adbook/app/base/QYView;", "isRefresh", "", "", "refreshView", "application_release"})
    public static abstract interface View extends com.wy.adbook.app.base.QYView {
        
        public abstract void refreshView();
        
        public abstract void isRefresh(boolean isRefresh);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH&\u00a8\u0006\u000f"}, d2 = {"Lcom/wy/adbook/mvp/contranct/ClassificationContract$Model;", "Lcom/wy/adbook/app/base/QYModel;", "categoryData", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/NetClassification;", "pageNo", "", "pageSize", "sexType", "", "fetchBanner", "Lcom/wy/adbook/mvp/model/entity/NetBanner;", "systemType", "position", "channel", "application_release"})
    public static abstract interface Model extends com.wy.adbook.app.base.QYModel {
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetClassification> categoryData(int pageNo, int pageSize, @org.jetbrains.annotations.NotNull()
        java.lang.String sexType);
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetBanner> fetchBanner(@org.jetbrains.annotations.NotNull()
        java.lang.String systemType, @org.jetbrains.annotations.NotNull()
        java.lang.String position, @org.jetbrains.annotations.NotNull()
        java.lang.String channel);
    }
}