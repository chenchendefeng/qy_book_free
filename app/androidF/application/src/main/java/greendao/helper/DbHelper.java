//Copyright (c) 2017. 章钦豪. All rights reserved.
package greendao.helper;

import android.database.sqlite.SQLiteDatabase;
import com.wy.adbook.app.QYApplication;
import greendao.DaoMaster;
import greendao.DaoSession;


public class DbHelper {
    private static final String DB_NAME = "QianYue_db";
    private MyOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private DbHelper(){
        mHelper = new MyOpenHelper(QYApplication.cxt(), DB_NAME, null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    private static DbHelper instance;

    public static DbHelper getInstance(){
        if(null == instance){
            synchronized (DbHelper.class){
                if(null == instance){
                    instance = new DbHelper();
                }
            }
        }
        return instance;
    }

    public DaoSession getmDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
