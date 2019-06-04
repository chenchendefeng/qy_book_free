package com.wy.adbook.mvp.view.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.bingoogolapple.bgabanner.BGABanner
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.freebookqy.application.R
import com.wy.adbook.app.QYApplication
import com.wy.adbook.app.base.QYBaseFragment
import com.wy.adbook.app.utils.GlideRoundImage
import com.wy.adbook.di.component.DaggerProjectComponent
import com.wy.adbook.di.module.ProjectModule
import com.wy.adbook.ext.dip2Px
import com.wy.adbook.ext.glideScroll
import com.wy.adbook.mvp.contranct.ProjectContract
import com.wy.adbook.mvp.model.entity.BannerItem
import com.wy.adbook.mvp.presenter.ProjectPresenter
import com.wy.adbook.mvp.view.adapter.ProjectAdapter
import com.wy.adbook.view.status.IStatusCoverView
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.fragment_project.*
import org.jetbrains.anko.find
import javax.inject.Inject


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
        initListener()
        initProjectView()
        mPresenter?.initData(arguments)
    }

    private fun initListener() {
        status_cover_view.setReTryClickListener(object : IStatusCoverView.ReTryClickListener {
            override fun reTry() {
                mPresenter?.fetchData()
            }
        })
    }

    private fun initProjectView() {
        if (project_rv.layoutManager == null) {
            project_rv.layoutManager = projectLinearLayout
            project_rv.adapter = projectAdapter
            project_rv.glideScroll()
        }
    }

    override fun setData(data: Any?) {

    }

    override fun isHandlerStatusBarHeight(): Boolean = false

    @Inject
    lateinit var projectAdapter: ProjectAdapter

    @Inject
    lateinit var projectLinearLayout: LinearLayoutManager

    @Inject
    lateinit var headerView: View

    @Inject
    lateinit var bannerList: MutableList<BannerItem>

    private val banner: BGABanner by lazy {
        headerView.find<BGABanner>(R.id.banner)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_project, null)

    override fun startInitView() {
        project_refresh_layout.setOnRefreshListener {
            mPresenter?.fetchData()
        }
    }

    override fun loadData() {
        mPresenter?.fetchData()
    }

    private fun initBanner() {
        banner
            .setAdapter(object : BGABanner.Adapter<View, BannerItem> {
                override fun fillBannerItem(banner: BGABanner?, itemView: View, model: BannerItem?, position: Int) {
                    val transform = RequestOptions()
                        .transform(
                            GlideRoundImage(9.dip2Px)
                        )
                        .error(R.drawable.shape_placeholder_figure_corner9)
                        .placeholder(R.drawable.shape_placeholder_figure_corner9)
                    Glide.with(QYApplication.cxt())
                        .load(model?.img)
                        .apply(transform)
                        .into(itemView.find(R.id.banner_iv))
                }
            })
        val list = mutableListOf<View>().apply {
            bannerList.forEach { _ ->
                add(View.inflate(context, R.layout.item_banner, null))
            }
        }
        banner.setData(list, bannerList, null)
        banner.setDelegate(object : BGABanner.Delegate<View, BannerItem> {
            override fun onBannerItemClick(banner: BGABanner?, itemView: View?, model: BannerItem?, position: Int) {
                mPresenter?.handlerBannerItem(model?.url?:"")
            }
        })
        banner.startAutoPlay()
    }

    override fun refreshBanner() {
        if (bannerList.isEmpty()) {
            projectAdapter.removeAllHeaderView()
        } else {
            projectAdapter.setHeaderView(headerView)
            initBanner()
        }
    }

    override fun refreshStatus(isRefresh: Boolean) {
        if (project_refresh_layout.isRefreshing != isRefresh)
            project_refresh_layout.isRefreshing = isRefresh
    }

    override fun changeStatusCoverView(status: IStatusCoverView.Status) {
        status_cover_view.changeStatus(status)
    }
}