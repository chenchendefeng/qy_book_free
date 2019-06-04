package com.wy.adbook.di.module

import com.wy.adbook.mvp.view.web.QYWebView
import com.wy.adbook.mvp.view.web.frag.QYWebContract
import com.wy.adbook.mvp.view.web.frag.QYWebModel
import com.jess.arms.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-23.
 */
@Module
class QYWebModule(private val view: QYWebContract.View) {
    @FragmentScope
    @Provides
    fun provideAboutView(): QYWebContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideAboutModel(model: QYWebModel): QYWebContract.Model {
        return model
    }

    @FragmentScope
    @Provides
    fun provideWebView() = QYWebView(view.getContext())


}