package com.only.tech.book.controller;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.book.service.facade.BookInfoFacde;
import com.only.tech.book.service.facade.BookSubjectFacde;
import com.only.tech.dto.book.BookCoverDto;
import com.only.tech.dto.book.BookDto;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.dto.book.BookSubjectDto;
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

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * controller: 书籍专题
 * @author shutong
 * @since 2019/04/28
 *
 */
@RestController
@Api(tags="书籍")
@RequestMapping("/bookInfo")
@Slf4j
public class BookInfoController extends BaseController {

    @Autowired
    private BookInfoFacde bookInfoFacde;

    /**
     * 猜你喜欢列表
     * @param pageReq
     * @return
     */
    @Access
    @ApiOperation(value = "猜你喜欢列表" )
    @ResponseBody
    @RequestMapping(value = "/pageListGuessYouLike", method = RequestMethod.POST)
    public ResultDto<BookInfoDetailDto> pageListGuessYouLike(PageReq pageReq) {
        try {
            PageData<BookInfoDetailDto> pageData=this.bookInfoFacde.pageListGuessYouLike(pageReq);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("查询猜你喜欢异常", e);
            return ResultDto.errorResult("查询猜你喜欢异常");
        }
    }

    /**
     * 大家都在看
     * @param pageReq
     * @return
     */
    @Access
    @ApiOperation(value = "大家都在看（同分类阅读量最高的 前3本）" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", dataType = "string", value = "书籍类目", required = false)
    })
    @ResponseBody
    @RequestMapping(value = "/pageListTogetherRead", method = RequestMethod.POST)
    public ResultDto<BookInfoDetailDto> pageListTogetherRead(PageReq pageReq, String category) {
        try {
            PageData<BookInfoDetailDto> pageData=this.bookInfoFacde.pageListTogetherRead(pageReq,category);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("查询大家都在看异常", e);
            return ResultDto.errorResult("查询大家都在看异常");
        }
    }


    @Access
    @ApiOperation(value = "书籍详情" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cuId", dataType = "long", value = "用户ID", required = false),
            @ApiImplicitParam(name = "bid", dataType = "long", value = "书籍ID", required = true),
    })
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResultDto<BookDto> detail(Long cuId,Long bid){

        try {
            BookDto detailDto = bookInfoFacde.detail(cuId,bid);
            return detailDto!=null?ResultDto.succesResult(detailDto):ResultDto.errorResult("书籍不存在");
        } catch (Exception e) {
            log.error("书籍详情错误：bid:[{}]",bid,e);
        }
        return ResultDto.errorResult("查询失败");
    }


    @Access
    @ApiOperation(value = "书籍封面" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bid", dataType = "long", value = "书籍ID", required = true)
    })
    @ResponseBody
    @RequestMapping(value = "/cover", method = RequestMethod.POST)
    public ResultDto<BookCoverDto> cover(Long bid){

        try {
            BookCoverDto bookCoverDto = bookInfoFacde.cover(bid);
            return bookCoverDto!=null?ResultDto.succesResult(bookCoverDto):ResultDto.errorResult("书籍不存在");
        } catch (Exception e) {
            log.error("书籍封面错误：bid:[{}]",bid,e);
        }
        return ResultDto.errorResult("查询失败");
    }


    /**
     * 每周新增书籍书
     * @return
     */
    @Access
    @ApiOperation(value = "每周新增书籍书" )
    @ResponseBody
    @RequestMapping(value = "/newBookNumPerWeek", method = RequestMethod.POST)
    public ResultDto newBookNumPerWeek(){
        Calendar now=Calendar.getInstance();
        int temp1 = now.get(Calendar.MONTH)*200;
        int temp2 = now.get(Calendar.WEEK_OF_YEAR)*2;
        int temp3 = now.get(Calendar.DAY_OF_MONTH)*2;
        int newBook=temp1+temp2+temp3;
        return ResultDto.succesResult(newBook);
    }

}
