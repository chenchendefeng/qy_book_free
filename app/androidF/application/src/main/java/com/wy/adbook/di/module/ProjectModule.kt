package com.wy.adbook.di.module

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.wy.adbook.mvp.contranct.ProjectContract
import com.wy.adbook.mvp.model.ProjectModel
import com.wy.adbook.mvp.model.entity.BannerItem
import com.wy.adbook.mvp.view.adapter.ProjectAdapter
import com.wy.adbook.mvp.view.adapter.ProjectItem
import com.jess.arms.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/5/1.
 */
@Module
class ProjectModule(private val view: ProjectContract.View) {
    @FragmentScope
    @Provides
    fun provideAboutView(): ProjectContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideAboutModel(model: ProjectModel): ProjectContract.Model {
        return model
    }

    @FragmentScope
    @Provides
    fun provideLayoutManager1() =
        LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false)

    @FragmentScope
    @Provides
    fun provideProjectList() = mutableListOf<ProjectItem>()

    @FragmentScope
    @Provides
    fun projectAdapter(list: MutableList<ProjectItem>) =
        ProjectAdapter(list)

    @FragmentScope
    @Provides
    fun headerView(): View =
        View.inflate(view.getContext(), com.freebookqy.application.R.layout.header_banner, null)

    @FragmentScope
    @Provides
    fun bannerList(): MutableList<BannerItem> = mutableListOf()


}