package com.wy.adbook.dialog;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\tR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/wy/adbook/dialog/EditTextDialog;", "Lcom/freebookqy/viewlib/dialog/BaseFullDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "mL", "Lcom/wy/adbook/dialog/EditTextDialog$EditTextDialogClickListener;", "getDialogLayoutId", "setData", "", "title", "", "hintText", "setEditTextDialogClickListener", "l", "EditTextDialogClickListener", "application_debug"})
public final class EditTextDialog extends com.freebookqy.viewlib.dialog.BaseFullDialog {
    private com.wy.adbook.dialog.EditTextDialog.EditTextDialogClickListener mL;
    
    @java.lang.Override()
    public int getDialogLayoutId() {
        return 0;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String hintText) {
    }
    
    public final void setEditTextDialogClickListener(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.dialog.EditTextDialog.EditTextDialogClickListener l) {
    }
    
    public EditTextDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    public EditTextDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int themeResId) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/wy/adbook/dialog/EditTextDialog$EditTextDialogClickListener;", "", "cancel", "", "d", "Lcom/wy/adbook/dialog/EditTextDialog;", "confirm", "inputContent", "", "application_debug"})
    public static abstract interface EditTextDialogClickListener {
        
        public abstract void cancel(@org.jetbrains.annotations.NotNull()
        com.wy.adbook.dialog.EditTextDialog d);
        
        public abstract void confirm(@org.jetbrains.annotations.NotNull()
        com.wy.adbook.dialog.EditTextDialog d, @org.jetbrains.annotations.NotNull()
        java.lang.String inputContent);
    }
}