package com.freebookqy.application.mvp.main.my

import com.freebookqy.application.R
import com.freebookqy.application.app.QYAccount
import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.app.rx.SimpleErrorSubscribe
import com.freebookqy.application.app.rx.netReq
import com.freebookqy.application.mvp.contranct.MyContract
import com.freebookqy.application.mvp.main.my.adapter.MyHeaderItem
import com.freebookqy.application.mvp.main.my.adapter.MyItem
import com.freebookqy.application.mvp.main.my.adapter.MyNormalItem
import com.freebookqy.application.mvp.main.my.wallet.MyWalletActivity
import com.freebookqy.application.mvp.model.entity.accout.PersonalCenterPage
import com.freebookqy.application.mvp.model.entity.accout.UserInfo
import com.freebookqy.application.mvp.model.entity.accout.WechatLoginSuccess
import com.freebookqy.utilslib.ResUtils
import com.jess.arms.di.scope.ActivityScope
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */
@ActivityScope
class MyPresenter
@Inject constructor(model: MyContract.Model, view: MyContract.View) :
    QYBasePresenter<MyContract.Model, MyContract.View>(model, view) {

    private val headerItem by lazy {
        MyHeaderItem().apply {

        }
    }

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
            rightTipColor = ResUtils.getColor(R.color.third_black_text_color)
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

    fun getMyItemList(): MutableList<MyItem>? {
        return mutableListOf<MyItem>().apply {
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
    }

    fun enterInviteFriends() {

    }

    fun enterMyWallet() {
        MyWalletActivity.startActivity(mRootView.getContext())
    }

    fun enterWantWithDraw() {

    }

    fun enterMembershipRenefits() {

    }

    fun enterMyFriends() {

    }

    fun enterMsg() {

    }

    fun enterReadFootprint() {

    }

    fun enterRedEnvelopesForCode() {

    }

    fun enterHelpCenter() {

    }

    fun enterSysSetting() {

    }

    private var personalCenterPage: PersonalCenterPage? = null

    fun fetchData() {

        if (QYAccount.isLogin()) {
            requestUserInfo()
        }
        mModel.personalCenterPage()
            .netReq(mRootView)
            .doOnSubscribe {
                mRootView.setRefresh(true)
            }
            .doFinally {
                mRootView.setRefresh(false)
            }
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<PersonalCenterPage>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<PersonalCenterPage>) {
                    personalCenterPage = t.data
                    mRootView.refreshView()
                    mRootView.setRefresh(false)
                }
            })
    }

    private fun requestUserInfo() {
        mModel.getCustomerBizInfo(QYAccount.getUserInfo().cuId)
            .netReq(mRootView)
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<UserInfo>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<UserInfo>) {
                    QYAccount.setUserInfo(t.data)
                    mRootView.refreshView()
                }
            })
    }

    fun loginWx(code: String) {
        mModel.wxLogin(code)
            .netReq(mRootView)
            .subscribe(object : SimpleErrorSubscribe<BaseEntity<WechatLoginSuccess>>(mRootView) {
                override fun success(t: BaseEntity<WechatLoginSuccess>) {
                    t.data?.let {
                        QYAccount.loginSuccess(it)
                    }
                }
            })
    }

}