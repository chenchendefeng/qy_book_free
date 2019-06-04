package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fJ\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0017J\u0016\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/wy/adbook/mvp/presenter/MyFriendPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/MyFriendContract$Model;", "Lcom/wy/adbook/mvp/contranct/MyFriendContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/MyFriendContract$Model;Lcom/wy/adbook/mvp/contranct/MyFriendContract$View;)V", "friendAdapter", "Lcom/wy/adbook/mvp/view/adapter/MyFriendAdapter;", "getFriendAdapter", "()Lcom/wy/adbook/mvp/view/adapter/MyFriendAdapter;", "setFriendAdapter", "(Lcom/wy/adbook/mvp/view/adapter/MyFriendAdapter;)V", "friendList", "", "Lcom/wy/adbook/mvp/model/entity/FriendItem;", "getFriendList", "()Ljava/util/List;", "setFriendList", "(Ljava/util/List;)V", "friendPage", "Lcom/wy/adbook/mvp/model/entity/FriendPage;", "enterIm", "", "friend", "fetchData", "loadMore", "toInviteFriend", "shareDialog", "Lcom/wy/adbook/dialog/share/ShareDialog;", "shareType", "", "application_debug"})
@com.jess.arms.di.scope.ActivityScope()
public final class MyFriendPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.MyFriendContract.Model, com.wy.adbook.mvp.contranct.MyFriendContract.View> {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.MyFriendAdapter friendAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public java.util.List<com.wy.adbook.mvp.model.entity.FriendItem> friendList;
    private com.wy.adbook.mvp.model.entity.FriendPage friendPage;
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.MyFriendAdapter getFriendAdapter() {
        return null;
    }
    
    public final void setFriendAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.MyFriendAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.model.entity.FriendItem> getFriendList() {
        return null;
    }
    
    public final void setFriendList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.FriendItem> p0) {
    }
    
    public final void fetchData() {
    }
    
    public final void loadMore() {
    }
    
    public final void enterIm(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.FriendItem friend) {
    }
    
    public final void toInviteFriend(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.dialog.share.ShareDialog shareDialog, int shareType) {
    }
    
    @javax.inject.Inject()
    public MyFriendPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.MyFriendContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.MyFriendContract.View view) {
        super(null, null);
    }
}