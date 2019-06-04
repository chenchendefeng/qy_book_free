package com.only.tech.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookMark;
import com.only.tech.entity.book.BookShelf;
import com.only.tech.exposeinfz.book.dto.BookInfoDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper: 书籍
 * @author shutong
 * @since 2019/04/26
 */
@Repository
public interface BookInfoMapper extends BaseMapper<BookInfo> {

    /**
     * 按书籍阅读量排序查询书籍
     * @return
     */
    List<BookInfoDetailDto> listOrderByReadNum(@Param("category") String category);

    List<BookInfoDto> findPageByNameOrAuthorName(String wd);

    /**
     * 查询书籍列表（按书籍分类 & 完结状态）
     * @param adCategory
     * @param finishFlag
     * @return
     */
    List<BookInfo> listByAdCategory(@Param("adCategory") String adCategory, @Param("finishFlag")Integer finishFlag);

    /**
     * 统计男生女生书籍数量
     * @param sexMark
     * @return
     */
    Integer countBySexFlag(@Param("sexMark") String sexMark);

    /**
     * 查询书籍详细信息
     * @param bid
     * @return
     */
    BookInfoDetailDto getBookInfoDetail(@Param("bid")Long bid);

    List<com.only.tech.exposeinfz.admin.dto.BookInfoDto> getBookList(@Param("keyWord") String keyWord, @Param("status")Integer status, @Param("category")String category);
}
