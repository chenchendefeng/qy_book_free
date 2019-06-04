package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/6.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010 \u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012\u00a8\u0006!"}, d2 = {"Lcom/wy/adbook/mvp/presenter/MyWalletPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/MyWalletContract$Model;", "Lcom/wy/adbook/mvp/contranct/MyWalletContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/MyWalletContract$Model;Lcom/wy/adbook/mvp/contranct/MyWalletContract$View;)V", "balance", "Lcom/wy/adbook/mvp/model/entity/accout/Balance;", "getBalance", "()Lcom/wy/adbook/mvp/model/entity/accout/Balance;", "setBalance", "(Lcom/wy/adbook/mvp/model/entity/accout/Balance;)V", "goldFlowPage", "Lcom/wy/adbook/mvp/model/entity/accout/FlowPage;", "getGoldFlowPage", "()Lcom/wy/adbook/mvp/model/entity/accout/FlowPage;", "setGoldFlowPage", "(Lcom/wy/adbook/mvp/model/entity/accout/FlowPage;)V", "rmbFlowPage", "getRmbFlowPage", "setRmbFlowPage", "fetchData", "", "loadMore", "currency", "", "pageNo", "", "adapter", "Lcom/wy/adbook/mvp/view/adapter/WalletItemAdapter;", "loadMoreGold", "loadMoreRmb", "application_debug"})
@com.jess.arms.di.scope.ActivityScope()
public final class MyWalletPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.MyWalletContract.Model, com.wy.adbook.mvp.contranct.MyWalletContract.View> {
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.entity.accout.Balance balance;
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.entity.accout.FlowPage rmbFlowPage;
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.entity.accout.FlowPage goldFlowPage;
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.accout.Balance getBalance() {
        return null;
    }
    
    public final void setBalance(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.accout.Balance p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.accout.FlowPage getRmbFlowPage() {
        return null;
    }
    
    public final void setRmbFlowPage(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.accout.FlowPage p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.accout.FlowPage getGoldFlowPage() {
        return null;
    }
    
    public final void setGoldFlowPage(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.accout.FlowPage p0) {
    }
    
    /**
     * * 获取用户现金情况
     */
    public final void fetchData() {
    }
    
    public final void loadMoreRmb(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.WalletItemAdapter adapter) {
    }
    
    public final void loadMoreGold(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.WalletItemAdapter adapter) {
    }
    
    private final void loadMore(java.lang.String currency, int pageNo, com.wy.adbook.mvp.view.adapter.WalletItemAdapter adapter) {
    }
    
    @javax.inject.Inject()
    public MyWalletPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.MyWalletContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.MyWalletContract.View view) {
        super(null, null);
    }
}