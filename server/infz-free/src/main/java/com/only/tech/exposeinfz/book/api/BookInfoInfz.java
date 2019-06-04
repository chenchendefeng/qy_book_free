package com.only.tech.exposeinfz.book.api;


import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookCategory;
import com.only.tech.exposeinfz.book.dto.BookInfoDto;

import java.util.List;

/**
 * 书籍信息服务
 * @author HUA MAN LOU
 * @since 2019/5/14
 */
public interface BookInfoInfz {


    BookInfoDto getBookInfo(Long bid);

    PageData<com.only.tech.exposeinfz.admin.dto.BookInfoDto> getBookList(String keyWord, Integer status, String category, PageReq pageReq);

    BookInfoDetailDto getBookDetail(Long bid);

    boolean updateInformation(Long bid, String sexMark, Integer shelfStatus, Long readedCount, Long addBookShelfCount);

    /**
     * 查询书籍分类
     * @return
     */
    List<BookCategory> listBookCategory();
}
