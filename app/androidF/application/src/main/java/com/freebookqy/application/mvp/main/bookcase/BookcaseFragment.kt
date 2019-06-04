package com.freebookqy.application.mvp.main.bookcase

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.freebookqy.application.R
import com.freebookqy.application.app.base.QYBaseFragment
import com.freebookqy.application.app.utils.LoadMoreHelper
import com.freebookqy.application.di.component.DaggerBookcaseComponent
import com.freebookqy.application.di.module.BookcaseModule
import com.freebookqy.application.dialog.WarningDialog
import com.freebookqy.application.ext.onClick
import com.freebookqy.application.mvp.contranct.BookcaseContract
import com.freebookqy.application.mvp.main.bookcase.adapter.BookcaseAdapter
import com.freebookqy.application.mvp.main.bookcase.adapter.BookcaseClickListener
import com.freebookqy.application.mvp.model.entity.book.Book
import com.freebookqy.application.mvp.model.event.BookEvent
import com.freebookqy.utilslib.ResUtils
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.fragment_bookcase.*
import org.jetbrains.anko.find
import org.simple.eventbus.Subscriber
import org.simple.eventbus.ThreadMode

/**
 * Created by leafye on 2019/4/30.
 */
class BookcaseFragment : QYBaseFragment<BookcasePresenter>(),
    BookcaseContract.View {
    override fun getAdapter(): BookcaseAdapter {
        return bookcaseAdapter
    }

    companion object {
        fun newInstance(): BookcaseFragment {
            return BookcaseFragment()
        }
    }

    override fun useEventBus() = true

    override fun initData(savedInstanceState: Bundle?) {
    }

    override fun setData(data: Any?) {
    }

    //private val cashCheckTipIv: ImageView by lazy { headerView.find<ImageView>(R.id.cash_check_tip_iv) }
    //    private val cashCheckContainer: View by lazy { headerView.find<View>(R.id.cash_check_container) }
    //    private val cashCheckTv: TextView by lazy { headerView.find<TextView>(R.id.cash_check_tv) }
    //    private val getCashEveryDayTv by lazy { headerView.find<TextView>(R.id.get_cash_every_day_tv) }
    //    private val goldenPigMakeLotMoneyTv by lazy { headerView.find<TextView>(R.id.golden_pig_make_lot_money_tv) }
    private val newBooksTv by lazy { headerView.find<TextView>(R.id.new_books_tv) }

    private val headerView: View by lazy {
        View.inflate(context, R.layout.header_bookcase, null).apply {
            find<View>(R.id.cash_check_container).onClick {
                mPresenter?.cashCheckClick()
            }
            find<View>(R.id.get_cash_every_day_tv).onClick {
                mPresenter?.getCashEveryDay()
            }
            find<View>(R.id.golden_pig_make_lot_money_tv).onClick {
                mPresenter?.makeLotMoney()
            }
        }
    }

    private val footerView: View by lazy {
        View.inflate(context, R.layout.footer_bookcase, null).apply {
            setOnClickListener {
                //进入书城界面
                mPresenter?.enterBookCity()
            }
        }
    }

    private val bookcaseAdapter: BookcaseAdapter by lazy {
        BookcaseAdapter(null).apply {
            setHeaderAndEmpty(true)
            addHeaderView(headerView)
            addFooterView(footerView)
            setOnLoadMoreListener({
                mPresenter?.fetchBookcaseList(false)
            }, bookcase_rv)
            setBookcaseClickListener(object : BookcaseClickListener {
                override fun delete(book: Book) {
                    showRemoveDialog(book)

                }
            })
        }
    }

    private fun showRemoveDialog(book: Book) {
        WarningDialog()
            .content("提示")
            .des("确定删除${book.bookName}?")
            .cancelButton("取消")
            .confirmButton("确定") { mPresenter?.removeBook(book) }
            .show(childFragmentManager, "")
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerBookcaseComponent.builder()
            .appComponent(appComponent)
            .bookcaseModule(BookcaseModule(this@BookcaseFragment))
            .build()
            .inject(this@BookcaseFragment)
    }

    override fun initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_bookcase, null)
    }

    override fun startInitView() {
        title_bar_view.let {
            it.setOnRightButtonClickListener {
                mPresenter?.enterSearch()
            }
        }
        refresh_layout.setOnRefreshListener {
            mPresenter?.fetchBookcaseList(true)
        }

    }

    override fun loadData() {
        mPresenter?.fetchBookcaseList(true)
    }

    override fun refreshVIew() {
        refreshAdapter()
        refreshHeader()
    }

    private fun refreshHeader() {
        newBooksTv.text =
            ResUtils.getString(R.string.new_add_book, mPresenter?.newBookNum ?: 0)
    }

    private fun refreshAdapter() {
        if (bookcase_rv.layoutManager == null) {
            bookcase_rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            bookcase_rv.adapter = bookcaseAdapter
        }
        bookcaseAdapter.setNewData(mPresenter?.getBookItem())
    }

    override fun refreshStatus(isRefresh: Boolean) {
        refresh_layout.isRefreshing = isRefresh
    }

    override fun loadMoreStatus(status: Int) {
        LoadMoreHelper.loadMoreStatus(bookcaseAdapter, status, true)
    }


    @Subscriber(mode = ThreadMode.MAIN)
    fun subscribeBookEvent(event:BookEvent){
        if (event.key == BookEvent.PUT_ON_BOOK_SUCCESS){
            mPresenter?.addBook(event.obj as Book)
        }
    }

}