package com.wy.adbook.di.module;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0003H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/wy/adbook/di/module/MyModule;", "", "view", "Lcom/wy/adbook/mvp/contranct/MyContract$View;", "(Lcom/wy/adbook/mvp/contranct/MyContract$View;)V", "lm", "Landroid/support/v7/widget/LinearLayoutManager;", "myAdapter", "Lcom/wy/adbook/mvp/view/adapter/MyAdapter;", "list", "", "Lcom/wy/adbook/mvp/view/adapter/MyItem;", "myItemList", "provideAboutModel", "Lcom/wy/adbook/mvp/contranct/MyContract$Model;", "model", "Lcom/wy/adbook/mvp/model/MyModel;", "provideAboutView", "application_debug"})
@dagger.Module()
public final class MyModule {
    private final com.wy.adbook.mvp.contranct.MyContract.View view = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.FragmentScope()
    public final com.wy.adbook.mvp.contranct.MyContract.View provideAboutView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.FragmentScope()
    public final com.wy.adbook.mvp.contranct.MyContract.Model provideAboutModel(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.MyModel model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.FragmentScope()
    public final android.support.v7.widget.LinearLayoutManager lm() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.FragmentScope()
    public final java.util.List<com.wy.adbook.mvp.view.adapter.MyItem> myItemList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.FragmentScope()
    public final com.wy.adbook.mvp.view.adapter.MyAdapter myAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.view.adapter.MyItem> list) {
        return null;
    }
    
    public MyModule(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.MyContract.View view) {
        super();
    }
}