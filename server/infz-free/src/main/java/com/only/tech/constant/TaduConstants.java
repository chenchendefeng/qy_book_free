package com.only.tech.constant;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/25
 */
public interface TaduConstants {

    /**
     * 唯一标识
     */
    String IDENTITY = "weiyi";

    /**
     * 基础路径
     */
    String BASE_URL = "http://openapi.tadu.com/";

    /**
     * 所有书籍
     */
    String BOOK_LIST = BASE_URL + "book/list";

    /**
     * 书籍信息
     */
    String BOOK_INFO = BASE_URL + "book/info";

    /**
     * 书籍结构
     */
    String BOOK_STRUCTURE = BASE_URL + "book/structure";

    /**
     * 章节信息
     */
    String CHAPTER_INFO = BASE_URL + "book/volume/chapter/info";

}
