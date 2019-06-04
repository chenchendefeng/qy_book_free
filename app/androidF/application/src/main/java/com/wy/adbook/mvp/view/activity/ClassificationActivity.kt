package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import cn.bingoogolapple.bgabanner.BGABanner
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.freebookqy.application.R
import com.wy.adbook.app.QYApplication
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.app.utils.GlideRoundImage
import com.wy.adbook.di.component.DaggerClassificationComponent
import com.wy.adbook.di.module.ClassificationModule
import com.wy.adbook.ext.dip2Px
import com.wy.adbook.mvp.contranct.ClassificationContract
import com.wy.adbook.mvp.model.entity.BannerItem
import com.wy.adbook.mvp.model.entity.Classification
import com.wy.adbook.mvp.model.entity.ClassificationItem
import com.wy.adbook.mvp.presenter.ClassificationPresenter
import com.wy.adbook.mvp.view.adapter.ClassificationAdapter
import com.wy.adbook.mvp.view.adapter.ClassificationContentAdapter
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.activity_classification.*
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by leafye on 2019/5/5.
 */
class ClassificationActivity : QYBaseActivity<ClassificationPresenter>(), ClassificationContract.View {

    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, ClassificationActivity::class.java))
        }
    }

    override fun isHandlerStatusBarHeight(): Boolean = true

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerClassificationComponent.builder()
            .appComponent(appComponent)
            .classificationModule(ClassificationModule((this@ClassificationActivity)))
            .build()
            .inject(this@ClassificationActivity)
    }

    @Inject
    lateinit var classificationContentAdapter: ClassificationContentAdapter

    @Inject
    lateinit var classificationList: MutableList<Classification>

    @Inject
    lateinit var classificationAdapter: ClassificationAdapter

    @Inject
    lateinit var bannerList: MutableList<BannerItem>

    @Inject
    @Named("l1")
    lateinit var linearLayoutManager1: LinearLayoutManager

    @Inject
    @Named("l2")
    lateinit var linearLayoutManager2: LinearLayoutManager

    @Inject
    lateinit var headerView: View

    private val banner: BGABanner by lazy {
        headerView.find<BGABanner>(R.id.classification_banner)
    }

    private val headerClassificationNameTv by lazy {
        headerView.find<TextView>(R.id.header_classification_name_tv)
    }

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_classification

    override fun initData(savedInstanceState: Bundle?) {
        initClassificationView()
        initBanner()
        initListener()
        refreshLeftAdapter()
        mPresenter?.fetchData()
    }

    private fun initClassificationView() {
        classificationAdapter.apply {
            setNewData(classificationList)
            setOnItemClickListener { adapter, _, position ->
                mPresenter?.classificationClick(adapter.data[position] as Classification)
            }
            classification_rv.layoutManager = linearLayoutManager1
            classification_rv.adapter = this
        }
        classificationContentAdapter.apply {
            setOnItemClickListener { adapter, _, position ->
                mPresenter?.classificationContentClick(adapter.data[position] as ClassificationItem)
            }
            setHeaderView(headerView)
            setOnLoadMoreListener({
                mPresenter?.loadMore()
            }, classification_content_rv)
            classification_content_rv.layoutManager = linearLayoutManager2
            classification_content_rv.adapter = this
        }
    }

    private fun initListener() {
        classification_title_view.setOnLeftButtonClickListener { finish() }
        refresh_layout.setOnRefreshListener {
            mPresenter?.fetchData()
        }
    }

    private fun initBanner() {
        banner
            .setAdapter(object : BGABanner.Adapter<View, BannerItem> {
                override fun fillBannerItem(banner: BGABanner?, itemView: View, model: BannerItem?, position: Int) {
                    val transform =
                        RequestOptions()
                            .transform(GlideRoundImage(9.dip2Px))
                            .error(R.mipmap.default_book_img)
                            .placeholder(R.mipmap.default_book_img)
                    Glide.with(QYApplication.cxt())
                        .load(model?.img)
                        .apply(transform)
                        .into(itemView.find(R.id.banner_iv))
                }
            })
        banner.setDelegate(object : BGABanner.Delegate<View, BannerItem> {
            override fun onBannerItemClick(banner: BGABanner?, itemView: View?, model: BannerItem?, position: Int) {
                toast("点解了banner")

            }
        })
    }

    private fun refreshBanner() {
        if (bannerList.isEmpty()) {
            banner.visibility = View.GONE
        } else {
            banner.visibility = View.VISIBLE
            val list = mutableListOf<View>().apply {
                bannerList.forEach { _ ->
                    add(getBannerItemView())
                }
            }
            banner.setData(list, bannerList, null)
            banner.startAutoPlay()
        }
    }

    private fun getBannerItemView() =
        View.inflate(this@ClassificationActivity, R.layout.item_banner_classification, null)

    override fun isRefresh(isRefresh: Boolean) {
        refresh_layout.isRefreshing = isRefresh
    }

    override fun refreshView() {
        refreshBanner()
        refreshLeftAdapter()
        val selectClassificationItem = mPresenter?.getSelectClassificationItem()
        classificationContentAdapter.setNewData(selectClassificationItem)
        selectClassificationItem?.let {
            headerClassificationNameTv.text = mPresenter?.classificationList?.find { it.isSelected }?.category
        }
    }

    private fun refreshLeftAdapter() {
        classificationAdapter.notifyDataSetChanged()
    }

}