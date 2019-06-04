package com.wy.adbook.dialog;

import java.lang.System;

/**
 * * Author : zhongwenpeng
 * * Email : 1340751953@qq.com
 * * Time :  2019/1/4
 * * Description :
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00072\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\tJ \u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00072\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\u001a\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\'\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050!\u00a2\u0006\u0002\b\"R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/wy/adbook/dialog/WarningDialog;", "Lcom/wy/adbook/dialog/BaseDialogFragment;", "()V", "mCancelFunc", "Lkotlin/Function0;", "", "mCancelText", "", "mClickDismiss", "", "mConfirmFunc", "mConfirmText", "mContent", "mDes", "cancelButton", "text", "func", "clickDismiss", "boolean", "confirmButton", "content", "des", "getResourcesId", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupLayoutParams", "show", "fragmentManager", "Landroid/support/v4/app/FragmentManager;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "application_debug"})
public final class WarningDialog extends com.wy.adbook.dialog.BaseDialogFragment {
    private java.lang.String mContent;
    private java.lang.String mDes;
    private java.lang.String mConfirmText;
    private java.lang.String mCancelText;
    private kotlin.jvm.functions.Function0<kotlin.Unit> mConfirmFunc;
    private kotlin.jvm.functions.Function0<kotlin.Unit> mCancelFunc;
    private boolean mClickDismiss;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected int getResourcesId() {
        return 0;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void setupLayoutParams() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.dialog.WarningDialog content(@org.jetbrains.annotations.NotNull()
    java.lang.String content) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.dialog.WarningDialog des(@org.jetbrains.annotations.NotNull()
    java.lang.String des) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.dialog.WarningDialog confirmButton(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> func) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.dialog.WarningDialog cancelButton(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> func) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.dialog.WarningDialog clickDismiss(boolean p0_32355860) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.dialog.WarningDialog show(@org.jetbrains.annotations.NotNull()
    android.support.v4.app.FragmentManager fragmentManager, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.wy.adbook.dialog.WarningDialog, kotlin.Unit> func) {
        return null;
    }
    
    public WarningDialog() {
        super();
    }
}