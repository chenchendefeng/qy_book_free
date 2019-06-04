package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/7.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 H2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001HB\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\b\u0010\'\u001a\u00020(H\u0002J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020(J\b\u0010+\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020(H\u0002J\u0006\u0010-\u001a\u00020(J&\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u0002002\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u0002002\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u000204J\u0006\u00109\u001a\u00020(J\b\u0010:\u001a\u00020(H\u0016J\b\u0010;\u001a\u00020(H\u0002J\u0006\u0010<\u001a\u00020(J\u0006\u0010=\u001a\u00020(J\u0006\u0010>\u001a\u00020(J\u0006\u0010?\u001a\u00020(J\u0006\u0010@\u001a\u00020(J\u0006\u0010A\u001a\u00020(J\u0006\u0010B\u001a\u00020(J\u0010\u0010C\u001a\u00020(2\u0006\u0010C\u001a\u000200H\u0002J\u000e\u0010D\u001a\u00020(2\u0006\u0010E\u001a\u00020FJ\b\u0010G\u001a\u00020(H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R?\u0010!\u001a&\u0012\f\u0012\n #*\u0004\u0018\u00010\u00190\u0019 #*\u0012\u0012\f\u0012\n #*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\"0\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\f\u001a\u0004\b$\u0010%\u00a8\u0006I"}, d2 = {"Lcom/wy/adbook/mvp/presenter/ReadPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/ReadContract$Model;", "Lcom/wy/adbook/mvp/contranct/ReadContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/ReadContract$Model;Lcom/wy/adbook/mvp/contranct/ReadContract$View;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable$delegate", "Lkotlin/Lazy;", "mCollBook", "Lcom/wy/adbook/mvp/model/dao/CollBookBean;", "getMCollBook", "()Lcom/wy/adbook/mvp/model/dao/CollBookBean;", "setMCollBook", "(Lcom/wy/adbook/mvp/model/dao/CollBookBean;)V", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "onceTiming", "", "readTime", "timeCoutDownDisposable", "Lio/reactivex/disposables/Disposable;", "getTimeCoutDownDisposable", "()Lio/reactivex/disposables/Disposable;", "setTimeCoutDownDisposable", "(Lio/reactivex/disposables/Disposable;)V", "timeCoutDownObservable", "Lio/reactivex/Observable;", "kotlin.jvm.PlatformType", "getTimeCoutDownObservable", "()Lio/reactivex/Observable;", "timeCoutDownObservable$delegate", "_30sWelfareRead", "", "addBookcase", "calculateReadTime", "checkNeedDownloadBookContent", "fetchBookDetail", "fetchChapterList", "getOssStr", "bookId", "", "ccid", "url", "isCurrent", "", "inputStream2String", "ins", "Ljava/io/InputStream;", "isFirstEnter", "loadBookChapterList", "onDestroy", "postBookPutOnSuccessEvent", "recordBook", "resetReadTime", "setFirstEnter", "startCalculateReadTime", "startDownload", "startTiming", "stopTiming", "tip", "tryDownloadNextChapter", "curChapter", "", "updateReadProgress", "Companion", "application_debug"})
@com.jess.arms.di.scope.ActivityScope()
public final class ReadPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.ReadContract.Model, com.wy.adbook.mvp.contranct.ReadContract.View> {
    private final kotlin.Lazy compositeDisposable$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.dao.CollBookBean mCollBook;
    private long readTime;
    private long onceTiming;
    @org.jetbrains.annotations.Nullable()
    private io.reactivex.disposables.Disposable timeCoutDownDisposable;
    private final kotlin.Lazy okHttpClient$delegate = null;
    private final kotlin.Lazy timeCoutDownObservable$delegate = null;
    public static final long NET_GET_30S_WELFARE_READ_TIME = 31L;
    private static final int CACHE_COUNT = 20;
    public static final com.wy.adbook.mvp.presenter.ReadPresenter.Companion Companion = null;
    
    private final io.reactivex.disposables.CompositeDisposable getCompositeDisposable() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.dao.CollBookBean getMCollBook() {
        return null;
    }
    
    public final void setMCollBook(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.dao.CollBookBean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final io.reactivex.disposables.Disposable getTimeCoutDownDisposable() {
        return null;
    }
    
    public final void setTimeCoutDownDisposable(@org.jetbrains.annotations.Nullable()
    io.reactivex.disposables.Disposable p0) {
    }
    
    public final void setFirstEnter() {
    }
    
    public final boolean isFirstEnter() {
        return false;
    }
    
    private final void fetchBookDetail() {
    }
    
    public final void fetchChapterList() {
    }
    
    public final void loadBookChapterList() {
    }
    
    private final void checkNeedDownloadBookContent() {
    }
    
    private final okhttp3.OkHttpClient getOkHttpClient() {
        return null;
    }
    
    public final void getOssStr(@org.jetbrains.annotations.NotNull()
    java.lang.String bookId, @org.jetbrains.annotations.NotNull()
    java.lang.String ccid, @org.jetbrains.annotations.NotNull()
    java.lang.String url, boolean isCurrent) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String inputStream2String(@org.jetbrains.annotations.NotNull()
    java.io.InputStream ins) throws java.io.IOException {
        return null;
    }
    
    public final void resetReadTime() {
    }
    
    public final void startCalculateReadTime() {
    }
    
    public final void calculateReadTime() {
    }
    
    /**
     * * 尝试下载下一章节
     */
    public final void tryDownloadNextChapter(int curChapter) {
    }
    
    /**
     * * 添加到书架
     */
    public final void addBookcase() {
    }
    
    private final void postBookPutOnSuccessEvent() {
    }
    
    /**
     * * 更新读书进度到后台
     */
    private final void updateReadProgress() {
    }
    
    private final io.reactivex.Observable<java.lang.Long> getTimeCoutDownObservable() {
        return null;
    }
    
    /**
     * * 开启计时
     */
    public final void startTiming() {
    }
    
    /**
     * * 停止计时
     */
    public final void stopTiming() {
    }
    
    private final void _30sWelfareRead() {
    }
    
    private final void tip(java.lang.String tip) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    public final void startDownload() {
    }
    
    public final void recordBook() {
    }
    
    @javax.inject.Inject()
    public ReadPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.ReadContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.ReadContract.View view) {
        super(null, null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/mvp/presenter/ReadPresenter$Companion;", "", "()V", "CACHE_COUNT", "", "NET_GET_30S_WELFARE_READ_TIME", "", "application_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}