package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import com.freebookqy.application.R
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.utilslib.SpanUtils
import com.freebookqy.viewlib.dialog.CommonDialog
import com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager
import com.freebookqy.viewlib.rv.layoutmanager.FullyLinearLayoutManager
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.di.component.DaggerSignCalenderComponent
import com.wy.adbook.di.module.SignCalenderModule
import com.wy.adbook.dialog.prompt.ContinuousSignPromptView
import com.wy.adbook.dialog.prompt.QYCommonPromptDialog
import com.wy.adbook.dialog.prompt.RetroactivePromptView
import com.wy.adbook.dialog.prompt.SignSuccessPromptView
import com.wy.adbook.ext.inflate
import com.wy.adbook.ext.onClick
import com.wy.adbook.ext.px
import com.wy.adbook.mvp.contranct.SignCalenderContract
import com.wy.adbook.mvp.model.entity.AttendanceStatus
import com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem
import com.wy.adbook.mvp.presenter.SignCalenderPresenter
import com.wy.adbook.mvp.view.adapter.ContinuousSignInAdapter
import com.wy.adbook.mvp.view.adapter.SignCalendarAdapter
import com.wy.adbook.view.status.IStatusCoverView
import kotlinx.android.synthetic.main.activity_sign_calender.*
import org.jetbrains.anko.find
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-08.
 */
class SignCalenderActivity : QYBaseActivity<SignCalenderPresenter>(), SignCalenderContract.View {

