package com.only.tech.book.service.facade;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.book.service.biz.BookCategoryService;
import com.only.tech.book.service.biz.BookInfoService;
import com.only.tech.book.service.biz.BookMarkService;
import com.only.tech.dto.book.BookCategoryDto;
import com.only.tech.entity.book.BookCategory;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookMark;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * facade: 书籍
 * @author shutong
 * @since 2019/04/30
 */
@Service
@Slf4j
public class BookCategoryFacde {

    @Autowired
    private BookCategoryService categoryService;

    @Autowired
    private BookMarkService markService;

    @Autowired
    private BookInfoService bookInfoService;


    /**
     * 书籍分类列表
     * @param pageReq
     * @param sexType
     * @return
     */
    public PageData<BookCategoryDto> pageListBySexType(PageReq pageReq, String sexType) {

        Page page = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());

        List<BookCategory> bookCategoryList =this.categoryService.listBySexType(sexType);

        List<BookCategoryDto> dtoList=new ArrayList<BookCategoryDto>();
        for(BookCategory category: bookCategoryList){

            BookCategoryDto dto=new BookCategoryDto();
            BeanUtils.copyProperties(category,dto);

            //书籍总数 & 置顶书籍
            List<BookMark> bookList=this.markService.listByAdCategory(category.getAdCategory());
            if(bookList!=null){
                dto.setBookNum(bookList.size());
                Long bid=bookList.get(0).getBid();
                BookInfo bookInfo=this.bookInfoService.getOneByBid(bid);
                dto.setTopBook(bookInfo);
            }else{
                dto.setBookNum(0);
            }

            //子目录
            List<String> childCategoryList=this.markService.listChildCategoryByAdCategory(category.getAdCategory());
            dto.setChildCategoryList(childCategoryList);

            dtoList.add(dto);
        }

        PageData pageData = new PageData(page);
        pageData.setData(dtoList);
        return pageData;

    }

    /**
     * 查询书籍分类
     * @return
     */
    public List<BookCategory> listAll() {
        return this.categoryService.listAll();
    }
}
