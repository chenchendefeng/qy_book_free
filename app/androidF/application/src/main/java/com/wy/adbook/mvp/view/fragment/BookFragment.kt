package com.wy.adbook.mvp.view.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freebookqy.application.R
import com.wy.adbook.app.base.QYBaseFragment
import com.wy.adbook.di.component.DaggerBookComponent
import com.wy.adbook.di.module.BookModule
import com.wy.adbook.mvp.presenter.BookPresenter
import com.wy.adbook.mvp.view.adapter.ClassificationDetailBookAdapter
import com.wy.adbook.mvp.contranct.BookContract
import com.wy.adbook.mvp.model.entity.book.Book
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.fragment_book.*

/**
 * Created by leafye on 2019/5/5.
 */
class BookFragment : QYBaseFragment<BookPresenter>(), BookContract.View {


    companion object {

        private const val BOOK_TYPE = "bookType"

        fun newInstance(@Book.FinishFlag bookType: Int): BookFragment {
            return BookFragment().apply {
                val bundle = Bundle().apply {
                    putInt(BOOK_TYPE, bookType)
                }
                arguments = bundle
            }
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerBookComponent
            .builder()
            .appComponent(appComponent)
            .bookModule(BookModule(this@BookFragment))
            .build()
            .inject(this@BookFragment)
    }

    override fun initData(savedInstanceState: Bundle?) {
        mPresenter?.fetchData()
    }

    override fun setData(data: Any?) {

    }

    override fun startInitView() {
        refresh_layout.setOnRefreshListener { mPresenter?.fetchData() }
    }

    override fun isHandlerStatusBarHeight() = false

    override fun initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_book, null)
    }

    private val bookAdapter: ClassificationDetailBookAdapter by lazy {
        ClassificationDetailBookAdapter(null).apply {
            setOnItemClickListener { adapter, view, position ->
                mPresenter?.enterBookDetail(adapter.data[position] as Book)
            }
            setOnLoadMoreListener({
                mPresenter?.loadMore()
            }, book_rv)
        }
    }

    override fun getAdapter(): ClassificationDetailBookAdapter = bookAdapter

    override fun loadData() {
        mPresenter?.fetchData()
    }

    override fun startRefreshLayout(isRefresh: Boolean) {
        refresh_layout.isRefreshing = isRefresh
    }

    override fun refreshView() {
        if (book_rv.layoutManager == null) {
            book_rv.layoutManager = LinearLayoutManager(getFragmentActivity(), LinearLayoutManager.VERTICAL, false)
            book_rv.adapter = bookAdapter
        }
        bookAdapter.setNewData(mPresenter?.bookList)
    }


}