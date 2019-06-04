package com.wy.adbook.dialog.prompt;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-20.
 * * 连续签到提示对话框
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u0016\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/wy/adbook/dialog/prompt/ContinuousSignPromptView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mL", "Lcom/wy/adbook/dialog/prompt/ContinuousSignPromptView$ContinuousSignPromptListener;", "setContinuousSignPromptListener", "", "l", "setData", "continuousDays", "", "gold", "ContinuousSignPromptListener", "application_debug"})
public final class ContinuousSignPromptView extends android.widget.FrameLayout {
    private com.wy.adbook.dialog.prompt.ContinuousSignPromptView.ContinuousSignPromptListener mL;
    private java.util.HashMap _$_findViewCache;
    
    public final void setData(int continuousDays, int gold) {
    }
    
    public final void setContinuousSignPromptListener(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.dialog.prompt.ContinuousSignPromptView.ContinuousSignPromptListener l) {
    }
    
    public ContinuousSignPromptView(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        super(null);
    }
    
    public ContinuousSignPromptView(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/dialog/prompt/ContinuousSignPromptView$ContinuousSignPromptListener;", "", "toWithDrawal", "", "application_debug"})
    public static abstract interface ContinuousSignPromptListener {
        
        public abstract void toWithDrawal();
    }
}