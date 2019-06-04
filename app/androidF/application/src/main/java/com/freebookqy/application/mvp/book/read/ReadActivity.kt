package com.freebookqy.application.mvp.book.read

import android.content.Context
import android.content.Intent
import android.database.ContentObserver
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freebookqy.application.R
import com.freebookqy.application.app.ADManager
import com.freebookqy.application.app.base.QYBaseActivity
import com.freebookqy.application.di.component.DaggerReadComponent
import com.freebookqy.application.di.module.ReadModule
import com.freebookqy.application.mvp.book.read.adapter.ChapterAdapter
import com.freebookqy.application.mvp.contranct.ReadContract
import com.freebookqy.application.mvp.model.dao.CollBookBean
import com.freebookqy.application.view.CoverBookView
import com.freebookqy.application.view.ReadBookGuideView
import com.freebookqy.application.view.page.PageLoader
import com.freebookqy.application.view.page.PageMode
import com.freebookqy.application.view.page.PageStyle
import com.freebookqy.application.view.page.PageView
import com.freebookqy.application.view.readview.ReadSettingManager
import com.freebookqy.notchtools.NotchTools
import com.freebookqy.utilslib.BrightnessUtils
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.utilslib.StatusBarUtils
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.LogUtils
import kotlinx.android.synthetic.main.activity_read.*
import org.jetbrains.anko.find
import org.jetbrains.anko.toast


/**
 * Created by leafye on 2019/5/7.
 */
open class ReadActivity : QYBaseActivity<ReadPresenter>(), ReadContract.View {

    companion object {

        private const val EXTRA_BOOK = "extraBook"

        // 注册 Brightness 的 uri
        private val BRIGHTNESS_MODE_URI = Settings.System.getUriFor(Settings.System.SCREEN_BRIGHTNESS_MODE)
        private val BRIGHTNESS_URI = Settings.System.getUriFor(Settings.System.SCREEN_BRIGHTNESS)
        private val BRIGHTNESS_ADJ_URI = Settings.System.getUriFor("screen_auto_brightness_adj")

        @JvmStatic
        fun startActivity(
            context: Context,
            book: CollBookBean
        ) {
            context.startActivity(
                Intent(context, ReadActivity::class.java).apply {
                    putExtra(EXTRA_BOOK, book)
                })
        }
    }

    private var isBrightnessBySystem = true

    /**
     * 是否开始阅读章节
     */
    private var startRead = false

    private var isRegistered = false


    private var pageLoader: PageLoader? = null

    // 亮度调节监听
    // 由于亮度调节没有 Broadcast 而是直接修改 ContentProvider 的。所以需要创建一个 Observer 来监听 ContentProvider 的变化情况。
    private var brightObserver: ContentObserver? = null

    private val chapterAdapter: ChapterAdapter by lazy {
        ChapterAdapter(mPresenter?.chapterList).apply {
            bindToRecyclerView(left_menu_rv)
            setOnItemClickListener { _, _, position ->
                drawer_layout.closeDrawer(Gravity.START)
                pageLoader?.skipToChapter(position)
                setChapter(position)
            }
        }
    }

    private val readAdView by lazy {
        //        NativeAdContainer(this@ReadActivity)
        View.inflate(this@ReadActivity, R.layout.layout_read_view_ad, null)
    }

    private val coverPageVIew by lazy {
        LayoutInflater.from(this@ReadActivity).inflate(R.layout.layout_cover_view, null, false)
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerReadComponent.builder()
            .appComponent(appComponent)
            .readModule(ReadModule((this@ReadActivity)))
            .build()
            .inject(this@ReadActivity)
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        NotchTools.getFullScreenTools().fullScreenDontUseStatus(this);
        setSwipeBackEnable(false)
        return R.layout.activity_read
    }

    override fun initData(savedInstanceState: Bundle?) {
        hideReadBar()
        intent.let {
            (it.getParcelableExtra<CollBookBean>(EXTRA_BOOK))?.apply {
                mPresenter?.mCollBook = this@apply
            }
        }
        initStatusBarColor()
        initListener()
        initReadView()
        mPresenter?.loadBookChapterList()
    }

    private fun initStatusBarColor() {
        StatusBarUtils
            .from(this)
            .setTransparentStatusbar(true)
            .setLightStatusBar(false)
            .setActionBarOtherColor(true)
            .process()
    }

    override fun getReadPageLoader(): PageLoader? {
        return pageLoader
    }

    override fun initReadView() {
        if (mPresenter?.mCollBook == null) {
            mPresenter?.fetchBookDetail()
        } else {
            pageLoader = page_view.getPageLoader(mPresenter?.mCollBook)
            pageLoader?.openChapter()
        }
    }

    override fun onStart() {
        super.onStart()
        registerBrightObserver()
    }

    override fun onResume() {
        super.onResume()
        mPresenter?.startCalculateReadTime()
    }

