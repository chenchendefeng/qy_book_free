package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-28.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u0017R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/wy/adbook/mvp/presenter/ReadFooterPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/ReadFooterContract$Model;", "Lcom/wy/adbook/mvp/contranct/ReadFooterContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/ReadFooterContract$Model;Lcom/wy/adbook/mvp/contranct/ReadFooterContract$View;)V", "readFooterAdapter", "Lcom/wy/adbook/mvp/view/adapter/ReadFooterAdapter;", "getReadFooterAdapter", "()Lcom/wy/adbook/mvp/view/adapter/ReadFooterAdapter;", "setReadFooterAdapter", "(Lcom/wy/adbook/mvp/view/adapter/ReadFooterAdapter;)V", "readFooterItemList", "", "Lcom/wy/adbook/mvp/model/entity/ReadFooterItem;", "getReadFooterItemList", "()Ljava/util/List;", "setReadFooterItemList", "(Ljava/util/List;)V", "readFooterPage", "Lcom/wy/adbook/mvp/model/entity/ReadFooterPage;", "deleteData", "", "item", "deleteReadFooter", "fetchData", "loadMore", "application_release"})
@com.jess.arms.di.scope.ActivityScope()
public final class ReadFooterPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.ReadFooterContract.Model, com.wy.adbook.mvp.contranct.ReadFooterContract.View> {
    private com.wy.adbook.mvp.model.entity.ReadFooterPage readFooterPage;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public java.util.List<com.wy.adbook.mvp.model.entity.ReadFooterItem> readFooterItemList;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.ReadFooterAdapter readFooterAdapter;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.model.entity.ReadFooterItem> getReadFooterItemList() {
        return null;
    }
    
    public final void setReadFooterItemList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.ReadFooterItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.ReadFooterAdapter getReadFooterAdapter() {
        return null;
    }
    
    public final void setReadFooterAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.ReadFooterAdapter p0) {
    }
    
    public final void fetchData() {
    }
    
    public final void loadMore() {
    }
    
    public final void deleteReadFooter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.ReadFooterItem item) {
    }
    
    private final void deleteData(com.wy.adbook.mvp.model.entity.ReadFooterItem item) {
    }
    
    @javax.inject.Inject()
    public ReadFooterPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.ReadFooterContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.ReadFooterContract.View view) {
        super(null, null);
    }
}