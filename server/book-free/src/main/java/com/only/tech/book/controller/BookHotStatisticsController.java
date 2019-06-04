package com.only.tech.book.controller;

import com.only.tech.base.result.ResultDto;
import com.only.tech.book.service.facade.BookHotFacade;
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
 * @author ZHI ZUN BAO
 * @since 2019/5/7
 */
@Slf4j
@RestController
@Api(tags="书籍统计")
@RequestMapping("/bookhot")
public class BookHotStatisticsController extends BaseController {

    @Autowired
    private BookHotFacade bookHotFacade;



    @Access
    @ResponseBody
    @ApiOperation(value = "数量统计")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "bid", dataType = "int", value = "书籍ID", required = true),
            @ApiImplicitParam(paramType = "query", name = "type", dataType = "string", value = "类型（share:分享 | reading:在读）", required = true),
    })
    @RequestMapping(value = "/statistics", method = RequestMethod.POST)
    public ResultDto statistics(Long bid,String type){
        try {
            boolean add = bookHotFacade.addCountByType(bid,type);
            return add? ResultDto.succesResult("统计成功"):ResultDto.errorResult("统计失败");
        } catch (Exception e) {
            log.error("书籍热度统计错误：bid:[{}]",bid,e);
        }
        return ResultDto.errorResult("统计失败");
    }

}
