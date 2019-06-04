package com.freebookqy.application.mvp.classification.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.freebookqy.application.R
import com.freebookqy.application.app.base.QYBaseActivity
import com.freebookqy.application.di.component.DaggerClassificationDetailComponent
import com.freebookqy.application.di.module.ClassificationDetailModule
import com.freebookqy.application.ext.px
import com.freebookqy.application.mvp.classification.detail.book.BookFragment
import com.freebookqy.application.mvp.contranct.ClassificationDetailContract
import com.freebookqy.application.mvp.model.entity.book.Book
import com.freebookqy.application.mvp.model.entity.ClassificationItem
import com.freebookqy.application.view.indicator.ScaleTransitionPagerTitleView
import com.freebookqy.application.view.indicator.StrokePagerIndicator
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
class ClassificationDetailActivity() : QYBaseActivity<ClassificationDetailPresenter>(),
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
        BookVpAdapter(fragmentList, supportFragmentManager)
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
                        val simplePagerTitleView = ScaleTransitionPagerTitleView(context)
                        simplePagerTitleView.text = indicatorList[index]
                        simplePagerTitleView.normalColor = ResUtils.getColor(R.color.second_black_text_color)
                        simplePagerTitleView.selectedColor = ResUtils.getColor(R.color.red_text_color)
                        simplePagerTitleView.setOnClickListener { book_vp.currentItem = index }
                        simplePagerTitleView.minScale = 1.0F
                        return simplePagerTitleView
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