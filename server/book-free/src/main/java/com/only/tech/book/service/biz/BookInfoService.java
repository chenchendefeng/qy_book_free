package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookMark;
import com.only.tech.entity.book.BookShelf;
import com.only.tech.exposeinfz.book.dto.BookInfoDto;

import java.util.List;

/**
 * @author shutong
 * @since 2019/04/25
 */

public interface BookInfoService extends IService<BookInfo> {

    /**
     * 根据"bid"查询书籍
     * @param bid
     * @return
     */
    BookInfo getOneByBid(Long bid);

    /**
     * 按书籍阅读量排序查询书籍
     * @param category
     * @return
     */
    List<BookInfoDetailDto> listOrderByReadNum(String category);

    List<BookInfoDto> findPageByNameOrAuthorName(String wd);

    /**
     * 查询书籍列表（按书籍分类 & 完结状态）
     * @param adCategory
     * @param finishFlag
     * @return
     */
    List<BookInfo> listByAdCategory(String adCategory, Integer finishFlag);

    /**
     * 统计男生女生书籍数量
     * @param sexflag
     * @return
     */
    Integer countBySexFlag(String sexflag);

    /**
     * 查询书籍详细信息
     * @param bid
     * @return
     */
    BookInfoDetailDto getBookInfoDetail(Long bid);

    List<com.only.tech.exposeinfz.admin.dto.BookInfoDto> getBookList(String keyWord, Integer status, String category);

    /**
     * 清理redis缓存
     * @param bid
     */
    void clearRedisCache(Long bid);
}
