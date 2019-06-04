package com.wy.adbook.di.component

import com.wy.adbook.di.module.WelfareModule
import com.wy.adbook.mvp.view.fragment.WelfareFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.FragmentScope
import dagger.Component

/**
 * Created by leafye on 2019/4/30.
 */
@FragmentScope
@Component(modules = [WelfareModule::class], dependencies = [AppComponent::class])
interface WelfareComponent {
    fun inject(fragment: WelfareFragment)
}