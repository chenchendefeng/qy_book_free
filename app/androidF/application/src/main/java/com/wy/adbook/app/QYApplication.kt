package com.wy.adbook.app

import android.annotation.SuppressLint
import android.content.Context
import android.support.multidex.MultiDex
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.di.component.DaggerQYComponent
import com.wy.adbook.di.component.QYComponent
import com.wy.adbook.di.module.QYModule
import com.wy.adbook.mvp.view.web.NDWebConfig
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
        NDWebConfig.init(
            Constant.JS_CALL_JAVA_PROTOCOL,
            Constant.INJECT_INTO_WEB_VIEW_CLASS,
            Constant.WEB_DEBUGABLE
        )
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