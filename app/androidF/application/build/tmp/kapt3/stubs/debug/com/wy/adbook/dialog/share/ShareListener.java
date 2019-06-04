package com.wy.adbook.dialog.share;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-20.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/wy/adbook/dialog/share/ShareListener;", "", "share", "", "shareDialog", "Lcom/wy/adbook/dialog/share/ShareDialog;", "shareType", "", "application_debug"})
public abstract interface ShareListener {
    
    public abstract void share(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.dialog.share.ShareDialog shareDialog, @com.wy.adbook.app.constant.Constant.ShareType()
    int shareType);
}