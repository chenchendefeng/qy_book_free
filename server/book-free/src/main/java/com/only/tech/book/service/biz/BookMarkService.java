package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.book.BookCategory;
import com.only.tech.entity.book.BookCategoryRela;
import com.only.tech.entity.book.BookMark;

import java.util.List;

/**
 * service: 书籍标签
 * @author shutong
 * @since 2019/05/21
 */

public interface BookMarkService extends IService<BookMark> {

    List<BookMark> listByAdCategory(String adCategory);

    List<String> listChildCategoryByAdCategory(String adCategory);

    BookMark getMarkByBid(Long bid);

    /**
     * 清理redis缓存
     * @param bid
     */
    void clearRedisCache(Long bid);
}
