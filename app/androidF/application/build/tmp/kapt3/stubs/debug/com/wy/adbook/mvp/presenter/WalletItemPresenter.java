package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-28.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/wy/adbook/mvp/presenter/WalletItemPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/WalletItemContract$Model;", "Lcom/wy/adbook/mvp/contranct/WalletItemContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/WalletItemContract$Model;Lcom/wy/adbook/mvp/contranct/WalletItemContract$View;)V", "flowPage", "Lcom/wy/adbook/mvp/model/entity/accout/FlowPage;", "getFlowPage", "()Lcom/wy/adbook/mvp/model/entity/accout/FlowPage;", "setFlowPage", "(Lcom/wy/adbook/mvp/model/entity/accout/FlowPage;)V", "application_debug"})
@com.jess.arms.di.scope.FragmentScope()
public final class WalletItemPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.WalletItemContract.Model, com.wy.adbook.mvp.contranct.WalletItemContract.View> {
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.entity.accout.FlowPage flowPage;
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.accout.FlowPage getFlowPage() {
        return null;
    }
    
    public final void setFlowPage(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.accout.FlowPage p0) {
    }
    
    @javax.inject.Inject()
    public WalletItemPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.WalletItemContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.WalletItemContract.View view) {
        super(null, null);
    }
}