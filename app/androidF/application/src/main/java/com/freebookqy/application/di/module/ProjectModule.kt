package com.freebookqy.application.di.module

import com.freebookqy.application.mvp.contranct.ProjectContract
import com.freebookqy.application.mvp.main.project.ProjectModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/5/1.
 */
@Module
class ProjectModule(private val view: ProjectContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): ProjectContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: ProjectModel): ProjectContract.Model {
        return model
    }


}