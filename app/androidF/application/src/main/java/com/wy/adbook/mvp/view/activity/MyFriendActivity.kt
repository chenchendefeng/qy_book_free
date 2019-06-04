package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.freebookqy.application.R
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.app.manager.ShareManager
import com.wy.adbook.di.component.DaggerMyFriendComponent
import com.wy.adbook.di.module.MyFriendModule
import com.wy.adbook.dialog.share.ShareDialog
import com.wy.adbook.dialog.share.ShareListener
import com.wy.adbook.ext.inflate
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.contranct.MyFriendContract
import com.wy.adbook.mvp.model.entity.FriendItem
import com.wy.adbook.mvp.presenter.MyFriendPresenter
import com.wy.adbook.mvp.view.adapter.MyFriendAdapter
import com.wy.adbook.view.status.IStatusCoverView
import kotlinx.android.synthetic.main.activity_my_friend.*
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-29.
 */
class MyFriendActivity : QYBaseActivity<MyFriendPresenter>(), MyFriendContract.View {

    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, MyFriendActivity::class.java))
        }
    }

    override fun getToolbar(): View? = title_bar_view

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMyFriendComponent.builder()
            .appComponent(appComponent)
            .myFriendModule(MyFriendModule((this@MyFriendActivity)))
            .build()
            .inject(this@MyFriendActivity)
    }

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_my_friend

    @Inject
    lateinit var friendAdapter: MyFriendAdapter

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun initData(savedInstanceState: Bundle?) {
        if (friends_rv.layoutManager == null) {
            friends_rv.layoutManager = linearLayoutManager
            friends_rv.adapter = friendAdapter.apply {
                setOnItemClickListener { adapter, view, position ->
                    val item = adapter.data[position] as FriendItem
                    //进入聊天界面
                    mPresenter?.enterIm(item)
                }
                setOnItemChildClickListener { adapter, view, position ->
                    val item = adapter.data[position] as FriendItem
                    when (view.id) {
                        R.id.poke_ta_tv -> {
                            mPresenter?.enterIm(item)//戳他一下
                        }
                    }
                }
                setOnLoadMoreListener({ mPresenter?.loadMore() }, friends_rv)
                emptyView = inflate(R.layout.empty_view)
            }
        }
        initListener()
        mPresenter?.fetchData()
    }

    private fun initListener() {
        title_bar_view.setOnLeftButtonClickListener { finish() }
        refresh_layout.setOnRefreshListener { mPresenter?.fetchData() }
        invite_more_friends_btn.onClick {
            //显示分享对话框
            ShareManager.showInviteFriendDialog(this@MyFriendActivity, object : ShareListener {
                override fun share(shareDialog: ShareDialog, shareType: Int) {
                    mPresenter?.toInviteFriend(shareDialog,shareType)
                }
            })
        }
        status_cover_view.setReTryClickListener(object : IStatusCoverView.ReTryClickListener {
            override fun reTry() {
                mPresenter?.fetchData()
            }
        })
    }

    override fun setRefresh(isRefresh: Boolean) {
        if (refresh_layout.isRefreshing != isRefresh)
            refresh_layout.isRefreshing = isRefresh
    }

    override fun changeStatus(status: IStatusCoverView.Status) {
        status_cover_view.changeStatus(status)
    }
}