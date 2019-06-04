package com.wy.adbook.mvp.view.activity

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
import android.widget.ImageView
import android.widget.TextView
import com.freebookqy.application.R
import com.freebookqy.notchtools.NotchTools
import com.freebookqy.utilslib.BrightnessUtils
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.utilslib.StatusBarUtils
import com.freebookqy.utilslib.UtilsView
import com.freebookqy.viewlib.simplelistener.SimpleTouchSlideListener
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.LogUtils
import com.qq.e.ads.nativ.NativeExpressAD
import com.qq.e.ads.nativ.NativeExpressADView
import com.qq.e.comm.util.AdError
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.app.manager.ADManager
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.di.component.DaggerReadComponent
import com.wy.adbook.di.module.ReadModule
import com.wy.adbook.dialog.WarningDialog
import com.wy.adbook.ext.loadImage
import com.wy.adbook.ext.onClick
import com.wy.adbook.ext.sp
import com.wy.adbook.mvp.contranct.ReadContract
import com.wy.adbook.mvp.model.dao.CollBookBean
import com.wy.adbook.mvp.model.entity.book.Book
import com.wy.adbook.mvp.presenter.ReadPresenter
import com.wy.adbook.mvp.view.adapter.ChapterAdapter
import com.wy.adbook.view.CoverBookView
import com.wy.adbook.view.ReadBookGuideView
import com.wy.adbook.view.page.PageLoader
import com.wy.adbook.view.page.PageMode
import com.wy.adbook.view.page.PageStyle
import com.wy.adbook.view.page.PageView
import com.wy.adbook.view.readview.ReadSettingManager
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

    private var isRegistered = false

    private var pageLoader: PageLoader? = null

    // 亮度调节监听
    // 由于亮度调节没有 Broadcast 而是直接修改 ContentProvider 的。所以需要创建一个 Observer 来监听 ContentProvider 的变化情况。
    private var brightObserver: ContentObserver? = null

    private val chapterAdapter: ChapterAdapter by lazy {
        ChapterAdapter(mPresenter?.mCollBook?.bookChapterList).apply {
            bindToRecyclerView(left_menu_rv)
            setOnItemClickListener { _, _, position ->
                drawer_layout.closeDrawer(Gravity.START)
                mPresenter?.tryDownloadNextChapter(position)
                pageLoader?.skipToChapter(position)
                setChapter(position)
            }
        }
    }

    private val readAdView by lazy {
        View.inflate(this@ReadActivity, R.layout.layout_read_view_ad, null)
    }

    private val coverPageVIew by lazy {
        LayoutInflater.from(this@ReadActivity)
            .inflate(R.layout.layout_cover_view, null, false).apply {
                setBackgroundColor(ResUtils.getColor(ReadSettingManager.getInstance().readBgTheme.bgColor))
                layoutParams =
                    ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                setOnTouchListener(object : SimpleTouchSlideListener() {
                    override fun touchEnable() {
                        UtilsView.removeParent(this@apply)
                    }
                })
                mPresenter?.mCollBook?.let {
                    find<ImageView>(R.id.book_cover_iv).loadImage(it.bookCovers ?: "")
                    find<TextView>(R.id.book_name_tv).text = it.title
                    find<TextView>(R.id.book_author_tv).text = it.author
                    find<TextView>(R.id.book_des_tv).text = it.shortIntro
                    find<TextView>(R.id.add_book_case_tv).apply {
                        visibility =
                            if (mPresenter?.mCollBook?.shelfStatus == Book.ShelfStatus.SHELF_STATUS_ON) View.INVISIBLE else View.VISIBLE
                        onClick { mPresenter?.addBookcase() }
                    }
                }
            }
    }

    override fun refreshProgressBar(progress: Float) {
        progress_bar.progress = progress
    }

    override fun getGoldTipTv(): TextView = gold_tip_tv

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
        initTopRightRewardView()
        getAdView()
        pageLoader = page_view.getPageLoader(mPresenter?.mCollBook)
        mPresenter?.fetchChapterList()
    }

    private fun initTopRightRewardView() {
        progress_bar.progressMax = ReadPresenter.NET_GET_30S_WELFARE_READ_TIME.toFloat()
    }

    private fun initStatusBarColor() {
        StatusBarUtils
            .from(this)
            .setTransparentStatusbar(true)
            .setLightStatusBar(false)
            .setActionBarOtherColor(true)
            .process()
    }

    override fun getReadPageLoader(): PageLoader? = pageLoader

    override fun onStart() {
        super.onStart()
        registerBrightObserver()
    }

    override fun onResume() {
        super.onResume()
        mPresenter?.startCalculateReadTime()
        if (!cover_book_view.isOpenCoverView()) {
            StatusBarUtils.hideStableNavBar(this@ReadActivity)
        }
    }

    override fun onPause() {
        super.onPause()
        mPresenter?.calculateReadTime()
        pageLoader?.saveRecord()
        mPresenter?.stopTiming()
    }

    override fun onStop() {
        super.onStop()
        unregisterBrightObserver()
    }

    override fun onDestroy() {
        super.onDestroy()
        adViewList?.forEach { it.destroy() }
        mPresenter?.resetReadTime()
    }

    private fun initListener() {
        if (mPresenter?.isFirstEnter() != false) {
            read_book_guide_view.visibility = View.VISIBLE
            read_book_guide_view.setDismissCallback(guideViewCallback)
        } else {
            read_book_guide_view.visibility = View.GONE
        }
        page_view.setReaderAdListener(readerAdListener())
        page_view.setTouchListener(touchListener())
        cover_book_view.setCoverBookVIewListener(coverBookListener)
        cover_book_view.setSettingChangeListener(settingChangeListener)
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        drawer_layout.addDrawerListener(drawerListener())
        reward_tip_container.onClick {
            if (!QYAccount.isLogin()) {
                LoginActivity.startActivity(this@ReadActivity)
            }
        }
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
                return !cover_book_view.isOpenCoverView()
            }

            override fun center() {
                showReadBar()
            }

            override fun prePage() {
            }

            override fun nextPage() {
                mPresenter?.tryDownloadNextChapter(pageLoader?.chapterPos ?: 0)
            }

            override fun cancel() {

            }
        }
    }

    private var isAdLoaded = false

    private var adViewList: MutableList<NativeExpressADView>? = null

    private var currentAdViewIndex = 0

    private fun getAdView() {
        ADManager.displayNativeExpressAD(this@ReadActivity,
            ADManager.POSID_READ,
            object : NativeExpressAD.NativeExpressADListener {
                override fun onADCloseOverlay(p0: NativeExpressADView?) {

                }

                override fun onADLoaded(p0: MutableList<NativeExpressADView>?) {
                    if (p0 != null && p0.isNotEmpty()) {
                        adViewList = p0
                        isAdLoaded = true
                        addNextAdToContainer()
                    }
                }

                override fun onADOpenOverlay(p0: NativeExpressADView?) {

                }

                override fun onRenderFail(p0: NativeExpressADView?) {

                }

                override fun onADExposure(p0: NativeExpressADView?) {

                }

                override fun onADClosed(p0: NativeExpressADView?) {

                }

                override fun onADLeftApplication(p0: NativeExpressADView?) {

                }

                override fun onNoAD(p0: AdError?) {

                }

                override fun onADClicked(p0: NativeExpressADView?) {

                }

                override fun onRenderSuccess(p0: NativeExpressADView?) {

                }
            })
    }

    private fun readerAdListener(): PageView.ReaderAdListener {
        return object : PageView.ReaderAdListener {
            override fun getAdView(): View? {
                if (isAdLoaded)
                    return readAdView
                return null
            }

            override fun onRequestAd() {
                addNextAdToContainer()
            }

            override fun getCoverPageView(): View? {
                return null
            }
        }
    }

    private fun addNextAdToContainer() {
        if (adViewList != null && adViewList!!.size > 0) {
            readAdView.find<ViewGroup>(R.id.ad_container).removeAllViews()
            val view = adViewList!![currentAdViewIndex]
            readAdView.find<ViewGroup>(R.id.ad_container).addView(view)
            currentAdViewIndex = if (currentAdViewIndex + 1 < adViewList!!.size) currentAdViewIndex + 1 else 0
            view.render()
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
     */
    private val coverBookListener: CoverBookView.CoverBookVIewListener by lazy {
        object : CoverBookView.CoverBookVIewListener {
            override fun backClick() {
                handlerBackPress()
            }

            override fun freeAdClick() {
                toast("免广告")
            }

            override fun directoryClick() {
                cover_book_view.closeCoverView()
                refreshChapterBgAndFontColor(ReadSettingManager.getInstance().readBgTheme)
                drawer_layout.openDrawer(Gravity.START)
            }

            override fun nightClick() {
                val nightMode = ReadSettingManager.getInstance().isNightMode
                pageLoader?.setNightMode(!nightMode)
                cover_book_view.refreshSettingView()
            }

            override fun downloadClick() {
                mPresenter?.startDownload()
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
                    mPresenter?.tryDownloadNextChapter(pageLoader?.chapterPos ?: 0)
                }
            }

            override fun chapterSeekChanged(progress: Int) {
                pageLoader?.skipToChapter(progress)
                chapterAdapter.setChapter(pageLoader?.chapterPos ?: 0)
                mPresenter?.tryDownloadNextChapter(progress)
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
                val preTextSize = ReadSettingManager.getInstance().preTextSize()
                pageLoader?.setTextSize(preTextSize.sp)
                cover_book_view.refreshSettingView()
            }

            override fun typeSizeUp() {
                val nextTextSize = ReadSettingManager.getInstance().nextTextSize()
                pageLoader?.setTextSize(nextTextSize.sp)
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

    private fun refreshChapterBgAndFontColor(color: PageStyle) {
        val nightMode = ReadSettingManager.getInstance().isNightMode
        if (color == PageStyle.BG_4 || nightMode) {
            left_menu_container.setBackgroundColor(ResUtils.getColor(PageStyle.BG_4.bgColor))
        } else {
            left_menu_container.setBackgroundColor(ResUtils.getColor(R.color.white))
        }
        chapterAdapter.setTextColor()
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
        when {
            drawer_layout.isDrawerOpen(Gravity.START) -> drawer_layout.closeDrawer(Gravity.START)
            mPresenter?.mCollBook?.shelfStatus == Book.ShelfStatus.SHELF_STATUS_OFF -> {
                //弹出加入书架对话框
                WarningDialog()
                    .content("提示")
                    .des("是否加入书架")
                    .cancelButton("不加入") { finish() }
                    .confirmButton("加入") { mPresenter?.addBookcase() }
                    .show(supportFragmentManager, "addBookcase")
            }
            else -> super.handlerBackPress()
        }
    }

    override fun refreshChapter() {
        book_status_tv.text = if (mPresenter?.mCollBook?.isFinishFlag == 1) "已完结" else "连载中"
        book_category_tv.text = "本书共" + (mPresenter?.mCollBook?.bookChapterList?.size ?: 0) + "章"
        if (left_menu_rv.layoutManager == null) {
            left_menu_rv.layoutManager = LinearLayoutManager(this@ReadActivity)
            left_menu_rv.adapter = chapterAdapter
        } else {
            chapterAdapter.setNewData(mPresenter?.mCollBook?.bookChapterList)
        }
    }

    override fun finishChapters() {
        if (pageLoader?.pageStatus == PageLoader.STATUS_LOADING) {
            // 刷新章节列表
            page_view.post {
                mPresenter?.mCollBook?.let {
                    cover_book_view.setBookInfo(it)
                    cover_book_view.setCurrentChapter(pageLoader?.chapterPos ?: 0)
                }
                chapterAdapter.setNewData(mPresenter?.mCollBook?.bookChapterList)
                chapterAdapter.setChapter(pageLoader?.chapterPos ?: 0)
                if (pageLoader?.chapterPos ?: 0 == 0 && pageLoader?.pagePos ?: 0 == 0) {
                    UtilsView.removeParent(coverPageVIew)
                    read_container.addView(coverPageVIew)
                }
                mPresenter?.startTiming()
                mPresenter?.recordBook()
                pageLoader?.openChapter()
                pageLoader?.refreshChapterList()
            }
        }
    }

    override fun errorChapters() {
        if (pageLoader?.pageStatus == PageLoader.STATUS_LOADING) {
            pageLoader?.chapterError()
        }
    }


}