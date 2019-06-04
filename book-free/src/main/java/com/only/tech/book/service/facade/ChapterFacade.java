package com.only.tech.book.service.facade;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.book.service.biz.ChapterService;
import com.only.tech.constant.BookRedisKeyConstants;
import com.only.tech.dto.book.ChapterDto;
import com.only.tech.entity.book.Chapter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/7
 */
@Service
public class ChapterFacade {

    @Autowired
    private ChapterService chapterService;


    /**
     * 分页查询
     * @param bid
     * @param pageReq
     * @return
     */
    public PageData<ChapterDto> pageData(Long bid, PageReq pageReq) {
        Page page = PageHelper.startPage(pageReq.getPageNo(),pageReq.getPageSize());
        chapterService.chapterDtoList(bid);

        PageData pageData = new PageData(page);
        return pageData;
    }



    /**
     * 章节内容
     * @param bid
     * @param cid
     * @return
     */
    public ChapterDto chapterContent(Long bid, Long cid) {
        Chapter chapter = chapterService.getChapter(bid,cid);
        if (chapter == null){
            return null;
        }

        List<ChapterDto> dtoList = new ArrayList<>();
        ChapterDto chapterDto = new ChapterDto();
        BeanUtils.copyProperties(chapter,chapterDto);
        dtoList.add(chapterDto);

        chapterService.getChapterOssUrl(dtoList);
        return dtoList.get(0);
    }


    public Integer getTotalWordCount(Long bid) {
        return chapterService.getTotalWordCount(bid);
    }
}
