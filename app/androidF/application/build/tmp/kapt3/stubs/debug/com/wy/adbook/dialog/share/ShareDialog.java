package com.wy.adbook.dialog.share;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-20.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u000fR\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/wy/adbook/dialog/share/ShareDialog;", "Lcom/freebookqy/viewlib/dialog/BaseFullDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "adapter", "Lcom/wy/adbook/mvp/view/adapter/ShareItemAdapter;", "getAdapter", "()Lcom/wy/adbook/mvp/view/adapter/ShareItemAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "mL", "Lcom/wy/adbook/dialog/share/ShareListener;", "getDialogLayoutId", "setData", "", "list", "", "Lcom/wy/adbook/mvp/view/adapter/ShareItem;", "setShareListener", "l", "application_debug"})
public class ShareDialog extends com.freebookqy.viewlib.dialog.BaseFullDialog {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy adapter$delegate = null;
    private com.wy.adbook.dialog.share.ShareListener mL;
    
    @java.lang.Override()
    public int getDialogLayoutId() {
        return 0;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.view.adapter.ShareItem> list) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.ShareItemAdapter getAdapter() {
        return null;
    }
    
    public final void setShareListener(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.dialog.share.ShareListener l) {
    }
    
    public ShareDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    public ShareDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int themeResId) {
        super(null);
    }
}