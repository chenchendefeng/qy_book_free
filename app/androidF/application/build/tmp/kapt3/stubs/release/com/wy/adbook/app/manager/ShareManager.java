package com.wy.adbook.app.manager;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-22.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u00a8\u0006\u0013"}, d2 = {"Lcom/wy/adbook/app/manager/ShareManager;", "", "()V", "shareSuccess", "", "rootView", "Lcom/wy/adbook/app/base/QYView;", "rm", "Lcom/jess/arms/integration/IRepositoryManager;", "uid", "", "errorHandler", "Lme/jessyan/rxerrorhandler/core/RxErrorHandler;", "showShareBookDialog", "context", "Landroid/content/Context;", "l", "Lcom/wy/adbook/dialog/share/ShareListener;", "showShareDialog", "application_release"})
public final class ShareManager {
    public static final com.wy.adbook.app.manager.ShareManager INSTANCE = null;
    
    public final void showShareDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.dialog.share.ShareListener l) {
    }
    
    public final void showShareBookDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.dialog.share.ShareListener l) {
    }
    
    public final void shareSuccess(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.app.base.QYView rootView, @org.jetbrains.annotations.NotNull()
    com.jess.arms.integration.IRepositoryManager rm, int uid, @org.jetbrains.annotations.NotNull()
    me.jessyan.rxerrorhandler.core.RxErrorHandler errorHandler) {
    }
    
    private ShareManager() {
        super();
    }
}