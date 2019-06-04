package com.only.tech.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.entity.book.BookCategory;
import com.only.tech.entity.book.BookMark;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper: 书籍标签
 * @author shutong
 * @since 2019/05/21
 */
@Repository
public interface BookMarkMapper extends BaseMapper<BookMark> {

    List<String> listChildCategoryByAdCategory(@Param("adCategory") String adCategory);
}
