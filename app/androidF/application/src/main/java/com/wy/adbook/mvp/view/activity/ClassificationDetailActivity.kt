package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.View
import com.freebookqy.application.R
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.di.component.DaggerClassificationDetailComponent
import com.wy.adbook.di.module.ClassificationDetailModule
import com.wy.adbook.ext.onClick
import com.wy.adbook.ext.px
import com.wy.adbook.mvp.contranct.ClassificationDetailContract
import com.wy.adbook.mvp.model.entity.ClassificationItem
import com.wy.adbook.mvp.model.entity.book.Book
import com.wy.adbook.mvp.presenter.ClassificationDetailPresenter
import com.wy.adbook.mvp.view.fragment.BookFragment
import com.wy.adbook.view.indicator.ScaleTransitionPagerTitleView
import com.wy.adbook.view.indicator.StrokePagerIndicator
import com.freebookqy.utilslib.ResUtils
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.activity_classification_detail.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView

/**
 * Created by leafye on 2019/5/5.
 */
class ClassificationDetailActivity : QYBaseActivity<ClassificationDetailPresenter>(),
    ClassificationDetailContract.View {

    companion object {

        private const val EXTRA_CLASSIFICATION_ITEM = "extraClassificationItem"

        @JvmStatic
        fun startActivity(context: Context, classificationItem: ClassificationItem) {
            context.startActivity(Intent(context, ClassificationDetailActivity::class.java).apply {
                putExtra(EXTRA_CLASSIFICATION_ITEM, classificationItem)
            })
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerClassificationDetailComponent.builder()
            .appComponent(appComponent)
            .classificationDetailModule(ClassificationDetailModule((this@ClassificationDetailActivity)))
            .build()
            .inject(this@ClassificationDetailActivity)
    }

    private val fragmentList: MutableList<Fragment> by lazy {
        mutableListOf<Fragment>().apply {
            add(BookFragment.newInstance(Book.FinishFlag.ALL))
            add(BookFragment.newInstance(Book.FinishFlag.FINISH_FLAG_SERIAL))
            add(BookFragment.newInstance(Book.FinishFlag.FINISH_FLAG_FINISH))
        }
    }

    private val bookVpAdapter: BookVpAdapter by lazy {
        BookVpAdapter(
            fragmentList,
            supportFragmentManager
        )
    }

    private val indicatorList: MutableList<String> by lazy {
        mutableListOf<String>().apply {
            add(ResUtils.getString(R.string.all))
            add(ResUtils.getString(R.string.book_serial))
            add(ResUtils.getString(R.string.book_end))
        }
    }

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_classification_detail

    override fun initData(savedInstanceState: Bundle?) {
        intent.apply {
            getSerializableExtra(EXTRA_CLASSIFICATION_ITEM)?.let {
                if (it is ClassificationItem) {
                    mPresenter?.classificationItem = it
                }
            }
        }
        initTitle()
        initIndicator()
        mPresenter?.fetchData()
    }

    override fun getToolbar(): View? = title_bar_view

    private fun initTitle() {
        title_bar_view.let {
            it.setTitleText(mPresenter?.classificationItem?.classificationName ?: "")
            it.setOnLeftButtonClickListener { finish() }
        }
    }

    private fun initIndicator() {
        magic_indicator?.also {
            val navigator = CommonNavigator(this@ClassificationDetailActivity).apply {
                scrollPivotX = 0.35f
                isAdjustMode = true
                adapter = object : CommonNavigatorAdapter() {
                    override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
                        return ScaleTransitionPagerTitleView(context).apply {
                            text = indicatorList[index]
                            normalColor = ResUtils.getColor(R.color.second_black_text_color)
                            selectedColor = ResUtils.getColor(R.color.red_text_color)
                            onClick { book_vp.currentItem = index }
                            minScale = 1.0F
                        }
                    }

                    override fun getCount(): Int {
                        return indicatorList.size
                    }

                    override fun getIndicator(context: Context): IPagerIndicator {
                        val indicator = StrokePagerIndicator(context)
                        indicator.horizontalPadding = 11.px
                        indicator.verticalPadding = 5.px
                        indicator.fillColor = ResUtils.getColor(R.color.red_text_color)
                        return indicator
                    }
                }
            }
            it.navigator = navigator
            ViewPagerHelper.bind(it, book_vp)
        }
    }

    override fun refreshView() {
        if (book_vp.adapter == null) {
            book_vp.adapter = bookVpAdapter
            book_vp.offscreenPageLimit = fragmentList.size
        }
        bookVpAdapter.notifyDataSetChanged()
    }

    class BookVpAdapter(private val fragmentList: MutableList<Fragment>, fm: FragmentManager) :
        FragmentStatePagerAdapter(fm) {
        override fun getItem(p0: Int): Fragment {
            return fragmentList[p0]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getItemPosition(`object`: Any): Int = FragmentStatePagerAdapter.POSITION_NONE

    }


}