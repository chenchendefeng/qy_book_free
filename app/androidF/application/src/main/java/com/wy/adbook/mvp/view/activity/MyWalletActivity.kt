package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.widget.LinearLayout
import android.widget.TextView
import com.freebookqy.application.R
import com.freebookqy.utilslib.ResUtils
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.di.component.DaggerMyWalletComponent
import com.wy.adbook.di.module.MyWalletModule
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.contranct.MyWalletContract
import com.wy.adbook.mvp.presenter.MyWalletPresenter
import com.wy.adbook.mvp.view.adapter.WalletItemAdapter
import com.wy.adbook.view.status.IStatusCoverView
import kotlinx.android.synthetic.main.activity_wallet.*
import net.lucode.hackware.magicindicator.FragmentContainerHelper
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.UIUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView
import org.jetbrains.anko.find

/**
 * Created by leafye on 2019/5/6.
 */
class MyWalletActivity : QYBaseActivity<MyWalletPresenter>(), MyWalletContract.View {


    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, MyWalletActivity::class.java))
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMyWalletComponent.builder()
            .appComponent(appComponent)
            .myWalletModule(MyWalletModule((this@MyWalletActivity)))
            .build()
            .inject(this@MyWalletActivity)
    }

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_wallet

    override fun getToolbar(): View? = title_bar_view

    private val walletList: MutableList<String> by lazy {
        mutableListOf<String>().apply {
            add("现金明细")
            add("金豆明细")
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        initListener()
        initIndicator()
        mPresenter?.fetchData()
    }

    private fun initListener() {
        status_cover_view.setReTryClickListener(object : IStatusCoverView.ReTryClickListener {
            override fun reTry() {
                mPresenter?.fetchData()
            }
        })
        title_bar_view.setOnLeftButtonClickListener { finish() }
    }

    private val walletVpAdapter by lazy {
        WalletVpAdapter(this@MyWalletActivity, viewList)
    }

    private fun initVp() {
        if (wallet_vp.adapter == null) {
            wallet_vp.adapter = walletVpAdapter
        } else {
            walletVpAdapter.notifyDataSetChanged()
        }
    }

    private val viewList: MutableList<View> by lazy {
        mutableListOf<View>().apply {
            add(RecyclerView(this@MyWalletActivity))
            add(RecyclerView(this@MyWalletActivity))
        }
    }

    private fun initIndicator() {
        val commonNavigator = CommonNavigator(this).apply {
            isAdjustMode = true
            adapter = object : CommonNavigatorAdapter() {
                override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
                    return ColorTransitionPagerTitleView(context).apply {
                        normalColor =
                            ResUtils.getColor(R.color.second_black_text_color)
                        selectedColor =
                            ResUtils.getColor(R.color.red_text_color)
                        text = walletList[index]
                        onClick { wallet_vp.currentItem = index }
                    }
                }

                override fun getCount(): Int = walletList.size

                override fun getIndicator(context: Context?): IPagerIndicator {
                    return LinePagerIndicator(context).apply {
                        mode = LinePagerIndicator.MODE_EXACTLY
                        lineWidth = UIUtil.dip2px(context, 26.0).toFloat()
                        lineHeight = UIUtil.dip2px(context, 2.0).toFloat()
                        setColors(
                            ResUtils.getColor(R.color.red_text_color)
                        )
                    }
                }
            }
        }
        magic_indicator.navigator = commonNavigator
        val titleContainer = commonNavigator.titleContainer // must after setNavigator
        titleContainer.showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE
        titleContainer.dividerDrawable = object : ColorDrawable() {
            override fun getIntrinsicWidth(): Int {
                return UIUtil.dip2px(this@MyWalletActivity, 15.0)
            }
        }
        val fragmentContainerHelper = FragmentContainerHelper(magic_indicator)
        fragmentContainerHelper.setInterpolator(OvershootInterpolator(2.0f))
        fragmentContainerHelper.setDuration(300)
        wallet_vp.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                fragmentContainerHelper.handlePageSelected(position)
            }
        })
        ViewPagerHelper.bind(magic_indicator, wallet_vp)
    }

    inner class WalletVpAdapter(private val context: Context, var viewList: MutableList<View>) : PagerAdapter() {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val list = if (position == 0) {
                mPresenter?.rmbFlowPage?.data
            } else {
                mPresenter?.goldFlowPage?.data
            }
            val recyclerView = viewList[position] as RecyclerView
            if (recyclerView.layoutManager == null) {
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = WalletItemAdapter(list).apply itemAdapter@{
                    val view = View.inflate(context, R.layout.empty_wallet, null).apply {
                        val str = if (position == 0) "现金" else "金豆"
                        find<TextView>(R.id.empty_text_tv).text =
                            ResUtils.getString(R.string.no_cash_detail, str)
                        find<TextView>(R.id.empty_tip_tv).text =
                            ResUtils.getString(R.string.detailed_system_retain_only_last_3_days_cash, str)
                    }
                    emptyView = view
                    setOnLoadMoreListener({
                        if (position == 0) {
                            mPresenter?.loadMoreRmb(this@itemAdapter)
                        } else {
                            mPresenter?.loadMoreGold(this@itemAdapter)
                        }
                    }, recyclerView)
                }
            } else {
                val walletItemAdapter = recyclerView.adapter as WalletItemAdapter
                if (walletItemAdapter.data.isEmpty()) {
                    walletItemAdapter.setNewData(list)
                }
            }
            container.addView(recyclerView)
            return recyclerView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(viewList[position])
        }

        override fun isViewFromObject(p0: View, p1: Any): Boolean = p0 == p1

        override fun getCount(): Int = viewList.size

        override fun getItemPosition(`object`: Any): Int {
            return PagerAdapter.POSITION_NONE
        }
    }

    override fun changeStatusCoverView(status: IStatusCoverView.Status) {
        status_cover_view.changeStatus(status)
    }

    override fun refreshView() {
        mPresenter?.balance?.let {
            rmb_amount_tv.text = "${it.rmbalance}"
            total_get_rmb_amount_tv.text = ResUtils.getString(R.string.has_to_earn_cash, it.rmbTotal)
            gold_amount_tv.text = "${it.goldBalance}"
        }
        initVp()
    }

    override fun getCurrentAdapter(): WalletItemAdapter {
        return (viewList[wallet_vp.currentItem] as RecyclerView).adapter as WalletItemAdapter
    }

}