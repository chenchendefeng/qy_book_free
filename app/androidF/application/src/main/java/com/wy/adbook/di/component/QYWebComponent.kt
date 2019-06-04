package com.wy.adbook.di.component

import com.wy.adbook.di.module.QYWebModule
import com.wy.adbook.mvp.view.web.frag.QYWebFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.FragmentScope
import dagger.Component

/**
 * Created by leafye on 2019-05-23.
 */
@FragmentScope
@Component(modules = [QYWebModule::class], dependencies = [AppComponent::class])
interface QYWebComponent {
    fun inject(inject: QYWebFragment)
}