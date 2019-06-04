package com.only.tech.ywapi.controller;

import com.only.tech.dto.tadu.TaduResultDto;
import com.only.tech.ywapi.service.handler.TaduHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/12
 */
@RestController
@RequestMapping("/taduapi")
@Api("tadu_api")
public class TaduApiController {


    @Autowired
    private TaduHandler taduHandler;


    @ResponseBody
    @ApiOperation(value = "所有书籍id")
    @ApiImplicitParam(paramType = "query",name = "lastUpdateTime",dataType = "long",value = "上次更新时间",required = true)
    @RequestMapping(value = "/bookList", method = RequestMethod.GET)
    public TaduResultDto bookList(Long lastUpdateTime){
        return taduHandler.bookList(lastUpdateTime);
    }



    @ResponseBody
    @ApiOperation(value = "获取书籍信息")
    @ApiImplicitParam(paramType = "query", name = "bookId", dataType = "long", value = "书籍ID", required = true)
    @RequestMapping(value = "/bookInfo", method = RequestMethod.GET)
    public TaduResultDto bookInfo(Long bookId){
        return taduHandler.bookInfo(bookId);
    }



    @ResponseBody
    @ApiOperation(value = "获取书籍结构")
    @ApiImplicitParam(paramType = "query", name = "bookId", dataType = "long", value = "书籍ID", required = true)
    @RequestMapping(value = "/bookStructure", method = RequestMethod.GET)
    public TaduResultDto bookStructure(Long bookId){
        return taduHandler.bookStructure(bookId);
    }



    @ResponseBody
    @ApiOperation(value = "获取章节信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "bookId", dataType = "long", value = "书籍ID", required = true),
            @ApiImplicitParam(paramType = "query", name = "volumeId", dataType = "long", value = "章节id", required = true),
            @ApiImplicitParam(paramType = "query", name = "chapterId", dataType = "long", value = "用户id", required = true)
    })
    @RequestMapping(value = "/chapterInfo", method = RequestMethod.GET)
    public TaduResultDto chapterInfo(Long bookId, Long volumeId, Long chapterId){
        return taduHandler.chapterInfo(bookId,volumeId,chapterId);
    }





}
