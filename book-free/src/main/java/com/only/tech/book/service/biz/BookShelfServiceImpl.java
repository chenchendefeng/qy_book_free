package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.book.mapper.BookShelfMapper;
import com.only.tech.constant.BookRedisKeyConstants;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookShelf;
import com.only.tech.exposeinfz.book.dto.BookInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 服务实现类: 书架
 * @author shutong
 * @since 2019/04/25
 */
@Service
public class BookShelfServiceImpl extends ServiceImpl<BookShelfMapper, BookShelf> implements BookShelfService {

    @Autowired
    private BookShelfMapper bookShelfMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 放入书架
     * @param uid
     * @param bid
     */
    @Override
    public boolean save(Long uid, Long bid) {

        QueryWrapper<BookShelf> wrapper=new QueryWrapper<BookShelf>();
        wrapper.eq("uid",uid);
        wrapper.eq("bid",bid);
        BookShelf bookShelf=super.getOne(wrapper);

        if(bookShelf==null){
            BookShelf _bookShelf=new BookShelf();
            _bookShelf.setBid(bid);
            _bookShelf.setCreateTime(new Date());
            _bookShelf.setUid(uid);
            return this.save(_bookShelf);
        }
        return false;
    }



    /**
     * 查询用户书架书籍
     * @param uid
     * @return
     */
    @Override
    public List<BookShelf> listByUid(Long uid){
        QueryWrapper<BookShelf> wrapper=new QueryWrapper<BookShelf>();
        wrapper.eq("uid",uid);
        wrapper.orderByDesc("id");
        return super.list(wrapper);
    }

    /**
     * 移出书架
     * @param uid
     * @param bid
     */
    @Override
    public void remove(Long uid, Long bid) {
        QueryWrapper<BookShelf> wrapper=new QueryWrapper<BookShelf>();
        wrapper.eq("uid",uid);
        wrapper.eq("bid",bid);
        super.remove(wrapper);
    }

    /**
     * 查找书架中的书
     * @param uid
     * @param bid
     * @return
     */
    @Override
    public BookShelf getOneByUidAndBid(Long uid, Long bid) {
        QueryWrapper<BookShelf> wrapper=new QueryWrapper<BookShelf>();
        wrapper.eq("uid",uid);
        wrapper.eq("bid",bid);
        return super.getOne(wrapper);
    }



}
