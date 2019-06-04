package com.wy.adbook.di.module

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.freebookqy.application.R
import com.wy.adbook.mvp.contranct.ClassificationContract
import com.wy.adbook.mvp.model.ClassificationModel
import com.wy.adbook.mvp.model.entity.BannerItem
import com.wy.adbook.mvp.model.entity.Classification
import com.wy.adbook.mvp.view.adapter.ClassificationAdapter
import com.wy.adbook.mvp.view.adapter.ClassificationContentAdapter
import com.freebookqy.utilslib.ResUtils
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides
import javax.inject.Named

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

    @ActivityScope
    @Named("l1")
    @Provides
    fun provideLinearLayoutManager1(): LinearLayoutManager =
        getLinearLayoutManager()

    @ActivityScope
    @Named("l2")
    @Provides
    fun provideLinearLayoutManager2(): LinearLayoutManager =
        getLinearLayoutManager()

    @Provides
    fun getLinearLayoutManager() = LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false)

    @ActivityScope
    @Provides
    fun provideHeaderView(): View = View.inflate(view.getContext(), R.layout.header_classification, null)


    @ActivityScope
    @Provides
    fun provideBannerList() = mutableListOf<BannerItem>()

    @ActivityScope
    @Provides
    fun provideClassificationList() = mutableListOf<Classification>().apply {
        add(Classification(ResUtils.getString(R.string.man)))
        add(Classification(ResUtils.getString(R.string.woman)))
        get(0).isSelected = true
    }

    @ActivityScope
    @Provides
    fun classificationAdapter(list: MutableList<Classification>) = ClassificationAdapter(list)

    @ActivityScope
    @Provides
    fun provideClassificationContentAdapter() =
        ClassificationContentAdapter()

}