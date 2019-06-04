package com.wy.adbook.view;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-09.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002-.B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\u0006\u0010\u001d\u001a\u00020\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0002J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\"J\u000e\u0010\'\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0014J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\"H\u0002J\b\u0010*\u001a\u00020\u0016H\u0002J\b\u0010+\u001a\u00020\u0016H\u0002J\u0006\u0010,\u001a\u00020\u000fR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/wy/adbook/view/CoverBookView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "collBook", "Lcom/wy/adbook/mvp/model/dao/CollBookBean;", "coverBookVIewListener", "Lcom/wy/adbook/view/CoverBookView$CoverBookVIewListener;", "instance", "Lcom/wy/adbook/view/readview/ReadSettingManager;", "isAniming", "", "isFirstEnter", "isOpenCoverView", "isOpenSetting", "settingChangeListener", "Lcom/wy/adbook/view/CoverBookView$SettingChangeListener;", "closeCoverView", "", "initBrightness", "initListener", "initSettingListener", "openCoverView", "refreshBgTheme", "refreshPageMode", "refreshSettingView", "refreshSize", "setBookInfo", "setChapterProgress", "chapterCount", "", "setCoverBookVIewListener", "l", "setCurrentChapter", "curChapter", "setSettingChangeListener", "setTypeSize", "size", "startCloseSettingWindow", "startPopSettingWindow", "tryCloseCoverBookView", "CoverBookVIewListener", "SettingChangeListener", "application_debug"})
public final class CoverBookView extends android.widget.RelativeLayout {
    private final com.wy.adbook.view.readview.ReadSettingManager instance = null;
    private com.wy.adbook.view.CoverBookView.CoverBookVIewListener coverBookVIewListener;
    private com.wy.adbook.view.CoverBookView.SettingChangeListener settingChangeListener;
    
    /**
     * * 是否在动画中
     */
    private boolean isAniming;
    
    /**
     * * 是否打开设置界面
     */
    private boolean isOpenSetting;
    
    /**
     * * 是否打开coverView
     */
    private boolean isOpenCoverView;
    private com.wy.adbook.mvp.model.dao.CollBookBean collBook;
    private boolean isFirstEnter;
    private java.util.HashMap _$_findViewCache;
    
    private final void initBrightness() {
    }
    
    public final boolean isOpenCoverView() {
        return false;
    }
    
    public final void refreshSettingView() {
    }
    
    public final void setBookInfo(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.dao.CollBookBean collBook) {
    }
    
    public final void setCurrentChapter(int curChapter) {
    }
    
    private final void setChapterProgress(int chapterCount) {
    }
    
    private final void refreshSize() {
    }
    
    private final void refreshBgTheme() {
    }
    
    private final void refreshPageMode() {
    }
    
    public final void setCoverBookVIewListener(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.view.CoverBookView.CoverBookVIewListener l) {
    }
    
    public final void setSettingChangeListener(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.view.CoverBookView.SettingChangeListener l) {
    }
    
    private final void initListener() {
    }
    
    private final void initSettingListener() {
    }
    
    private final void setTypeSize(int size) {
    }
    
    private final synchronized void startPopSettingWindow() {
    }
    
    private final synchronized void startCloseSettingWindow() {
    }
    
    public final synchronized void closeCoverView() {
    }
    
    public final synchronized void openCoverView() {
    }
    
    /**
     * * 尝试关闭coverbookView
     *     * 返回true表示拦截消费掉事件
     */
    public final boolean tryCloseCoverBookView() {
        return false;
    }
    
    public CoverBookView(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        super(null);
    }
    
    public CoverBookView(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&\u00a8\u0006\u000f"}, d2 = {"Lcom/wy/adbook/view/CoverBookView$CoverBookVIewListener;", "", "backClick", "", "chapterSeekChanged", "progress", "", "closeCoverView", "directoryClick", "downloadClick", "freeAdClick", "nextChapterClick", "nightClick", "openCoverView", "previousChapterClick", "application_debug"})
    public static abstract interface CoverBookVIewListener {
        
        /**
         * * 返回按钮
         */
        public abstract void backClick();
        
        /**
         * * 免广告按钮
         */
        public abstract void freeAdClick();
        
        /**
         * * 目录按钮
         */
        public abstract void directoryClick();
        
        /**
         * * 夜间
         */
        public abstract void nightClick();
        
        /**
         * * 下载
         */
        public abstract void downloadClick();
        
        /**
         * * 上一章
         */
        public abstract void previousChapterClick();
        
        /**
         * * 下一章
         */
        public abstract void nextChapterClick();
        
        /**
         * * 章节调节结果
         */
        public abstract void chapterSeekChanged(int progress);
        
        /**
         * * 关闭coverView成功
         */
        public abstract void closeCoverView();
        
        /**
         * * 开启coverView成功
         */
        public abstract void openCoverView();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&\u00a8\u0006\u000e"}, d2 = {"Lcom/wy/adbook/view/CoverBookView$SettingChangeListener;", "", "bgColorChange", "", "color", "Lcom/wy/adbook/view/page/PageStyle;", "brightnessSeekChange", "progress", "", "pageTurnChange", "pageTurnType", "Lcom/wy/adbook/view/page/PageMode;", "typeSizeDown", "typeSizeUp", "application_debug"})
    public static abstract interface SettingChangeListener {
        
        public abstract void brightnessSeekChange(int progress);
        
        public abstract void typeSizeDown();
        
        public abstract void typeSizeUp();
        
        public abstract void bgColorChange(@org.jetbrains.annotations.NotNull()
        com.wy.adbook.view.page.PageStyle color);
        
        public abstract void pageTurnChange(@org.jetbrains.annotations.NotNull()
        com.wy.adbook.view.page.PageMode pageTurnType);
    }
}