    override fun onPause() {
        super.onPause()
        mPresenter?.calculateReadTime()
        pageLoader?.saveRecord()
    }

    override fun onStop() {
        super.onStop()
        unregisterBrightObserver()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.resetReadTime()
    }

    private fun initListener() {
        if (mPresenter?.isFirstEnter() != false)
            read_book_guide_view.setDismissCallback(guideViewCallback)
        else
            read_book_guide_view.visibility = View.GONE
        page_view.setReaderAdListener(readerAdListener())
        page_view.setTouchListener(touchListener())
        cover_book_view.setCoverBookVIewListener(coverBookListener)
        cover_book_view.setSettingChangeListener(settingChangeListener)
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        drawer_layout.addDrawerListener(drawerListener())
    }

    private fun drawerListener(): DrawerLayout.DrawerListener {
        return object : DrawerLayout.DrawerListener {
            override fun onDrawerStateChanged(p0: Int) {

            }

            override fun onDrawerSlide(p0: View, p1: Float) {

            }

            override fun onDrawerClosed(p0: View) {

            }

            override fun onDrawerOpened(p0: View) {

            }
        }
    }

    private fun touchListener(): PageView.TouchListener {
        return object : PageView.TouchListener {
            override fun onTouch(): Boolean {
                return true
            }

            override fun center() {
                showReadBar()
            }

            override fun prePage() {
            }

            override fun nextPage() {
            }

            override fun cancel() {

            }
        }
    }

    private fun readerAdListener(): PageView.ReaderAdListener {
        return object : PageView.ReaderAdListener {
            override fun getAdView(): View {
                return readAdView
            }

            override fun onRequestAd() {
                ADManager.displayNativeExpressAD(
                    this@ReadActivity,
                    readAdView.find(R.id.ad_container) as ViewGroup,
                    ADManager.POSID_READ,
                    object : ADManager.NativeADListener {
                        override fun onADClosed() {

                        }

                        override fun onNoAD() {

                        }
                    }
                )
            }

            override fun getCoverPageView(): View? {
                return null
            }
        }
    }

    override fun isHandlerStatusBarHeight() = false

    // 注册亮度观察者
    private fun registerBrightObserver() {
        try {
            if (!isRegistered) {
                val cr = contentResolver
                if (brightObserver == null) {
                    brightObserver = object : ContentObserver(Handler()) {
                        override fun onChange(selfChange: Boolean) {
                            onChange(selfChange, null)
                        }

                        override fun onChange(selfChange: Boolean, uri: Uri?) {
                            super.onChange(selfChange)
                            // 判断当前是否跟随屏幕亮度，如果不是则返回
                            if (selfChange || !isBrightnessBySystem) return
                            // 如果系统亮度改变，则修改当前 Activity 亮度
                            if (BRIGHTNESS_MODE_URI == uri) {
                                LogUtils.debugInfo(TAG, "亮度模式改变")
                            } else if (BRIGHTNESS_URI == uri && !BrightnessUtils.isAutoBrightness(this@ReadActivity)) {
                                LogUtils.debugInfo(TAG, "亮度模式为手动模式 值改变")
                                BrightnessUtils.setBrightness(
                                    this@ReadActivity,
                                    BrightnessUtils.getScreenBrightness(this@ReadActivity)
                                )
                            } else if (BRIGHTNESS_ADJ_URI == uri && BrightnessUtils.isAutoBrightness(this@ReadActivity)) {
                                LogUtils.debugInfo(TAG, "亮度模式为自动模式 值改变")
                                BrightnessUtils.setDefaultBrightness(this@ReadActivity)
                            } else {
                                LogUtils.debugInfo(TAG, "亮度调整 其他")
                            }
                        }
                    }
                }
                brightObserver?.let {
                    cr.unregisterContentObserver(it)
                    cr.registerContentObserver(BRIGHTNESS_MODE_URI, false, it)
                    cr.registerContentObserver(BRIGHTNESS_URI, false, it)
                    cr.registerContentObserver(BRIGHTNESS_ADJ_URI, false, it)
                }
                isRegistered = true
            }
        } catch (throwable: Throwable) {
            LogUtils.warnInfo(TAG, "register brightObserver error! $throwable")
        }
    }

    //解注册
    private fun unregisterBrightObserver() {
        try {
            if (isRegistered) {
                brightObserver?.let {
                    contentResolver.unregisterContentObserver(it)
                }
                isRegistered = false
            }
        } catch (throwable: Throwable) {
            LogUtils.warnInfo(TAG, "unregister BrightnessObserver error! $throwable")
        }
    }


    private val guideViewCallback: ReadBookGuideView.DismissCallback by lazy {
        object : ReadBookGuideView.DismissCallback {
            override fun dismiss() {
                mPresenter?.setFirstEnter()
            }
        }
    }

