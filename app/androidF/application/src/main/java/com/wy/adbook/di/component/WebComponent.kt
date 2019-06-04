package com.wy.adbook.di.component

import com.wy.adbook.di.module.WebModule
import com.wy.adbook.mvp.view.web.act.WebActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019-05-23.
 */
@ActivityScope
@Component(modules = [WebModule::class], dependencies = [AppComponent::class])
interface WebComponent {
    fun inject(inject: WebActivity)
}