package com.only.tech.book.controller;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.book.service.facade.BookCategoryFacde;
import com.only.tech.book.service.facade.BookInfoFacde;
import com.only.tech.dto.book.BookCategoryDto;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookCategory;
import com.only.tech.entity.book.BookInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import ooh.chaos.targetMethod.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller: 书籍类目
 * @author shutong
 * @since 2019/05/06
 *
 */
@RestController
@Api(tags="书籍类目")
@RequestMapping("/bookCategory")
@Slf4j
public class BookCategoryController extends BaseController {

    @Autowired
    private BookCategoryFacde bookCategoryFacde;

    @Autowired
    private BookInfoFacde bookInfoFacde;

    @Access
    @ApiOperation(value = "书籍分类列表（按男生女生分类）" )
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sexType", dataType = "string", value = "性别标识（ boy:男生 | girl：女生 ）", required = false)
    })
    @RequestMapping(value = "/pageListBySexType", method = RequestMethod.POST)
    public ResultDto<BookCategoryDto> pageListBySexType(PageReq pageReq, String sexType) {
        try {

            PageData<BookCategoryDto> pageData=this.bookCategoryFacde.pageListBySexType(pageReq,sexType);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("查询书籍分类列表异常", e);
            return ResultDto.errorResult("查询书籍分类列表异常");
        }
    }

    @Access
    @ApiOperation(value = "书籍列表（按书籍分类 & 完结状态）" )
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "finishFlag", dataType = "int", value = "完结状态( 0:连载中 | 1：已完结 )", required = false),
            @ApiImplicitParam(name = "adCategory", dataType = "string", value = "书籍分类(中文类名，eg: 武侠 )", required = false)
    })
    @RequestMapping(value = "/pageListByBookClass", method = RequestMethod.POST)
    public ResultDto<BookInfoDetailDto> pageListByBookClass(PageReq pageReq,String adCategory,Integer finishFlag) {
        try {

            PageData<BookInfo> pageData=this.bookInfoFacde.pageListByAdCategory(pageReq,adCategory,finishFlag);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("查询书籍列表异常", e);
            return ResultDto.errorResult("查询书籍列表异常");
        }
    }


}
