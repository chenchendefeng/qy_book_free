package com.only.tech.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookCategory;
import com.only.tech.entity.book.BookInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper: 书籍类目
 * @author shutong
 * @since 2019/05/06
 */
@Repository
public interface BookCategoryMapper extends BaseMapper<BookCategory> {

}
