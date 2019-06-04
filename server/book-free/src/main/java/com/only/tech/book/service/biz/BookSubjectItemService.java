package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookSubject;
import com.only.tech.entity.book.BookSubjectItem;

import java.util.List;

/**
 * 专题书籍
 * @author shutong
 * @since 2019/04/25
 */

public interface BookSubjectItemService extends IService<BookSubjectItem> {

    /**
     * 查询专题书籍
     * @param sexMark 性别标识( boy:男生| girl:女生 )
     * @param subjectId
     * @return
     */
    List<BookInfoDetailDto> listBySubjectId(String sexMark, Long subjectId);

    /**
     * 删除专题书籍
     * @param subjectId
     */
    void deleteBySubjectId(Long subjectId);
}
