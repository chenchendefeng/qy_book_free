package com.wy.adbook.di.component

import com.wy.adbook.di.module.MyWalletModule
import com.wy.adbook.mvp.view.activity.MyWalletActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/5/6.
 */
@ActivityScope
@Component(modules = [MyWalletModule::class], dependencies = [AppComponent::class])
interface MyWalletComponent {
    fun inject(inject: MyWalletActivity)
}