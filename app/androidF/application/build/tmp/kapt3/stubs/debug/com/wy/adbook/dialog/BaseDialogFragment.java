package com.wy.adbook.dialog;

import java.lang.System;

/**
 * * Created by zhongwenpeng
 * * Email : 1340751953@qq.com
 * * Time :  2017/11/1
 * * Description :
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H$J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\u001a\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010#\u001a\u00020\u0014H\u0016J\u001c\u0010$\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR#\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\r\u00a8\u0006)"}, d2 = {"Lcom/wy/adbook/dialog/BaseDialogFragment;", "Landroid/support/v4/app/DialogFragment;", "()V", "mContentView", "Landroid/view/View;", "getMContentView", "()Landroid/view/View;", "setMContentView", "(Landroid/view/View;)V", "mInAnimation", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "getMInAnimation", "()Landroid/view/animation/Animation;", "mInAnimation$delegate", "Lkotlin/Lazy;", "mOutAnimation", "getMOutAnimation", "mOutAnimation$delegate", "dismissWithAnimation", "", "getResourcesId", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onViewCreated", "view", "setupLayoutParams", "show", "manager", "Landroid/support/v4/app/FragmentManager;", "tag", "", "application_debug"})
public abstract class BaseDialogFragment extends android.support.v4.app.DialogFragment {
    @org.jetbrains.annotations.Nullable()
    private android.view.View mContentView;
    private final kotlin.Lazy mOutAnimation$delegate = null;
    private final kotlin.Lazy mInAnimation$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    protected final android.view.View getMContentView() {
        return null;
    }
    
    protected final void setMContentView(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
    
    protected abstract int getResourcesId();
    
    private final android.view.animation.Animation getMOutAnimation() {
        return null;
    }
    
    private final android.view.animation.Animation getMInAnimation() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void show(@org.jetbrains.annotations.Nullable()
    android.support.v4.app.FragmentManager manager, @org.jetbrains.annotations.Nullable()
    java.lang.String tag) {
    }
    
    public void setupLayoutParams() {
    }
    
    public final void dismissWithAnimation() {
    }
    
    public BaseDialogFragment() {
        super();
    }
}