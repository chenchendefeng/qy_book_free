package com.wy.adbook.dialog.prompt;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-20.
 * * 补签提示对话框
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0012B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\tR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/wy/adbook/dialog/prompt/RetroactivePromptView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mL", "Lcom/wy/adbook/dialog/prompt/RetroactivePromptView$RetroactivePromptListener;", "setData", "", "isWatchVideoForRetroactive", "", "contentStr", "", "setRetroactivePromptListener", "l", "RetroactivePromptListener", "application_release"})
public final class RetroactivePromptView extends android.widget.LinearLayout {
    private com.wy.adbook.dialog.prompt.RetroactivePromptView.RetroactivePromptListener mL;
    private java.util.HashMap _$_findViewCache;
    
    public final void setData(boolean isWatchVideoForRetroactive) {
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.lang.String contentStr) {
    }
    
    public final void setRetroactivePromptListener(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.dialog.prompt.RetroactivePromptView.RetroactivePromptListener l) {
    }
    
    public RetroactivePromptView(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        super(null);
    }
    
    public RetroactivePromptView(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/wy/adbook/dialog/prompt/RetroactivePromptView$RetroactivePromptListener;", "", "goldBeans", "", "watchVideo", "application_release"})
    public static abstract interface RetroactivePromptListener {
        
        public abstract void watchVideo();
        
        public abstract void goldBeans();
    }
}