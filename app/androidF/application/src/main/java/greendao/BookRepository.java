package greendao;

import android.support.annotation.Nullable;
import android.util.Log;
import com.wy.adbook.app.constant.Constant;
import com.wy.adbook.mvp.model.dao.BookChapterBean;
import com.wy.adbook.mvp.model.dao.ChapterInfoBean;
import com.wy.adbook.mvp.model.dao.CollBookBean;
import com.wy.adbook.view.readview.bean.BookRecordBean;
import com.freebookqy.imp.Void;
import com.freebookqy.utilslib.FileUtils;
import com.freebookqy.utilslib.IOUtils;
import greendao.helper.DbHelper;
import io.reactivex.Single;
import org.greenrobot.greendao.query.QueryBuilder;

import java.io.*;
import java.util.List;

/**
 * 存储关于书籍内容的信息(CollBook(收藏书籍),BookChapter(书籍列表),ChapterInfo(书籍章节),BookRecord(记录))
 */

public class BookRepository {
    private static final String TAG = "CollBookManager";
    private static volatile BookRepository sInstance;
    private DaoSession mSession;
    private CollBookBeanDao mCollBookDao;

    private BookRepository() {
        mSession = DbHelper.getInstance().getmDaoSession();
        mCollBookDao = mSession.getCollBookBeanDao();
    }

    public static BookRepository getInstance() {
        if (sInstance == null) {
            synchronized (BookRepository.class) {
                if (sInstance == null) {
                    sInstance = new BookRepository();
                }
            }
        }
        return sInstance;
    }

    //存储已收藏书籍
    public void saveCollBookWithAsync(CollBookBean bean) {
        //启动异步存储
        mSession.startAsyncSession()
                .runInTx(
                        () -> {
                            if (bean.getBookChapters() != null) {
                                // 存储BookChapterBean
                                mSession.getBookChapterBeanDao()
                                        .insertOrReplaceInTx(bean.getBookChapters());
                            }
                            //存储CollBook (确保先后顺序，否则出错)
                            mCollBookDao.insertOrReplace(bean);
                        }
                );
    }

    /**
     * 异步存储。
     * 同时保存BookChapter
     *
     * @param beans
     */
    public void saveCollBooksWithAsync(List<CollBookBean> beans) {
        mSession.startAsyncSession()
                .runInTx(
                        () -> {
                            for (CollBookBean bean : beans) {
                                if (bean.getBookChapters() != null) {
                                    //存储BookChapterBean(需要修改，如果存在id相同的则无视)
                                    mSession.getBookChapterBeanDao()
                                            .insertOrReplaceInTx(bean.getBookChapters());
                                }
                            }
                            //存储CollBook (确保先后顺序，否则出错)
                            mCollBookDao.insertOrReplaceInTx(beans);
                        }
                );
    }

    public void saveCollBook(CollBookBean bean) {
        if (bean == null) return;
        mCollBookDao.insertOrReplace(bean);
    }

    public void saveBookChapters(List<BookChapterBean> beans) {
        mSession
                .runInTx(
                        () -> {
                            //存储BookChapterBean
                            mSession.getBookChapterBeanDao()
                                    .insertOrReplaceInTx(beans);
                            Log.d(TAG, "saveBookChapters: " + "进行存储");
                        }
                );
    }

    public void saveCollBooks(List<CollBookBean> beans) {
        mCollBookDao.insertOrReplaceInTx(beans);
    }

    /**
     * 异步存储BookChapter
     */
    public void saveBookChaptersWithAsync(List<BookChapterBean> beans) {
        mSession.startAsyncSession()
                .runInTx(
                        () -> {
                            //存储BookChapterBean
                            mSession.getBookChapterBeanDao()
                                    .insertOrReplaceInTx(beans);
                            Log.d(TAG, "saveBookChaptersWithAsync: " + "进行存储");
                        }
                );
    }

