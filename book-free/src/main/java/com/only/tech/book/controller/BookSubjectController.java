package com.only.tech.book.controller;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.book.service.biz.BookShelfService;
import com.only.tech.book.service.biz.ChapterService;
import com.only.tech.book.service.facade.BookShelfFacde;
import com.only.tech.book.service.facade.BookSubjectFacde;
import com.only.tech.dto.book.BookSubjectDto;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.Chapter;
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

import java.util.List;

/**
 * controller: 书籍专题
 * @author shutong
 * @since 2019/04/28
 *
 */
@RestController
@Api(tags="书籍专题")
@RequestMapping("/bookSubject")
@Slf4j
public class BookSubjectController extends BaseController {

    @Autowired
    private BookSubjectFacde bookSubjectFacde;

    @Access
    @ApiOperation(value = "按类型查询书籍专题" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "subjectType", dataType = "string", value = "专题类型（ boy:男生 | girl：女生 | recommend: 推荐 ）", required = false),
            @ApiImplicitParam(name = "sexMark", dataType = "string", value = "性别标识（ boy:男生 | girl：女生 ）", required = false)
    })
    @ResponseBody
    @RequestMapping(value = "/listBySubjectType", method = RequestMethod.POST)
    public ResultDto<BookSubjectDto> listBySubjectType(String subjectType, String sexMark) {
        try {
            List<BookSubjectDto> dtoList=this.bookSubjectFacde.listByCondition(sexMark,subjectType,1);
            return ResultDto.succesResult(dtoList);
        } catch (Exception e) {
            log.error("查询书籍专题异常", e);
            return ResultDto.errorResult("查询书籍专题异常");
        }
    }




}
