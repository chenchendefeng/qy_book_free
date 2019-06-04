package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.book.BookHot;


/**
 * <p>
 * 书籍热度统计 服务类
 * </p>
 *
 * @author HUA MAN LOU
 * @since 2019/4/29
 */
public interface BookHotService extends IService<BookHot> {

    BookHot getBookHotByBid(Long bid);

    boolean deleteCache(Long bid);
}
