package com.wy.adbook.di.module;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-28.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0003H\u0007J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/wy/adbook/di/module/WalletItemModule;", "", "view", "Lcom/wy/adbook/mvp/contranct/WalletItemContract$View;", "(Lcom/wy/adbook/mvp/contranct/WalletItemContract$View;)V", "provideAboutModel", "Lcom/wy/adbook/mvp/contranct/WalletItemContract$Model;", "model", "Lcom/wy/adbook/mvp/model/WalletItemModel;", "provideAboutView", "provideAdapter", "Lcom/wy/adbook/mvp/view/adapter/WalletItemAdapter;", "list", "", "Lcom/wy/adbook/mvp/model/entity/accout/FlowItem;", "application_release"})
@dagger.Module()
public final class WalletItemModule {
    private final com.wy.adbook.mvp.contranct.WalletItemContract.View view = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.FragmentScope()
    public final com.wy.adbook.mvp.contranct.WalletItemContract.View provideAboutView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.FragmentScope()
    public final com.wy.adbook.mvp.contranct.WalletItemContract.Model provideAboutModel(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.WalletItemModel model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.FragmentScope()
    public final com.wy.adbook.mvp.view.adapter.WalletItemAdapter provideAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.accout.FlowItem> list) {
        return null;
    }
    
    public WalletItemModule(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.WalletItemContract.View view) {
        super();
    }
}