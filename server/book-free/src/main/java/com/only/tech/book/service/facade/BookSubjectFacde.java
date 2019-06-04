package com.only.tech.book.service.facade;

import com.only.tech.book.service.biz.BookInfoService;
import com.only.tech.book.service.biz.BookSubjectItemService;
import com.only.tech.book.service.biz.BookSubjectService;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.dto.book.BookSubjectDto;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookSubject;
import com.only.tech.entity.book.BookSubjectItem;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

/**
 * facade: 书籍专题
 * @author shutong
 * @since 2019/04/28
 */
@Service
@Slf4j
public class BookSubjectFacde {

    @Autowired
    private BookSubjectService bookSubjectService;

    @Autowired
    private BookSubjectItemService bookSubjectItemService;

    @Autowired
    private BookInfoService bookInfoService;

    /**
     * 条件查询书籍专题
     * @param sexMark 性别标识( boy:男生| girl:女生 )
     * @param subjectType ( boy:男生| girl:女生 | recommend: 推荐 )
     * @param status ( 0:下架 | 1:上架 )
     * @return
     */
    public List<BookSubjectDto> listByCondition(String sexMark, String subjectType,Integer status) {

        List<BookSubjectDto> dtoList=new ArrayList<BookSubjectDto>();

        List<BookSubject> subjectList=this.bookSubjectService.listByCondition(subjectType,status);
        if(subjectList==null || subjectList.size()==0){
            return dtoList;
        }

        for (BookSubject subject : subjectList){

            BookSubjectDto dto=new BookSubjectDto();
            BeanUtils.copyProperties(subject,dto);

            //查询书籍
            Long subjectId=subject.getId();
            List<BookInfoDetailDto>  bookInfoDetailDtoList=this.bookSubjectItemService.listBySubjectId(sexMark,subjectId);
            dto.setBookList(bookInfoDetailDtoList);

            dtoList.add(dto);
        }

        return dtoList;

    }
}