    /**
     * coverview的回调
     *
     */
    private val coverBookListener: CoverBookView.CoverBookVIewListener by lazy {
        object : CoverBookView.CoverBookVIewListener {


            override fun backClick() {
                finish()
            }

            override fun freeAdClick() {
                toast("免广告")
            }

            override fun directoryClick() {
                cover_book_view.closeCoverView()
                drawer_layout.openDrawer(Gravity.START)
            }

            override fun nightClick() {
                val nightMode = ReadSettingManager.getInstance().isNightMode
                pageLoader?.setNightMode(!nightMode)
                cover_book_view.refreshSettingView()
            }

            override fun downloadClick() {
                toast("开始下载")
            }

            override fun previousChapterClick() {
                if (pageLoader?.skipPreChapter() == true) {
                    chapterAdapter.setChapter(pageLoader?.chapterPos ?: 0)
                    cover_book_view.setCurrentChapter(pageLoader?.chapterPos ?: 0)
                }
            }

            override fun nextChapterClick() {
                if (pageLoader?.skipNextChapter() == true) {
                    chapterAdapter.setChapter(pageLoader?.chapterPos ?: 0)
                    cover_book_view.setCurrentChapter(pageLoader?.chapterPos ?: 0)
                }
            }

            override fun chapterSeekChanged(progress: Int) {
//                skip_to_chapter_tv.visibility = View.GONE
                pageLoader?.skipToChapter(progress)
                chapterAdapter.setChapter(pageLoader?.chapterPos ?: 0)
            }

            override fun chapterSeekChange(progress: Int) {
//                skip_to_chapter_tv.visibility = View.VISIBLE
//                val chapterPos = pageLoader?.chapterPos ?: 0
//                skip_to_chapter_tv.text = ResUtils.getString(R.string.for_n1_skip_to_n_chapter, chapterPos, progress+1)
            }

            override fun closeCoverView() {
                hideReadBar()
            }

            override fun openCoverView() {

            }
        }
    }
    /**
     * 设置改变的回调
     * 包括:亮度调节/字体大小/背景颜色/翻页方式
     */
    private val settingChangeListener: CoverBookView.SettingChangeListener by lazy {
        object : CoverBookView.SettingChangeListener {
            override fun brightnessSeekChange(progress: Int) {
                isBrightnessBySystem = false
                BrightnessUtils.setBrightness(this@ReadActivity, progress)
            }

            override fun typeSizeDown() {
                val textSize = ReadSettingManager.getInstance().textSize
                pageLoader?.setTextSize(textSize - 1)
                cover_book_view.refreshSettingView()
            }

            override fun typeSizeUp() {
                val textSize = ReadSettingManager.getInstance().textSize
                pageLoader?.setTextSize(textSize + 1)
                cover_book_view.refreshSettingView()
            }

            override fun bgColorChange(color: PageStyle) {
                pageLoader?.setNightMode(false)
                pageLoader?.setPageStyle(color)
                cover_book_view.refreshSettingView()
            }

            override fun pageTurnChange(pageTurnType: PageMode) {
                pageLoader?.setPageMode(pageTurnType)
                cover_book_view.refreshSettingView()
            }
        }
    }

    @Synchronized
    private fun hideReadBar() {
        hideSystemBar()
    }

    @Synchronized
    private fun showReadBar() { // 显示工具栏
        cover_book_view.openCoverView()
        showSystemBar()
    }

    private fun hideSystemBar() {
        StatusBarUtils.setStatusBarVisibility(this, false)
        StatusBarUtils.hideStableNavBar(this)
    }

    private fun showSystemBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.navigationBarColor = ResUtils.getColor(R.color.translucent_background)
        }
        StatusBarUtils.setStatusBarVisibility(this, true)
        StatusBarUtils.showStableNavBar(this)
    }

    override fun handlerBackPress() {
        if (drawer_layout.isDrawerOpen(Gravity.START)) {
            drawer_layout.closeDrawer(Gravity.START)
        } else {
            super.handlerBackPress()
        }
    }

    override fun refreshChapter() {
        book_status_tv.text = if (mPresenter?.mCollBook?.isFinishFlag == 1) "已完结" else "连载中"
        book_category_tv.text = "本书共" + (mPresenter?.chapterList?.size ?: 0) + "章"
        if (left_menu_rv.layoutManager == null) {
            left_menu_rv.layoutManager = LinearLayoutManager(this@ReadActivity)
            left_menu_rv.adapter = chapterAdapter
        } else {
            chapterAdapter.setNewData(mPresenter?.chapterList)
        }
    }

    override fun finishChapters() {
        if (pageLoader?.pageStatus == PageLoader.STATUS_LOADING) {
            // 刷新章节列表
            pageLoader?.refreshChapterList()
            cover_book_view.setChapterProgress(mPresenter?.chapterList?.size ?: 0)
            cover_book_view.setCurrentChapter(pageLoader?.chapterPos ?: 0)
            chapterAdapter.setChapter(pageLoader?.chapterPos ?: 0)
            page_view.post { pageLoader?.openChapter() }
        }
    }

}