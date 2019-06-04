package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.book.mapper.BookCategoryMapper;
import com.only.tech.book.mapper.BookMarkMapper;
import com.only.tech.constant.BookRedisKeyConstants;
import com.only.tech.entity.book.BookCategory;
import com.only.tech.entity.book.BookCategoryRela;
import com.only.tech.entity.book.BookMark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类: 书籍类目
 * @author shutong
 * @since 2019/05/21
 */
@Service
public class BookMarkServiceImpl extends ServiceImpl<BookMarkMapper, BookMark> implements BookMarkService {

    @Autowired
    private BookMarkMapper bookMarkMapper;

    @Autowired
    private RedisTemplate redisTemplate;



    @Override
    public List<BookMark> listByAdCategory(String adCategory) {

        QueryWrapper<BookMark> wrapper=new QueryWrapper<BookMark>();
        wrapper.eq("adCategory",adCategory);

        return super.list(wrapper);
    }

    @Override
    public List<String> listChildCategoryByAdCategory(String adCategory) {
        return this.bookMarkMapper.listChildCategoryByAdCategory(adCategory);
    }

    @Override
    public void clearRedisCache(Long bid) {
        String redisKey = BookRedisKeyConstants.BOOK_INFO_MARK +bid;
        redisTemplate.delete(redisKey);
    }

    @Override
    public BookMark getMarkByBid(Long bid){
        QueryWrapper<BookMark> wrapper=new QueryWrapper<BookMark>();
        wrapper.eq("bid",bid);

        return super.getOne(wrapper);
    }
}
