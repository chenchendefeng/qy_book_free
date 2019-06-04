package com.only.tech.book.controller;

import com.only.tech.base.result.ResultDto;
import com.only.tech.book.service.biz.BookShelfService;
import com.only.tech.book.service.biz.ChapterService;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookShelf;
import com.only.tech.entity.book.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.book.service.facade.BookShelfFacde;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import ooh.chaos.targetMethod.Access;

import java.util.List;

/**
 * controller: 书架
 * @author shutong
 * @since 2019/04/25
 *
 */
@RestController
@Api(tags="书架")
@RequestMapping("/bookShelf")
@Slf4j
public class BookShelfController extends BaseController {


    @Autowired
    private BookShelfService bookShelfService;

    @Autowired
    private BookShelfFacde bookShelfFacde;


    @Access
    @ApiOperation(value = "加入书架" )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", dataType = "int", value = "用户ID", required = true),
            @ApiImplicitParam(paramType = "query", name = "bid", dataType = "int", value = "书籍ID", required = true)
    })
    @ResponseBody
    @RequestMapping(value = "/putOn", method = RequestMethod.POST)
    public ResultDto putOn(Long uid, Long bid) {
        try {

            if( uid==null || bid==null ){
                return ResultDto.errorResult("参数异常");
            }

            BookShelf bookShelf=this.bookShelfService.getOneByUidAndBid(uid, bid);

            if(bookShelf!=null){
                return ResultDto.errorResult("已在书架中");
            } else{
                boolean add = bookShelfFacde.addShelf(uid,bid);
                return add?ResultDto.succesResult("加入书架成功"):ResultDto.errorResult("加入失败");
            }


        } catch (Exception e) {
            log.error("加入书架异常", e);
            return ResultDto.errorResult("加入书架异常");
        }
    }

    @Access
    @ApiOperation(value = "移出书架" )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", dataType = "int", value = "用户ID", required = true),
            @ApiImplicitParam(paramType = "query", name = "bid", dataType = "int", value = "书籍ID", required = true)
    })
    @ResponseBody
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ResultDto remove(Long uid, Long bid) {
        try {

            if( uid==null || bid==null ){
                return ResultDto.errorResult("参数异常");
            }

            BookShelf bookShelf=this.bookShelfService.getOneByUidAndBid(uid, bid);

            if(bookShelf==null){
                return ResultDto.succesResult("未在书架中");
            }else{
                this.bookShelfService.remove(uid, bid);
                return ResultDto.succesResult("移出书架成功");
            }

        } catch (Exception e) {
            log.error("移出书架异常", e);
            return ResultDto.errorResult("移出书架异常");
        }
    }


    @Access
    @ApiOperation(value = "查询书架书籍" )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", dataType = "int", value = "用户ID", required = true)
    })
    @ResponseBody
    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    public ResultDto<BookInfoDetailDto> pageList(PageReq pageReq, Long uid) {
        try {

            if( uid==null){
                return ResultDto.errorResult("参数异常");
            }

            PageData<BookInfoDetailDto> pageData=this.bookShelfFacde.pageList(pageReq,uid);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("查询书架书籍异常", e);
            return ResultDto.errorResult("查询书架书籍异常");
        }
    }




}
