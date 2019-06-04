package com.wy.adbook.di.component

import com.wy.adbook.di.module.WithdrawalRecordModule
import com.wy.adbook.mvp.view.activity.WithdrawalRecordActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019-05-26.
 */
@ActivityScope
@Component(modules = [WithdrawalRecordModule::class], dependencies = [AppComponent::class])
interface WithdrawalRecordComponent {
    fun inject(inject: WithdrawalRecordActivity)
}