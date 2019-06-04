package com.wy.adbook.di.module

import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.mvp.contranct.VipContract
import com.wy.adbook.mvp.model.VipModel
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-28.
 */
@Module
class VipModule(private val view: VipContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): VipContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: VipModel): VipContract.Model {
        return model
    }


}