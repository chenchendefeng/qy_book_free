package com.freebookqy.application.mvp.main.my.adapter

import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.freebookqy.application.R
import com.freebookqy.application.app.QYAccount
import com.freebookqy.application.ext.gif
import com.freebookqy.application.mvp.account.Login.LoginActivity
import com.freebookqy.application.mvp.main.my.adapter.MyItem.Companion.TYPE_HEADER
import com.freebookqy.application.mvp.main.my.adapter.MyItem.Companion.TYPE_NORMAL
import com.freebookqy.application.view.InfoItem
import com.freebookqy.application.wxapi.WxManager
import com.tencent.mm.opensdk.modelmsg.SendAuth

/**
 * Created by leafye on 2019/5/6.
 */
class MyAdapter(list: MutableList<MyItem>?)

    : BaseMultiItemQuickAdapter<MyItem, BaseViewHolder>(list) {

    init {
        addItemType(TYPE_HEADER, R.layout.item_my_header)
        addItemType(TYPE_NORMAL, R.layout.item_my_normal)
    }

    override fun convert(helper: BaseViewHolder, item: MyItem) {
        when (item.itemType) {
            TYPE_HEADER -> refreshHeader(helper, item.any as MyHeaderItem)
            TYPE_NORMAL -> refreshNormal(helper, item.any as MyNormalItem)
        }
    }

    private fun refreshHeader(helper: BaseViewHolder, item: MyHeaderItem) {
        val wxLoginTipTv = helper.getView<ImageView>(R.id.wx_login_tip_iv)
        val phoneLoginIv = helper.getView<ImageView>(R.id.phone_login_iv)
        val userNameInfoContainer = helper.getView<View>(R.id.user_name_info_container)
        val userNameTv = helper.getView<TextView>(R.id.user_name_tv)
        val redCodeTv = helper.getView<TextView>(R.id.red_code_tv)
        val userSimpleInfoContainer = helper.getView<View>(R.id.user_simple_info_container)
        val goldenBeanItem = helper.getView<InfoItem>(R.id.golden_bean_item)
        val cashItem = helper.getView<InfoItem>(R.id.cash_item)
        val readItem = helper.getView<InfoItem>(R.id.read_item)
        val loginWxContainer = helper.getView<View>(R.id.login_wx_container)
        val readCodetv = helper.getView<ImageView>(R.id.red_code_iv)
        if (QYAccount.isLogin()) {
            //清除动画
            wxLoginTipTv.setImageResource(0)
            phoneLoginIv.setImageResource(0)
            wxLoginTipTv.clearAnimation()
            phoneLoginIv.clearAnimation()
            //信息
            userNameTv.text = QYAccount.getUserInfo().nickName
            redCodeTv.text = QYAccount.redPackageCode()
            goldenBeanItem.setInfoTitle("金豆")
            cashItem.setInfoTitle("现金")
            readItem.setInfoTitle("今日阅读(分钟)")
            goldenBeanItem.setInfoContent("" + QYAccount.goldBeanNum())
            cashItem.setInfoContent("" + QYAccount.cashNum())
            readItem.setInfoContent("" + QYAccount.getTodayReadMinute())

            userSimpleInfoContainer.visibility = View.VISIBLE
            userNameInfoContainer.visibility = View.GONE
            loginWxContainer.visibility = View.GONE
            readCodetv.visibility = View.VISIBLE
        } else {
            wxLoginTipTv.gif(R.mipmap.gif_wx_login_red_pagkage_tip)
            phoneLoginIv.gif(R.mipmap.gif_phone_login_tip)

            userSimpleInfoContainer.visibility = View.GONE
            userNameInfoContainer.visibility = View.VISIBLE
            loginWxContainer.visibility = View.VISIBLE
            readCodetv.visibility = View.GONE
        }
        helper.getView<ImageView>(R.id.head_portrait_iv).apply {
            //展示头像
            if (QYAccount.getGender() == com.freebookqy.application.app.constant.Constant.Gender.MALE) {
                setImageResource(R.mipmap.gender_select_man_no_selected)
            } else {
                setImageResource(R.mipmap.gender_select_woman_no_selected)
            }
        }

        helper.getView<TextView>(R.id.wx_login_tv).setOnClickListener {
            //进入微信登录
            val req = SendAuth.Req()
            req.scope = "snsapi_userinfo"//
            //req.scope = "snsapi_login";//提示 scope参数错误，或者没有scope权限
            req.state = "wechat_sdk_微信登录"
            WxManager.wxApi().sendReq(req)
        }
        phoneLoginIv.setOnClickListener { LoginActivity.startActivity(mContext) }
    }

    private fun refreshNormal(helper: BaseViewHolder, item: MyNormalItem) {
        helper.getView<ImageView>(R.id.left_iv).setImageResource(item.leftRes)
        helper.getView<TextView>(R.id.my_title_tv).text = item.title
        helper.getView<TextView>(R.id.my_content_tv).apply {
            if (TextUtils.isEmpty(item.content)) {
                visibility = View.GONE
            } else {
                visibility = View.VISIBLE
                text = item.content
            }
        }
        helper.getView<TextView>(R.id.my_tip_tv).apply {
            if (TextUtils.isEmpty(item.rightTip)) {
                visibility = View.GONE
            } else {
                visibility = View.VISIBLE
                text = item.rightTip
                setTextColor(item.rightTipColor)
            }
        }
        helper.getView<View>(R.id.my_enter_iv).visibility = if (item.isEntry) View.VISIBLE else View.INVISIBLE
        helper.getView<View>(R.id.divide_view).visibility = if (item.isDivide) View.VISIBLE else View.GONE
        helper.getView<View>(R.id.top_divide_view).visibility = if (item.isTopDivide) View.VISIBLE else View.GONE
    }


}


class MyItem(
    private val type: Int,
    val any: Any?
) : MultiItemEntity {
    override fun getItemType(): Int {
        return type
    }

    companion object {
        const val TYPE_HEADER = 1
        const val TYPE_NORMAL = 2
    }
}

class MyHeaderItem

class MyNormalItem(
    /**
     * 范围 NormalItem中的ID_XXX
     */
    val id: Int,
    @DrawableRes
    val leftRes: Int,
    val title: String,
    val content: String = "",
    val rightTip: String = "",
    @ColorInt
    val rightTipColor: Int = 0,
    val isEntry: Boolean = true,
    val isTopDivide: Boolean = false,
    val isDivide: Boolean = true
) {
    companion object {
        const val ID_INVITE_FRIENDS = 1
        const val ID_MY_WALLET = 2
        const val ID_WANT_WITH_DRAW = 3
        const val ID_MEMBERSHIP_BENEFITS = 4
        const val ID_MY_FRIENDS = 5
        const val ID_MSG = 6
        const val ID_READ_FOOTPRINT = 7
        const val ID_RED_ENVELOPES_FOR_CODE = 8
        const val ID_HELP_CENTER = 9
        const val ID_SYS_SETTING = 10
    }
}