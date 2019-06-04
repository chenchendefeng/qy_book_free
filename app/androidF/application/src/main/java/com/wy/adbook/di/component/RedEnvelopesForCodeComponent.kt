package com.wy.adbook.di.component

import com.wy.adbook.di.module.RedEnvelopesForCodeModule
import com.wy.adbook.mvp.view.activity.RedEnvelopesForCodeActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019-05-27.
 */
@ActivityScope
@Component(modules = [RedEnvelopesForCodeModule::class], dependencies = [AppComponent::class])
interface RedEnvelopesForCodeComponent {
    fun inject(inject: RedEnvelopesForCodeActivity)
}