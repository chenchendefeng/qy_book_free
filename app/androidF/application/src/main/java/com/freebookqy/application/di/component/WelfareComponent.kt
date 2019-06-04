package com.freebookqy.application.di.component

import com.freebookqy.application.di.module.WelfareModule
import com.freebookqy.application.mvp.main.welfare.WelfareFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/4/30.
 */
@ActivityScope
@Component(modules = [WelfareModule::class], dependencies = [AppComponent::class])
interface WelfareComponent {
    fun inject(fragment: WelfareFragment)
}