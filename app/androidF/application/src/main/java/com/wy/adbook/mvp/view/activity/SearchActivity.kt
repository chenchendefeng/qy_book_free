package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.app.utils.LoadMoreHelper
import com.wy.adbook.di.component.DaggerSearchComponent
import com.wy.adbook.di.module.SearchModule
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.contranct.SearchContract
import com.wy.adbook.mvp.model.entity.book.Book
import com.wy.adbook.mvp.presenter.SearchPresenter
import com.wy.adbook.mvp.view.adapter.SearchAdapter
import com.wy.adbook.mvp.view.adapter.SearchGuessLikeAdapter
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.activity_search.*


/**
 * Created by leafye on 2019/5/3.
 */
class SearchActivity : QYBaseActivity<SearchPresenter>(), SearchContract.View {

    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, SearchActivity::class.java))
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerSearchComponent.builder()
            .appComponent(appComponent)
            .searchModule(SearchModule((this@SearchActivity)))
            .build()
            .inject(this@SearchActivity)
    }

    override fun isHandlerStatusBarHeight(): Boolean {
        return true
    }

    private val searchGuessLikeAdapter: SearchGuessLikeAdapter by lazy {
        SearchGuessLikeAdapter(null).apply {
            bindToRecyclerView(search_guess_like_rv)
            setEmptyView(com.freebookqy.application.R.layout.empty_guess_you_like, search_guess_like_rv)
            setOnItemClickListener { adapter, _, position ->
                (adapter.data[position] as Book).apply {
                    mPresenter?.enterBookDetail(this)
                }
            }
        }
    }

    private val searchAdapter: SearchAdapter by lazy {
        SearchAdapter(null).apply {
            bindToRecyclerView(search_rv)
            setEmptyView(com.freebookqy.application.R.layout.empty_guess_you_like, search_rv)
            setOnLoadMoreListener({ mPresenter?.loadMore() }, search_rv)
            setOnItemClickListener { adapter, _, position ->
                (adapter.data[position] as Book).apply {
                    mPresenter?.enterBookDetail(this)
                }
            }
        }
    }

    override fun initView(savedInstanceState: Bundle?): Int = com.freebookqy.application.R.layout.activity_search

    override fun initData(savedInstanceState: Bundle?) {
        initListener()
        mPresenter?.fetchData()
    }

    private fun initListener() {
        back_iv.onClick { finish() }
        in_batch_tv.onClick { mPresenter?.change() }
        search_et.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    mPresenter?.search(search_et.text.toString().trim())
                    return true
                }
                return false
            }
        })
        search_et.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val empty = TextUtils.isEmpty(search_et.text)
                val notEmpty = mPresenter?.guessYouLike?.bookList?.isNotEmpty() ?: false
                if (empty && notEmpty) {
                    top_container.visibility = View.VISIBLE
                } else {
                    top_container.visibility = View.INVISIBLE
                }
                if (empty) {
                    delete_iv.visibility = View.INVISIBLE
                    mPresenter?.searchViewType = SearchPresenter.VIEW_TYPE_GUESS
                    refreshView()
                } else {
                    delete_iv.visibility = View.VISIBLE
                    mPresenter?.searchViewType = SearchPresenter.VIEW_TYPE_START_SEARCH
                    refreshView()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
        delete_iv.onClick { search_et.setText("") }
        refresh_layout.isEnabled = false
    }

    override fun refreshView() {
        when {
            mPresenter?.searchViewType == SearchPresenter.VIEW_TYPE_SEARCH_RESULT -> {
                top_container.visibility = View.VISIBLE
                guess_like_container.visibility = View.INVISIBLE
                refresh_layout.visibility = View.VISIBLE
                if (search_rv.layoutManager == null) {
                    search_rv.layoutManager = LinearLayoutManager(this@SearchActivity)
                    search_rv.adapter = searchAdapter
                }
                searchAdapter.setEnableLoadMore(true)
                searchAdapter.setNewData(mPresenter?.searchResult?.searchResult)
            }
            mPresenter?.searchViewType == SearchPresenter.VIEW_TYPE_GUESS -> {
                top_container.visibility = View.VISIBLE
                guess_like_container.visibility = View.VISIBLE
                refresh_layout.visibility = View.INVISIBLE
                if (search_guess_like_rv.layoutManager == null) {
                    search_guess_like_rv.layoutManager = LinearLayoutManager(this@SearchActivity)
                    search_guess_like_rv.adapter = searchGuessLikeAdapter
                }
                searchGuessLikeAdapter.setNewData(mPresenter?.guessYouLike?.bookList)
            }
            mPresenter?.searchViewType == SearchPresenter.VIEW_TYPE_START_SEARCH -> {
                guess_like_container.visibility = View.INVISIBLE
                refresh_layout.visibility = View.INVISIBLE
            }
        }
    }

    override fun searchAdapter(): SearchAdapter {
        return searchAdapter
    }

    override fun loadStatus(loadMoreStatus: Int) {
        LoadMoreHelper.loadMoreStatus(searchGuessLikeAdapter, loadMoreStatus)
    }

}