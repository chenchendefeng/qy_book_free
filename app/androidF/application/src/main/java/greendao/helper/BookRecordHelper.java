//package greendao.helper;
//
//
//import com.wy.adbook.view.readview.bean.BookRecordBean;
//import greendao.BookRecordBeanDao;
//import greendao.DaoSession;
//
//import java.util.List;
//
//
///**
// * Created by Liang_Lu on 2017/12/1.
// * 阅读记录数据库工具类
// */
//
//public class BookRecordHelper {
//    private static volatile BookRecordHelper sInstance;
//    private static DaoSession daoSession;
//    private static BookRecordBeanDao bookRecordBeanDao;
//
//    public static BookRecordHelper getsInstance() {
//        if (sInstance == null) {
//            synchronized (BookRecordHelper.class) {
//                if (sInstance == null) {
//                    sInstance = new BookRecordHelper();
//                    daoSession = DbHelper.getInstance().getmDaoSession();
//                    bookRecordBeanDao = daoSession.getBookRecordBeanDao();
//                }
//            }
//        }
//        return sInstance;
//    }
//
//    /**
//     * 保存阅读记录
//     */
//    public void saveRecordBook(BookRecordBean collBookBean) {
//
//        try {
//            bookRecordBeanDao.insertOrReplace(collBookBean);
//        }catch (Exception e){}
//
//    }
//
////
////    /**
////     * 根据书籍id 删除书籍记录
////     */
////    public void removeBook(String bookId) {
////
////        FileUtils.deleteFile(BookManager.getInstance().getBookPath(bookId));
////        bookRecordBeanDao
////                .queryBuilder()
////                .where(BookRecordBeanDao.Properties.BookId.eq(bookId))
////                .buildDelete()
////                .executeDeleteWithoutDetachingEntities();
////    }
//
//    /**
//     * 删除所有记录
//     */
//    public void removeAllBooks() {
//        for (BookRecordBean bookRecordBean : findBookRecord()) {
//            delete(bookRecordBean);
//        }
//    }
//
//    /**
//     * 根据书籍内容 删除书籍
//     *
//     * @param bookRecordBean
//     */
//    public void delete(BookRecordBean bookRecordBean) {
//        bookRecordBeanDao.delete(bookRecordBean);
//    }
//
//
//    /**
//     * 查询阅读记录
//     */
//    public BookRecordBean findBookRecordById(String bookId) {
//        return bookRecordBeanDao.queryBuilder()
//                .where(BookRecordBeanDao.Properties.BookId.eq(bookId)).unique();
//    }
//
//    /**
//     * 查询所有书籍阅读记录
//     */
//    public List<BookRecordBean> findBookRecord() {
//        return bookRecordBeanDao
//                .queryBuilder()
//                .orderDesc(BookRecordBeanDao.Properties.BookId)
//                .list();
//    }
//
//}
