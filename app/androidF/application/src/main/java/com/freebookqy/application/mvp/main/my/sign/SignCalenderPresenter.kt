package com.freebookqy.application.mvp.main.my.sign

import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.mvp.contranct.SignCalenderContract
import com.freebookqy.application.mvp.main.my.adapter.SignCalendarItem
import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-08.
 */
@ActivityScope
class SignCalenderPresenter
@Inject
constructor(model: SignCalenderContract.Model, view: SignCalenderContract.View) :
    QYBasePresenter<SignCalenderContract.Model, SignCalenderContract.View>(model, view) {

    fun fetchData() {
        mRootView.refreshView()
    }

    fun getDataList(): MutableList<SignCalendarItem> {
        return mutableListOf<SignCalendarItem>().apply {
            for (i in 1..20) {
                add(SignCalendarItem(i, i % 2 == 0, i % 4 == 0))
            }
        }
    }

    /**
     * 返回可以连续补签的天数
     */
    fun canRetroactiveDay(): Int {
        return 5
    }


}