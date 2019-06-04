package com.wy.adbook.mvp.view.adapter

import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cn.bingoogolapple.bgabanner.BGABanner
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.freebookqy.application.R
import com.tencent.mm.opensdk.modelmsg.SendAuth
import com.wy.adbook.app.QYApplication
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.ext.gif
import com.wy.adbook.ext.loadImageCircle
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.model.entity.BannerItem
import com.wy.adbook.mvp.view.activity.BasicInfoActivity
import com.wy.adbook.mvp.view.activity.LoginActivity
import com.wy.adbook.mvp.view.adapter.MyItem.Companion.TYPE_HEADER
import com.wy.adbook.mvp.view.adapter.MyItem.Companion.TYPE_NORMAL
import com.wy.adbook.view.InfoItem
import com.wy.adbook.wxapi.WXEntryActivity
import com.wy.adbook.wxapi.WxManager
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

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
        val vipIv = helper.getView<ImageView>(R.id.vip_iv)
        val bannerContainer = helper.getView<ViewGroup>(R.id.banner_container)
        val bgaBanner = helper.getView<BGABanner>(R.id.banner)
        vipIv.visibility = View.GONE
        if (QYAccount.isLogin()) {
            //清除动画
            wxLoginTipTv.setImageResource(0)
            phoneLoginIv.setImageResource(0)
            wxLoginTipTv.clearAnimation()
            phoneLoginIv.clearAnimation()
            //信息
            userNameTv.text = QYAccount.getUserInfo().nickName
            redCodeTv.text = QYAccount.getInviteCode()
            goldenBeanItem.setInfoTitle("金豆")
            cashItem.setInfoTitle("现金")
            readItem.setInfoTitle("今日阅读(分钟)")
            goldenBeanItem.setInfoContent("" + QYAccount.goldBeanNum())
            cashItem.setInfoContent("" + QYAccount.cashNum())
            readItem.setInfoContent("" + QYAccount.getTodayReadMinute())

            userSimpleInfoContainer.visibility = View.VISIBLE
            userNameInfoContainer.visibility = View.VISIBLE
            loginWxContainer.visibility = View.GONE
            readCodetv.visibility = View.VISIBLE

            vipIv.visibility = View.VISIBLE
            vipIv.isSelected = QYAccount.isVip()
        } else {
            wxLoginTipTv.gif(R.mipmap.gif_wx_login_red_pagkage_tip)
            phoneLoginIv.gif(R.mipmap.gif_phone_login_tip)

            userSimpleInfoContainer.visibility = View.GONE
            userNameInfoContainer.visibility = View.GONE
            loginWxContainer.visibility = View.VISIBLE
            readCodetv.visibility = View.GONE
        }
        helper.getView<ImageView>(R.id.head_portrait_iv).apply {
            //展示头像
            val isMan = QYAccount.getGender() == com.wy.adbook.app.constant.Constant.Gender.MALE
            loadImageCircle(
                QYAccount.getUserInfo().avatar,
                if (isMan) R.mipmap.gender_select_man_no_selected else R.mipmap.gender_select_woman_no_selected
            )
            onClick { BasicInfoActivity.startActivity(mContext) }
        }

        helper.getView<TextView>(R.id.wx_login_tv).onClick {
            //进入微信登录
            val req = SendAuth.Req()
            req.scope = "snsapi_userinfo"//
            //req.scope = "snsapi_login";//提示 scope参数错误，或者没有scope权限
            req.state = WXEntryActivity.WX_LOGIN_KEY
            WxManager.wxApi().sendReq(req)
        }
        phoneLoginIv.onClick { LoginActivity.startActivity(mContext) }
        if (item.list == null || item.list?.isEmpty() == true) {
            bannerContainer.visibility = View.GONE
        } else {
            bannerContainer.visibility = View.VISIBLE
            initBanner(bgaBanner, item)
        }

    }

    private fun initBanner(banner: BGABanner, item: MyHeaderItem) {
        val bannerList = item.list ?: return
        banner
            .setAdapter(object : BGABanner.Adapter<View, BannerItem> {
                override fun fillBannerItem(banner: BGABanner?, itemView: View, model: BannerItem?, position: Int) {
                    val transform =
                        RequestOptions()
                            .error(R.mipmap.default_book_img)
                            .placeholder(R.mipmap.default_book_img)
                    Glide.with(QYApplication.cxt())
                        .load(model?.img)
                        .apply(transform)
                        .into(itemView.find(R.id.banner_iv))
                }
            })
        banner.setDelegate(object : BGABanner.Delegate<View, BannerItem> {
            override fun onBannerItemClick(banner: BGABanner?, itemView: View?, model: BannerItem?, position: Int) {
                mContext.toast("点解了banner")
            }
        })
        if (bannerList.isEmpty()) {
            banner.visibility = View.GONE
        } else {
            banner.visibility = View.VISIBLE
            val list = mutableListOf<View>().apply {
                bannerList.forEach { _ ->
                    add(getBannerItemView())
                }
            }
            banner.setData(list, bannerList, null)
            banner.startAutoPlay()
        }
    }

    private fun getBannerItemView() =
        View.inflate(mContext, R.layout.item_banner_my, null)

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

class MyHeaderItem(var list: MutableList<BannerItem>? = null)

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