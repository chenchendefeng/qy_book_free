package com.freebookqy.application.mvp.main.adapter

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.freebookqy.application.R
import com.freebookqy.application.app.QYApplication
import com.freebookqy.application.mvp.book.detail.BookDetailActivity
import com.freebookqy.application.mvp.main.adapter.ProjectItem.Companion.TYPE_1_3
import com.freebookqy.application.mvp.main.adapter.ProjectItem.Companion.TYPE_1_4_GRID
import com.freebookqy.application.mvp.main.adapter.ProjectItem.Companion.TYPE_1_4_LIST
import com.freebookqy.application.mvp.main.adapter.ProjectItem.Companion.TYPE_N
import com.freebookqy.application.mvp.model.entity.SubjectType
import com.freebookqy.application.mvp.model.entity.book.Book
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.viewlib.rv.decoration.EvenItemDecoration
import com.jess.arms.utils.LogUtils

/**
 * Created by leafye on 2019/4/30.
 */
class ProjectAdapter(projectList: MutableList<ProjectItem>?) :
    BaseMultiItemQuickAdapter<ProjectItem, BaseViewHolder>(projectList) {

    init {
        addItemType(TYPE_1_3, R.layout.item_project)
        addItemType(TYPE_1_4_GRID, R.layout.item_project)
        addItemType(TYPE_N, R.layout.item_project)
        addItemType(TYPE_1_4_LIST, R.layout.item_project)
    }

    override fun convert(helper: BaseViewHolder, item: ProjectItem) {
        LogUtils.debugInfo("刷新 ProjectAdapter")
        when (item.itemType) {
            TYPE_1_3 -> refreshType1_3(helper, item.any as SubjectType)
            TYPE_1_4_GRID -> refreshType1_4_grid(helper, item.any as SubjectType)
            TYPE_1_4_LIST -> refresh1_4_list(helper, item.any as SubjectType)
            TYPE_N -> refreshN(helper, item.any as SubjectType)
        }
    }

    private fun refreshN(helper: BaseViewHolder, item: SubjectType) {
        val list = mutableListOf<Book>().apply {
            item.bookList?.let {
                if (it.isNotEmpty()) {
                    it.forEachIndexed { _, book ->
                        add(book)
                    }
                }
            }
        }
        val projectItemTitle = helper.getView<TextView>(R.id.project_title_tv)
        val projectMainRv = helper.getView<RecyclerView>(R.id.project_main_rv)
        projectItemTitle.text = item.title
        if (projectMainRv.layoutManager == null) {
            projectMainRv.layoutManager = LinearLayoutManager(mContext)
            projectMainRv.adapter = ProjectMainAdapter(list)
        } else {
            (projectMainRv.adapter as ProjectMainAdapter).setNewData(list)
        }
    }

    private fun refresh1_4_list(helper: BaseViewHolder, item: SubjectType) {
        val list = mutableListOf<Book>().apply {
            item.bookList?.let {
                if (it.isNotEmpty()) {
                    add(it[0])
                }
            }
        }
        val list2 = mutableListOf<Book>().apply {
            item.bookList?.let {
                if (it.size > 2) {
                    it.forEachIndexed { index, book ->
                        if (index > 0) add(book)
                    }
                }
            }
        }
        val projectItemTitle = helper.getView<TextView>(R.id.project_title_tv)
        val projectMainRv = helper.getView<RecyclerView>(R.id.project_main_rv)
        val projectSecondaryRv = helper.getView<RecyclerView>(R.id.project_secondary_rv)
        projectItemTitle.text = item.title
        if (projectMainRv.layoutManager == null) {
            projectMainRv.layoutManager = LinearLayoutManager(mContext)
            projectMainRv.adapter = ProjectMainAdapter(list)
        } else {
            (projectMainRv.adapter as ProjectMainAdapter).setNewData(list)
        }
        if (projectSecondaryRv.layoutManager == null) {
            projectSecondaryRv.adapter = ProjectThirdAdapter(list2)
            projectSecondaryRv.addItemDecoration(EvenItemDecoration(QYApplication.cxt(), 3))
            projectSecondaryRv.layoutManager = GridLayoutManager(mContext, 3)
        } else {
            (projectSecondaryRv.adapter as ProjectThirdAdapter).setNewData(list2)
        }
    }

    private fun refreshType1_4_grid(helper: BaseViewHolder, item: SubjectType) {
        val list = mutableListOf<Book>().apply {
            item.bookList?.let {
                if (it.isNotEmpty()) {
                    add(it[0])
                }
            }
        }
        val list2 = mutableListOf<Book>().apply {
            item.bookList?.let {
                if (it.size > 2) {
                    it.forEachIndexed { index, book ->
                        if (index > 0) add(book)
                    }
                }
            }
        }
        val projectItemTitle = helper.getView<TextView>(R.id.project_title_tv)
        val projectMainRv = helper.getView<RecyclerView>(R.id.project_main_rv)
        val projectSecondaryRv = helper.getView<RecyclerView>(R.id.project_secondary_rv)
        projectItemTitle.text = item.title
        if (projectMainRv.layoutManager == null) {
            projectMainRv.layoutManager = LinearLayoutManager(mContext)
            projectMainRv.adapter = ProjectMainAdapter(list)
        } else {
            (projectMainRv.adapter as ProjectMainAdapter).setNewData(list)
        }
        if (projectSecondaryRv.layoutManager == null) {
            projectSecondaryRv.adapter = ProjectThirdAdapter(list2)
            projectSecondaryRv.addItemDecoration(EvenItemDecoration(QYApplication.cxt(), 3))
            projectSecondaryRv.layoutManager = GridLayoutManager(mContext, 3)
        } else {
            (projectSecondaryRv.adapter as ProjectThirdAdapter).setNewData(list2)
        }
    }

    private fun refreshType1_3(helper: BaseViewHolder, item: SubjectType) {
        val list = mutableListOf<Book>().apply {
            item.bookList?.let {
                if (it.isNotEmpty()) {
                    add(it[0])
                }
            }
        }
        val list2 = mutableListOf<Book>().apply {
            item.bookList?.let {
                if (it.size > 2) {
                    it.forEachIndexed { index, book ->
                        if (index > 0) add(book)
                    }
                }
            }
        }
        val projectItemTitle = helper.getView<TextView>(R.id.project_title_tv)
        val projectMainRv = helper.getView<RecyclerView>(R.id.project_main_rv)
        val projectSecondaryRv = helper.getView<RecyclerView>(R.id.project_secondary_rv)
        projectItemTitle.text = item.title
        if (projectMainRv.layoutManager == null) {
            projectMainRv.layoutManager = LinearLayoutManager(mContext)
            projectMainRv.adapter = ProjectMainAdapter(list)
        } else {
            (projectMainRv.adapter as ProjectMainAdapter).setNewData(list)
        }
        if (projectSecondaryRv.layoutManager == null) {
            projectSecondaryRv.adapter = ProjectThirdAdapter(list2)
            projectSecondaryRv.addItemDecoration(EvenItemDecoration(QYApplication.cxt(), 3))
            projectSecondaryRv.layoutManager = GridLayoutManager(mContext, 3)
        } else {
            (projectSecondaryRv.adapter as ProjectThirdAdapter).setNewData(list2)
        }
    }
}

