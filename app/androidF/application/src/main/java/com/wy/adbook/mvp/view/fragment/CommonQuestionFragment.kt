package com.wy.adbook.mvp.view.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freebookqy.application.R
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseFragment
import com.wy.adbook.di.component.DaggerCommonQuestionComponent
import com.wy.adbook.di.module.CommonQuestionModule
import com.wy.adbook.ext.inflate
import com.wy.adbook.mvp.contranct.CommonQuestionContract
import com.wy.adbook.mvp.model.entity.FaqItem
import com.wy.adbook.mvp.presenter.CommonQuestionPresenter
import com.wy.adbook.mvp.view.adapter.CommonQuestionAdapter
import com.wy.adbook.view.status.IStatusCoverView
import kotlinx.android.synthetic.main.fragment_common_question.*
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-28.
 */
class CommonQuestionFragment : QYBaseFragment<CommonQuestionPresenter>(), CommonQuestionContract.View {


    companion object {
        fun newInstance(): CommonQuestionFragment {
            return CommonQuestionFragment()
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerCommonQuestionComponent
            .builder()
            .appComponent(appComponent)
            .commonQuestionModule(CommonQuestionModule(this@CommonQuestionFragment))
            .build()
            .inject(this@CommonQuestionFragment)
    }

    @Inject
    lateinit var commonQuestionAdapter: CommonQuestionAdapter

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var faqList: MutableList<FaqItem>

    override fun initData(savedInstanceState: Bundle?) {
    }

    override fun setData(data: Any?) {

    }

    override fun startInitView() {
        super.startInitView()
        if (common_question_rv.layoutManager == null) {
            common_question_rv.layoutManager = linearLayoutManager
            common_question_rv.adapter = commonQuestionAdapter.apply {
                setOnLoadMoreListener({
                    mPresenter?.loadMore()
                }, common_question_rv)
            }
        }
        status_cover_view.setReTryClickListener(object : IStatusCoverView.ReTryClickListener {
            override fun reTry() {
                mPresenter?.fetchData()
            }
        })
        refresh_layout.setOnRefreshListener { mPresenter?.fetchData() }
    }

    override fun loadData() {
        super.loadData()
        mPresenter?.fetchData()
    }

    override fun isHandlerStatusBarHeight() = false

    override fun initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = context.inflate(R.layout.fragment_common_question)

    override fun changeStatus(status: IStatusCoverView.Status) {
        status_cover_view.changeStatus(status)
    }

    override fun setRefresh(isRefresh: Boolean) {
        refresh_layout.isRefreshing = isRefresh
    }
}