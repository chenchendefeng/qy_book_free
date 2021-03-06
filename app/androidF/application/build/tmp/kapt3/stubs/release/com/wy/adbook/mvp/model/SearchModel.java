package com.wy.adbook.mvp.model;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/3.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/wy/adbook/mvp/model/SearchModel;", "Lcom/jess/arms/mvp/BaseModel;", "Lcom/wy/adbook/mvp/contranct/SearchContract$Model;", "repositoryManager", "Lcom/jess/arms/integration/IRepositoryManager;", "(Lcom/jess/arms/integration/IRepositoryManager;)V", "guessYouLike", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/NetGuessYouLike;", "pageNo", "", "pageSize", "search", "Lcom/wy/adbook/mvp/model/entity/NetSearchResult;", "key", "", "application_release"})
@com.jess.arms.di.scope.ActivityScope()
public final class SearchModel extends com.jess.arms.mvp.BaseModel implements com.wy.adbook.mvp.contranct.SearchContract.Model {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetSearchResult> search(@org.jetbrains.annotations.NotNull()
    java.lang.String key, int pageNo, int pageSize) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetGuessYouLike> guessYouLike(int pageNo, int pageSize) {
        return null;
    }
    
    @javax.inject.Inject()
    public SearchModel(@org.jetbrains.annotations.NotNull()
    com.jess.arms.integration.IRepositoryManager repositoryManager) {
        super(null);
    }
}