package com.only.tech.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookSubject;
import org.springframework.stereotype.Repository;

/**
 * Mapper: 书籍专题
 * @author shutong
 * @since 2019/04/26
 */
@Repository
public interface BookSubjectMapper extends BaseMapper<BookSubject> {

}
