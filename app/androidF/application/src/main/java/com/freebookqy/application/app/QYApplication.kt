package com.freebookqy.application.app

import android.annotation.SuppressLint
import android.content.Context
import android.support.multidex.MultiDex
import com.freebookqy.application.di.component.DaggerQYComponent
import com.freebookqy.application.di.component.QYComponent
import com.freebookqy.application.di.module.QYModule
import com.freebookqy.utilslib.Utils
import com.jess.arms.base.BaseApplication
import com.jess.arms.utils.ArmsUtils
import com.jess.arms.utils.LogUtils
import com.mob.MobSDK
import greendao.DaoMaster
import greendao.DaoSession

class QYApplication : BaseApplication(), QY {

    companion object {

        @SuppressLint("StaticFieldLeak")
        @JvmStatic
        private lateinit var context: Context

        lateinit var daoSession: DaoSession

        @JvmStatic
        fun cxt(): Context {
            return context
        }

        fun getDaoInstant(): DaoSession { //用于获得对象
            return daoSession
        }
    }

    private lateinit var yangYanComponent: QYComponent

    override fun onCreate() {
        super.onCreate()
        Utils.initUtils(this)
        context = this
        MultiDex.install(this)
        LogUtils.setLog(true)
        initDao()
        initMob()
        yangYanComponent = DaggerQYComponent
            .builder()
            .appComponent(ArmsUtils.obtainAppComponentFromContext(this))
            .qYModule(QYModule())
            .build()
    }

    private fun initMob() {
        MobSDK.init(this);
    }

    private fun initDao() {
        val helper = DaoMaster.DevOpenHelper(this, "qy")//创建的数据库名。
        val db = helper.writableDb
        daoSession = DaoMaster(db).newSession()
    }


    override fun yangYangComponent(): QYComponent {
        return yangYanComponent
    }
}