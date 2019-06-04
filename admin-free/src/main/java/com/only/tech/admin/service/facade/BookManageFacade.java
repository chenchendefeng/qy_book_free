package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.book.BookDto;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookCategory;
import com.only.tech.exposeinfz.admin.dto.BookInfoDto;
import com.only.tech.exposeinfz.book.api.BookInfoInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HUA MAN LOU
 * @since 2019/5/23
 */
@Service
@Slf4j
public class BookManageFacade {

    @Reference
    private BookInfoInfz bookInfoInfz;

    public PageData<BookInfoDto> getBookList(String keyWord, Integer status, String category, PageReq pageReq){

        return bookInfoInfz.getBookList(keyWord, status, category, pageReq);
    }


    /**
     * 书籍详情
     * @param bid
     * @return
     */
    public BookInfoDetailDto getBookDetail(Long bid) {
        log.info("admin 书籍详情 bid:[{}] ",bid);

        BookInfoDetailDto bookDetail = bookInfoInfz.getBookDetail(bid);

        return bookDetail;
    }

    /**
     * 修改书籍信息
     * @param bid
     * @return
     */
    public ResultDto updateInformation(Long bid, String sexMark, Integer shelfStatus, Long readedCount, Long addBookShelfCount){
        boolean update = bookInfoInfz.updateInformation(bid, sexMark, shelfStatus, readedCount, addBookShelfCount);
        return update? ResultDto.succesResult("修改成功"): ResultDto.errorResult("修改失败");
    }

    /**
     * 查询书籍分类
     * @return
     */
    public List<BookCategory> listBookCategory() {
        return this.bookInfoInfz.listBookCategory();
    }
}
