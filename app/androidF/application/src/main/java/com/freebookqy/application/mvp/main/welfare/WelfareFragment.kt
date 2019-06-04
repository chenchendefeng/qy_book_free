package com.freebookqy.application.mvp.main.welfare

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freebookqy.application.R
import com.freebookqy.application.app.base.QYBaseFragment
import com.freebookqy.application.app.constant.Constant
import com.freebookqy.application.di.component.DaggerWelfareComponent
import com.freebookqy.application.di.module.WelfareModule
import com.freebookqy.application.ext.px
import com.freebookqy.application.mvp.contranct.WelfareContract
import com.freebookqy.application.mvp.model.entity.WelfareItem
import com.freebookqy.application.view.DailyReadingProgress
import com.freebookqy.application.view.WelfareItemView
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.utilslib.SpanUtils
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.fragment_welfare.*

/**
 * Created by leafye on 2019/4/30.
 */
class WelfareFragment : QYBaseFragment<WelfarePresenter>(), WelfareContract.View {


    companion object {

        const val HEAD_TYPE_NONE = -1

        const val HEAD_TYPE_FIRST = 0

        const val HEAD_TYPE_CONTINUOUS_SIGN_IN = 1

        fun newInstance(): WelfareFragment = WelfareFragment()
    }

    private var headerType = HEAD_TYPE_FIRST

    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerWelfareComponent
            .builder()
            .appComponent(appComponent)
            .welfareModule(WelfareModule(this@WelfareFragment))
            .build()
            .inject(this@WelfareFragment)
    }

    override fun initData(savedInstanceState: Bundle?) {
        mPresenter?.fetchData()
    }

    override fun setData(data: Any?) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_welfare, null)!!

    override fun startInitView() {
        initSignInHeader()
        refreshHeaderView()
        initListener()
        refresh_layout.setOnRefreshListener { mPresenter?.fetchData() }
    }

    private fun initListener() {
        sign_in_status_container.setOnClickListener { mPresenter?.toTodaySign() }

    }

    override fun refreshHeader(headViewType: Int) {
        this.headerType = headViewType
        refreshHeaderView()
    }

    private fun refreshHeaderView() {
        if (headerType == HEAD_TYPE_FIRST) {
            header_container.visibility = View.VISIBLE
            sign_in_status_container.setBackgroundResource(R.drawable.shape_circle_40_g_fa5e5b_to_e9101e)
            sign_in_status_tv.setTextColor(ResUtils.getColor(R.color.white))
            sign_in_status_tv.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0)
            sign_in_status_tv.setText(R.string.sign_in_immediately)
            val signInNunDays: SpannableStringBuilder = SpanUtils().apply {
                append("首次签到奖励")
                    .append("100").setFontSize(20.px)
                    .append("金豆")
            }.create()
            sign_in_number_days_tv.text = signInNunDays
            val signInTip = SpanUtils().apply {
                append(ResUtils.getString(R.string.sign_in_to_highest_available_in_succession))
                    .append(ResUtils.getString(R.string.n_gold_beans, Constant.maxSignGoldBean))
                    .setForegroundColor(ResUtils.getColor(R.color.red_text_color))
            }.create()
            sign_in_tip_tv.text = signInTip
        } else if (headerType == HEAD_TYPE_CONTINUOUS_SIGN_IN) {
            header_container.visibility = View.VISIBLE
            if (isTodaySign()) {
                sign_in_status_container.setBackgroundResource(R.drawable.shape_circle_40_8d8d8d_1stroke)
                sign_in_status_tv.setTextColor(ResUtils.getColor(R.color.black_text_color))
                sign_in_status_tv.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    R.mipmap.icon_small_right_arrow,
                    0
                )
                //首次签到奖励100金豆
                sign_in_status_tv.text = "已签到"

            } else {
                sign_in_status_container.setBackgroundResource(R.drawable.shape_circle_40_g_fa5e5b_to_e9101e)
                sign_in_status_tv.setTextColor(ResUtils.getColor(R.color.white))
                sign_in_status_tv.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    R.mipmap.icon_jindou,
                    0
                )
                sign_in_status_tv.text = "签到+20"
            }
            val signInNunDays: SpannableStringBuilder = SpanUtils().apply {
                append(ResUtils.getString(R.string.consecutive_sign_in))
                    .append("" + (mPresenter?.getContinueSignDays() ?: 0)).setFontSize(20.px)
                    .append(ResUtils.getString(R.string.tian))
            }.create()
            sign_in_number_days_tv.text = signInNunDays

            if (mPresenter?.hasCompensateSign() == true) {
                //漏签4天，补签之后可达到连续5天，立即补签>
                val signInTip = SpanUtils().apply {
                    append(
                        ResUtils.getString(
                            R.string.leakage_sign_to_continue_sign,
                            mPresenter?.leakageSignDays() ?: 0,
                            mPresenter?.canContinueSignDays() ?: 0
                        )
                    ).append(ResUtils.getString(R.string.retroactive_immediately))
                        .setForegroundColor(ResUtils.getColor(R.color.red_text_color))
                }.create()
                sign_in_tip_tv.text = signInTip
            } else {
                val signInTip = SpanUtils().apply {
                    append(ResUtils.getString(R.string.sign_in_to_highest_available_in_succession))
                        .append(ResUtils.getString(R.string.n_gold_beans, Constant.maxSignGoldBean))
                        .setForegroundColor(ResUtils.getColor(R.color.red_text_color))
                }.create()
                sign_in_tip_tv.text = signInTip
            }
        } else {
            header_container.visibility = View.GONE
        }
    }

    private fun isTodaySign(): Boolean {
        return true
    }


    override fun refreshView() {
        mPresenter?.welfare?.let { welfare ->
            if (welfare.dailyList?.isNotEmpty() == true) {
                daily_welfare_container.visibility = View.VISIBLE
                addViewToList(welfare.dailyList!!, daily_welfare_list)
            } else {
                daily_welfare_container.visibility = View.GONE
            }
            if (welfare.noviceList?.isNotEmpty() == true) {
                new_welfare_container.visibility = View.VISIBLE
                addViewToList(welfare.noviceList!!, new_welfare_list)
            } else {
                new_welfare_container.visibility = View.GONE
            }
            if (welfare.readList?.isNotEmpty() == true) {
                read_welfare_container.visibility = View.VISIBLE
                addViewToList(welfare.readList!!, read_welfare_list)
            } else {
                read_welfare_container.visibility = View.GONE
            }
        }
    }

    private fun addViewToList(welfareItemList: MutableList<WelfareItem>, list: ViewGroup) {
        list.removeAllViews()
        welfareItemList.forEach { welfareItem ->
            val welfareItemView = getWelfareItemView(welfareItem = welfareItem)
            list.addView(welfareItemView)
            if (welfareItem.mainTitle == "每日阅读") {
                list.addView(DailyReadingProgress(this@WelfareFragment.getFragmentActivity()))
            }
        }
    }

    private fun getWelfareItemView(welfareItem: WelfareItem): WelfareItemView {
        return WelfareItemView(this@WelfareFragment.getFragmentActivity()).apply {
            setTitle(welfareItem.mainTitle)
            setTitleColor(welfareItem.getMainTitleColorInt())
            setItemDesText(welfareItem.subTitle)
            setItemDesColor(welfareItem.getSubTitleColor())
            setRightBtnText(welfareItem.buttonTex)
            redTipVisible(!TextUtils.isEmpty(welfareItem.iconTex))
            setRedTipText(welfareItem.iconTex)
            setRedTipIv(
                when {
                    welfareItem.rewardType == "rmb" -> R.mipmap.icon_hongbao
                    welfareItem.rewardType == "gold" -> R.mipmap.icon_jindou
                    else -> R.mipmap.icon_jindou
                }
            )
            setOnRightClickListener(View.OnClickListener { mPresenter?.handleSkip(welfareItem) })
        }
    }

    override fun setRefresh(isRefresh: Boolean) {
        refresh_layout.isRefreshing = isRefresh
    }

    private fun initSignInHeader() {

    }


