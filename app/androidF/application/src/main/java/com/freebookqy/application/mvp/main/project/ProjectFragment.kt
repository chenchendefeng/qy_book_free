package com.freebookqy.application.mvp.main.project

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.freebookqy.application.R
import com.freebookqy.application.app.base.QYBaseFragment
import com.freebookqy.application.di.component.DaggerProjectComponent
import com.freebookqy.application.di.module.ProjectModule
import com.freebookqy.application.mvp.contranct.ProjectContract
import com.freebookqy.application.mvp.main.adapter.ProjectAdapter
import com.freebookqy.viewlib.banner.BannerImageLoader
import com.jess.arms.di.component.AppComponent
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.fragment_project.*
import org.jetbrains.anko.find


/**
 * Created by leafye on 2019/4/30.
 */
class ProjectFragment : QYBaseFragment<ProjectPresenter>(), ProjectContract.View {

    companion object {

        private const val ARGUMENT_BANNER = "argumentBanner"

        const val ARGUMENT_SUBJECT_TYPE = "argSubjectType"

        fun newInstance(isBanner: Boolean, subjectType: String): ProjectFragment {
            return ProjectFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARGUMENT_BANNER, isBanner)
                    putString(ARGUMENT_SUBJECT_TYPE, subjectType)
                }
            }
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerProjectComponent
            .builder()
            .appComponent(appComponent)
            .projectModule(ProjectModule(this@ProjectFragment))
            .build()
            .inject(this@ProjectFragment)
    }

    override fun initData(savedInstanceState: Bundle?) {
        mPresenter?.initData(arguments)
    }

    override fun setData(data: Any?) {

    }

    override fun isHandlerStatusBarHeight(): Boolean = false

    private val projectAdapter by lazy {
        ProjectAdapter(null)
    }

    private val banner: Banner by lazy {
        headerBanner.find<Banner>(R.id.banner)
    }

    private val bannerIndicator by lazy {
        headerBanner.find<LinearLayout>(R.id.banner_indicator)
    }

    private val headerBanner: View by lazy {
        View.inflate(context, com.freebookqy.application.R.layout.header_banner, null)
    }

    private fun getBannerIndicatorItem(): View {
        return TextView(context).apply {
            setBackgroundResource(R.drawable.selector_banner)
            isSelected = false
        }
    }


    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(com.freebookqy.application.R.layout.fragment_project, null)
    }

    override fun startInitView() {
        project_refresh_layout.setOnRefreshListener {
            mPresenter?.fetchData(true)
        }
    }

    override fun loadData() {
        mPresenter?.fetchData(true)
    }

    override fun refreshView() {
        if (project_rv.layoutManager == null) {
            project_rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            projectAdapter.setHeaderView(headerBanner)//添加头部
            initBanner()
            project_rv.adapter = projectAdapter
        }
        projectAdapter.setNewData(mPresenter?.getTestData())
    }

    private fun initBanner() {
        banner
            .setImageLoader(BannerImageLoader())
            .setBannerStyle(BannerConfig.NOT_INDICATOR)
            .setOnBannerListener {

            }
        //设置图片链接
    }

    override fun refreshStatus(isRefresh: Boolean) {
        project_refresh_layout.isRefreshing = isRefresh
    }
}