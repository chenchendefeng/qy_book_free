package com.wy.adbook.mvp.contranct;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/mvp/contranct/ProjectContract;", "", "Model", "View", "application_release"})
public abstract interface ProjectContract {
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/wy/adbook/mvp/contranct/ProjectContract$View;", "Lcom/wy/adbook/app/base/QYView;", "changeStatusCoverView", "", "status", "Lcom/wy/adbook/view/status/IStatusCoverView$Status;", "refreshBanner", "refreshStatus", "isRefresh", "", "application_release"})
    public static abstract interface View extends com.wy.adbook.app.base.QYView {
        
        public abstract void refreshStatus(boolean isRefresh);
        
        public abstract void refreshBanner();
        
        public abstract void changeStatusCoverView(@org.jetbrains.annotations.NotNull()
        com.wy.adbook.view.status.IStatusCoverView.Status status);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/wy/adbook/mvp/contranct/ProjectContract$Model;", "Lcom/wy/adbook/app/base/QYModel;", "bannerList", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/NetBanner;", "subject", "", "fetchSubject", "Lcom/wy/adbook/mvp/model/entity/NetSubjectType;", "getRM", "Lcom/jess/arms/integration/IRepositoryManager;", "application_release"})
    public static abstract interface Model extends com.wy.adbook.app.base.QYModel {
        
        @org.jetbrains.annotations.NotNull()
        public abstract com.jess.arms.integration.IRepositoryManager getRM();
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetSubjectType> fetchSubject(@org.jetbrains.annotations.NotNull()
        java.lang.String subject);
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetBanner> bannerList(@org.jetbrains.annotations.NotNull()
        java.lang.String subject);
    }
}