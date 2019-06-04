package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.dto.book.ChapterDto;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.Chapter;

import java.util.List;

/**
 * @author shutong
 * @since 2019/04/26
 */

public interface ChapterService extends IService<Chapter> {


    /**
     * 查询所以章节
     * @param bid
     * @return
     */
    List<Chapter> listByBid(Long bid);

    List<ChapterDto> chapterDtoList(Long bid);

    Chapter getChapter(Long bid, Long cid);

    void getChapterOssUrl(List<ChapterDto> dtoList);

    /**
     * 获取制定章节之前的总字数
     * @param bid
     * @param cid
     * @return
     */
    Integer readWordCount(Long bid, Long cid);

    Integer getTotalWordCount(Long bid);
}
