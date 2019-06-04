package com.freebookqy.application.mvp.main.my.sign

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.freebookqy.application.R
import com.freebookqy.application.app.base.QYBaseActivity
import com.freebookqy.application.di.component.DaggerSignCalenderComponent
import com.freebookqy.application.di.module.SignCalenderModule
import com.freebookqy.application.mvp.contranct.SignCalenderContract
import com.freebookqy.application.mvp.main.my.adapter.SignCalendarAdapter
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.utilslib.SpanUtils
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.activity_sign_calender.*

/**
 * Created by leafye on 2019-05-08.
 */
class SignCalenderActivity : QYBaseActivity<SignCalenderPresenter>(), SignCalenderContract.View {

    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, SignCalenderActivity::class.java))
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerSignCalenderComponent.builder()
            .appComponent(appComponent)
            .signCalenderModule(SignCalenderModule((this@SignCalenderActivity)))
            .build()
            .inject(this@SignCalenderActivity)
    }

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_sign_calender

    private val signCalendarAdapter: SignCalendarAdapter by lazy {
        SignCalendarAdapter(null)
    }

    override fun initData(savedInstanceState: Bundle?) {
        can_continuous_sign_in_tip_tv.text = SpanUtils().append(""+mPresenter?.canRetroactiveDay())
            .setForegroundColor(ResUtils.getColor(R.color.red_text_color))
            .append("天可补签").create()

        mPresenter?.fetchData()
    }

    override fun refreshView() {
        if (continuous_sign_in_rv.layoutManager == null){
            continuous_sign_in_rv.layoutManager = LinearLayoutManager(this@SignCalenderActivity,LinearLayoutManager.HORIZONTAL,false)

        }

        if (sign_calendar_rv.layoutManager == null) {
            sign_calendar_rv.layoutManager =
                GridLayoutManager(this@SignCalenderActivity, 7, GridLayoutManager.VERTICAL, false)
            sign_calendar_rv.adapter = signCalendarAdapter
        }
        signCalendarAdapter.setNewData(mPresenter?.getDataList())
    }
}