    /**
     * 存储章节
     *
     * @param folderName
     * @param fileName
     * @param content
     */
    public void saveChapterInfo(String folderName, String fileName, String content) {
        File file = BookRepository.getBookFile(folderName, fileName);
        //获取流并存储
        Writer writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            IOUtils.close(writer);
        }
    }

    public void saveBookRecord(BookRecordBean bean) {
        mSession.getBookRecordBeanDao()
                .insertOrReplace(bean);
    }

    /*****************************get************************************************/
    public CollBookBean getCollBook(String bookId) {
        QueryBuilder<CollBookBean> where = mCollBookDao.queryBuilder()
                .where(CollBookBeanDao.Properties._id.eq(bookId));
        if (where == null) return null;
        return where.unique();
    }


    public List<CollBookBean> getCollBooks() {
        return mCollBookDao
                .queryBuilder()
                .orderDesc(CollBookBeanDao.Properties.LastRead)
                .list();
    }

    //获取书籍列表
    public Single<List<BookChapterBean>> getBookChaptersInRx(String bookId) {
        return Single.create(e -> {
            List<BookChapterBean> beans = mSession
                    .getBookChapterBeanDao()
                    .queryBuilder()
                    .where(BookChapterBeanDao.Properties.BookId.eq(bookId))
                    .list();
            e.onSuccess(beans);
        });
    }

    //获取阅读记录
    @Nullable
    public BookRecordBean getBookRecord(String bookId) {
        return mSession.getBookRecordBeanDao()
                .queryBuilder()
                .where(BookRecordBeanDao.Properties.BookId.eq(bookId))
                .unique();
    }

    //TODO:需要进行获取编码并转换的问题
    public ChapterInfoBean getChapterInfoBean(String folderName, String fileName) {
        File file = getBookFile(folderName, fileName);
//        File file = new File(Constant.getBOOK_CACHE_PATH() + folderName
//                + File.separator + fileName + FileUtils.SUFFIX_NB);
        if (!file.exists()) return null;
        Reader reader = null;
        String str = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.close(reader);
        }

        ChapterInfoBean bean = new ChapterInfoBean();
        bean.setTitle(fileName);
        bean.setBody(sb.toString());
        return bean;
    }

    /************************************************************/

    /************************************************************/
    public Single<Void> deleteCollBookInRx(CollBookBean bean) {
        return Single.create(e -> {
            //查看文本中是否存在删除的数据
            deleteBook(bean.get_id());
            //删除任务
            deleteDownloadTask(bean.get_id());
            //删除目录
            deleteBookChapter(bean.get_id());
            //删除CollBook
            mCollBookDao.delete(bean);
            e.onSuccess(new Void());
        });
    }

    //这个需要用rx，进行删除
    public void deleteBookChapter(String bookId) {
        mSession.getBookChapterBeanDao()
                .queryBuilder()
                .where(BookChapterBeanDao.Properties.BookId.eq(bookId))
                .buildDelete()
                .executeDeleteWithoutDetachingEntities();
    }

    public void deleteCollBook(CollBookBean collBook) {
        mCollBookDao.delete(collBook);
    }

    //删除书籍
    public void deleteBook(String bookId) {
        FileUtils.deleteFile(Constant.getBOOK_CACHE_PATH() + bookId);
    }

    public void deleteBookRecord(String id) {
        mSession.getBookRecordBeanDao()
                .queryBuilder()
                .where(BookRecordBeanDao.Properties.BookId.eq(id))
                .buildDelete()
                .executeDeleteWithoutDetachingEntities();
    }

    //删除任务
    public void deleteDownloadTask(String bookId) {
        mSession.getDownloadTaskBeanDao()
                .queryBuilder()
                .where(DownloadTaskBeanDao.Properties.BookId.eq(bookId))
                .buildDelete()
                .executeDeleteWithoutDetachingEntities();
    }

    public DaoSession getSession() {
        return mSession;
    }


    public static String getBookFilePath(String folderName, String fileName) {
        String fullPath = getBookPath(folderName
                + File.separator + fileName + FileUtils.SUFFIX_NB);
        return fullPath;
    }

    public static String getBookPath(String fileName) {
        return FileUtils.getCachePath() + File.separator
                + "book_cache" + File.separator + fileName;
    }

    /**
     * 创建或获取存储文件
     *
     * @param folderName
     * @param fileName
     * @return
     */
    public static File getBookFile(String folderName, String fileName) {
        return FileUtils.getFile(getBookFilePath(folderName, fileName));
    }

    public static long getBookSize(String folderName) {
        return FileUtils.getDirSize(FileUtils
                .getFolder(getBookPath(folderName)));
    }

    /**
     * 根据文件名判断是否被缓存过 (因为可能数据库显示被缓存过，但是文件中却没有的情况，所以需要根据文件判断是否被缓存
     * 过)
     *
     * @param folderName : bookId
     * @param fileName:  chapterName
     * @return
     */
    public static boolean isChapterCached(String folderName, String fileName) {
        File file = new File(getBookFilePath(folderName, fileName));
        return file.exists();
    }
}
