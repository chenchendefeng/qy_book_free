package com.wy.adbook.mvp.presenter;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r\u00a8\u0006\u000e"}, d2 = {"Lcom/wy/adbook/mvp/presenter/BasicInfoPresenter;", "Lcom/wy/adbook/app/base/QYBasePresenter;", "Lcom/wy/adbook/mvp/contranct/BasicInfoContract$Model;", "Lcom/wy/adbook/mvp/contranct/BasicInfoContract$View;", "model", "view", "(Lcom/wy/adbook/mvp/contranct/BasicInfoContract$Model;Lcom/wy/adbook/mvp/contranct/BasicInfoContract$View;)V", "handleBasicInfo", "", "item", "Lcom/wy/adbook/mvp/model/view/BasicInfo;", "toChangeNickname", "inputContent", "", "application_debug"})
@com.jess.arms.di.scope.ActivityScope()
public final class BasicInfoPresenter extends com.wy.adbook.app.base.QYBasePresenter<com.wy.adbook.mvp.contranct.BasicInfoContract.Model, com.wy.adbook.mvp.contranct.BasicInfoContract.View> {
    
    public final void handleBasicInfo(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.model.view.BasicInfo item) {
    }
    
    public final void toChangeNickname(@org.jetbrains.annotations.NotNull()
    java.lang.String inputContent) {
    }
    
    @javax.inject.Inject()
    public BasicInfoPresenter(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.BasicInfoContract.Model model, @org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.contranct.BasicInfoContract.View view) {
        super(null, null);
    }
}