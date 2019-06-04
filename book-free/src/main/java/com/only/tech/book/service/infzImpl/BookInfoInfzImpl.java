package com.only.tech.book.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.ResultDto;
import com.only.tech.book.service.biz.BookCategoryService;
import com.only.tech.book.service.biz.BookHotService;
import com.only.tech.book.service.biz.BookInfoService;
import com.only.tech.book.service.biz.BookShelfService;
import com.only.tech.book.service.facade.BookAdminFacade;
import com.only.tech.book.service.facade.BookCategoryFacde;
import com.only.tech.book.service.facade.BookFacade;
import com.only.tech.book.service.facade.BookHotFacade;
import com.only.tech.dto.book.BookDto;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookCategory;
import com.only.tech.entity.book.BookHot;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookShelf;
import com.only.tech.exposeinfz.book.api.BookInfoInfz;
import com.only.tech.exposeinfz.book.dto.BookInfoDto;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


/**
 * @author HUA MAN LOU
 * @since 2019/5/15
 */
@Service(interfaceClass = BookInfoInfz.class)
@Component
@Slf4j
public class BookInfoInfzImpl implements BookInfoInfz {


    @Autowired
    private BookFacade bookFacade;

    @Autowired
    private BookAdminFacade bookAdminFacade;

    @Autowired
    private BookHotFacade bookHotFacade;

    @Autowired
    private BookCategoryFacde bookCategoryFacde;



    @Override
    public BookInfoDto getBookInfo(Long bid) {
        BookInfo bookInfo = bookFacade.getBookByBid(bid);
        if (null == bookInfo){
            return null;
        }
        BookInfoDto bookInfoDto = new BookInfoDto();
        bookInfoDto.setBid(bookInfo.getBid());
        bookInfoDto.setName(bookInfo.getName());
        bookInfoDto.setAuthor(bookInfo.getAuthor());
        bookInfoDto.setCoverImg(bookInfo.getCoverImg());
        bookInfoDto.setTotalWordCount(bookInfo.getTotalWordCount());
        bookInfoDto.setFinishFlag(bookInfo.getFinishFlag());
        bookInfoDto.setDescription(bookInfo.getDescription());  //书籍简介
        bookInfoDto.setLastUpdateTime(bookInfo.getLastUpdateTime()); //最近更新时间
        bookInfoDto.setShelfStatus(bookInfo.getShelfStatus());
        return bookInfoDto;
    }

    @Override
    public PageData<com.only.tech.exposeinfz.admin.dto.BookInfoDto> getBookList(String keyWord, Integer status, String category, PageReq pageReq) {
        try {
            return bookAdminFacade.getBookList(keyWord, status, category, pageReq);
        } catch (Exception e) {
            log.error("后台管理-查询 信息：[{}]",e);
        }
        return null;
    }

    /**
     * 后台管理-书籍详情
     * @param bid
     * @return
     */
    @Override
    public BookInfoDetailDto getBookDetail(Long bid){
        try {
            return bookAdminFacade.getBookDetailToAdmin(bid);
        } catch (Exception e) {
            log.error("后台管理-书籍详情  信息：[{}]",e);
        }
        return null;
    }

    @Override
    public boolean updateInformation(Long bid, String sexMark, Integer shelfStatus, Long readedCount, Long addBookShelfCount){
        try {
            return bookAdminFacade.updateInformation(bid, sexMark, shelfStatus, readedCount, addBookShelfCount);
        } catch (Exception e) {
            log.error("书籍管理-加入书架量 信息：[{}]",e);
        }
        return false;
    }

    /**
     * 查询书籍分类
     * @return
     */
    @Override
    public List<BookCategory> listBookCategory() {
        return this.bookCategoryFacde.listAll();
    }
}
