package com.only.tech.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.dto.book.ChapterDto;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.Chapter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper: 书籍章节
 * @author shutong
 * @since 2019/04/26
 */
@Repository
public interface ChapterMapper extends BaseMapper<Chapter> {

    List<Chapter> listByBid(@Param("bid")Long bid);

    List<ChapterDto> chapterDtoList(Long bid);

    Chapter getOneByCondtion(@Param("bid")Long bid, @Param("cid")Long cid);

    /**
     * 获取制定章节之前的总字数
     * @param bid
     * @param displayOrder
     * @return
     */
    Integer readWordCount(@Param("bid")Long bid, @Param("displayOrder")Integer displayOrder);

    Integer getTotalWordCount(Long bid);
}
