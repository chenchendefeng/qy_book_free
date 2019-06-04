package com.freebookqy.application.di.module

import com.freebookqy.application.mvp.contranct.ClassificationContract
import com.freebookqy.application.mvp.classification.ClassificationModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/5/5.
 */
@Module
class ClassificationModule(private val view: ClassificationContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): ClassificationContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: ClassificationModel): ClassificationContract.Model {
        return model
    }


}