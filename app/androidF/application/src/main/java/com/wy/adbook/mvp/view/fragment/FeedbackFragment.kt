package com.wy.adbook.mvp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freebookqy.application.R
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseFragment
import com.wy.adbook.di.component.DaggerFeedbackComponent
import com.wy.adbook.di.module.FeedbackModule
import com.wy.adbook.mvp.contranct.FeedbackContract
import com.wy.adbook.mvp.presenter.FeedbackPresenter

/**
 * Created by leafye on 2019-05-29.
 */
class FeedbackFragment : QYBaseFragment<FeedbackPresenter>(), FeedbackContract.View {


    companion object {

        fun newInstance(): FeedbackFragment {
            return FeedbackFragment()
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerFeedbackComponent
            .builder()
            .appComponent(appComponent)
            .feedbackModule(FeedbackModule(this@FeedbackFragment))
            .build()
            .inject(this@FeedbackFragment)
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun setData(data: Any?) {

    }

    override fun startInitView() {
        super.startInitView()

    }

    override fun isHandlerStatusBarHeight() = false

    override fun initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_feedback, null)
    }


}