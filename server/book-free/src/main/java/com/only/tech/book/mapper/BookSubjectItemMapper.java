package com.only.tech.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookSubject;
import com.only.tech.entity.book.BookSubjectItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper: 专题书籍
 * @author shutong
 * @since 2019/04/26
 */
@Repository
public interface BookSubjectItemMapper extends BaseMapper<BookSubjectItem> {

    /**
     * 查询专题书籍
     * @param sexMark 性别
     * @param subjectId 专题ID
     * @return
     */
    List<BookInfoDetailDto> listBySubjectIdOrderBySexMark(@Param("sexMark") String sexMark, @Param("subjectId") Long subjectId);
}
