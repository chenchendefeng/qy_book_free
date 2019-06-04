package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.book.mapper.BookCategoryMapper;
import com.only.tech.book.mapper.BookInfoMapper;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookCategory;
import com.only.tech.entity.book.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类: 书籍类目
 * @author shutong
 * @since 2019/05/06
 */
@Service
public class BookCategoryServiceImpl extends ServiceImpl<BookCategoryMapper, BookCategory> implements BookCategoryService {

    @Autowired
    private BookCategoryMapper bookCategoryMapper;

    /**
     * 按性别分类目录
     * @param sexType
     * @return
     */
    @Override
    public List<BookCategory> listBySexType(String sexType) {
        QueryWrapper<BookCategory> wrapper=new QueryWrapper<BookCategory>();
        wrapper.eq("sexType",sexType);
        return super.list(wrapper);
    }

    @Override
    public List<BookCategory> listAll() {
        QueryWrapper<BookCategory> wrapper=new QueryWrapper<BookCategory>();
        wrapper.orderByAsc("id");
        return super.list(wrapper);
    }
}
