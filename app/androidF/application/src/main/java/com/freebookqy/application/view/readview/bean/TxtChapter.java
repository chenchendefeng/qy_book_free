package com.freebookqy.application.view.readview.bean;

/**
 * Created by newbiechen on 17-7-1.
 */

public class TxtChapter {

    //章节所属的小说(网络)
    public String bookId;
    //章节的链接(网络)
    public String CCID;

    //章节名(共用)
    public String title;

    //章节内容在文章中的起始位置(本地)
    public  long start;
    //章节内容在文章中的终止位置(本地)
    public  long end;
    // 是否免费
    public String authority;

    //选中目录
    public  boolean isSelect;


    @Override
    public String toString() {
        return "TxtChapter{" +
                "title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
