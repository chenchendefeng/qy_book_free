package com.wy.adbook.mvp.model;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/wy/adbook/mvp/model/ProjectModel;", "Lcom/jess/arms/mvp/BaseModel;", "Lcom/wy/adbook/mvp/contranct/ProjectContract$Model;", "repositoryManager", "Lcom/jess/arms/integration/IRepositoryManager;", "(Lcom/jess/arms/integration/IRepositoryManager;)V", "bannerList", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/NetBanner;", "subject", "", "fetchSubject", "Lcom/wy/adbook/mvp/model/entity/NetSubjectType;", "getRM", "application_release"})
@com.jess.arms.di.scope.FragmentScope()
public final class ProjectModel extends com.jess.arms.mvp.BaseModel implements com.wy.adbook.mvp.contranct.ProjectContract.Model {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.jess.arms.integration.IRepositoryManager getRM() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetBanner> bannerList(@org.jetbrains.annotations.NotNull()
    java.lang.String subject) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetSubjectType> fetchSubject(@org.jetbrains.annotations.NotNull()
    java.lang.String subject) {
        return null;
    }
    
    @javax.inject.Inject()
    public ProjectModel(@org.jetbrains.annotations.NotNull()
    com.jess.arms.integration.IRepositoryManager repositoryManager) {
        super(null);
    }
}