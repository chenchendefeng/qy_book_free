package com.wy.adbook.view

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import android.widget.SeekBar
import com.freebookqy.application.R
import com.freebookqy.utilslib.BrightnessUtils
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.utilslib.StatusBarUtils
import com.freebookqy.viewlib.simplelistener.SimpleTouchListener
import com.wy.adbook.ext.onClick
import com.wy.adbook.ext.px2sp
import com.wy.adbook.mvp.model.dao.CollBookBean
import com.wy.adbook.mvp.view.activity.ReadActivity
import com.wy.adbook.view.page.PageMode
import com.wy.adbook.view.page.PageStyle
import com.wy.adbook.view.readview.ReadSettingManager
import kotlinx.android.synthetic.main.view_cover_book.view.*
import org.jetbrains.anko.toast

/**
 * Created by leafye on 2019-05-09.
 */
class CoverBookView : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    private val instance: ReadSettingManager = ReadSettingManager.getInstance()

    private var coverBookVIewListener: CoverBookVIewListener? = null

    private var settingChangeListener: SettingChangeListener? = null
    /**
     * 是否在动画中
     */
    private var isAniming = false
    /**
     * 是否打开设置界面
     */
    private var isOpenSetting = false
    /**
     * 是否打开coverView
     */
    private var isOpenCoverView = false

    private var collBook: CollBookBean? = null

    private var isFirstEnter: Boolean = true

    init {
        View.inflate(context, R.layout.view_cover_book, this)
        //设置点击
        top_container.setPadding(0, StatusBarUtils.getStatusBarOffsetPx(context), 0, 0)
        btm_container.setPadding(0, 0, 0, StatusBarUtils.getNavigationBarHeight())
        btm_container2.setPadding(0, 0, 0, StatusBarUtils.getNavigationBarHeight())
        refreshSettingView()
        initListener()
        initSettingListener()
        initBrightness()
    }

    private fun initBrightness() {
        val screenBrightness = BrightnessUtils.getScreenBrightness(context as ReadActivity)
        brightness_seek_bar.progress = screenBrightness
    }

    fun isOpenCoverView(): Boolean = isOpenSetting || isOpenCoverView

    fun refreshSettingView() {
        refreshBgTheme()
        refreshPageMode()
        refreshSize()
    }

    fun setBookInfo(collBook: CollBookBean) {
        this.collBook = collBook
        setChapterProgress((this.collBook?.bookChapterList?.size ?: 1) - 1)
    }

    fun setCurrentChapter(curChapter: Int) {
        chapter_seek_bar.progress = curChapter
    }

    private fun setChapterProgress(chapterCount: Int) {
        chapter_seek_bar.max = chapterCount
    }

    private fun refreshSize() {
        val size: Int = instance.textSize.px2sp
        setTypeSize(size)
    }

    private fun refreshBgTheme() {
        val pageStyle: PageStyle = instance.readBgTheme
        val nightMode = instance.isNightMode
        yellow_btn_iv.isSelected = false
        green_btn_iv.isSelected = false
        blue_btn_iv.isSelected = false
        pink_btn_iv.isSelected = false
        black_btn_iv.isSelected = false
        when (pageStyle) {
            PageStyle.BG_0 -> yellow_btn_iv.isSelected = true
            PageStyle.BG_1 -> green_btn_iv.isSelected = true
            PageStyle.BG_2 -> blue_btn_iv.isSelected = true
            PageStyle.BG_3 -> pink_btn_iv.isSelected = true
            PageStyle.BG_4 -> black_btn_iv.isSelected = true
            else -> {

            }
        }
        night_tv.text = ResUtils.getString(if (nightMode) R.string.night_text else R.string.during_day)
        night_tv.isSelected = nightMode
    }

    private fun refreshPageMode() {
        val pageMode: PageMode = instance.pageMode
        up_down_tv.isSelected = false
        smooth_tv.isSelected = false
        simulation_tv.isSelected = false
        automatic_tv.isSelected = false
        when (pageMode) {
            PageMode.COVER -> up_down_tv.isSelected = true
            PageMode.SIMULATION -> simulation_tv.isSelected = true
            PageMode.SLIDE -> {
            }
            PageMode.NONE -> {
            }
            PageMode.SCROLL -> {
            }
        }
    }


    fun setCoverBookVIewListener(l: CoverBookVIewListener) {
        coverBookVIewListener = l
    }

    fun setSettingChangeListener(l: SettingChangeListener) {
        settingChangeListener = l
    }

    private fun initListener() {
        //背景点击事件
        setOnTouchListener(object : SimpleTouchListener() {
            override fun touchEnable() {
                if (isOpenSetting) {
                    startCloseSettingWindow()
                } else {
                    //关闭cover
                    closeCoverView()
                }
            }
        })
        top_container.setOnTouchListener { _, _ -> true }
        btm_container.setOnTouchListener { _, _ -> true }
        btm_container2.setOnTouchListener { _, _ -> true }
        //返回事件点击事件
        back_iv.onClick { coverBookVIewListener?.backClick() }
        //去广告点击事件
        free_ad_tv.onClick { coverBookVIewListener?.freeAdClick() }
        //弹出目录点击事件
        directory_tv.onClick { coverBookVIewListener?.directoryClick() }
        //是否夜间模式点击事件
        night_tv.onClick { coverBookVIewListener?.nightClick() }
        //弹出设置模式点击事件
        setting_view.onClick {
            //弹出设置窗口
            if (isOpenSetting)
                startCloseSettingWindow()
            else
                startPopSettingWindow()
        }
        //下载点击事件
        download_tv.onClick { coverBookVIewListener?.downloadClick() }
        //上一章
        previous_chapter_tv.onClick { coverBookVIewListener?.previousChapterClick() }
        //下一章
        next_chapter_tv.onClick { coverBookVIewListener?.nextChapterClick() }
        //章节调整滚动事件
        chapter_seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (isFirstEnter) return
                isFirstEnter = false
                collBook?.let {
                    selected_chapter_info_container.visibility = View.VISIBLE
                    selected_chapter_name_tv.text = it.bookChapterList[progress].title
                    selected_chapter_progress_info_tv.text =
                        ResUtils.getString(R.string.n_slash_n, progress + 1, it.bookChapterList.size)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                val progress = chapter_seek_bar.progress
                coverBookVIewListener?.chapterSeekChanged(progress)
            }
        })
    }

    private fun initSettingListener() {
        //亮度调整点击事件
        brightness_seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                settingChangeListener?.brightnessSeekChange(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                settingChangeListener?.brightnessSeekChange(brightness_seek_bar.progress)
            }
        })
        //调整字体大小点击事件
        down_type_size_tv.onClick {
            if (ReadSettingManager.TEXT_SIZE_MIN < instance.textSize.px2sp)
                settingChangeListener?.typeSizeDown()
            else context.toast("已经是最小字体")
        }
        up_type_size_tv.onClick {
            if (ReadSettingManager.TEXT_SIZE_MAX > instance.textSize.px2sp)
                settingChangeListener?.typeSizeUp()
            else context.toast("已经是最大字体")

        }
        //背景颜色设置点击事件
        yellow_btn.onClick { settingChangeListener?.bgColorChange(PageStyle.BG_0) }
        green_btn.onClick { settingChangeListener?.bgColorChange(PageStyle.BG_1) }
        blue_btn.onClick { settingChangeListener?.bgColorChange(PageStyle.BG_2) }
        pink_btn.onClick { settingChangeListener?.bgColorChange(PageStyle.BG_3) }
        black_btn.onClick { settingChangeListener?.bgColorChange(PageStyle.BG_4) }
        //翻页样式点击事件
        up_down_tv.onClick { settingChangeListener?.pageTurnChange(PageMode.COVER) }
        smooth_tv.onClick { settingChangeListener?.pageTurnChange(PageMode.SIMULATION) }
        simulation_tv.onClick { settingChangeListener?.pageTurnChange(PageMode.SIMULATION) }
        automatic_tv.onClick { settingChangeListener?.pageTurnChange(PageMode.NONE) }
    }

    private fun setTypeSize(size: Int) {
        type_size_tv.text = "" + size
    }


    @Synchronized
    private fun startPopSettingWindow() {
        if (isAniming) return
        selected_chapter_info_container.visibility = View.GONE
        ValueAnimator.ofFloat(1F, 0F).apply {
            btm_container2.visibility = View.VISIBLE
            duration = 300
            addUpdateListener { animation ->
                animation?.let {
                    val v = it.animatedValue as Float
                    btm_container2.translationY = btm_container2.measuredHeight * v
                    if (v == 0F) {
                        isAniming = false
                        isOpenSetting = true
                        btm_container.visibility = View.INVISIBLE
                    } else {
                        isAniming = true
                    }
                }
            }
        }.start()
    }

    @Synchronized
    private fun startCloseSettingWindow() {
        if (isAniming) return
        ValueAnimator.ofFloat(0F, 1F).apply {
            duration = 300
            addUpdateListener { animation ->
                animation?.let {
                    val v = it.animatedValue as Float
                    top_container.translationY = top_container.measuredHeight * -v
                    btm_container2.translationY = btm_container2.measuredHeight * v
                    if (v == 1F) {
                        visibility = View.INVISIBLE
                        btm_container2.visibility = View.INVISIBLE
                        top_container.visibility = View.INVISIBLE
                        btm_container.visibility = View.INVISIBLE
                        isAniming = false
                        isOpenSetting = false
                        isOpenCoverView = false
                        selected_chapter_info_container.visibility = View.GONE
                        coverBookVIewListener?.closeCoverView()
                    } else {
                        isAniming = true
                    }
                }
            }
        }.start()
    }

    @Synchronized
    fun closeCoverView() {
        if (isAniming) return
        isAniming = true
        ValueAnimator.ofFloat(0F, 1F).apply {
            duration = 300
            addUpdateListener { animation ->
                animation?.let {
                    val v = it.animatedValue as Float
                    top_container.translationY = top_container.measuredHeight * -v
                    btm_container.translationY = btm_container.measuredHeight * v
                    if (v == 1F) {
                        visibility = View.INVISIBLE
                        top_container.visibility = View.INVISIBLE
                        btm_container.visibility = View.INVISIBLE
                        isOpenCoverView = false
                        isAniming = false
                        selected_chapter_info_container.visibility = View.GONE
                        coverBookVIewListener?.closeCoverView()
                    }
                }
            }
        }.start()
    }

    @Synchronized
    fun openCoverView() {
        if (isAniming) return
        isAniming = true
        visibility = View.VISIBLE
        top_container.visibility = View.VISIBLE
        btm_container.visibility = View.VISIBLE
        ValueAnimator.ofFloat(1F, 0F).apply {
            duration = 300
            addUpdateListener { animation ->
                animation?.let {
                    val v = it.animatedValue as Float
                    top_container.translationY = top_container.measuredHeight * -v
                    btm_container.translationY = btm_container.measuredHeight * v
                    if (v == 0F) {
                        isAniming = false
                        isOpenCoverView = true
                        coverBookVIewListener?.openCoverView()
                    }
                }
            }
        }.start()
    }

    /**
     * 尝试关闭coverbookView
     * 返回true表示拦截消费掉事件
     */
    fun tryCloseCoverBookView(): Boolean {
        if (isOpenSetting) {
            startCloseSettingWindow()
            return true
        } else if (isOpenCoverView) {
            closeCoverView()
            return true
        }
        return false
    }


    interface CoverBookVIewListener {
        /**
         * 返回按钮
         */
        fun backClick()

        /**
         * 免广告按钮
         */
        fun freeAdClick()

        /**
         * 目录按钮
         */
        fun directoryClick()

        /**
         * 夜间
         */
        fun nightClick()

        /**
         * 下载
         */
        fun downloadClick()

        /**
         * 上一章
         */
        fun previousChapterClick()

        /**
         * 下一章
         */
        fun nextChapterClick()

        /**
         * 章节调节结果
         */
        fun chapterSeekChanged(progress: Int)

        /**
         * 关闭coverView成功
         */
        fun closeCoverView()

        /**
         * 开启coverView成功
         */
        fun openCoverView()
    }

    interface SettingChangeListener {

        fun brightnessSeekChange(progress: Int)

        fun typeSizeDown()

        fun typeSizeUp()

        fun bgColorChange(color: PageStyle)

        fun pageTurnChange(pageTurnType: PageMode)


    }

}