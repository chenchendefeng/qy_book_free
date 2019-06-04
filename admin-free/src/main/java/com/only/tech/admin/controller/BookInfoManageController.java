package com.only.tech.admin.controller;

import com.only.tech.admin.service.facade.BookManageFacade;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookCategory;
import com.only.tech.exposeinfz.admin.dto.BookInfoDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "bookInfoManage")
@Api(tags="书籍管理")
@Slf4j
public class BookInfoManageController {

    @Autowired
    private BookManageFacade bookManageFacade;


    @ApiOperation(value = "书籍管理-书籍列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "keyWord", dataType = "String", value = "书名/编号", required = false),
            @ApiImplicitParam(paramType = "query", name = "status", dataType = "int", value = "上架状态 （0：下架 | 1：上架）", required = false),
            @ApiImplicitParam(paramType = "query", name = "category", dataType = "String", value = "筛选条件 （boy男生，girl女生）", required = false),
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "每页数据数量",required = true)
})
    @RequestMapping(value = "/bookList", method = RequestMethod.POST)
    public ResultDto<PageData<BookInfoDto>> bookList(String keyWord, Integer status, String category, PageReq pageReq) {

        try {
            PageData<BookInfoDto> resultData = bookManageFacade.getBookList(keyWord, status, category, pageReq);

            return ResultDto.succesResult(resultData);
        } catch (Exception e) {
            log.error("书籍管理-书籍列表 信息：[{}]",e);
        }
        return ResultDto.errorResult("查询失败");
    }

    @ApiOperation(value = "书籍详情")
    @ApiImplicitParam(paramType = "query", name = "bid", dataType = "Long", value = "书籍id", required = true)
    @RequestMapping(value = "/bookDetail", method = RequestMethod.POST)
    public ResultDto<PageData<BookInfoDetailDto>> bookDetail(Long bid) {
        log.info("书籍详情  bid:[{}]",bid);

        try {
            if (bid == null){
                return ResultDto.errorResult("参数错误");
            }
            BookInfoDetailDto bookDetail = bookManageFacade.getBookDetail(bid);

            if (bookDetail == null){
                return ResultDto.errorResult("书籍不存在");
            }
            return ResultDto.succesResult(bookDetail);
        } catch (Exception e) {
            log.error("书籍详情 信息:[{}]",e);
        }
        return ResultDto.errorResult();
    }

    @ApiOperation(value = "修改书籍信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "bid", dataType = "Long", value = "书籍id", required = true),
            @ApiImplicitParam(paramType = "query", name = "sexMark", dataType = "String", value = "性别标签", required = true),
            @ApiImplicitParam(paramType = "query", name = "shelfStatus", dataType = "Integer", value =  "书籍状态（0：下架 | 1：上架）"),
            @ApiImplicitParam(paramType = "query", name = "readedCount", dataType = "Long", value =  "阅读量", required = true),
            @ApiImplicitParam(paramType = "query", name = "addBookShelfCount", dataType = "Long", value = "加入书架量", required = true)
    })
    @RequestMapping(value = "/updateInformation", method = RequestMethod.POST)
    public ResultDto updateInformation(Long bid, String sexMark, Integer shelfStatus, Long readedCount, Long addBookShelfCount){
        return bookManageFacade.updateInformation(bid, sexMark, shelfStatus, readedCount, addBookShelfCount);
    }


    @ApiOperation(value = "查询书籍分类")
    @RequestMapping(value = "/listBookCategory", method = RequestMethod.POST)
    public ResultDto<BookCategory> listBookCategory(){
        try{
            List<BookCategory> bookCategoryList=this.bookManageFacade.listBookCategory();
            return ResultDto.succesResult(bookCategoryList);
        }catch (Exception e){
            log.error("查询书籍分类异常:"+ e);
            return ResultDto.errorResult("查询书籍分类异常");
        }

    }


}