    companion object {

        const val EXTRA_ATTENDANCE_PAGE = "attendancePage"

        @JvmStatic
        fun startActivity(
            context: Context,
            attendanceStatus: AttendanceStatus
        ) {
            context.startActivity(Intent(context, SignCalenderActivity::class.java).apply {
                putExtra(EXTRA_ATTENDANCE_PAGE, attendanceStatus)
            })
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerSignCalenderComponent.builder()
            .appComponent(appComponent)
            .signCalenderModule(SignCalenderModule((this@SignCalenderActivity)))
            .build()
            .inject(this@SignCalenderActivity)
    }

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_sign_calender

    @Inject
    lateinit var mLayoutManager1: FullyLinearLayoutManager
    @Inject
    lateinit var mLayoutManager2: FullyGridLayoutManager
    @Inject
    lateinit var mSignCalendarAdapter: SignCalendarAdapter
    @Inject
    lateinit var mContinuousSignInAdapter: ContinuousSignInAdapter

    override fun getToolbar(): View? = title_bar_view

    override fun initData(savedInstanceState: Bundle?) {
        mPresenter?.initData(intent)
        refresh_layout.isEnabled = false
        initListener()
        initRv()
        refreshSignInTipTv()
        refreshTopSignBtnTv()
        refreshRuleContent()
        mPresenter?.fetchData()
    }

    private fun refreshSignInTipTv() {
        can_continuous_sign_in_tip_tv.text = SpanUtils().append("" + mPresenter?.canRetroactiveDay())
            .setForegroundColor(ResUtils.getColor(R.color.red_text_color))
            .append("天可补签").create()
    }

    private fun refreshTopSignBtnTv() {
        sign_top_tv_1.text =
            ResUtils.getString(R.string.has_been_signed_in_n_days, mPresenter?.attendanceStatus?.times ?: 0)
        sign_top_tv_2.text =
            ResUtils.getString(R.string.watch_short_video_bring_n_gold_beans, mPresenter?.watchVideoForGetGold() ?: 0)
    }

    private fun refreshTopSignBtnEnable() {
        sign_top_btn_container.isEnabled = true
        sign_top_tv_1.isEnabled = true
        sign_top_tv_2.isEnabled = true
    }

    private fun refreshTopSignBtnUnEnable() {
        sign_top_btn_container.isEnabled = false
        sign_top_tv_1.isEnabled = false
        sign_top_tv_2.isEnabled = false
    }

    private fun refreshRuleContent() {
        val singRuleText = mPresenter?.getSignRuleText()
        val continueSIgnRuleText = mPresenter?.getContinueSIgnRuleText()
        if (TextUtils.isEmpty(singRuleText)) {
            sign_rule_title.visibility = View.GONE
            sign_rule_tv.visibility = View.GONE
        } else {
            sign_rule_title.visibility = View.VISIBLE
            sign_rule_tv.visibility = View.VISIBLE
            sign_rule_title.setTitleTv(ResUtils.getString(R.string.sign_in_rules_title))
            sign_rule_tv.text = singRuleText
        }
        if (TextUtils.isEmpty(continueSIgnRuleText)) {
            continue_sign_rule_title.visibility = View.GONE
            continuous_sign_in_rv.visibility = View.GONE
        } else {
            continue_sign_rule_title.visibility = View.VISIBLE
            continue_sign_rule_tv.visibility = View.VISIBLE
            continue_sign_rule_title.setTitleTv(ResUtils.getString(R.string.retroactive_rules_title))
            continue_sign_rule_tv.text = continueSIgnRuleText
        }
    }

    private fun initRv() {
        if (continuous_sign_in_rv.layoutManager == null) {
            continuous_sign_in_rv.layoutManager = mLayoutManager1
            continuous_sign_in_rv.adapter = mContinuousSignInAdapter
        }
        if (sign_calendar_rv.layoutManager == null) {
            sign_calendar_rv.layoutManager = mLayoutManager2
            sign_calendar_rv.adapter = mSignCalendarAdapter
            mSignCalendarAdapter.setOnItemClickListener { adapter, _, position ->
                val item = adapter.data[position]
                if (item is AttendanceCalendarItem) {
                    if (item.compensateStatus == 1) {
                        mPresenter?.clickAttendanceCalendarItem = item
                        showRetroactiveChanceDialog()
                    }
                }
            }
        }
    }

    private fun initListener() {
        title_bar_view.setOnLeftButtonClickListener { finish() }
        refresh_layout.setOnRefreshListener { mPresenter?.fetchData() }
        sign_top_btn_container.onClick { mPresenter?.signToday() }
        status_cover_view.setReTryClickListener(object : IStatusCoverView.ReTryClickListener {
            override fun reTry() {
                mPresenter?.fetchData()
            }
        })
    }

    override fun refreshView() {
        refreshSignBtnEnable()
        refreshSignInTipTv()
        refreshTopSignBtnTv()
        refreshContinueSignTip()
    }

    private fun refreshContinueSignTip() {
        mPresenter?.rewardList?.let { list ->
            val rewardItem = list.find { it.days > mPresenter?.continueSignDay() ?: 0 }
            if (rewardItem == null) {
                continue_sign_tip_tv.text = "再连签${list[0].days}天"
            } else {
                continue_sign_tip_tv.text = "再连签${rewardItem.days - (mPresenter?.continueSignDay() ?: 0)}天"
                continue_sign_tip_container.setPadding(list.indexOf(rewardItem) * 58.px, 0, 0, 0)
            }
        }
    }

    private fun refreshSignBtnEnable() {
        mPresenter?.attendanceStatus?.let {
            if (it.status == 1 && mPresenter?.isWatchVideoForGold == true) {
                refreshTopSignBtnUnEnable()
            } else {
                refreshTopSignBtnEnable()
            }
        }
    }

    override fun showSignSuccessDialog() {
        QYCommonPromptDialog(this@SignCalenderActivity).apply dialog@{
            setView(SignSuccessPromptView(context).apply {
                setData(mPresenter?.getGoldGet() ?: 20)
                setSignSuccessPromptListener(object : SignSuccessPromptView.SignSuccessPromptListener {
                    override fun watchVideo() {
                        mPresenter?.watchingVideo(false)
                        this@dialog.dismiss()
                    }
                })
                setOnDismissListener {
                    //判断是否需要弹出提现对话框
                    if (mPresenter?.isWatchVideoForGold == false)
                        showContinuousSignDialog()
                }
            })
        }.show()
    }

    /**
     * 显示连续签到对话框
     * 内容:连续签到可提现
     */
    override fun showContinuousSignDialog() {
        val qyCommonPromptDialog = QYCommonPromptDialog(this@SignCalenderActivity)
        val continuousSignPromptView =
            ContinuousSignPromptView(this@SignCalenderActivity).apply view@{
                setData(mPresenter?.continueSignDay() ?: 0, mPresenter?.getUserGold() ?: 0)
                setContinuousSignPromptListener(object : ContinuousSignPromptView.ContinuousSignPromptListener {
                    override fun toWithDrawal() {
                        WithdrawalActivity.startActivity(this@SignCalenderActivity)
                        qyCommonPromptDialog.dismiss()
                    }
                })
            }
        qyCommonPromptDialog.setView(continuousSignPromptView)
        qyCommonPromptDialog.show()
    }

    /**
     * 显示补签提示对话框
     */
    private fun showRetroactiveChanceDialog() {
        val qyCommonPromptDialog = QYCommonPromptDialog(this@SignCalenderActivity)
        qyCommonPromptDialog.setView(RetroactivePromptView(this@SignCalenderActivity).apply {
            setRetroactivePromptListener(object : RetroactivePromptView.RetroactivePromptListener {
                override fun watchVideo() {
                    mPresenter?.watchingVideo(true)
                    qyCommonPromptDialog.dismiss()
                }

                override fun goldBeans() {
                    mPresenter?.startRetroactive()
                    qyCommonPromptDialog.dismiss()
                }
            })
        })
        qyCommonPromptDialog.show()
    }

    override fun showTipWatchVideoDialog() {
        val dialog = CommonDialog.Builder()
            .contentView(getContext().inflate(R.layout.common_dialog_layout).apply {
                find<TextView>(R.id.title).let {
                    it.visibility = View.VISIBLE
                    it.text = "友情提示"
                }
                find<TextView>(R.id.content_tv).let {
                    it.text = "小视频时长约15-30秒，需看完才能获得哦！"
                    it.visibility = View.VISIBLE
                }
                find<TextView>(R.id.dialog_exit).text = "放弃奖励"
                find<TextView>(R.id.dialog_continue).text = "看小视频"
            })
            .setOnClick(R.id.dialog_continue, R.id.dialog_exit)
            .onClick { d, view ->
                when (view.id) {
                    R.id.dialog_continue -> {
                        //看视频拿奖励
                        mPresenter?.watchingVideo(false)
                    }
                }
                d.dismiss()
            }.build(this@SignCalenderActivity)
        dialog.show()
    }

    override fun changeStatus(status: IStatusCoverView.Status) {
        status_cover_view.changeStatus(status)
    }

    override fun setRefreshStatus(isRefresh: Boolean) {
        if (refresh_layout.isEnabled)
            refresh_layout.isRefreshing = isRefresh
    }
}