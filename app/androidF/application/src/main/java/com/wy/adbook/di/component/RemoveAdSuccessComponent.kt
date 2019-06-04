package com.wy.adbook.di.component

import com.wy.adbook.di.module.RemoveAdSuccessModule
import com.wy.adbook.mvp.view.activity.RemoveAdSuccessActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019-05-27.
 */
@ActivityScope
@Component(modules = [RemoveAdSuccessModule::class], dependencies = [AppComponent::class])
interface RemoveAdSuccessComponent {
    fun inject(inject: RemoveAdSuccessActivity)
}