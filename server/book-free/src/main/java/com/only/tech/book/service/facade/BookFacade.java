package com.only.tech.book.service.facade;


import com.only.tech.book.service.biz.BookInfoService;
import com.only.tech.entity.book.BookInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class BookFacade {

    @Autowired
    private BookInfoService bookInfoService;

    /**
     * @param bid
     * @return
     */
    public BookInfo getBookByBid(Long bid) {
        return bookInfoService.getOneByBid(bid);
    }

}
