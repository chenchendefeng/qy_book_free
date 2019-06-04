package com.wy.adbook.di.module;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u0003H\u0007J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/wy/adbook/di/module/MyFriendModule;", "", "view", "Lcom/wy/adbook/mvp/contranct/MyFriendContract$View;", "(Lcom/wy/adbook/mvp/contranct/MyFriendContract$View;)V", "friendList", "", "Lcom/wy/adbook/mvp/model/entity/FriendItem;", "linearLayoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "provideAboutModel", "Lcom/wy/adbook/mvp/contranct/MyFriendContract$Model;", "model", "Lcom/wy/adbook/mvp/model/MyFriendModel;", "provideAboutView", "provideMyFriendAdapter", "Lcom/wy/adbook/mvp/view/adapter/MyFriendAdapter;", "list", "application_debug"})
@dagger.Module()
public final class MyFriendModule {
    private final com.wy.adbook.mvp.contranct.MyFriendContract.View view = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.MyFriendContract.View provideAboutView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.contranct.MyFriendContract.Model provideAboutModel(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.MyFriendModel model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final android.support.v7.widget.LinearLayoutManager linearLayoutManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final java.util.List<com.wy.adbook.mvp.model.entity.FriendItem> friendList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @com.jess.arms.di.scope.ActivityScope()
    public final com.wy.adbook.mvp.view.adapter.MyFriendAdapter provideMyFriendAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.FriendItem> list) {
        return null;
    }
    
    public MyFriendModule(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.MyFriendContract.View view) {
        super();
    }
}