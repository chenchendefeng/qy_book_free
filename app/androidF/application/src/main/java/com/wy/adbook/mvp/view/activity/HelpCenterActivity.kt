package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.WindowManager
import android.widget.LinearLayout
import com.freebookqy.application.R
import com.freebookqy.utilslib.ResUtils
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.di.component.DaggerHelpCenterComponent
import com.wy.adbook.di.module.HelpCenterModule
import com.wy.adbook.ext.hideKeyboard
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.contranct.HelpCenterContract
import com.wy.adbook.mvp.presenter.HelpCenterPresenter
import com.wy.adbook.mvp.view.fragment.CommonQuestionFragment
import com.wy.adbook.mvp.view.fragment.FeedbackFragment
import kotlinx.android.synthetic.main.activity_help_center.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.UIUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-29.
 */
class HelpCenterActivity : QYBaseActivity<HelpCenterPresenter>(), HelpCenterContract.View {

    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, HelpCenterActivity::class.java))
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerHelpCenterComponent.builder()
            .appComponent(appComponent)
            .helpCenterModule(HelpCenterModule((this@HelpCenterActivity)))
            .build()
            .inject(this@HelpCenterActivity)
    }

    @Inject
    lateinit var indicatorList: MutableList<String>

    @Inject
    lateinit var commonQuestionFragment: CommonQuestionFragment

    @Inject
    lateinit var feedbackFragment: FeedbackFragment

    override fun initView(savedInstanceState: Bundle?): Int {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        return R.layout.activity_help_center
    }

    override fun initData(savedInstanceState: Bundle?) {
        title_bar_view.setOnLeftButtonClickListener { finish() }
        initMagicIndicator()
        initVp()
    }

    private fun initMagicIndicator() {
        magic_indicator?.also {
            val navigator = CommonNavigator(this@HelpCenterActivity).apply {
                scrollPivotX = 0.35f
                isAdjustMode = true
                adapter = object : CommonNavigatorAdapter() {
                    override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
                        return ColorTransitionPagerTitleView(context).apply {
                            text = indicatorList[index]
                            normalColor = ResUtils.getColor(R.color.third_black_text_color)
                            selectedColor = ResUtils.getColor(R.color.black_text_color)
                            onClick { help_center_vp.currentItem = index }
                        }
                    }

                    override fun getCount(): Int {
                        return indicatorList.size
                    }

                    override fun getIndicator(context: Context): IPagerIndicator {
                        val indicator = LinePagerIndicator(context)
                        indicator.setColors(ResUtils.getColor(R.color.translucent_background))
                        return indicator
                    }
                }

            }
            it.navigator = navigator
            navigator.titleContainer.showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE
            navigator.titleContainer.dividerPadding = UIUtil.dip2px(this@HelpCenterActivity, 15.0)
            navigator.titleContainer.dividerDrawable = resources.getDrawable(R.drawable.simple_splitter)
            ViewPagerHelper.bind(it, help_center_vp)
        }
    }

    private fun initVp() {
        help_center_vp.adapter = HelpCenterVpAdapter(supportFragmentManager)
        help_center_vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                if (p0 == 0) {
                    hideKeyboard()
                }
            }
        })
    }

    inner class HelpCenterVpAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(p0: Int): Fragment {
            return when (p0) {
                0 -> commonQuestionFragment
                1 -> feedbackFragment
                else -> commonQuestionFragment
            }
        }

        override fun getCount(): Int = indicatorList.size

    }


}