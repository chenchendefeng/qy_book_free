package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookCategory;
import com.only.tech.entity.book.BookInfo;

import java.util.List;

/**
 * service: 书籍类目
 * @author shutong
 * @since 2019/05/06
 */

public interface BookCategoryService extends IService<BookCategory> {

    /**
     * 按性别分类目录
     * @param sexType
     * @return
     */
    List<BookCategory> listBySexType(String sexType);

    /**
     * 查询书籍分类
     * @return
     */
    List<BookCategory> listAll();
}
