package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.book.mapper.BookHotMapper;
import com.only.tech.constant.BookRedisKeyConstants;
import com.only.tech.entity.book.BookHot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 书籍热度统计 服务实现类
 * </p>
 *
 * @author HUA MAN LOU
 * @since 2019/4/29
 */
@Service
public class BookHotServiceImpl extends ServiceImpl<BookHotMapper, BookHot> implements BookHotService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public BookHot getBookHotByBid(Long bid) {
        String redisKey = BookRedisKeyConstants.BOOK_HOT + bid;
        Object data = redisTemplate.opsForValue().get(redisKey);
        if (data != null){
            return (BookHot)data;
        }

        Wrapper qwBookHot = new QueryWrapper<BookHot>().eq("bid", bid);
        BookHot bookHot = this.getOne(qwBookHot);

        if (bookHot != null){
            redisTemplate.opsForValue().set(redisKey,bookHot,1, TimeUnit.DAYS);
        }
        return bookHot;
    }

    /**
     * 清理缓存
     * @param bid
     * @return
     */
    @Override
    public boolean deleteCache(Long bid){
        String redisKey = BookRedisKeyConstants.BOOK_HOT + bid;
        return redisTemplate.delete(redisKey);
    }
}
