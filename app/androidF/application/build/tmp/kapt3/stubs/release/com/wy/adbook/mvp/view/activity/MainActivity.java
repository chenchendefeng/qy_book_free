package com.wy.adbook.mvp.view.activity;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00014B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\bH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0007J\b\u0010$\u001a\u00020\fH\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J\u0012\u0010\'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u000202H\u0007J\b\u00103\u001a\u00020,H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/MainActivity;", "Lcom/wy/adbook/app/base/QYBaseActivity;", "Lcom/wy/adbook/mvp/presenter/MainPresenter;", "Lcom/wy/adbook/mvp/contranct/MainContract$View;", "()V", "bookCityFragment", "Lcom/wy/adbook/mvp/view/fragment/BookCityFragment;", "bookcaseFragment", "Lcom/wy/adbook/mvp/view/fragment/BookcaseFragment;", "mFragmentContainerHelper", "Lnet/lucode/hackware/magicindicator/FragmentContainerHelper;", "myFragment", "Lcom/wy/adbook/mvp/view/fragment/MyFragment;", "tagBookCity", "", "tagBookcase", "tagMy", "tagTitleList", "", "getTagTitleList", "()Ljava/util/List;", "tagTitleList$delegate", "Lkotlin/Lazy;", "tagWelfare", "welfareFragment", "Lcom/wy/adbook/mvp/view/fragment/WelfareFragment;", "addFragmentToContainer", "", "frag", "Landroid/support/v4/app/Fragment;", "tag", "getBookCityFragment", "getBookcaseFragment", "getImageResByIndex", "", "p", "getMyFragment", "getWelfareFragment", "initBtmNavigation", "initData", "savedInstanceState", "Landroid/os/Bundle;", "initView", "isHandlerStatusBarHeight", "", "setupActivityComponent", "appComponent", "Lcom/jess/arms/di/component/AppComponent;", "subscribeMainEvent", "event", "Lcom/wy/adbook/mvp/model/event/MainEvent;", "useEventBus", "Companion", "application_release"})
public final class MainActivity extends com.wy.adbook.app.base.QYBaseActivity<com.wy.adbook.mvp.presenter.MainPresenter> implements com.wy.adbook.mvp.contranct.MainContract.View {
    private final net.lucode.hackware.magicindicator.FragmentContainerHelper mFragmentContainerHelper = null;
    private final java.lang.String tagBookcase = "tagBookcase";
    private final java.lang.String tagBookCity = "tagBookCity";
    private final java.lang.String tagWelfare = "tagWelfare";
    private final java.lang.String tagMy = "tagMy";
    private com.wy.adbook.mvp.view.fragment.BookcaseFragment bookcaseFragment;
    private com.wy.adbook.mvp.view.fragment.BookCityFragment bookCityFragment;
    private com.wy.adbook.mvp.view.fragment.WelfareFragment welfareFragment;
    private com.wy.adbook.mvp.view.fragment.MyFragment myFragment;
    private final kotlin.Lazy tagTitleList$delegate = null;
    public static final com.wy.adbook.mvp.view.activity.MainActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void setupActivityComponent(@org.jetbrains.annotations.NotNull()
    com.jess.arms.di.component.AppComponent appComponent) {
    }
    
    @java.lang.Override()
    public boolean isHandlerStatusBarHeight() {
        return false;
    }
    
    @java.lang.Override()
    public int initView(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return 0;
    }
    
    private final com.wy.adbook.mvp.view.fragment.BookcaseFragment getBookcaseFragment() {
        return null;
    }
    
    private final com.wy.adbook.mvp.view.fragment.BookCityFragment getBookCityFragment() {
        return null;
    }
    
    private final com.wy.adbook.mvp.view.fragment.WelfareFragment getWelfareFragment() {
        return null;
    }
    
    private final com.wy.adbook.mvp.view.fragment.MyFragment getMyFragment() {
        return null;
    }
    
    private final java.util.List<java.lang.String> getTagTitleList() {
        return null;
    }
    
    @java.lang.Override()
    public void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void addFragmentToContainer(android.support.v4.app.Fragment frag, java.lang.String tag) {
    }
    
    private final void initBtmNavigation() {
    }
    
    @android.support.annotation.DrawableRes()
    public final int getImageResByIndex(int p) {
        return 0;
    }
    
    @java.lang.Override()
    public boolean useEventBus() {
        return false;
    }
    
    @org.simple.eventbus.Subscriber(mode = org.simple.eventbus.ThreadMode.MAIN)
    public final void subscribeMainEvent(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.event.MainEvent event) {
    }
    
    public MainActivity() {
        super();
    }
    
    public static final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/mvp/view/activity/MainActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "application_release"})
    public static final class Companion {
        
        public final void startActivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        private Companion() {
            super();
        }
    }
}