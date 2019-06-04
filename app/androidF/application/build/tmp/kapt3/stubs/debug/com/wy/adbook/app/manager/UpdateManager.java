package com.wy.adbook.app.manager;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\f"}, d2 = {"Lcom/wy/adbook/app/manager/UpdateManager;", "", "()V", "toCheckUpdate", "", "rm", "Lcom/jess/arms/integration/IRepositoryManager;", "errorHandler", "Lme/jessyan/rxerrorhandler/core/RxErrorHandler;", "rootView", "Lcom/wy/adbook/app/base/QYView;", "CheckUpdateListener", "application_debug"})
public final class UpdateManager {
    public static final com.wy.adbook.app.manager.UpdateManager INSTANCE = null;
    
    /**
     * * 去检查是否有更新
     */
    public final void toCheckUpdate(@org.jetbrains.annotations.NotNull()
    com.jess.arms.integration.IRepositoryManager rm, @org.jetbrains.annotations.NotNull()
    me.jessyan.rxerrorhandler.core.RxErrorHandler errorHandler, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.app.base.QYView rootView) {
    }
    
    private UpdateManager() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/wy/adbook/app/manager/UpdateManager$CheckUpdateListener;", "", "application_debug"})
    public static abstract interface CheckUpdateListener {
    }
}