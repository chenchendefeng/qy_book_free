package com.wy.adbook.mvp.view.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freebookqy.application.R
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseFragment
import com.wy.adbook.di.component.DaggerMyComponent
import com.wy.adbook.di.module.MyModule
import com.wy.adbook.ext.inflate
import com.wy.adbook.mvp.contranct.MyContract
import com.wy.adbook.mvp.model.event.LoginEvent
import com.wy.adbook.mvp.presenter.MyPresenter
import com.wy.adbook.mvp.view.adapter.MyAdapter
import com.wy.adbook.mvp.view.adapter.MyItem
import com.wy.adbook.mvp.view.adapter.MyNormalItem
import com.wy.adbook.view.status.IStatusCoverView
import com.wy.adbook.wxapi.WXEntryActivity
import kotlinx.android.synthetic.main.fragment_my.*
import org.simple.eventbus.Subscriber
import org.simple.eventbus.ThreadMode
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */
class MyFragment : QYBaseFragment<MyPresenter>(), MyContract.View {

    companion object {
        fun newInstance(): MyFragment = MyFragment()
    }

    override fun useEventBus(): Boolean = true

    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerMyComponent.builder()
            .appComponent(appComponent)
            .myModule(MyModule(this@MyFragment))
            .build()
            .inject(this@MyFragment)
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun setData(data: Any?) {

    }

    @Inject
    lateinit var myAdapter :MyAdapter

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun startInitView() {
        if (my_rv.layoutManager == null) {
            my_rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            my_rv.adapter = myAdapter
        }
        myAdapter.apply{
            setOnItemClickListener { adapter, _, position ->
                val myItem = adapter.data[position] as MyItem
                when (myItem.itemType) {
                    MyItem.TYPE_NORMAL -> if (myItem.any is MyNormalItem) {
                        when (myItem.any.id) {
                            MyNormalItem.ID_INVITE_FRIENDS -> mPresenter?.enterInviteFriends()
                            MyNormalItem.ID_MY_WALLET -> mPresenter?.enterMyWallet()
                            MyNormalItem.ID_WANT_WITH_DRAW -> mPresenter?.enterWantWithDraw()
                            MyNormalItem.ID_MEMBERSHIP_BENEFITS -> mPresenter?.enterMembershipRenefits()
                            MyNormalItem.ID_MY_FRIENDS -> mPresenter?.enterMyFriends()
                            MyNormalItem.ID_MSG -> mPresenter?.enterMsg()
                            MyNormalItem.ID_READ_FOOTPRINT -> mPresenter?.enterReadFootprint()
                            MyNormalItem.ID_RED_ENVELOPES_FOR_CODE -> mPresenter?.enterRedEnvelopesForCode()
                            MyNormalItem.ID_HELP_CENTER -> mPresenter?.enterHelpCenter()
                            MyNormalItem.ID_SYS_SETTING -> mPresenter?.enterSysSetting()
                        }
                    }
                }
            }
        }
        initListener()
        refreshView()
    }

    private fun initListener() {
        refresh_layout.setOnRefreshListener {
            mPresenter?.fetchData()
        }
        status_cover_view.setReTryClickListener(object : IStatusCoverView.ReTryClickListener {
            override fun reTry() {
                mPresenter?.fetchData()
            }
        })
    }

    override fun loadData() {
        super.loadData()
        mPresenter?.fetchData()
    }

    override fun refreshView() {
        myAdapter.notifyDataSetChanged()
    }

    override fun changeStatus(status: IStatusCoverView.Status) {
        status_cover_view.changeStatus(status)
    }

    override fun setRefresh(isRefresh: Boolean) {
        refresh_layout.isRefreshing = isRefresh
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return context.inflate(R.layout.fragment_my)
    }

    @Subscriber(mode = ThreadMode.MAIN)
    fun subscribeLoginEvent(event: LoginEvent) {
        when (event.key) {
            LoginEvent.EVENT_LOGIN_SUCCESS ->
                refreshView()
            LoginEvent.EVENT_LOGOUT_SUCCESS->
                refreshView()
        }
    }

    @Subscriber(mode = ThreadMode.MAIN)
    fun subscribeWxEvent(event: WXEntryActivity.WxEventBusKey) {
        when (event.key) {
            WXEntryActivity.WxEventBusKey.WX_LOGIN_SUCCESS -> {
                val code = event.strArgs
                mPresenter?.loginWx(code)
            }
        }
    }
}