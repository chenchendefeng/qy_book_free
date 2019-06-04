package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.book.mapper.BookSubjectItemMapper;
import com.only.tech.book.mapper.BookSubjectMapper;
import com.only.tech.constant.BookSubjectTypeConstants;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookSubject;
import com.only.tech.entity.book.BookSubjectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类: 专题书籍
 * @author shutong
 * @since 2019/04/26
 */
@Service
public class BookSubjectItemServiceImpl extends ServiceImpl<BookSubjectItemMapper, BookSubjectItem> implements BookSubjectItemService {

    @Autowired
    private BookSubjectService bookSubjectService;

    @Autowired
    private BookSubjectItemMapper bookSubjectItemMapper;

    /**
     * 查询专题书籍
     * @param subjectId
     * @return
     */
    @Override
    public List<BookInfoDetailDto> listBySubjectId(String sexMark, Long subjectId) {

        BookSubject bookSubject=this.bookSubjectService.getById(subjectId);
        if(bookSubject==null){
            return null;
        }
        return this.bookSubjectItemMapper.listBySubjectIdOrderBySexMark(sexMark,subjectId);
    }

    @Override
    public void deleteBySubjectId(Long subjectId) {
        QueryWrapper<BookSubjectItem> wrapper=new QueryWrapper<BookSubjectItem>();

        if(subjectId ==null){
           return ;
        }
        wrapper.eq("subjectId",subjectId);
        super.remove(wrapper);
    }

    /**
     * 删除专题书籍
     * @param subjectId
     */
    public void deleteBookSubjectBook(Long subjectId) {
        QueryWrapper<BookSubjectItem> qw=new QueryWrapper<BookSubjectItem>();

        if(subjectId==null){
            return;
        }
        qw.eq("subjectId",subjectId);
        super.remove(qw);
    }
}
