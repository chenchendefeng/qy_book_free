package com.wy.adbook.mvp.view.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import com.freebookqy.application.R
import com.wy.adbook.app.base.QYBaseFragment
import com.wy.adbook.di.component.DaggerBookCityComponent
import com.wy.adbook.di.module.BookCityModule
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.contranct.BookCityContract
import com.wy.adbook.mvp.model.entity.SubjectType
import com.wy.adbook.mvp.presenter.BookCityPresenter
import com.wy.adbook.view.indicator.ScaleTransitionPagerTitleView
import com.freebookqy.utilslib.ResUtils
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.fragment_book_city.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.UIUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator


/**
 * Created by leafye on 2019/4/30.
 */
class BookCityFragment : QYBaseFragment<BookCityPresenter>(),
    BookCityContract.View {

    companion object {
        fun newInstance(): BookCityFragment {
            return BookCityFragment()
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerBookCityComponent.builder()
            .appComponent(appComponent)
            .bookCityModule(BookCityModule(this@BookCityFragment))
            .build()
            .inject(this@BookCityFragment)
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun setData(data: Any?) {

    }

    private val recommendFragment: ProjectFragment by lazy {
        ProjectFragment.newInstance(true, SubjectType.SUBJECT_TYPE_RECOMMEND)
    }
    private val manFragment: ProjectFragment by lazy {
        ProjectFragment.newInstance(true, SubjectType.SUBJECT_TYPE_BOY)
    }
    private val womanFragment: ProjectFragment by lazy {
        ProjectFragment.newInstance(true, SubjectType.SUBJECT_TYPE_GIRL)
    }

    private val fragmentList: MutableList<Fragment> by lazy {
        mutableListOf<Fragment>().apply {
            add(recommendFragment)
            add(manFragment)
            add(womanFragment)
        }
    }

    private val bookCityAdapter: BookCityAdapter by lazy {
        BookCityAdapter(fragmentList, childFragmentManager)
    }

    private val titleDataList: MutableList<String> by lazy {
        mutableListOf<String>().apply {
            add(ResUtils.getString(R.string.recommend))
            add(ResUtils.getString(R.string.man))
            add(ResUtils.getString(R.string.woman))
        }
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(com.freebookqy.application.R.layout.fragment_book_city, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        search_iv.onClick { mPresenter?.enterSearch() }
        classification_iv.onClick { mPresenter?.enterClassification() }
        refreshView()
        initIndicator()
    }

    private fun initIndicator() {
        val commonNavigator = CommonNavigator(context)
        commonNavigator.scrollPivotX = 0.8f
        commonNavigator.adapter = object : CommonNavigatorAdapter() {

            override fun getCount(): Int {
                return titleDataList.size
            }

            override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
                return ScaleTransitionPagerTitleView(context).apply {
                    normalColor =
                        ResUtils.getColor(R.color.second_black_text_color)
                    selectedColor =
                        ResUtils.getColor(R.color.red_text_color)
                    text = titleDataList[index]
                    textSize = 20F
                    setTextColor(ResUtils.getColor(R.color.black_text_color))
                    onClick { book_city_vp.currentItem = index }
                }
            }

            override fun getIndicator(context: Context): IPagerIndicator {
                return LinePagerIndicator(context).apply {
                    mode = LinePagerIndicator.MODE_EXACTLY
                    lineWidth = UIUtil.dip2px(context, 26.0).toFloat()
                    lineHeight = UIUtil.dip2px(context, 2.0).toFloat()
                    endInterpolator = OvershootInterpolator(1.6f)
                    setColors(
                        ResUtils.getColor(R.color.red_text_color)
                    )
                }
            }
        }
        book_city_magic_indicator.navigator = commonNavigator
        ViewPagerHelper.bind(book_city_magic_indicator, book_city_vp)
    }

    private fun refreshView() {
        if (book_city_vp.adapter == null) {
            book_city_vp.adapter = bookCityAdapter
        }
        book_city_vp.offscreenPageLimit = bookCityAdapter.count
    }
}


class BookCityAdapter(
    var fragmentList: MutableList<Fragment>,
    fm: FragmentManager
) : FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment {
        return fragmentList[p0]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

}