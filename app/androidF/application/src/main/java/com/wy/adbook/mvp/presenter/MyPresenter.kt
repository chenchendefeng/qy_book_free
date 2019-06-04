package com.wy.adbook.mvp.presenter

import com.freebookqy.application.R
import com.freebookqy.utilslib.ResUtils
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.utils.RxLifecycleUtils
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.rx.SimpleErrorSubscribe
import com.wy.adbook.mvp.contranct.MyContract
import com.wy.adbook.mvp.model.entity.accout.NetPersonalCenterPage
import com.wy.adbook.mvp.model.entity.accout.NetUserInfo
import com.wy.adbook.mvp.model.entity.accout.NetWechatLoginSuccess
import com.wy.adbook.mvp.model.entity.accout.PersonalCenterPage
import com.wy.adbook.mvp.view.activity.*
import com.wy.adbook.mvp.view.adapter.MyAdapter
import com.wy.adbook.mvp.view.adapter.MyHeaderItem
import com.wy.adbook.mvp.view.adapter.MyItem
import com.wy.adbook.mvp.view.adapter.MyNormalItem
import com.wy.adbook.view.status.IStatusCoverView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */
@FragmentScope
class MyPresenter
@Inject constructor(model: MyContract.Model, view: MyContract.View) :
    QYBasePresenter<MyContract.Model, MyContract.View>(model, view) {

    private val headerItem: MyHeaderItem by lazy {
        MyHeaderItem(null)
    }

    @Inject
    lateinit var myAdapter: MyAdapter

    @Inject
    lateinit var myItemList: MutableList<MyItem>
    /*
    mutableListOf<MyItem>().apply {
            add(MyItem(MyItem.TYPE_HEADER, headerItem))
            add(MyItem(MyItem.TYPE_NORMAL, inviteToCash))
            add(MyItem(MyItem.TYPE_NORMAL, myWallet))
            add(MyItem(MyItem.TYPE_NORMAL, wantToWithdraw))
            add(MyItem(MyItem.TYPE_NORMAL, membershipBenefits))
            add(MyItem(MyItem.TYPE_NORMAL, friends))
            add(MyItem(MyItem.TYPE_NORMAL, msg))
            add(MyItem(MyItem.TYPE_NORMAL, readFootprint))
            add(MyItem(MyItem.TYPE_NORMAL, redEnvelopesForCode))
            add(MyItem(MyItem.TYPE_NORMAL, helpCenter))
            add(MyItem(MyItem.TYPE_NORMAL, systemSetting))
        }
     */

    private var personalCenterPage: PersonalCenterPage? = null

    private val inviteToCash by lazy {
        MyNormalItem(
            id = MyNormalItem.ID_INVITE_FRIENDS,
            leftRes = R.mipmap.icon_yaoqing,
            title = ResUtils.getString(R.string.invite_friends_to_bring_red_envelope),
            content = ResUtils.getString(R.string.invite_good_ulead_earn_n, 10),
            isTopDivide = true,
            isDivide = false
        )
    }

    private val redEnvelopesForCode by lazy {
        MyNormalItem(
            id = MyNormalItem.ID_RED_ENVELOPES_FOR_CODE,
            leftRes = R.mipmap.icon_duihuan,
            title = ResUtils.getString(R.string.red_envelopes_for_code),
            rightTip = ResUtils.getString(R.string.input_friend_bonus_code_brought_cash),
            rightTipColor = ResUtils.getColor(R.color.red_text_color),
            isTopDivide = true,
            isDivide = false
        )
    }

    private val readFootprint by lazy {
        MyNormalItem(
            id = MyNormalItem.ID_READ_FOOTPRINT,
            leftRes = R.mipmap.icon_zuji,
            title = ResUtils.getString(R.string.read_footprint)
        )
    }

    private val msg by lazy {
        MyNormalItem(
            id = MyNormalItem.ID_MSG,
            leftRes = R.mipmap.icon_news,
            title = ResUtils.getString(R.string.message_notification)
        )
    }

    private val friends by lazy {
        MyNormalItem(
            id = MyNormalItem.ID_MY_FRIENDS,
            leftRes = R.mipmap.icon_haoyou,
            title = ResUtils.getString(R.string.my_good_friend)
        )
    }

    private val membershipBenefits by lazy {
        MyNormalItem(
            id = MyNormalItem.ID_MEMBERSHIP_BENEFITS,
            leftRes = R.mipmap.icon_huiyuan,
            title = ResUtils.getString(R.string.membership_benefits),
            rightTip = ResUtils.getString(R.string.fortunella_venosa_double_reward),
            rightTipColor = ResUtils.getColor(R.color.red_text_color)
        )
    }

    private val wantToWithdraw by lazy {
        MyNormalItem(
            id = MyNormalItem.ID_WANT_WITH_DRAW,
            leftRes = R.mipmap.icon_tixian,
            title = ResUtils.getString(R.string.i_want_to_withdraw),
            rightTip = ResUtils.getString(R.string.withdrawal_seconds_to_account),
            rightTipColor = ResUtils.getColor(R.color.third_black_text_color),
            isDivide = true
        )
    }

    private val myWallet by lazy {
        MyNormalItem(
            id = MyNormalItem.ID_MY_WALLET,
            leftRes = R.mipmap.icon_qianbao,
            title = ResUtils.getString(R.string.my_wallet)
        )
    }

    private val helpCenter by lazy {
        MyNormalItem(
            id = MyNormalItem.ID_HELP_CENTER,
            leftRes = R.mipmap.icon_help,
            title = ResUtils.getString(R.string.help_center)
        )
    }

    private val systemSetting by lazy {
        MyNormalItem(
            id = MyNormalItem.ID_SYS_SETTING,
            leftRes = R.mipmap.icon_setting,
            title = ResUtils.getString(R.string.system_settings)
        )
    }

    fun enterInviteFriends() {

    }

    fun enterMyWallet() {
        MyWalletActivity.startActivity(mRootView.getContext())
    }

    /**
     * 我要提现
     */
    fun enterWantWithDraw() {
        WithdrawalActivity.startActivity(mRootView.getContext())
    }

    /**
     * 会员福利
     */
    fun enterMembershipRenefits() {
        VipActivity.startActivity(mRootView.getContext())
    }

    /**
     * 我的好友
     */
    fun enterMyFriends() {
        MyFriendActivity.startActivity(mRootView.getContext())
    }

    /**
     * 消息中心
     */
    fun enterMsg() {

    }

    /**
     * 阅读足迹
     */
    fun enterReadFootprint() {
        ReadFooterActivity.startActivity(mRootView.getContext())
    }

    /**
     * 红包码兑换
     */
    fun enterRedEnvelopesForCode() {
        RedEnvelopesForCodeActivity.startActivity(mRootView.getContext())
    }

    /**
     * 帮助中心
     */
    fun enterHelpCenter() {
        HelpCenterActivity.startActivity(mRootView.getContext())
    }

    /**
     * 设置中心
     */
    fun enterSysSetting() {
        SettingActivity.startActivity(mRootView.getContext())
    }

    fun fetchData() {
        if (QYAccount.isLogin()) {
            mRootView.setRefresh(true)
            mRootView.changeStatus(IStatusCoverView.Status.LOADING)
            requestUserInfo()
            return
        }
        fetchPersonalCenterData()
    }

    private fun requestUserInfo() {
        mModel.getCustomerBizInfo(QYAccount.uid())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<NetUserInfo>(mErrorHandler) {
                override fun onNext(t: NetUserInfo) {
                    if (t.isOk()) {
                        QYAccount.updateUserCustomerBizInfo(t.data)
                        mRootView.refreshView()
                        fetchPersonalCenterData()
                    } else {
                        mRootView.changeStatus(IStatusCoverView.Status.ERROR)
                        mRootView.showError(t.msg)
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.changeStatus(IStatusCoverView.Status.ERROR)
                }
            })
    }

    private fun fetchPersonalCenterData() {
        mModel.personalCenterPage()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .doFinally {
                mRootView.setRefresh(false)
            }
            .subscribe(object : ErrorHandleSubscriber<NetPersonalCenterPage>(mErrorHandler) {
                override fun onNext(t: NetPersonalCenterPage) {
                    if (t.isOk()) {
                        myItemList.clear()
                        t.data?.banners?.let {
                            headerItem.list = it
                            myItemList.add(MyItem(MyItem.TYPE_HEADER, headerItem))
                        }
                        myItemList.apply {
                            add(MyItem(MyItem.TYPE_NORMAL, inviteToCash))
                            add(MyItem(MyItem.TYPE_NORMAL, myWallet))
                            add(MyItem(MyItem.TYPE_NORMAL, wantToWithdraw))
                            add(MyItem(MyItem.TYPE_NORMAL, membershipBenefits))
                            add(MyItem(MyItem.TYPE_NORMAL, friends))
                            add(MyItem(MyItem.TYPE_NORMAL, msg))
                            add(MyItem(MyItem.TYPE_NORMAL, readFootprint))
                            add(MyItem(MyItem.TYPE_NORMAL, redEnvelopesForCode))
                            add(MyItem(MyItem.TYPE_NORMAL, helpCenter))
                            add(MyItem(MyItem.TYPE_NORMAL, systemSetting))
                        }
//                        t.data?.modules?.forEachIndexed { index, personalCenterModule ->
//
//                            MyNormalItem(
//                                id = MyNormalItem.ID_INVITE_FRIENDS,
//                                leftRes = R.mipmap.icon_yaoqing,
//                                title = ResUtils.getString(R.string.invite_friends_to_bring_red_envelope),
//                                content = ResUtils.getString(R.string.invite_good_ulead_earn_n, 10),
//                                isTopDivide = true,
//                                isDivide = false
//                            )
//                        }
                        personalCenterPage = t.data
                        mRootView.refreshView()
                        mRootView.changeStatus(IStatusCoverView.Status.SUCCESS)
                    } else {
                        mRootView.changeStatus(IStatusCoverView.Status.ERROR)
                        mRootView.showError(t.msg)
                    }
                    mRootView.setRefresh(false)
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.changeStatus(IStatusCoverView.Status.ERROR)
                }
            })
    }

    fun loginWx(code: String) {
        mModel.wxLogin(code)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : SimpleErrorSubscribe<NetWechatLoginSuccess>(mRootView) {
                override fun success(t: NetWechatLoginSuccess) {
                    if (t.isOk()) {
                        t.data?.let {
                            QYAccount.loginSuccess(it)
                            mRootView.refreshView()
                        }
                    } else {
                        mRootView.showError(t.msg)
                    }
                }
            })
    }

}