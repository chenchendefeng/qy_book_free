package com.wy.adbook.di.component;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/wy/adbook/di/component/GenderComponent;", "", "inject", "", "activity", "Lcom/wy/adbook/mvp/view/activity/GenderSelectActivity;", "application_release"})
@dagger.Component(modules = {com.wy.adbook.di.module.GenderModule.class}, dependencies = {com.jess.arms.di.component.AppComponent.class})
@com.jess.arms.di.scope.ActivityScope()
public abstract interface GenderComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.wy.adbook.mvp.view.activity.GenderSelectActivity activity);
}