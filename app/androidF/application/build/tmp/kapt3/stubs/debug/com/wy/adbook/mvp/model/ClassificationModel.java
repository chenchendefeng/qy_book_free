package com.wy.adbook.mvp.model;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/5.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/wy/adbook/mvp/model/ClassificationModel;", "Lcom/jess/arms/mvp/BaseModel;", "Lcom/wy/adbook/mvp/contranct/ClassificationContract$Model;", "repositoryManager", "Lcom/jess/arms/integration/IRepositoryManager;", "(Lcom/jess/arms/integration/IRepositoryManager;)V", "categoryData", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/NetClassification;", "pageNo", "", "pageSize", "sexType", "", "fetchBanner", "Lcom/wy/adbook/mvp/model/entity/NetBanner;", "systemType", "position", "channel", "application_debug"})
@com.jess.arms.di.scope.ActivityScope()
public final class ClassificationModel extends com.jess.arms.mvp.BaseModel implements com.wy.adbook.mvp.contranct.ClassificationContract.Model {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetBanner> fetchBanner(@org.jetbrains.annotations.NotNull()
    java.lang.String systemType, @org.jetbrains.annotations.NotNull()
    java.lang.String position, @org.jetbrains.annotations.NotNull()
    java.lang.String channel) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetClassification> categoryData(int pageNo, int pageSize, @org.jetbrains.annotations.NotNull()
    java.lang.String sexType) {
        return null;
    }
    
    @javax.inject.Inject()
    public ClassificationModel(@org.jetbrains.annotations.NotNull()
    com.jess.arms.integration.IRepositoryManager repositoryManager) {
        super(null);
    }
}