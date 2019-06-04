package com.wy.adbook.mvp.view.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/wy/adbook/mvp/view/adapter/BookcaseClickListener;", "", "adClick", "", "book", "Lcom/wy/adbook/mvp/model/entity/book/Book;", "contentCick", "delete", "longClick", "application_release"})
public abstract interface BookcaseClickListener {
    
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.book.Book book);
    
    public abstract void contentCick(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.book.Book book);
    
    public abstract void adClick(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.book.Book book);
    
    public abstract void longClick(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.book.Book book);
}