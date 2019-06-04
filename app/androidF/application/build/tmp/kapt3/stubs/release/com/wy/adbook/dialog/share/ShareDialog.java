package com.wy.adbook.dialog.share;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-20.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/wy/adbook/dialog/share/ShareDialog;", "Lcom/freebookqy/viewlib/dialog/BaseFullDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "mL", "Lcom/wy/adbook/dialog/share/ShareListener;", "getDialogLayoutId", "setShareListener", "", "l", "application_release"})
public class ShareDialog extends com.freebookqy.viewlib.dialog.BaseFullDialog {
    private com.wy.adbook.dialog.share.ShareListener mL;
    
    @java.lang.Override()
    public int getDialogLayoutId() {
        return 0;
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