package com.wy.adbook.di.module

import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.mvp.contranct.FaceToFaceContract
import com.wy.adbook.mvp.model.FaceToFaceModel
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-29.
 */
@Module
class FaceToFaceModule(private val view: FaceToFaceContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): FaceToFaceContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: FaceToFaceModel): FaceToFaceContract.Model {
        return model
    }


}