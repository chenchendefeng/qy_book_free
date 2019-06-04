package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.widget.CheckBox
import com.freebookqy.application.R
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.di.component.DaggerMainComponent
import com.wy.adbook.di.module.MainModule
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.contranct.MainContract
import com.wy.adbook.mvp.model.event.MainEvent
import com.wy.adbook.mvp.presenter.MainPresenter
import com.wy.adbook.mvp.view.fragment.BookCityFragment
import com.wy.adbook.mvp.view.fragment.BookcaseFragment
import com.wy.adbook.mvp.view.fragment.MyFragment
import com.wy.adbook.mvp.view.fragment.WelfareFragment
import com.freebookqy.utilslib.ResUtils
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.activity_main.*
import net.lucode.hackware.magicindicator.FragmentContainerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView
import org.jetbrains.anko.find
import org.simple.eventbus.Subscriber
import org.simple.eventbus.ThreadMode


/**
 * Created by leafye on 2019/4/29.
 */
class MainActivity : QYBaseActivity<MainPresenter>(), MainContract.View {

    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMainComponent.builder()
            .appComponent(appComponent)
            .mainModule(MainModule((this@MainActivity)))
            .build()
            .inject(this@MainActivity)
    }

    override fun isHandlerStatusBarHeight(): Boolean = false

    override fun initView(savedInstanceState: Bundle?): Int = com.freebookqy.application.R.layout.activity_main

    private val mFragmentContainerHelper = FragmentContainerHelper()

    private val tagBookcase = "tagBookcase"
    private val tagBookCity = "tagBookCity"
    private val tagWelfare = "tagWelfare"
    private val tagMy = "tagMy"

    private var bookcaseFragment: BookcaseFragment? = null
    private var bookCityFragment: BookCityFragment? = null
    private var welfareFragment: WelfareFragment? = null
    private var myFragment: MyFragment? = null

    //书架frag
    private fun getBookcaseFragment(): BookcaseFragment {
        var fragment = supportFragmentManager.findFragmentByTag(tagBookcase)
        if (fragment == null || !(fragment is BookcaseFragment)) {
            fragment = BookcaseFragment.newInstance()
        }
        bookcaseFragment = fragment
        return fragment
    }

    //书城frag
    private fun getBookCityFragment(): BookCityFragment {
        var fragment = supportFragmentManager.findFragmentByTag(tagBookCity)
        if (fragment == null || !(fragment is BookCityFragment)) {
            fragment = BookCityFragment.newInstance()
        }
        bookCityFragment = fragment
        return fragment
    }

    //福利 frag
    private fun getWelfareFragment(): WelfareFragment {
        var fragment = supportFragmentManager.findFragmentByTag(tagWelfare)
        if (fragment == null || !(fragment is WelfareFragment)) {
            fragment = WelfareFragment.newInstance()
        }
        welfareFragment = fragment
        return fragment
    }

    //我的 frag
    private fun getMyFragment(): MyFragment {
        var fragment = supportFragmentManager.findFragmentByTag(tagMy)
        if (fragment == null || !(fragment is MyFragment)) {
            fragment = MyFragment.newInstance()
        }
        myFragment = fragment
        return fragment
    }

    private val tagTitleList: MutableList<String> by lazy {
        mutableListOf<String>()
            .apply {
                add(ResUtils.getString(com.freebookqy.application.R.string.bookcase))
                add(ResUtils.getString(com.freebookqy.application.R.string.book_city))
                add(ResUtils.getString(com.freebookqy.application.R.string.welfare))
                add(ResUtils.getString(com.freebookqy.application.R.string.my))
            }
    }

    override fun initData(savedInstanceState: Bundle?) {
        setSwipeBackEnable(false)
        initBtmNavigation()
        mFragmentContainerHelper.handlePageSelected(1, false)
        addFragmentToContainer(getBookCityFragment(), tagBookCity)
    }

    private fun addFragmentToContainer(frag: Fragment, tag: String) {
        val fragmentByTag = supportFragmentManager.findFragmentByTag(tag)
        val beginTransaction = supportFragmentManager
            .beginTransaction()
        bookcaseFragment?.let {
            if (frag != it)
                beginTransaction.hide(it)
        }
        bookCityFragment?.let {
            if (frag != it)
                beginTransaction.hide(it)
        }
        welfareFragment?.let {
            if (frag != it)
                beginTransaction.hide(it)
        }
        myFragment?.let {
            if (frag != it)
                beginTransaction.hide(it)
        }
        if (fragmentByTag == null || !fragmentByTag.isAdded) {
            beginTransaction
                .add(R.id.fragment_container, frag, tag)
                .commit()// 此处的R.id.fragment_container是要盛放fragment的父容器
        } else {
            beginTransaction
                .show(fragmentByTag)
                .commit()// 此处的R.id.fragment_container是要盛放fragment的父容器
        }
    }


    private fun initBtmNavigation() {
        val commonNavigator = CommonNavigator(this)
        commonNavigator.isAdjustMode = true
        commonNavigator.adapter = object : CommonNavigatorAdapter() {

            override fun getCount() = tagTitleList.size

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                return CommonPagerTitleView(context).apply {
                    // load custom layout
                    LayoutInflater.from(context)
                        .inflate(R.layout.simple_pager_title_layout, null).let {
                            val titleText = it.find<CheckBox>(com.freebookqy.application.R.id.title_text)
                            titleText.setCompoundDrawablesRelativeWithIntrinsicBounds(
                                0,
                                getImageResByIndex(index),
                                0,
                                0
                            )
                            titleText.text = tagTitleList[index]
                            setContentView(it)
                            onPagerTitleChangeListener =
                                object : CommonPagerTitleView.OnPagerTitleChangeListener {

                                    override fun onSelected(index: Int, totalCount: Int) {
                                        titleText.isChecked = true
                                    }

                                    override fun onDeselected(index: Int, totalCount: Int) {
                                        titleText.isChecked = false
                                    }

                                    override fun onLeave(
                                        index: Int,
                                        totalCount: Int,
                                        leavePercent: Float,
                                        leftToRight: Boolean
                                    ) {
                                    }

                                    override fun onEnter(
                                        index: Int,
                                        totalCount: Int,
                                        enterPercent: Float,
                                        leftToRight: Boolean
                                    ) {
                                    }
                                }
                        }
                    onClick {
                        mFragmentContainerHelper.handlePageSelected(index)
                        when (index) {
                            0 -> addFragmentToContainer(getBookcaseFragment(), tagBookcase)
                            1 -> addFragmentToContainer(getBookCityFragment(), tagBookCity)
                            2 -> addFragmentToContainer(getWelfareFragment(), tagWelfare)
                            3 -> addFragmentToContainer(getMyFragment(), tagMy)
                        }
                    }
                }
            }

            override fun getIndicator(context: Context): IPagerIndicator? {
                return null
            }
        }
        magic_indicator.navigator = commonNavigator
        mFragmentContainerHelper.attachMagicIndicator(magic_indicator)
    }

    @DrawableRes
    fun getImageResByIndex(p: Int): Int {
        return when (p) {
            0 -> com.freebookqy.application.R.drawable.selector_icon_bookcase
            1 -> com.freebookqy.application.R.drawable.selector_icon_book_city
            2 -> com.freebookqy.application.R.drawable.selector_icon_welfare
            3 -> com.freebookqy.application.R.drawable.selector_icon_my
            else -> com.freebookqy.application.R.drawable.selector_icon_bookcase
        }
    }

    override fun useEventBus() = true

    @Subscriber(mode = ThreadMode.MAIN)
    fun subscribeMainEvent(event: MainEvent) {
        when (event.key) {
            MainEvent.EVENT_ENTER_BOOK_CITY -> {
                mFragmentContainerHelper.handlePageSelected(1, false)
                addFragmentToContainer(getBookCityFragment(), tagBookCity)
            }
            MainEvent.EVENT_ENTER_BOOKCASE -> {
                mFragmentContainerHelper.handlePageSelected(0, false)
                addFragmentToContainer(getBookcaseFragment(), tagBookcase)
            }

        }
    }

}

