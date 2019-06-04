package com.wy.adbook.di.module

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager
import com.freebookqy.viewlib.rv.layoutmanager.FullyLinearLayoutManager
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.mvp.contranct.SignCalenderContract
import com.wy.adbook.mvp.model.SignCalenderModel
import com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem
import com.wy.adbook.mvp.model.entity.accout.RewardItem
import com.wy.adbook.mvp.view.adapter.ContinuousSignInAdapter
import com.wy.adbook.mvp.view.adapter.SignCalendarAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-08.
 */
@Module
class SignCalenderModule(private val view: SignCalenderContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): SignCalenderContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: SignCalenderModel): SignCalenderContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    internal fun provideLayoutManager1() =
        object : FullyLinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false) {
            override fun canScrollHorizontally(): Boolean {
                return false
            }

            override fun canScrollVertically(): Boolean {
                return false
            }
        }

    @ActivityScope
    @Provides
    internal fun provideLayoutManager2() =
        object : FullyGridLayoutManager(view.getContext(), 7, GridLayoutManager.VERTICAL, false) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }

    @ActivityScope
    @Provides
    fun provideAttendanceCalendarDataList() = mutableListOf<AttendanceCalendarItem>()

    @ActivityScope
    @Provides
    fun signCalendarAdapter(dataList: MutableList<AttendanceCalendarItem>) =
        SignCalendarAdapter(dataList)

    @ActivityScope
    @Provides
    fun provideRewardDataList() = mutableListOf<RewardItem>()

    @ActivityScope
    @Provides
    fun continuousSignInAdapter(dataList: MutableList<RewardItem>) =
        ContinuousSignInAdapter(dataList)

}