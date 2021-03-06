package com.freebookqy.application.mvp.main.my

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freebookqy.application.R
import com.freebookqy.application.app.base.QYBaseFragment
import com.freebookqy.application.di.component.DaggerMyComponent
import com.freebookqy.application.di.module.MyModule
import com.freebookqy.application.mvp.contranct.MyContract
import com.freebookqy.application.mvp.main.my.adapter.MyAdapter
import com.freebookqy.application.mvp.main.my.adapter.MyItem
import com.freebookqy.application.mvp.main.my.adapter.MyNormalItem
import com.freebookqy.application.mvp.model.event.LoginEvent
import com.freebookqy.application.wxapi.WXEntryActivity
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.fragment_my.*
import org.simple.eventbus.Subscriber
import org.simple.eventbus.ThreadMode

/**
 * Created by leafye on 2019/4/30.
 */
class MyFragment : QYBaseFragment<MyPresenter>(), MyContract.View {

    companion object {

        fun newInstance(): MyFragment = MyFragment()

    }

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

    private val myAdapter: MyAdapter by lazy {
        MyAdapter(mPresenter?.getMyItemList()).apply {
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
    }

    override fun startInitView() {
        initListener()
        refreshView()
    }

    private fun initListener() {
        refresh_layout.setOnRefreshListener {
            mPresenter?.fetchData()
        }
    }

    override fun refreshView() {
        if (my_rv.layoutManager == null) {
            my_rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            my_rv.adapter = myAdapter
        }
        myAdapter.notifyDataSetChanged()
    }

    override fun setRefresh(isRefresh: Boolean) {
        refresh_layout.isRefreshing = isRefresh
    }


    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_my, null)
    }

    @Subscriber(mode = ThreadMode.MAIN)
    fun subscribeLoginEvent(event: LoginEvent) {
        when (event.key) {
            LoginEvent.EVENT_LOGIN_SUCCESS ->
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