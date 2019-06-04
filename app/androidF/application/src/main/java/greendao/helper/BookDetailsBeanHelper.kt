//package greendao.helper
//
//import com.wy.adbook.mvp.model.entity.book.bookread.BookDetailsBean
//import greendao.BookDetailsBeanDao
//import greendao.DaoSession
//
///**
// * Created by leafye on 2019-05-13.
// */
//object BookDetailsBeanHelper {
//
//    /**
//     * 保存一本书籍 同步
//     *
//     * @param bookDetailsBean
//     */
//    fun saveBook(bookDetailsBean: BookDetailsBean) {
//        bookDetailsBeanDao.insertOrReplace(bookDetailsBean)
//    }
//
//    /**
//     * 保存多本书籍 同步
//     *
//     * @param bookDetailsBean
//     */
//    fun saveBooks(bookDetailsBean: List<BookDetailsBean>) {
//        bookDetailsBeanDao.insertOrReplaceInTx(bookDetailsBean)
//    }
//
//    /**
//     * 删除书籍
//     *
//     * @param bookDetailsBean
//     */
//    fun delete(bookDetailsBean: BookDetailsBean) {
//        bookDetailsBeanDao.delete(bookDetailsBean)
//    }
//
//    /**
//     * 删除所有书籍
//     */
//    fun removeAllBook() {
//        for (bookDetailsBean in findAllBooks()) {
//            delete(bookDetailsBean)
//        }
//    }
//
//
//    /**
//     * 查询一本书籍
//     */
//    fun findBookById(id: String): BookDetailsBean? {
//        return bookDetailsBeanDao
//            .queryBuilder()
//            .where(BookDetailsBeanDao.Properties.CBID.eq(id))?.unique()
//    }
//
//
//    /**
//     * 查询所有书籍
//     */
//    fun findAllBooks(): List<BookDetailsBean> {
//        return bookDetailsBeanDao
//            .queryBuilder()
//            .orderDesc(BookDetailsBeanDao.Properties.CBID)
//            .list()
//    }
//
//    private var daoSession: DaoSession = DbHelper.getInstance().getmDaoSession()
//    private var bookDetailsBeanDao: BookDetailsBeanDao = daoSession.bookDetailsBeanDao
//
//}