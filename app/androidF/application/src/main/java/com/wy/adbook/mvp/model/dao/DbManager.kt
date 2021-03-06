package com.wy.adbook.mvp.model.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import greendao.DaoMaster
import greendao.DaoSession

/**
 * Created by leafye on 2019-05-08.
 */
class DbManager constructor(context: Context) {
    private val DB_NAME = "qy.db"
    private var mDevOpenHelper: DaoMaster.DevOpenHelper? = null
    private var mDaoMaster: DaoMaster? = null
    private var mDaoSession: DaoSession? = null

    init {
        // 初始化数据库信息
        mDevOpenHelper = DaoMaster.DevOpenHelper(context, DB_NAME)
        getDaoMaster(context)
        getDaoSession(context)
    }

    companion object {
        @Volatile
        var instance: DbManager? = null

        fun getInstance(mContext: Context): DbManager? {
            if (instance == null) {
                synchronized(DbManager::class) {
                    if (instance == null) {
                        instance = DbManager(mContext)
                    }
                }
            }
            return instance
        }
    }

    /**
     * 获取可读数据库
     *
     * @param context
     * @return
     */
    fun getReadableDatabase(context: Context): SQLiteDatabase? {
        if (null == mDevOpenHelper) {
            getInstance(context)
        }
        return mDevOpenHelper?.getReadableDatabase()
    }

    /**
     * 获取可写数据库
     *
     * @param context
     * @return
     */
    fun getWritableDatabase(context: Context): SQLiteDatabase? {
        if (null == mDevOpenHelper) {
            getInstance(context)
        }

        return mDevOpenHelper?.getWritableDatabase()
    }

    /**
     * 获取DaoMaster
     *
     * @param context
     * @return
     */
    fun getDaoMaster(context: Context): DaoMaster? {
        if (null == mDaoMaster) {
            synchronized(DbManager::class.java) {
                if (null == mDaoMaster) {
                    mDaoMaster = DaoMaster(getWritableDatabase(context))
                }
            }
        }
        return mDaoMaster
    }

    /**
     * 获取DaoSession
     *
     * @param context
     * @return
     */
    fun getDaoSession(context: Context): DaoSession? {
        if (null == mDaoSession) {
            synchronized(DbManager::class.java) {
                mDaoSession = getDaoMaster(context)?.newSession()
            }
        }

        return mDaoSession
    }

}