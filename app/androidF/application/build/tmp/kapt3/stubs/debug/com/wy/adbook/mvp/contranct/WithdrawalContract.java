package com.wy.adbook.mvp.contranct;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-26.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/mvp/contranct/WithdrawalContract;", "", "Model", "View", "application_debug"})
public abstract interface WithdrawalContract {
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/mvp/contranct/WithdrawalContract$View;", "Lcom/wy/adbook/app/base/QYView;", "changeStatus", "", "status", "Lcom/wy/adbook/view/status/IStatusCoverView$Status;", "refreshView", "application_debug"})
    public static abstract interface View extends com.wy.adbook.app.base.QYView {
        
        public abstract void refreshView();
        
        public abstract void changeStatus(@org.jetbrains.annotations.NotNull()
        com.wy.adbook.view.status.IStatusCoverView.Status status);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/wy/adbook/mvp/contranct/WithdrawalContract$Model;", "Lcom/wy/adbook/app/base/QYModel;", "application_debug"})
    public static abstract interface Model extends com.wy.adbook.app.base.QYModel {
    }
}