package com.wy.adbook.mvp.contranct;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/mvp/contranct/GenderContract;", "", "Model", "View", "application_debug"})
public abstract interface GenderContract {
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/mvp/contranct/GenderContract$View;", "Lcom/wy/adbook/app/base/QYView;", "getGender", "", "application_debug"})
    public static abstract interface View extends com.wy.adbook.app.base.QYView {
        
        /**
         * * 获取现在的性别
         */
        public abstract int getGender();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/wy/adbook/mvp/contranct/GenderContract$Model;", "Lcom/jess/arms/mvp/IModel;", "setGender", "Lio/reactivex/Observable;", "Lcom/wy/adbook/app/base/BaseEntity;", "Lcom/wy/adbook/mvp/model/entity/SetGender;", "gender", "", "application_debug"})
    public static abstract interface Model extends com.jess.arms.mvp.IModel {
        
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<com.wy.adbook.app.base.BaseEntity<com.wy.adbook.mvp.model.entity.SetGender>> setGender(int gender);
    }
}