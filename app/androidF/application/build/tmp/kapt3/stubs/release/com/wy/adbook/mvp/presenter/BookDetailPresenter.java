package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/7.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u0006\u0010\'\u001a\u00020%J\u0006\u0010(\u001a\u00020\u000fJ\b\u0010)\u001a\u00020\u000fH\u0002J\b\u0010*\u001a\u00020%H\u0002J\u0006\u0010+\u001a\u00020%J\b\u0010,\u001a\u00020%H\u0002J\u0006\u0010-\u001a\u00020%J\u0016\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000fR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u00062"}, d2 = {"Lcom/wy/adbook/mvp/presenter/BookDetailPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/BookDetailContract$Model;", "Lcom/wy/adbook/mvp/contranct/BookDetailContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/BookDetailContract$Model;Lcom/wy/adbook/mvp/contranct/BookDetailContract$View;)V", "adViewList", "", "Lcom/qq/e/ads/nativ/NativeExpressADView;", "getAdViewList", "()Ljava/util/List;", "setAdViewList", "(Ljava/util/List;)V", "currentAdIndex", "", "extraBook", "Lcom/wy/adbook/mvp/model/entity/book/Book;", "getExtraBook", "()Lcom/wy/adbook/mvp/model/entity/book/Book;", "setExtraBook", "(Lcom/wy/adbook/mvp/model/entity/book/Book;)V", "extraBookId", "getExtraBookId", "()I", "setExtraBookId", "(I)V", "isCloseAd", "", "pageSize", "togetherRead", "Lcom/wy/adbook/mvp/model/entity/TogetherRead;", "getTogetherRead", "()Lcom/wy/adbook/mvp/model/entity/TogetherRead;", "setTogetherRead", "(Lcom/wy/adbook/mvp/model/entity/TogetherRead;)V", "closeAd", "", "enterRead", "fetchData", "getNextAdIndex", "getPageNo", "postBookPutOnSuccessEvent", "putOn", "requestAd", "shareSuccess", "startShare", "shareDialog", "Lcom/wy/adbook/dialog/share/ShareDialog;", "shareType", "application_release"})
@com.jess.arms.di.scope.ActivityScope()
public final class BookDetailPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.BookDetailContract.Model, com.wy.adbook.mvp.contranct.BookDetailContract.View> {
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.entity.book.Book extraBook;
    private int extraBookId;
    private int pageSize;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.qq.e.ads.nativ.NativeExpressADView> adViewList;
    private int currentAdIndex;
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.entity.TogetherRead togetherRead;
    private boolean isCloseAd;
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.book.Book getExtraBook() {
        return null;
    }
    
    public final void setExtraBook(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.book.Book p0) {
    }
    
    public final int getExtraBookId() {
        return 0;
    }
    
    public final void setExtraBookId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.qq.e.ads.nativ.NativeExpressADView> getAdViewList() {
        return null;
    }
    
    public final void setAdViewList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.qq.e.ads.nativ.NativeExpressADView> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.TogetherRead getTogetherRead() {
        return null;
    }
    
    public final void setTogetherRead(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.TogetherRead p0) {
    }
    
    public final void fetchData() {
    }
    
    private final int getPageNo() {
        return 0;
    }
    
    public final void startShare(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.dialog.share.ShareDialog shareDialog, @com.wy.adbook.app.constant.Constant.ShareType()
    int shareType) {
    }
    
    public final void shareSuccess() {
    }
    
    private final void requestAd() {
    }
    
    public final void closeAd() {
    }
    
    /**
     * * 存入书架
     */
    public final void putOn() {
    }
    
    private final void postBookPutOnSuccessEvent() {
    }
    
    public final void enterRead() {
    }
    
    public final int getNextAdIndex() {
        return 0;
    }
    
    @javax.inject.Inject()
    public BookDetailPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.BookDetailContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.BookDetailContract.View view) {
        super(null, null);
    }
}