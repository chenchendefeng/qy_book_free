package com.wy.adbook.dialog.prompt;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-27.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u000bR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/wy/adbook/dialog/prompt/RedRevelopesDialog;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mL", "Lcom/wy/adbook/dialog/prompt/RedRevelopesDialog$RedRevelopesListener;", "setRedRevelopesListener", "", "l", "startAnim", "RedRevelopesListener", "application_debug"})
public final class RedRevelopesDialog extends android.widget.FrameLayout {
    private com.wy.adbook.dialog.prompt.RedRevelopesDialog.RedRevelopesListener mL;
    private java.util.HashMap _$_findViewCache;
    
    public final void startAnim() {
    }
    
    public final void setRedRevelopesListener(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.dialog.prompt.RedRevelopesDialog.RedRevelopesListener l) {
    }
    
    public RedRevelopesDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    public RedRevelopesDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/dialog/prompt/RedRevelopesDialog$RedRevelopesListener;", "", "ok", "", "application_debug"})
    public static abstract interface RedRevelopesListener {
        
        public abstract void ok();
    }
}