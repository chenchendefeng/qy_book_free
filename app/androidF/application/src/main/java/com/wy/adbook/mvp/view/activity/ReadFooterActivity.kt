package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.freebookqy.application.R
import com.freebookqy.viewlib.dialog.CommonDialog
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.di.component.DaggerReadFooterComponent
import com.wy.adbook.di.module.ReadFooterModule
import com.wy.adbook.ext.inflate
import com.wy.adbook.mvp.contranct.ReadFooterContract
import com.wy.adbook.mvp.model.entity.ReadFooterItem
import com.wy.adbook.mvp.presenter.ReadFooterPresenter
import com.wy.adbook.mvp.view.adapter.ReadFooterAdapter
import com.wy.adbook.view.status.IStatusCoverView
import kotlinx.android.synthetic.main.activity_read_footer.*
import org.jetbrains.anko.find
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-28.
 */
class ReadFooterActivity : QYBaseActivity<ReadFooterPresenter>(), ReadFooterContract.View {


    companion object {
        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, ReadFooterActivity::class.java))
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerReadFooterComponent.builder()
            .appComponent(appComponent)
            .readFooterModule(ReadFooterModule((this@ReadFooterActivity)))
            .build()
            .inject(this@ReadFooterActivity)
    }

    override fun getToolbar(): View? = title_bar_view

    @Inject
    lateinit var readFooterAdapter: ReadFooterAdapter

    @Inject
    lateinit var list: MutableList<ReadFooterItem>

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_read_footer

    override fun initData(savedInstanceState: Bundle?) {
        if (read_foot_rv.layoutManager == null) {
            read_foot_rv.layoutManager = linearLayoutManager
            read_foot_rv.adapter = readFooterAdapter.apply {
                setOnItemChildClickListener { adapter, view, position ->
                    val item = adapter.data[position] as ReadFooterItem
                    when (view.id) {
                        R.id.content -> {
                            BookDetailActivity.startActivity(this@ReadFooterActivity, item.bid)
                        }
                        R.id.right -> {
                            showDeleteConfirmDialog(item)
                        }
                    }
                }
                setOnLoadMoreListener({ mPresenter?.loadMore() }, read_foot_rv)
            }
        }
        status_cover_view.setReTryClickListener(object : IStatusCoverView.ReTryClickListener {
            override fun reTry() {
                mPresenter?.fetchData()
            }
        })
        refresh_layout.setOnRefreshListener { mPresenter?.fetchData() }
        title_bar_view.setOnLeftButtonClickListener { finish() }
        mPresenter?.fetchData()
    }

    private fun showDeleteConfirmDialog(item: ReadFooterItem) {
        val view = inflate(R.layout.common_dialog_layout).apply {
            find<TextView>(R.id.title).text = "确认删除?"
        }
        CommonDialog.Builder()
            .contentView(view)
            .setOnClick(R.id.dialog_exit, R.id.dialog_continue)
            .onClick { dialog, clickView ->
                when (clickView.id) {
                    R.id.dialog_continue -> mPresenter?.deleteReadFooter(item)
                }
                dialog.dismiss()
            }
            .build(this@ReadFooterActivity)
            .show()
    }

    override fun changeCoverStatus(status: IStatusCoverView.Status) {
        status_cover_view.changeStatus(status)
    }

    override fun setRefresh(isRefresh: Boolean) {
        if (refresh_layout.isRefreshing != isRefresh)
            refresh_layout.isRefreshing = isRefresh
    }
}