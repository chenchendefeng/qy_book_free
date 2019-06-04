package com.wy.adbook.dialog.prompt;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-20.
 * * 签到成功提示
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\tR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/wy/adbook/dialog/prompt/SignSuccessPromptView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mL", "Lcom/wy/adbook/dialog/prompt/SignSuccessPromptView$SignSuccessPromptListener;", "setData", "", "goldGet", "", "setGoldGetTv", "setSignSuccessPromptListener", "l", "SignSuccessPromptListener", "application_release"})
public final class SignSuccessPromptView extends android.widget.FrameLayout {
    private com.wy.adbook.dialog.prompt.SignSuccessPromptView.SignSuccessPromptListener mL;
    private java.util.HashMap _$_findViewCache;
    
    public final void setData(int goldGet) {
    }
    
    public final void setGoldGetTv(int goldGet) {
    }
    
    public final void setSignSuccessPromptListener(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.dialog.prompt.SignSuccessPromptView.SignSuccessPromptListener l) {
    }
    
    public SignSuccessPromptView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    public SignSuccessPromptView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/dialog/prompt/SignSuccessPromptView$SignSuccessPromptListener;", "", "watchVideo", "", "application_release"})
    public static abstract interface SignSuccessPromptListener {
        
        public abstract void watchVideo();
    }
}