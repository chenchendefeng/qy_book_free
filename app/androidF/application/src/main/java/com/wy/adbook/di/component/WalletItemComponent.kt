package com.wy.adbook.di.component

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.FragmentScope
import com.wy.adbook.di.module.WalletItemModule
import com.wy.adbook.mvp.view.fragment.WalletItemFragment
import dagger.Component

/**
 * Created by leafye on 2019-05-28.
 */
@FragmentScope
@Component(modules = [WalletItemModule::class], dependencies = [AppComponent::class])
interface WalletItemComponent {
    fun inject(inject:WalletItemFragment)
}