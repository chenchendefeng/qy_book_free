package com.only.tech.book.controller;


import com.only.tech.base.ResultDto;
import com.only.tech.book.service.facade.ReadProcessFacade;
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
 * <p>
 * 书籍阅读进度表 前端控制器
 * </p>
 *
 * @author zzb
 * @since 2019-05-08
 */
@Slf4j
@RestController
@Api(tags = "阅读进度")
@RequestMapping("/read-process")
public class ReadProcessController extends BaseController {

    @Autowired
    private ReadProcessFacade readProcessFacade;


    @ApiOperation(value = "更新阅读进度")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户ID", required = true),
            @ApiImplicitParam(paramType = "query", name = "bid", dataType = "long", value = "书号ID", required = true),
            @ApiImplicitParam(paramType = "query", name = "cid", dataType = "long", value = "章节ID", required = true),
            @ApiImplicitParam(paramType = "query", name = "readWords", dataType = "int", value = "章节已读字数", required = true)})
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Access
    public ResultDto update(Long cuId, Long bid, Long cid, Integer readWords) {
        try {

            boolean update = readProcessFacade.update(cuId, bid, cid, readWords);
            return update?ResultDto.succesResult("更新成功"):ResultDto.errorResult("更新失败");
        } catch (Exception e) {
            log.error("更新阅读进度错误",e);
            return ResultDto.errorResult("更新阅读进度错误");
        }

    }





}
