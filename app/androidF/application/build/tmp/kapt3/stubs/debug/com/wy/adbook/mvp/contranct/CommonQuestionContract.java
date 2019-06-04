package com.wy.adbook.mvp.contranct;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-28.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/mvp/contranct/CommonQuestionContract;", "", "Model", "View", "application_debug"})
public abstract interface CommonQuestionContract {
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/wy/adbook/mvp/contranct/CommonQuestionContract$View;", "Lcom/wy/adbook/app/base/QYView;", "changeStatus", "", "status", "Lcom/wy/adbook/view/status/IStatusCoverView$Status;", "setRefresh", "isRefresh", "", "application_debug"})
    public static abstract interface View extends com.wy.adbook.app.base.QYView {
        
        public abstract void changeStatus(@org.jetbrains.annotations.NotNull()
        com.wy.adbook.view.status.IStatusCoverView.Status status);
        
        public abstract void setRefresh(boolean isRefresh);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/wy/adbook/mvp/contranct/CommonQuestionContract$Model;", "Lcom/wy/adbook/app/base/QYModel;", "faqList", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/NetFaqList;", "channle", "", "page", "", "pageSize", "application_debug"})
    public static abstract interface Model extends com.wy.adbook.app.base.QYModel {
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetFaqList> faqList(@org.jetbrains.annotations.NotNull()
        java.lang.String channle, int page, int pageSize);
    }
}