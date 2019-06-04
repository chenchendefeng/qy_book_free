package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookSubject;

import java.util.List;

/**
 * 书籍专题
 * @author shutong
 * @since 2019/04/25
 */

public interface BookSubjectService extends IService<BookSubject> {

    /**
     * 条件查询书籍专题
     * @param subjectType ( boy:男生| girl:女生 )
     * @param status ( 0:下架 | 1:上架 )
     * @return
     */
    List<BookSubject> listByCondition(String subjectType,Integer status);
}
