package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookShelf;
import com.only.tech.exposeinfz.admin.dto.BookInfoDto;

import java.util.List;

/**
 * @author shutong
 * @since 2019/04/25
 */

public interface BookShelfService extends IService<BookShelf> {

    /**
     * 放入书架
     * @param uid
     * @param bid
     */
    boolean save(Long uid, Long bid);

    /**
     * 查询用户书架书籍
     * @param uid
     * @return
     */
    public List<BookShelf> listByUid(Long uid);

    /**
     * 移出书架
     * @param uid
     * @param bid
     */
    void remove(Long uid, Long bid);

    /**
     * 查询书架中的书
     * @param uid
     * @param bid
     * @return
     */
    BookShelf getOneByUidAndBid(Long uid, Long bid);


}
