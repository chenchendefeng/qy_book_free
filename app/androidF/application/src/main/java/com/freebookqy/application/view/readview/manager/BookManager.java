//package com.freebookqy.application.view.readview.manager;
//
//import com.freebookqy.application.mvp.model.entity.book.Book;
//import com.freebookqy.application.mvp.model.entity.book.bookread.BookDetailsBean;
//import com.freebookqy.utilslib.FileUtils;
//import greendao.helper.BookDetailsBeanHelper;
//
//import java.io.File;
//import java.lang.ref.WeakReference;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 处理书籍的工具类
// */
//
//public class BookManager {
//
//    private long position;
//    private Map<String, Cache> cacheMap = new HashMap<>();
//    private static volatile BookManager sInstance;
//
//    public static BookManager getInstance() {
//        if (sInstance == null) {
//            synchronized (BookManager.class) {
//                if (sInstance == null) {
//                    sInstance = new BookManager();
//                }
//            }
//        }
//        return sInstance;
//    }
//
//
//    public void setPosition(long position) {
//        this.position = position;
//    }
//
//    public long getPosition() {
//        return position;
//    }
//
//
//    public void clear() {
//        cacheMap.clear();
//        position = 0;
//    }
//
//
//    public static String getBookPath(String fileName) {
//        return FileUtils.getCachePath() + File.separator
//                + "book_cache" + File.separator + fileName;
//    }
//
////    public static String getBookFilePath(String folderName, String fileName) {
////        String fullPath = getBookPath(folderName
////                + File.separator + fileName + FileUtils.SUFFIX_NB);
////        return fullPath;
////    }
//
////    /**
////     * 创建或获取存储文件
////     *
////     * @param folderName
////     * @param fileName
////     * @return
////     */
////    public static File getBookFile(String folderName, String fileName) {
////        return FileUtils.getFile(getBookFilePath(folderName, fileName));
////    }
//
////    public static long getBookSize(String folderName) {
////        return FileUtils.getDirSize(FileUtils
////                .getFolder(getBookPath(folderName)));
////    }
//
////    /**
////     * 根据文件名判断是否被缓存过 (因为可能数据库显示被缓存过，但是文件中却没有的情况，所以需要根据文件判断是否被缓存
////     * 过)
////     *
////     * @param folderName : bookId
////     * @param fileName:  chapterName
////     * @return
////     */
////    public static boolean isChapterCached(String folderName, String fileName) {
////        File file = new File(getBookFilePath(folderName, fileName));
////        return file.exists();
////    }
//
//    public class Cache {
//        private long size;
//        private WeakReference<char[]> data;
//
//        public WeakReference<char[]> getData() {
//            return data;
//        }
//
//        public void setData(WeakReference<char[]> data) {
//            this.data = data;
//        }
//
//        public long getSize() {
//            return size;
//        }
//
//        public void setSize(long size) {
//            this.size = size;
//        }
//    }
//
////    /**
////     * 存储章节
////     *
////     * @param folderName
////     * @param fileName
////     * @param content
////     */
////    public void saveChapterInfo(String folderName, String fileName, String content) {
////        File file = getBookFile(folderName, fileName);
////        //获取流并存储
////        Writer writer = null;
////        try {
////            writer = new BufferedWriter(new FileWriter(file));
////            writer.write(content);
////            writer.flush();
////        } catch (IOException e) {
////            e.printStackTrace();
////            IOUtils.close(writer);
////        }
////    }
//
////    /**
////     * 存储章节
////     *
////     * @param folderName
////     * @param fileName
////     * @param content
////     */
////    public void saveChapterInfo(String folderName, String fileName, String content) {
////        File file = getBookFile(folderName, fileName);
////        //获取流并存储
////        Writer writer = null;
////        try {
////            writer = new BufferedWriter(new FileWriter(file));
////            writer.write(content);
////            writer.flush();
////        } catch (IOException e) {
////            e.printStackTrace();
////            IOUtils.close(writer);
////        }
////    }
//
//    public void saveBookDetail(Book book) {
//        BookDetailsBean bookDetailsBean = new BookDetailsBean();
//        bookDetailsBean.setCBID(book.getBid() + "");
//        bookDetailsBean.setAllwords(book.getAllwords());
//        bookDetailsBean.setAmount(book.getAmount());
//        bookDetailsBean.setAuthorName(book.getAuthor());
////        bookDetailsBean.setBuyStatus(book.data.buyStatus);
////        bookDetailsBean.setCategoryid(book.data.categoryid);
//        bookDetailsBean.setCoverUrl(book.getBookCovers());
////        bookDetailsBean.setFreeOrSpecial(book.data.freeOrSpecial);
////        bookDetailsBean.setFreeStatus(book.data.freeStatus);
////        bookDetailsBean.setIntro(book.data.intro);
//        bookDetailsBean.setLastReadChapterId(book.getLastReadChapterId() + "");
//        bookDetailsBean.setOnShelf(book.getShelfStatus() + "");
//        bookDetailsBean.setReadCount(book.getReadedCount() + "");
////        bookDetailsBean.setReadWords(book.data.readWords);
////        bookDetailsBean.setStatus(book.data.status);
////        bookDetailsBean.setTitle(book.data.title);
//        bookDetailsBean.setUpdatetime(book.getLastUpdateTime() + "");
////        bookDetailsBean.setIsReadCard(book.data.isReadCard);
//        bookDetailsBean.setLastUpdateTime(book.getLastUpdateTime() + "");
////        bookDetailsBean.setChapterCount(book.data.chapterCount);
////        bookDetailsBean.setWappageData(book.data.wappageData);
//        BookDetailsBeanHelper.INSTANCE.saveBook(bookDetailsBean);
//    }
//
//
//}
