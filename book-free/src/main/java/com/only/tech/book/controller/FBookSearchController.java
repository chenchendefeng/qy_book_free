package com.only.tech.book.controller;

import com.mysql.jdbc.StringUtils;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.ResultDto;
import com.only.tech.book.service.facade.BookSearchFacade;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.exposeinfz.admin.dto.BookInfoDto;
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
 * @author HUA MAN LOU
 * @since 2019/4/25
 */
@Slf4j
@RestController
@RequestMapping("/search")
@Api(tags="搜索")
public class FBookSearchController extends BaseController {
    @Autowired
    private BookSearchFacade bookSearchFacade;


    @ApiOperation(value = "/search/list", notes = "搜索查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "wd", dataType = "String", value = "关键字", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "每页数据数量", required = true)})
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @Access
    public ResultDto<PageData<BookInfoDto>> searchList(String wd, PageReq pageReq) {
//        log.info("搜索查询 wd:[{}]", wd);
        if (StringUtils.isNullOrEmpty(wd)) {
            return ResultDto.errorResult("关键字不能为空");
        }

        //去除空格
        wd = wd.trim();
        wd = wd.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，,。？“”]+", "");

        if (StringUtils.isNullOrEmpty(wd)) {
            return ResultDto.errorResult("关键字不能包含特殊字符");
        }

        try {
            PageData pageData = bookSearchFacade.search(wd, pageReq);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("搜索查询 错误信息：[{}]",e);
            return ResultDto.errorResult("系统异常");
        }
    }
}
