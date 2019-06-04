package com.wy.adbook.di.component

import com.wy.adbook.di.module.WithdrawalModule
import com.wy.adbook.mvp.view.activity.WithdrawalActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019-05-26.
 */
@ActivityScope
@Component(modules = [WithdrawalModule::class], dependencies = [AppComponent::class])
interface WithdrawalComponent {
    fun inject(inject: WithdrawalActivity)
}