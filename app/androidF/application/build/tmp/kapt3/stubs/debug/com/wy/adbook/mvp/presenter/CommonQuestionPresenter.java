package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-28.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/wy/adbook/mvp/presenter/CommonQuestionPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/CommonQuestionContract$Model;", "Lcom/wy/adbook/mvp/contranct/CommonQuestionContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/CommonQuestionContract$Model;Lcom/wy/adbook/mvp/contranct/CommonQuestionContract$View;)V", "commonQuestionAdapter", "Lcom/wy/adbook/mvp/view/adapter/CommonQuestionAdapter;", "getCommonQuestionAdapter", "()Lcom/wy/adbook/mvp/view/adapter/CommonQuestionAdapter;", "setCommonQuestionAdapter", "(Lcom/wy/adbook/mvp/view/adapter/CommonQuestionAdapter;)V", "faqList", "", "Lcom/wy/adbook/mvp/model/entity/FaqItem;", "getFaqList", "()Ljava/util/List;", "setFaqList", "(Ljava/util/List;)V", "faqPage", "Lcom/wy/adbook/mvp/model/entity/FaqList;", "getFaqPage", "()Lcom/wy/adbook/mvp/model/entity/FaqList;", "setFaqPage", "(Lcom/wy/adbook/mvp/model/entity/FaqList;)V", "fetchData", "", "loadMore", "application_debug"})
@com.jess.arms.di.scope.FragmentScope()
public final class CommonQuestionPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.CommonQuestionContract.Model, com.wy.adbook.mvp.contranct.CommonQuestionContract.View> {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.CommonQuestionAdapter commonQuestionAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public java.util.List<com.wy.adbook.mvp.model.entity.FaqItem> faqList;
    @org.jetbrains.annotations.Nullable()
    private com.wy.adbook.mvp.model.entity.FaqList faqPage;
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.CommonQuestionAdapter getCommonQuestionAdapter() {
        return null;
    }
    
    public final void setCommonQuestionAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.CommonQuestionAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.model.entity.FaqItem> getFaqList() {
        return null;
    }
    
    public final void setFaqList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.FaqItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.wy.adbook.mvp.model.entity.FaqList getFaqPage() {
        return null;
    }
    
    public final void setFaqPage(@org.jetbrains.annotations.Nullable()
    com.wy.adbook.mvp.model.entity.FaqList p0) {
    }
    
    public final void loadMore() {
    }
    
    public final void fetchData() {
    }
    
    @javax.inject.Inject()
    public CommonQuestionPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.CommonQuestionContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.CommonQuestionContract.View view) {
        super(null, null);
    }
}