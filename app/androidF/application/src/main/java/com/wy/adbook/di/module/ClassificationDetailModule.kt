package com.wy.adbook.di.module

import com.wy.adbook.mvp.model.ClassificationDetailModel
import com.wy.adbook.mvp.contranct.ClassificationDetailContract
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/5/5.
 */
@Module
class ClassificationDetailModule(private val view: ClassificationDetailContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): ClassificationDetailContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: ClassificationDetailModel): ClassificationDetailContract.Model {
        return model
    }


}