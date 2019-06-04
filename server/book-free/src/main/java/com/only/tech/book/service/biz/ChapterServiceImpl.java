package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.book.mapper.ChapterMapper;
import com.only.tech.constant.BookRedisKeyConstants;
import com.only.tech.dto.book.ChapterDto;
import com.only.tech.entity.book.Chapter;
import com.only.tech.exposeinfz.book.dto.BChapterDto;
import ooh.chaos.service.OSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 服务实现类: 书籍章节
 * @author shutong
 * @since 2019/04/26
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private OSSService ossService;


    /**
     * 查询书籍章节
     * @param bid
     * @return
     */
    @Override
    public List<Chapter> listByBid(Long bid) {
        return this.chapterMapper.listByBid(bid);
    }

    @Override
    public List<ChapterDto> chapterDtoList(Long bid) {
        return chapterMapper.chapterDtoList(bid);
    }

    @Override
    public Chapter getChapter(Long bid, Long cid) {
        return chapterMapper.getOneByCondtion(bid,cid);
    }

    /**
     * oss路径有效时间为5分钟
     * @param dtoList
     */
    @Override
    public void getChapterOssUrl(List<ChapterDto> dtoList) {
        int minute = 5;
        int count = 0;
        for (ChapterDto chapterDto : dtoList) {
            Long bid = chapterDto.getBid();
            Long cid = chapterDto.getCid();
            count++;
            if (count == 10) {
                count = 0;
                minute++;
            }
            String key = bid + "/" + cid + ".txt";
            String redisKey = BookRedisKeyConstants.CHAPTER_OSS_URL + bid + ":"+ cid;
            Object ossUrl = redisTemplate.opsForValue().get(redisKey);
            if (ossUrl != null){
                chapterDto.setOssUrl((String) ossUrl);
            }else {
                boolean exist = ossService.checkContentExist(bid, cid);
                if (exist) {
                    String url = ossService.getChapterUrl(key, minute);
                    //放入缓存
                    redisTemplate.opsForValue().set(redisKey,url,((minute-1)), TimeUnit.MINUTES);
                    chapterDto.setOssUrl(url);
                }
            }
        }
    }

    /**
     * 获取制定章节之前的总字数
     * @param bid
     * @param cid
     * @return
     */
    @Override
    public Integer readWordCount(Long bid, Long cid) {
        Chapter chapter=this.chapterMapper.getOneByCondtion(bid,cid);
        if(chapter==null){
            return 0;
        }
        Integer displayOrder=chapter.getDisplayOrder();
        Integer readWordCount=this.chapterMapper.readWordCount(bid,displayOrder);
        return readWordCount==null?0:readWordCount;
    }

    @Override
    public Integer getTotalWordCount(Long bid) {
        return chapterMapper.getTotalWordCount(bid);
    }
}
