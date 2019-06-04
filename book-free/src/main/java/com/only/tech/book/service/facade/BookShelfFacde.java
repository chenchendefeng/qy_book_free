package com.only.tech.book.service.facade;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.book.service.biz.BookInfoService;
import com.only.tech.book.service.biz.BookShelfService;
import com.only.tech.book.service.biz.ReadProcessService;
import com.only.tech.constant.BookHotTypeConstants;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookShelf;
import com.only.tech.entity.book.ReadProcess;
import com.only.tech.exposeinfz.book.dto.BookInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * facade: 书架
 * @author shutong
 * @since 2019/04/28
 */
@Service
@Slf4j
public class BookShelfFacde {

    @Autowired
    private BookShelfService bookShelfService;

    @Autowired
    private BookInfoService bookInfoService;

    @Autowired
    private BookHotFacade bookHotFacade;

    @Autowired
    private ReadProcessService readProcessService;

    /**
     * 分页查询书架书籍
     * @param pageReq
     * @param cuId
     * @return
     */
    public PageData<BookInfoDetailDto> pageList(PageReq pageReq, Long cuId) {

        List<BookInfoDetailDto> bookInfoList=new ArrayList<BookInfoDetailDto>();

        Page page = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());

        List<BookShelf> bookShelfList =this.bookShelfService.listByUid(cuId);
        if(bookShelfList==null || bookShelfList.size()==0){
            return new PageData(page) ;
        }

        for(BookShelf bookShelf : bookShelfList){
            Long bid=bookShelf.getBid();

            //基本属性&业务属性
            BookInfoDetailDto detailDto = this.bookInfoService.getBookInfoDetail(bid);
            if(detailDto==null) continue;

            //阅读进度
            ReadProcess readProcess=this.readProcessService.getByCuidAndBid(cuId,bid);
            if(readProcess!=null){
                detailDto.setReadProcess(readProcess.getProcess());
            }else{
                detailDto.setReadProcess(0.00f);
            }

            bookInfoList.add(detailDto);
        }

        PageData pageData = new PageData(page);
        pageData.setData(bookInfoList);
        return pageData;

    }

    /**
     * 加入书架
     * @param uid
     * @param bid
     * @return
     */
    public boolean addShelf(Long uid, Long bid) {
        boolean save = bookShelfService.save(uid, bid);

        //收藏统计
        if (save){
            bookHotFacade.addCountByType(bid, BookHotTypeConstants.COLLECTION);
        }
        return save;
    }

    public boolean onShelf(Long cuId, Long bid) {
        BookShelf bookShelf = bookShelfService.getOneByUidAndBid(cuId, bid);
        return bookShelf!=null;
    }
}
