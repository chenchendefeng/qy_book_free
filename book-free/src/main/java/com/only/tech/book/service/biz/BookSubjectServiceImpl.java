package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.book.mapper.BookInfoMapper;
import com.only.tech.book.mapper.BookSubjectMapper;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookSubject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类: 书籍专题
 * @author shutong
 * @since 2019/04/26
 */
@Service
public class BookSubjectServiceImpl extends ServiceImpl<BookSubjectMapper, BookSubject> implements BookSubjectService {

    @Autowired
    private BookSubjectService bookSubjectService;

    /**
     * 条件查询书籍专题
     * @param subjectType ( boy:男生| girl:女生 )
     * @param status ( 0:下架 | 1:上架 )
     * @return
     */
    @Override
    public List<BookSubject> listByCondition(String subjectType, Integer status) {

        QueryWrapper<BookSubject> wrapper=new QueryWrapper<BookSubject>();

        if(StringUtils.isNotBlank(subjectType)){
            wrapper.eq("subjectType",subjectType);
        }
        if(status!=null){
            wrapper.eq("status",status);
        }

        wrapper.orderByAsc("displayOrder");
        return super.list(wrapper);
    }
}
