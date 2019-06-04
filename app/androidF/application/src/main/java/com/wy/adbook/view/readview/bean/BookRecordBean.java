package com.wy.adbook.view.readview.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * 存储当前进度
 */
@Entity
public class BookRecordBean {

    //所属的书的id
    @Id
    private String bookId;
    //阅读到了第几章
    private int chapter;
    // 章节编号
    private String chapterStr;
    //当前的页码
    private int pagePos;
    // 当前页面第一个字位置
    private int textNo;

    @Generated(hash = 890017906)
    public BookRecordBean(String bookId, int chapter, String chapterStr,
                          int pagePos, int textNo) {
        this.bookId = bookId;
        this.chapter = chapter;
        this.chapterStr = chapterStr;
        this.pagePos = pagePos;
        this.textNo = textNo;
    }

    @Generated(hash = 398068002)
    public BookRecordBean() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getPagePos() {
        return pagePos;
    }

    public void setPagePos(int pagePos) {
        this.pagePos = pagePos;
    }

    public int getTextNo() {
        return textNo;
    }

    public void setTextNo(int textNo) {
        this.textNo = textNo;
    }

    public String getChapterStr() {
        return chapterStr;
    }

    public void setChapterStr(String chapterStr) {
        this.chapterStr = chapterStr;
    }
}
