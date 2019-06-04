package com.only.tech.book.service.facade;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.book.service.biz.BookInfoService;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.exposeinfz.book.dto.BookInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HUA MAN LOU
 * @since 2019/4/25
 */
@Service
@Slf4j
public class BookSearchFacade {

    @Autowired
    private BookInfoService bookInfoService;

    @Autowired
    private BookHotFacade bookHotFacade;


    /**
     * 搜索书籍
     *
     * @param wd
     * @return
     */
    public PageData<BookInfoDto> search(String wd, PageReq pageReq) {

        List<BookInfoDto> data = new ArrayList<BookInfoDto>();
        PageData<BookInfoDto> book = new PageData<>();
        Page pageHaper = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());
        data = bookInfoService.findPageByNameOrAuthorName("%" + wd + "%");
        book = new PageData<>(pageHaper);
        //添加搜索次数
        bookHotFacade.addSearchCount(data);

        return book;
    }


}