//    private fun initWelfareItem() {
//        fill_in_red_envelope_code_item.apply {
//            setTitle("填红包码")
//            setItemDesText("红包码可向你的好友获取")
//            setRightBtnText("去填写")
//            redTipVisible(true)
//            setRedTipText("最高5元")
//            setRedTipIv(R.mipmap.icon_hongbao)
//            setOnRightClickListener(View.OnClickListener { mPresenter?.toFillInRed() })
//        }
//        binding_mobile_phone_number_item.apply {
//            setTitle("绑定手机/微信号")
//            setItemDesText("绑定手机/微信号即可获得金豆奖励")
//            setRightBtnText("去绑定")
//            redTipVisible(true)
//            setRedTipIv(R.mipmap.icon_jindou)
//            setOnRightClickListener(View.OnClickListener { mPresenter?.toBind() })
//        }
//        time_to_invite_item.apply {
//            setTitle("限时邀请好友")
//            setItemDesText("成功邀请一位有效好友，金豆翻倍")
//            setRightBtnText("去邀请")
//            redTipVisible(true)
//            setRedTipIv(R.mipmap.icon_jindou)
//            setOnRightClickListener(View.OnClickListener { mPresenter?.toInvite() })
//        }
//        //有奖竞答
//        prize_correct_item.apply {
//            setTitle(ResUtils.getString(R.string.prize_correct))
//            setItemDesText(ResUtils.getString(R.string.help_you_play_task_win_fortunella_venosa_reward))
//            setRightBtnText(ResUtils.getString(R.string.to_answer_questions))
//            redTipVisible(true)
//            setRedTipIv(R.mipmap.icon_jindou)
//            setOnRightClickListener(View.OnClickListener { mPresenter?.toAnswer() })
//        }
//        //阅读计时奖励
//        timing_reward_item.apply {
//            setTitle(ResUtils.getString(R.string.read_n_sec_timer_reward, QYConfig.readSecondsToGetReward))
//            setItemDesText(ResUtils.getString(R.string.read_longer_more_fortunella_venosa_cumulative_gain))
//            setRightBtnText(ResUtils.getString(R.string.to_read))
//            redTipVisible(true)
//            setRedTipIv(R.mipmap.icon_jindou)
//            setOnRightClickListener(View.OnClickListener { mPresenter?.toRead() })
//        }
//        //每日阅读
//        daily_reading_item.apply {
//            setTitle(ResUtils.getString(R.string.daily_reading))
//            setItemDesText(ResUtils.getString(R.string.finish_reading_tasks_often_get_bonus))
//            setRightBtnText(ResUtils.getString(R.string.to_read))
//            redTipVisible(true)
//            setRedTipIv(R.mipmap.icon_jindou)
//            setOnRightClickListener(View.OnClickListener { mPresenter?.toRead() })
//        }
//        //看视频免广告
//        watching_video_from_advertising_item.apply {
//            setTitle(ResUtils.getString(R.string.watching_video_from_advertising))
//            setItemDesText(
//                ResUtils.getString(
//                    R.string.available_n_minutes_full_full_reading_ad_free_privileges,
//                    QYConfig.watchingVideoGetSkipAdTimeMinute
//                )
//            )
//            setRightBtnText(ResUtils.getString(R.string.to_watch))
//            redTipVisible(false)
//            setRedTipIv(R.mipmap.icon_jindou)
//            setOnRightClickListener(View.OnClickListener {
//                mPresenter?.watchingVideo()
//            })
//        }
//        //每日分享
//        share_points_item.apply {
//            setTitle(ResUtils.getString(R.string.daily_share))
//            setItemDesText(
//                ResUtils.getString(
//                    R.string.share_to_friends_and_wechat_group_available_n_gold_beans,
//                    QYConfig.shareGetRewardNum
//                )
//            )
//            setRightBtnText(ResUtils.getString(R.string.to_share))
//            setRedTipIv(R.mipmap.icon_jindou)
//            setOnRightClickListener(View.OnClickListener {
//                mPresenter?.share()
//            })
//            redTipVisible(true)
//        }
//        //邀请好友获现金奖励
//        won_prize_to_invite_friends_item.apply {
//            setTitle(ResUtils.getString(R.string.invite_friends_cash_rewards))
//            setItemDesText(ResUtils.getString(R.string.invite_friends_both_sides_cash_bonus))
//            setRightBtnText(ResUtils.getString(R.string.to_invite))
//            setRedTipIv(R.mipmap.icon_jindou)
//            setOnRightClickListener(View.OnClickListener {
//                mPresenter?.toInvite()
//            })
//            redTipVisible(true)
//        }
//        //幸运转盘
//        lucky_guy_item.apply {
//            setTitle(ResUtils.getString(R.string.lucky_guy))
//            setItemDesText(ResUtils.getString(R.string.fortunella_venosa_cash_envelopes_winning_100p))
//            setRightBtnText(ResUtils.getString(R.string.to_draw))
//            setRedTipIv(R.mipmap.icon_jindou)
//            setOnRightClickListener(View.OnClickListener {
//                mPresenter?.toInvite()
//            })
//            redTipVisible(true)
//        }
//        daily_reading_progress_view.apply {
//            setWelfareTv1("" + QYConfig.readLevelReward1)
//            setWelfareTv2("" + QYConfig.readLevelReward2)
//            setWelfareTv3("" + QYConfig.readLevelReward3)
//            setWelfareTv4("" + QYConfig.readLevelReward4)
//            setWelfareTimeTv1(ResUtils.getString(R.string.n_minutes, QYConfig.readLevelMinute1))
//            setWelfareTimeTv2(ResUtils.getString(R.string.n_minutes, QYConfig.readLevelMinute2))
//            setWelfareTimeTv3(ResUtils.getString(R.string.n_minutes, QYConfig.readLevelMinute3))
//            setWelfareTimeTv4(ResUtils.getString(R.string.n_minutes, QYConfig.readLevelMinute4))
//        }
//    }


}