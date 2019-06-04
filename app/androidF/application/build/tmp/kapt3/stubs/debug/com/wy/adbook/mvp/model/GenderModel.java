package com.wy.adbook.mvp.model;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/wy/adbook/mvp/model/GenderModel;", "Lcom/jess/arms/mvp/BaseModel;", "Lcom/wy/adbook/mvp/contranct/GenderContract$Model;", "rm", "Lcom/jess/arms/integration/IRepositoryManager;", "(Lcom/jess/arms/integration/IRepositoryManager;)V", "setGender", "Lio/reactivex/Observable;", "Lcom/wy/adbook/app/base/BaseEntity;", "Lcom/wy/adbook/mvp/model/entity/SetGender;", "gender", "", "application_debug"})
@com.jess.arms.di.scope.ActivityScope()
public final class GenderModel extends com.jess.arms.mvp.BaseModel implements com.wy.adbook.mvp.contranct.GenderContract.Model {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.wy.adbook.app.base.BaseEntity<com.wy.adbook.mvp.model.entity.SetGender>> setGender(int gender) {
        return null;
    }
    
    @javax.inject.Inject()
    public GenderModel(@org.jetbrains.annotations.NotNull()
    com.jess.arms.integration.IRepositoryManager rm) {
        super(null);
    }
}