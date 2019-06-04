package com.only.tech.book.service.facade;

import com.only.tech.book.service.biz.BookHotService;
import com.only.tech.constant.BookHotTypeConstants;
import com.only.tech.entity.book.BookHot;
import com.only.tech.exposeinfz.book.dto.BookInfoDto;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.NumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
public class BookHotFacade {

    @Autowired
    private BookHotService bookHotService;


    /**
     * 添加搜索次数
     * @param list
     */
    @Async
    public void addSearchCount(List<BookInfoDto> list) {
        if (list != null && !list.isEmpty()){

            for (BookInfoDto doc: list) {
                Long bid = doc.getBid();
                BookHot book = bookHotService.getBookHotByBid(bid);
                if (book != null){
                    Long searchCount = book.getSearchCount();
                    book.setSearchCount(++searchCount);
                    boolean update = bookHotService.updateById(book);
                    if (update){
                        bookHotService.deleteCache(bid);
                    }
                }
            }
        }
    }


    /**
     * 热度统计
     * @param bid
     * @param type
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean addCountByType(Long bid, String type) {
        try {
            BookHot bookHot = getBookHot(bid);

            //统计次数
            int count = 1;
            switch (type){
                case BookHotTypeConstants.SEARCH://搜索
                    Long searchCount = bookHot.getSearchCount();
                    bookHot.setShareCount(searchCount + count);
                    break;
                case BookHotTypeConstants.SHARE://分享
                    Long shareCount = bookHot.getSearchCount();
                    bookHot.setShareCount(shareCount + count);
                    break;
                case BookHotTypeConstants.COLLECTION://收藏
                    count = NumUtil.getRandom(100, 200);
                    Long collectionCount = bookHot.getCollectionCount();
                    bookHot.setCollectionCount( collectionCount + count);
                    break;
                case BookHotTypeConstants.READED://阅读
                    count = NumUtil.getRandom(100, 200);
                    Long readedCount = bookHot.getReadedCount();
                    bookHot.setReadedCount( readedCount + count);
                    break;
                case BookHotTypeConstants.READING://在读
                    count = NumUtil.getRandom(100, 200);
                    Long readingCount = bookHot.getReadingCount();
                    bookHot.setReadedCount( readingCount + count);
                    break;
            }
            boolean update = bookHotService.updateById(bookHot);
            if (update){
                bookHotService.deleteCache(bid);
            }
            return update;
        } catch (Exception e) {
            log.error("书籍热度统计错误：bid:[{}]",bid,e);
        }
        return false;
    }

    public BookHot getBookHot(Long bid) {
        BookHot bookHot = bookHotService.getBookHotByBid(bid);
        if (bookHot == null){
            bookHot = new BookHot();
            bookHot.setBid(bid);
            bookHot.setSearchCount(0L);
            bookHot.setShareCount(0L);
            bookHot.setCollectionCount(10000L);
            bookHot.setReadedCount(1000L);
            bookHot.setReadingCount(1000L);

            bookHotService.save(bookHot);
        }
        return bookHot;
    }
}
































