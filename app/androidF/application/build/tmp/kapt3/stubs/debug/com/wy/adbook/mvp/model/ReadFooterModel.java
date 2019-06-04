package com.wy.adbook.mvp.model;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-28.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/wy/adbook/mvp/model/ReadFooterModel;", "Lcom/jess/arms/mvp/BaseModel;", "Lcom/wy/adbook/mvp/contranct/ReadFooterContract$Model;", "repositoryManager", "Lcom/jess/arms/integration/IRepositoryManager;", "(Lcom/jess/arms/integration/IRepositoryManager;)V", "deleteReadFooter", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/NetDeleteReadFooter;", "id", "", "getReadFooterPage", "Lcom/wy/adbook/mvp/model/entity/NetReadFooterPage;", "cuid", "pageNo", "pageSize", "application_debug"})
@com.jess.arms.di.scope.ActivityScope()
public final class ReadFooterModel extends com.jess.arms.mvp.BaseModel implements com.wy.adbook.mvp.contranct.ReadFooterContract.Model {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetReadFooterPage> getReadFooterPage(int cuid, int pageNo, int pageSize) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetDeleteReadFooter> deleteReadFooter(int id) {
        return null;
    }
    
    @javax.inject.Inject()
    public ReadFooterModel(@org.jetbrains.annotations.NotNull()
    com.jess.arms.integration.IRepositoryManager repositoryManager) {
        super(null);
    }
}