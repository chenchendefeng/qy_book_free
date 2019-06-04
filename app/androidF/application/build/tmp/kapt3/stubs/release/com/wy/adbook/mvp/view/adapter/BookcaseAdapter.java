package com.wy.adbook.mvp.view.adapter;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u001a\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/wy/adbook/mvp/view/adapter/BookcaseAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/wy/adbook/mvp/view/adapter/MultiBookcaseItem;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "multiBookcaseItemList", "", "(Ljava/util/List;)V", "mL", "Lcom/wy/adbook/mvp/view/adapter/BookcaseClickListener;", "convert", "", "helper", "item", "refreshAd", "any", "", "refreshNormal", "book", "Lcom/wy/adbook/mvp/model/entity/book/Book;", "setBookcaseClickListener", "l", "application_release"})
public final class BookcaseAdapter extends com.chad.library.adapter.base.BaseMultiItemQuickAdapter<com.wy.adbook.mvp.view.adapter.MultiBookcaseItem, com.chad.library.adapter.base.BaseViewHolder> {
    private com.wy.adbook.mvp.view.adapter.BookcaseClickListener mL;
    
    public final void setBookcaseClickListener(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.BookcaseClickListener l) {
    }
    
    @java.lang.Override()
    protected void convert(@org.jetbrains.annotations.NotNull()
    com.chad.library.adapter.base.BaseViewHolder helper, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.MultiBookcaseItem item) {
    }
    
    private final void refreshNormal(com.chad.library.adapter.base.BaseViewHolder helper, com.wy.adbook.mvp.model.entity.book.Book book) {
    }
    
    private final void refreshAd(com.chad.library.adapter.base.BaseViewHolder helper, java.lang.Object any) {
    }
    
    public BookcaseAdapter(@org.jetbrains.annotations.Nullable()
    java.util.List<com.wy.adbook.mvp.view.adapter.MultiBookcaseItem> multiBookcaseItemList) {
        super(null);
    }
}