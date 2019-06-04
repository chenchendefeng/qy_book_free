package com.wy.adbook.mvp.model;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/5.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b0\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/wy/adbook/mvp/model/ClassificationDetailModel;", "Lcom/jess/arms/mvp/BaseModel;", "Lcom/wy/adbook/mvp/contranct/ClassificationDetailContract$Model;", "repositoryManager", "Lcom/jess/arms/integration/IRepositoryManager;", "(Lcom/jess/arms/integration/IRepositoryManager;)V", "categoryBookList", "Lio/reactivex/Observable;", "Lcom/wy/adbook/app/base/BaseEntity;", "", "Lcom/wy/adbook/mvp/model/entity/book/Book;", "application_release"})
@com.jess.arms.di.scope.ActivityScope()
public final class ClassificationDetailModel extends com.jess.arms.mvp.BaseModel implements com.wy.adbook.mvp.contranct.ClassificationDetailContract.Model {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.app.base.BaseEntity<java.util.List<com.wy.adbook.mvp.model.entity.book.Book>>> categoryBookList() {
        return null;
    }
    
    @javax.inject.Inject()
    public ClassificationDetailModel(@org.jetbrains.annotations.NotNull()
    com.jess.arms.integration.IRepositoryManager repositoryManager) {
        super(null);
    }
}