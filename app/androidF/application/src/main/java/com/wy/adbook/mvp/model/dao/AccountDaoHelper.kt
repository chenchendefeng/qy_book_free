package com.wy.adbook.mvp.model.dao

import com.wy.adbook.app.QYApplication
import com.wy.adbook.mvp.model.entity.Account
import greendao.AccountDao

/**
 * Created by leafye on 2019-05-08.
 */
object AccountDaoHelper {
    fun insert(account: Account) {
        QYApplication.getDaoInstant().accountDao.insert(account)
    }

    fun delete(id: Long) {
        QYApplication.getDaoInstant().accountDao.deleteByKey(id)
    }

    fun update(account: Account) {
        QYApplication.getDaoInstant().accountDao.update(account)
    }

    fun queryById(id: Long): Account? {
        val accountList = QYApplication
            .getDaoInstant()
            .accountDao
            .queryBuilder()
            .where(AccountDao.Properties.Id.eq(id)).list()
        return if (accountList.isNotEmpty()) {
            accountList[0]
        } else {
            null
        }
    }

    fun queryByPhoneNum(phoneNum:String):Account?{
        val accountList = QYApplication
            .getDaoInstant()
            .accountDao
            .queryBuilder()
            .where(AccountDao.Properties.MobilePhone.eq(phoneNum)).list()
        return if (accountList.isNotEmpty()) {
            accountList[0]
        } else {
            null
        }
    }
}