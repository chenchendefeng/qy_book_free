package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/3.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 .2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001.B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\"J \u0010\'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0006\u0010+\u001a\u00020\"J\u000e\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006/"}, d2 = {"Lcom/wy/adbook/mvp/presenter/SearchPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/SearchContract$Model;", "Lcom/wy/adbook/mvp/contranct/SearchContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/SearchContract$Model;Lcom/wy/adbook/mvp/contranct/SearchContract$View;)V", "guessLikePageSize", "", "guessYouLike", "Lcom/wy/adbook/mvp/model/entity/GuessYouLike;", "getGuessYouLike", "()Lcom/wy/adbook/mvp/model/entity/GuessYouLike;", "setGuessYouLike", "(Lcom/wy/adbook/mvp/model/entity/GuessYouLike;)V", "pageSize", "searchKeyStr", "", "getSearchKeyStr", "()Ljava/lang/String;", "setSearchKeyStr", "(Ljava/lang/String;)V", "searchResult", "Lcom/wy/adbook/mvp/model/entity/SearchResult;", "getSearchResult", "()Lcom/wy/adbook/mvp/model/entity/SearchResult;", "setSearchResult", "(Lcom/wy/adbook/mvp/model/entity/SearchResult;)V", "searchViewType", "getSearchViewType", "()I", "setSearchViewType", "(I)V", "change", "", "enterBookDetail", "book", "Lcom/wy/adbook/mvp/model/entity/book/Book;", "fetchData", "fetchGuessYouLike", "isRefresh", "", "pageNo", "loadMore", "search", "key", "Companion", "application_release"})
@com.jess.arms.di.scope.ActivityScope()
public final class SearchPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.SearchContract.Model, com.wy.adbook.mvp.contranct.SearchContract.View> {
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.entity.GuessYouLike guessYouLike;
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.entity.SearchResult searchResult;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String searchKeyStr;
    private int pageSize;
    private int guessLikePageSize;
    private int searchViewType;
    public static final int VIEW_TYPE_GUESS = 0;
    public static final int VIEW_TYPE_START_SEARCH = 1;
    public static final int VIEW_TYPE_SEARCH_RESULT = 2;
    public static final com.wy.adbook.mvp.presenter.SearchPresenter.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.GuessYouLike getGuessYouLike() {
        return null;
    }
    
    public final void setGuessYouLike(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.GuessYouLike p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.SearchResult getSearchResult() {
        return null;
    }
    
    public final void setSearchResult(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.SearchResult p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSearchKeyStr() {
        return null;
    }
    
    public final void setSearchKeyStr(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getSearchViewType() {
        return 0;
    }
    
    public final void setSearchViewType(int p0) {
    }
    
    public final void fetchData() {
    }
    
    public final void loadMore() {
    }
    
    public final void search(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    private final void fetchGuessYouLike(boolean isRefresh, int pageNo, int pageSize) {
    }
    
    public final void enterBookDetail(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.book.Book book) {
    }
    
    public final void change() {
    }
    
    @javax.inject.Inject()
    public SearchPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.SearchContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.SearchContract.View view) {
        super(null, null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/mvp/presenter/SearchPresenter$Companion;", "", "()V", "VIEW_TYPE_GUESS", "", "VIEW_TYPE_SEARCH_RESULT", "VIEW_TYPE_START_SEARCH", "application_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}