package com.wy.adbook.app.manager;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-22.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/wy/adbook/app/manager/ShareManager;", "", "()V", "getInviteFriend", "", "Lcom/wy/adbook/mvp/view/adapter/ShareItem;", "getShareNormal", "shareSuccess", "", "rootView", "Lcom/wy/adbook/app/base/QYView;", "rm", "Lcom/jess/arms/integration/IRepositoryManager;", "uid", "", "errorHandler", "Lme/jessyan/rxerrorhandler/core/RxErrorHandler;", "showInviteFriendDialog", "context", "Landroid/content/Context;", "l", "Lcom/wy/adbook/dialog/share/ShareListener;", "showShareBookDialog", "showShareDialog", "application_debug"})
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
    
    public final void showInviteFriendDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.dialog.share.ShareListener l) {
    }
    
    private final java.util.List<com.wy.adbook.mvp.view.adapter.ShareItem> getShareNormal() {
        return null;
    }
    
    private final java.util.List<com.wy.adbook.mvp.view.adapter.ShareItem> getInviteFriend() {
        return null;
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