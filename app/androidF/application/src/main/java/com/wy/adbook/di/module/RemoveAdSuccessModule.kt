package com.wy.adbook.di.module

import com.wy.adbook.mvp.contranct.RemoveAdSuccessContract
import com.wy.adbook.mvp.model.RemoveAdSuccessModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-27.
 */
@Module
class RemoveAdSuccessModule(private val view: RemoveAdSuccessContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): RemoveAdSuccessContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: RemoveAdSuccessModel): RemoveAdSuccessContract.Model {
        return model
    }


}