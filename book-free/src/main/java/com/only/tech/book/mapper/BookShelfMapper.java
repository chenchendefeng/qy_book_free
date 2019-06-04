package com.only.tech.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.entity.book.BookMark;
import com.only.tech.entity.book.BookShelf;
import com.only.tech.exposeinfz.admin.dto.BookInfoDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Mapper: 书架
 * @author shutong
 * @since 2019/04/25
 */
@Repository
public interface BookShelfMapper extends BaseMapper<BookShelf> {


}
