package com.freebookqy.application.di.module

import com.freebookqy.application.mvp.classification.detail.ClassificationDetailModel
import com.freebookqy.application.mvp.contranct.ClassificationDetailContract
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