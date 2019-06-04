//package greendao.helper;
//
//
//import com.wy.adbook.mvp.model.entity.book.bookread.ChapterListBean;
//import greendao.ChapterListBeanDao;
//
//import java.util.List;
//
//public class EntityManager {
//
//
//    public static void saveChapterListBean(List<ChapterListBean> list) {
//        DbHelper.getInstance().getmDaoSession().getChapterListBeanDao().insertOrReplaceInTx(list);
//    }
//
//    public static List<ChapterListBean> queryChapterListBean(String cbid) {
//        List<ChapterListBean> chapterListBean = DbHelper
//                .getInstance()
//                .getmDaoSession()
//                .getChapterListBeanDao()
//                .queryBuilder()
//                .where(ChapterListBeanDao.Properties.CBID.eq(cbid)).list();
//        return chapterListBean;
//    }
//
//
//}
