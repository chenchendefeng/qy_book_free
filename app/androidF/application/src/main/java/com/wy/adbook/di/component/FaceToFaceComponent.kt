package com.wy.adbook.di.component

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.di.module.FaceToFaceModule
import com.wy.adbook.mvp.view.activity.FaceToFaceActivity
import dagger.Component

/**
 * Created by leafye on 2019-05-29.
 */
@ActivityScope
@Component(modules = [FaceToFaceModule::class], dependencies = [AppComponent::class])
interface FaceToFaceComponent {
    fun inject(inject: FaceToFaceActivity)
}