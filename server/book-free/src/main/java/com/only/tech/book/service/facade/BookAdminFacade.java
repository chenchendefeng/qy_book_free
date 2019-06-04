package com.only.tech.book.service.facade;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.book.service.biz.BookHotService;
import com.only.tech.book.service.biz.BookInfoService;
import com.only.tech.book.service.biz.BookMarkService;
import com.only.tech.book.service.biz.BookShelfService;
import com.only.tech.dto.book.BookDto;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookHot;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookMark;
import com.only.tech.entity.book.BookShelf;
import com.only.tech.exposeinfz.admin.dto.BookBaseDto;
import com.only.tech.exposeinfz.admin.dto.BookInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author HUA MAN LOU
 * @since 2018/12/21
 */
@Service
@Slf4j
public class BookAdminFacade {

    @Autowired
    private BookInfoService bookInfoService;

    @Autowired
    private BookShelfService bookShelfService;

    @Autowired
    private BookMarkService bookMarkService;

    @Autowired
    private BookHotService bookHotService;

    public PageData<BookInfoDto> getBookList(String keyWord, Integer status, String category, PageReq pageReq){

        PageData<BookInfoDto> book  = new PageData<>();
        List<BookInfoDto> dataList = new ArrayList<BookInfoDto>();
        Page pageHaper = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());
        dataList =  bookInfoService.getBookList(keyWord, status, category);
        book = new PageData<>(pageHaper);

        if (!dataList.isEmpty()){
            List<BookInfoDto> dtoList = new ArrayList<>(dataList.size());
            for (BookInfoDto data : dataList){
                BookInfoDetailDto bookShelf = getBookDetailToAdmin(data.getBID());
                if (bookShelf != null){
                    data.setAddBookShelfCount(bookShelf.getAddBookShelfCount());
                }
                dtoList.add(data);
            }
            book.setData(dtoList);
        }
        return book;
    }

    public BookInfoDetailDto getBookDetailToAdmin(Long bid){
        BookInfoDetailDto detailDto = this.bookInfoService.getBookInfoDetail(bid);

        /*BookShelf bookShelf = bookShelfService.getAddBookShelfCount(bid);
        if (bookShelf != null){
            detailDto.setAddBookShelfCount(bookShelf.getAddBookShelfCount());
        }*/
        return  detailDto;
    }

    public boolean updateInformation(Long bid, String sexMark, Integer shelfStatus, Long readedCount, Long addBookShelfCount){

        BookInfo bookDto = bookInfoService.getOneByBid(bid);
        if (bookDto == null){
            log.error("书籍不存在 bid:[{}]",bid);
            return false;
        }

        BookMark markDto = bookMarkService.getMarkByBid(bid);
        markDto.setSexMark(sexMark);
        boolean update_1 = bookMarkService.updateById(markDto);
        bookMarkService.clearRedisCache(bid);

        bookDto.setShelfStatus(shelfStatus);
        boolean update_2 = bookInfoService.updateById(bookDto);
        bookInfoService.clearRedisCache(bid);

        BookHot bookShelfDto = bookHotService.getBookHotByBid(bid);
        bookShelfDto.setReadedCount(readedCount);
        bookShelfDto.setCollectionCount(addBookShelfCount);
        boolean update = bookHotService.updateById(bookShelfDto);
        bookHotService.deleteCache(bid);

        if (update | update_1| update_2){
            return true;
        }
        return false;
    }
}
