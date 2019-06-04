package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019/5/5.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00015B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001bJ\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020)H\u0002J\u0006\u0010/\u001a\u00020)J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u000202H\u0002J\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\bJ\u0006\u00104\u001a\u00020)R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR$\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/wy/adbook/mvp/presenter/ClassificationPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/ClassificationContract$Model;", "Lcom/wy/adbook/mvp/contranct/ClassificationContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/ClassificationContract$Model;Lcom/wy/adbook/mvp/contranct/ClassificationContract$View;)V", "bannerList", "", "Lcom/wy/adbook/mvp/model/entity/BannerItem;", "getBannerList", "()Ljava/util/List;", "setBannerList", "(Ljava/util/List;)V", "classificationAdapter", "Lcom/wy/adbook/mvp/view/adapter/ClassificationAdapter;", "getClassificationAdapter", "()Lcom/wy/adbook/mvp/view/adapter/ClassificationAdapter;", "setClassificationAdapter", "(Lcom/wy/adbook/mvp/view/adapter/ClassificationAdapter;)V", "classificationContentAdapter", "Lcom/wy/adbook/mvp/view/adapter/ClassificationContentAdapter;", "getClassificationContentAdapter", "()Lcom/wy/adbook/mvp/view/adapter/ClassificationContentAdapter;", "setClassificationContentAdapter", "(Lcom/wy/adbook/mvp/view/adapter/ClassificationContentAdapter;)V", "classificationList", "Lcom/wy/adbook/mvp/model/entity/Classification;", "getClassificationList", "setClassificationList", "currentRequestType", "", "currentRequestType$annotations", "()V", "getCurrentRequestType", "()Ljava/lang/String;", "setCurrentRequestType", "(Ljava/lang/String;)V", "pageSize", "", "classificationClick", "", "classification", "classificationContentClick", "classificationItem", "Lcom/wy/adbook/mvp/model/entity/ClassificationItem;", "fetchBanner", "fetchData", "fetchDataByType", "isRefresh", "", "getSelectClassificationItem", "loadMore", "Companion", "application_release"})
@com.jess.arms.di.scope.ActivityScope()
public final class ClassificationPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.ClassificationContract.Model, com.wy.adbook.mvp.contranct.ClassificationContract.View> {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public java.util.List<com.wy.adbook.mvp.model.entity.BannerItem> bannerList;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.ClassificationAdapter classificationAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.wy.adbook.mvp.view.adapter.ClassificationContentAdapter classificationContentAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public java.util.List<com.wy.adbook.mvp.model.entity.Classification> classificationList;
    
    /**
     * * @link {QYService.BOY}
     *     * @link {QYService.BOY}
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentRequestType;
    private int pageSize;
    private static final java.lang.String BANNER_ARGS = "recommend";
    public static final com.wy.adbook.mvp.presenter.ClassificationPresenter.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.model.entity.BannerItem> getBannerList() {
        return null;
    }
    
    public final void setBannerList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.BannerItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.ClassificationAdapter getClassificationAdapter() {
        return null;
    }
    
    public final void setClassificationAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.ClassificationAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.view.adapter.ClassificationContentAdapter getClassificationContentAdapter() {
        return null;
    }
    
    public final void setClassificationContentAdapter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.adapter.ClassificationContentAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wy.adbook.mvp.model.entity.Classification> getClassificationList() {
        return null;
    }
    
    public final void setClassificationList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wy.adbook.mvp.model.entity.Classification> p0) {
    }
    
    @com.wy.adbook.mvp.model.api.service.QYService.NetGenderParam()
    public static void currentRequestType$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentRequestType() {
        return null;
    }
    
    public final void setCurrentRequestType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final void fetchData() {
    }
    
    private final void fetchBanner() {
    }
    
    public final void loadMore() {
    }
    
    private final void fetchDataByType(boolean isRefresh) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.wy.adbook.mvp.model.entity.ClassificationItem> getSelectClassificationItem() {
        return null;
    }
    
    public final void classificationClick(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.Classification classification) {
    }
    
    public final void classificationContentClick(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.entity.ClassificationItem classificationItem) {
    }
    
    @javax.inject.Inject()
    public ClassificationPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.ClassificationContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.ClassificationContract.View view) {
        super(null, null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/wy/adbook/mvp/presenter/ClassificationPresenter$Companion;", "", "()V", "BANNER_ARGS", "", "application_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}