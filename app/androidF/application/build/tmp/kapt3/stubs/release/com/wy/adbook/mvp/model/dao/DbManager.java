package com.wy.adbook.mvp.model.dao;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-08.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/wy/adbook/mvp/model/dao/DbManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DB_NAME", "", "mDaoMaster", "Lgreendao/DaoMaster;", "mDaoSession", "Lgreendao/DaoSession;", "mDevOpenHelper", "Lgreendao/DaoMaster$DevOpenHelper;", "getDaoMaster", "getDaoSession", "getReadableDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "getWritableDatabase", "Companion", "application_release"})
public final class DbManager {
    private final java.lang.String DB_NAME = "qy.db";
    private greendao.DaoMaster.DevOpenHelper mDevOpenHelper;
    private greendao.DaoMaster mDaoMaster;
    private greendao.DaoSession mDaoSession;
    @org.jetbrains.annotations.Nullable()
    private static volatile com.wy.adbook.mvp.model.dao.DbManager instance;
    public static final com.wy.adbook.mvp.model.dao.DbManager.Companion Companion = null;
    
    /**
     * * 获取可读数据库
     *     *
     *     * @param context
     *     * @return
     */
    @org.jetbrains.annotations.Nullable()
    public final android.database.sqlite.SQLiteDatabase getReadableDatabase(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * * 获取可写数据库
     *     *
     *     * @param context
     *     * @return
     */
    @org.jetbrains.annotations.Nullable()
    public final android.database.sqlite.SQLiteDatabase getWritableDatabase(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * * 获取DaoMaster
     *     *
     *     * @param context
     *     * @return
     */
    @org.jetbrains.annotations.Nullable()
    public final greendao.DaoMaster getDaoMaster(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * * 获取DaoSession
     *     *
     *     * @param context
     *     * @return
     */
    @org.jetbrains.annotations.Nullable()
    public final greendao.DaoSession getDaoSession(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public DbManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/wy/adbook/mvp/model/dao/DbManager$Companion;", "", "()V", "instance", "Lcom/wy/adbook/mvp/model/dao/DbManager;", "getInstance", "()Lcom/wy/adbook/mvp/model/dao/DbManager;", "setInstance", "(Lcom/wy/adbook/mvp/model/dao/DbManager;)V", "mContext", "Landroid/content/Context;", "application_release"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final com.wy.adbook.mvp.model.dao.DbManager getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.Nullable()
        com.wy.adbook.mvp.model.dao.DbManager p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.wy.adbook.mvp.model.dao.DbManager getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context mContext) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}