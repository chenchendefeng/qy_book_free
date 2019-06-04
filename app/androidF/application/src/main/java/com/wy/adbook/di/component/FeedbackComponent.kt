package com.wy.adbook.di.component

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.FragmentScope
import com.wy.adbook.di.module.FeedbackModule
import com.wy.adbook.mvp.view.fragment.FeedbackFragment
import dagger.Component

/**
 * Created by leafye on 2019-05-29.
 */
@FragmentScope
@Component(modules = [FeedbackModule::class], dependencies = [AppComponent::class])
interface FeedbackComponent {
    fun inject(inject: FeedbackFragment)
}