class ProjectMainAdapter(bookList: MutableList<Book>?) :
    BaseQuickAdapter<Book, BaseViewHolder>(R.layout.item_project_main, bookList) {
    override fun convert(helper: BaseViewHolder, item: Book) {
        val coverIv = helper.getView<ImageView>(R.id.cover_iv)
        val bookNameTv = helper.getView<TextView>(R.id.book_name_tv)
        val bookDesTv = helper.getView<TextView>(R.id.book_des_tv)
        val bookAuthorClassifyTv = helper.getView<TextView>(R.id.author_classify_tv)
        Glide.with(QYApplication.cxt()).load(item.bookCovers).into(coverIv)
        bookNameTv.text = item.bookName
        bookDesTv.text = item.description
        bookAuthorClassifyTv.text = ResUtils.getString(
            R.string.author_classification,
            item.author,
            item.category
        )
        helper.itemView.setOnClickListener { BookDetailActivity.startActivity(mContext, item) }
    }
}

class ProjectSecondaryAdapter(bookList: MutableList<Book>?) :
    BaseQuickAdapter<Book, BaseViewHolder>(R.layout.item_project_second, bookList) {
    override fun convert(helper: BaseViewHolder, item: Book) {
        val coverIv = helper.getView<ImageView>(R.id.cover_iv)
        val bookNameTv = helper.getView<TextView>(R.id.book_name_tv)
        val bookDesTv = helper.getView<TextView>(R.id.book_des_tv)
        val bookAuthorClassifyTv = helper.getView<TextView>(R.id.author_classify_tv)
        Glide.with(QYApplication.cxt()).load(item.bookCovers).into(coverIv)
        bookNameTv.text = item.bookName
        bookDesTv.text = item.description
        bookAuthorClassifyTv.text = ResUtils.getString(
            R.string.author_classification,
            item.author,
            item.category
        )
        helper.itemView.setOnClickListener { BookDetailActivity.startActivity(mContext, item) }
    }
}

class ProjectThirdAdapter(bookList: MutableList<Book>?) :
    BaseQuickAdapter<Book, BaseViewHolder>(R.layout.item_project_third, bookList) {
    override fun convert(helper: BaseViewHolder, item: Book) {
        val coverIv = helper.getView<ImageView>(R.id.cover_iv)
        val bookNameTv = helper.getView<TextView>(R.id.book_name_tv)
        Glide.with(QYApplication.cxt()).load(item.bookCovers).into(coverIv)
        bookNameTv.text = item.bookName
        helper.itemView.setOnClickListener { BookDetailActivity.startActivity(mContext, item) }
    }
}

class ProjectFourthAdapter(bookList: MutableList<Book>?) :
    BaseQuickAdapter<Book, BaseViewHolder>(R.layout.item_project_fourth, bookList) {
    override fun convert(helper: BaseViewHolder, item: Book) {
        val coverIv = helper.getView<ImageView>(R.id.cover_iv)
        val bookNameTv = helper.getView<TextView>(R.id.book_name_tv)
        val bookAuthorClassifyTv = helper.getView<TextView>(R.id.author_classify_tv)
        Glide.with(QYApplication.cxt()).load(item.bookCovers).into(coverIv)
        bookNameTv.text = item.bookName
        bookAuthorClassifyTv.text = item.author
        helper.itemView.setOnClickListener { BookDetailActivity.startActivity(mContext, item) }
    }
}


class ProjectItem : MultiItemEntity {
    companion object {
        /**
         * 上面一个 下面3个
         */
        const val TYPE_1_3 = 0
        /**
         * 上面一个 下面4个 每排2个
         */
        const val TYPE_1_4_GRID = 1
        /**
         *上面N个
         */
        const val TYPE_N = 2
        /**
         * 上面一个 下面4个 列表
         */
        const val TYPE_1_4_LIST = 3
    }

    override fun getItemType(): Int = projectItemType

    var projectItemType: Int = 0

    var any: Any? = null
}