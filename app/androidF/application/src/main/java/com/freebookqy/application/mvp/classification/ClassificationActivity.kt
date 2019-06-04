package com.freebookqy.application.mvp.classification

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.freebookqy.application.R
import com.freebookqy.application.app.base.QYBaseActivity
import com.freebookqy.application.di.component.DaggerClassificationComponent
import com.freebookqy.application.di.module.ClassificationModule
import com.freebookqy.application.mvp.classification.adapter.ClassificationAdapter
import com.freebookqy.application.mvp.classification.adapter.ClassificationContentAdapter
import com.freebookqy.application.mvp.contranct.ClassificationContract
import com.freebookqy.application.mvp.model.entity.Classification
import com.freebookqy.application.mvp.model.entity.ClassificationItem
import com.jess.arms.di.component.AppComponent
import com.youth.banner.Banner
import kotlinx.android.synthetic.main.activity_classification.*
import org.jetbrains.anko.find

/**
 * Created by leafye on 2019/5/5.
 */
class ClassificationActivity : QYBaseActivity<ClassificationPresenter>(), ClassificationContract.View {


    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, ClassificationActivity::class.java))
        }
    }

    override fun isHandlerStatusBarHeight(): Boolean = true

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerClassificationComponent.builder()
            .appComponent(appComponent)
            .classificationModule(ClassificationModule((this@ClassificationActivity)))
            .build()
            .inject(this@ClassificationActivity)
    }

    private val classificationAdapter: ClassificationAdapter by lazy {
        ClassificationAdapter(null).apply {
            setOnItemClickListener { adapter, _, position ->
                mPresenter?.classificationClick(adapter.data[position] as Classification)
            }
        }
    }

    private val classificationContentAdapter: ClassificationContentAdapter by lazy {
        ClassificationContentAdapter(null).apply {
            setOnItemClickListener { adapter, _, position ->
                mPresenter?.classificationContentClick(adapter.data[position] as ClassificationItem)
            }
            setHeaderView(headerView)
            setOnLoadMoreListener({
                mPresenter?.loadMore()
            }, classification_content_rv)
        }
    }

    override fun getAdapter(): ClassificationContentAdapter {
        return classificationContentAdapter
    }

    private val banner: Banner by lazy {
        headerView.find<Banner>(R.id.classification_banner)
    }

    private val headerClassificationNameTv by lazy {
        headerView.find<TextView>(R.id.header_classification_name_tv)
    }

    private val headerView: View by lazy {
        View.inflate(this@ClassificationActivity, R.layout.header_classification, null)
    }

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_classification

    override fun initData(savedInstanceState: Bundle?) {
        initListener()
        refreshLeftAdapter()
        mPresenter?.fetchData()
    }

    private fun initListener() {
        classification_title_view.setOnLeftButtonClickListener { finish() }
        refresh_layout.setOnRefreshListener {
            mPresenter?.fetchData()
        }
    }

    override fun isRefresh(isRefresh: Boolean) {
        refresh_layout.isRefreshing = isRefresh
    }

    override fun refreshView() {
        refreshLeftAdapter()
        if (classification_content_rv.layoutManager == null) {
            classification_content_rv.layoutManager =
                LinearLayoutManager(this@ClassificationActivity, LinearLayoutManager.VERTICAL, false)
            classification_content_rv.adapter = classificationContentAdapter
        }
        val selectClassificationItem = mPresenter?.getSelectClassificationItem()
        classificationContentAdapter.setNewData(selectClassificationItem)
        selectClassificationItem?.let {
            headerClassificationNameTv.text = mPresenter?.classificationList?.find { it.isSelected }?.category
        }
    }

    private fun refreshLeftAdapter() {
        if (classification_rv.layoutManager == null) {
            classification_rv.layoutManager =
                LinearLayoutManager(this@ClassificationActivity, LinearLayoutManager.VERTICAL, false)
            classification_rv.adapter = classificationAdapter
        }
        classificationAdapter.setNewData(mPresenter?.classificationList)
    }

}