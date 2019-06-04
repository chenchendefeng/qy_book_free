package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.book.mapper.BookInfoMapper;
import com.only.tech.book.mapper.BookShelfMapper;
import com.only.tech.constant.BookRedisKeyConstants;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookMark;
import com.only.tech.entity.book.BookShelf;
import com.only.tech.exposeinfz.book.dto.BookInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 服务实现类: 书籍
 * @author shutong
 * @since 2019/04/25
 */
@Service
public class BookInfoServiceImpl extends ServiceImpl<BookInfoMapper, BookInfo> implements BookInfoService {

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Autowired
    private BookShelfMapper bookShelfMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据"bid"查询书籍
     * @param bid
     * @return
     */
    @Override
    public BookInfo getOneByBid(Long bid) {
        QueryWrapper<BookInfo> wrapper=new QueryWrapper<BookInfo>();
        wrapper.eq("bid",bid);
        return super.getOne(wrapper);
    }

    /**
     *  按书籍阅读量排序查询书籍
     * @return
     */
    @Override
    public List<BookInfoDetailDto> listOrderByReadNum(String category) {

        return this.bookInfoMapper.listOrderByReadNum(category);
    }

    @Override
    public List<BookInfoDto> findPageByNameOrAuthorName(String wd) {
        return bookInfoMapper.findPageByNameOrAuthorName(wd);
    }

    /**
     * 分页查询书籍列表（按书籍分类 & 完结状态）
     * @param adCategory
     * @param finishFlag
     * @return
     */
    @Override
    public List<BookInfo> listByAdCategory(String adCategory, Integer finishFlag) {
        return bookInfoMapper.listByAdCategory(adCategory,finishFlag);
    }

    /**
     * 统计男生女生书籍数量
     * @param sexMark
     * @return
     */
    @Override
    public Integer countBySexFlag(String sexMark) {
        return this.bookInfoMapper.countBySexFlag(sexMark);
    }

    /**
     * 查询书籍详细信息
     * @param bid
     * @return
     */
    @Override
    public BookInfoDetailDto getBookInfoDetail(Long bid) {
        return this.bookInfoMapper.getBookInfoDetail(bid);
    }

    @Override
    public List<com.only.tech.exposeinfz.admin.dto.BookInfoDto> getBookList(String keyWord, Integer status, String category){
        return bookInfoMapper.getBookList(keyWord, status, category);
    }

    @Override
    public void clearRedisCache(Long bid) {
        String redisKey = BookRedisKeyConstants.BOOKINFO +bid;
        redisTemplate.delete(redisKey);
    }

}
