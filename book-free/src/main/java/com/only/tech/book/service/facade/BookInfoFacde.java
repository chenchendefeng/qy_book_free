package com.only.tech.book.service.facade;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.book.service.biz.BookHotService;
import com.only.tech.book.service.biz.BookInfoService;
import com.only.tech.constant.BookHotTypeConstants;
import com.only.tech.dto.book.BookCoverDto;
import com.only.tech.dto.book.BookDto;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookHot;
import com.only.tech.entity.book.BookInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * facade: 书籍
 * @author shutong
 * @since 2019/04/30
 */
@Service
@Slf4j
public class BookInfoFacde {

    @Autowired
    private BookInfoService bookInfoService;

    @Autowired
    private BookHotService bookHotService;

    @Autowired
    private BookHotFacade bookHotFacade;

    @Autowired
    private BookShelfFacde bookShelfFacde;


    /**
     * 分页查询猜你喜欢(按书籍阅读量排序)
     * @param pageReq
     * @return
     */
    public PageData<BookInfoDetailDto> pageListGuessYouLike(PageReq pageReq) {

        Page page = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());

        List<BookInfoDetailDto> bookInfoDetailDtos =this.bookInfoService.listOrderByReadNum(null);
        if(bookInfoDetailDtos==null || bookInfoDetailDtos.size()==0){
            return new PageData(page) ;
        }
        PageData pageData = new PageData(page);
        pageData.setData(bookInfoDetailDtos);
        return pageData;

    }

    /**
     * 分页查询书籍列表（按书籍分类 & 完结状态）
     * @param pageReq
     * @param adCategory
     * @param finishFlag
     * @return
     */
    public PageData<BookInfo> pageListByAdCategory(PageReq pageReq, String adCategory, Integer finishFlag) {

        Page page = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());

        List<BookInfo> bookInfoList =this.bookInfoService.listByAdCategory(adCategory,finishFlag);
        if(bookInfoList==null || bookInfoList.size()==0){
            return new PageData(page) ;
        }
        PageData pageData = new PageData(page);
        pageData.setData(bookInfoList);
        return pageData;
    }

    /**
     * 大家都在看（同分类阅读量最高的 前 3 本）
     * @param pageReq
     * @param category
     * @return
     */
    public PageData<BookInfoDetailDto> pageListTogetherRead(PageReq pageReq,String category) {

        Page page = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());

        List<BookInfoDetailDto> bookInfoDetailDtos =this.bookInfoService.listOrderByReadNum(category);
        if(bookInfoDetailDtos==null || bookInfoDetailDtos.size()==0){
            return new PageData(page) ;
        }
        PageData pageData = new PageData(page);
        pageData.setData(bookInfoDetailDtos);
        return pageData;

    }

    /**
     * 书籍详情
     *
     * @param cuId
     * @param bid
     * @return
     */
    public BookDto detail(Long cuId, Long bid) {
        BookInfo bookInfo = bookInfoService.getOneByBid(bid);
        if (bookInfo != null){
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(bookInfo,bookDto);

            BookHot bookHot = bookHotFacade.getBookHot(bid);
            if (bookHot != null){
                bookDto.setCollectionCount(bookHot.getCollectionCount());
                bookDto.setReadedCount(bookHot.getReadedCount());
                bookDto.setReadingCount(bookHot.getReadingCount());
            }

            //是否在书架
            if (cuId != null){
                boolean onshelf = bookShelfFacde.onShelf(cuId,bid);
                bookDto.setOnShelf(onshelf?1:0);
            }


            //统计阅读
            bookHotFacade.addCountByType(bid, BookHotTypeConstants.READED);

            return bookDto;
        }

        return null;
    }

    /**
     * 封面
     * @param bid
     * @return
     */
    public BookCoverDto cover(Long bid) {
        BookInfo bookInfo = bookInfoService.getOneByBid(bid);
        if (bookInfo != null){
            BookCoverDto bookCoverDto = new BookCoverDto();
            BeanUtils.copyProperties(bookInfo,bookCoverDto);
            return bookCoverDto;
        }
        return null;
    }
}
