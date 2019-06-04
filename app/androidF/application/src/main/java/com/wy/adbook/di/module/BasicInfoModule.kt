package com.wy.adbook.di.module

import android.support.v7.widget.LinearLayoutManager
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.mvp.contranct.BasicInfoContract
import com.wy.adbook.mvp.model.BasicInfoModel
import com.wy.adbook.mvp.model.view.BasicInfo
import com.wy.adbook.mvp.view.adapter.BasicInfoAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-30.
 */
@Module
class BasicInfoModule(private val view: BasicInfoContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): BasicInfoContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: BasicInfoModel): BasicInfoContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    fun provideBasicList() = mutableListOf<BasicInfo>()
        .apply {
            add(
                BasicInfo(
                    title = "头像",
                    imageUrl = QYAccount.getUserInfo().avatar,
                    isShowTopLine = true,
                    type = BasicInfo.Type.TYPE_ACCOUNT
                )
            )
            add(
                BasicInfo(
                    title = "昵称",
                    content = QYAccount.getUserInfo().nickName,
                    type = BasicInfo.Type.TYPE_NICKNAME
                )
            )
            add(
                BasicInfo(
                    title = "性别",
                    content = if (QYAccount.getGender() == Constant.Gender.MALE) "男" else "女",
                    type = BasicInfo.Type.TYPE_GENDER
                )
            )
            add(
                BasicInfo(
                    title = "账号",
                    content = "" + QYAccount.getUserInfo().cuId,
                    isShowTopLine = true,
                    type = BasicInfo.Type.TYPE_ACCOUNT
                )
            )
        }

    @ActivityScope
    @Provides
    fun lm() = LinearLayoutManager(view.getContext())


    @ActivityScope
    @Provides
    fun basicAdapter(list: MutableList<BasicInfo>) = BasicInfoAdapter(list)


}