package com.only.tech.book.controller;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.book.service.biz.ChapterService;
import com.only.tech.book.service.facade.ChapterFacade;
import com.only.tech.dto.book.ChapterDto;
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
 * @author ZHI ZUN BAO
 * @since 2019/5/7
 */
@Slf4j
@RestController
@Api(tags="章节")
@RequestMapping("/chapter")
public class ChapterController extends BaseController {

    @Autowired
    private ChapterFacade chapterFacade;

    @Autowired
    private ChapterService chapterService;

    /**
     * 分页查询章节
     * @param
     * @return
     */
    @Access
    @ApiOperation(value = "分页章节" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bid", dataType = "long", value = "书籍ID", required = true),
            @ApiImplicitParam(name = "pageNo", dataType = "int", value = "页码", required = true),
            @ApiImplicitParam(name = "pageSize", dataType = "int", value = "页大小", required = true),
    })
    @ResponseBody
    @RequestMapping(value = "/pageData", method = RequestMethod.POST)
    public ResultDto<PageData<ChapterDto>> pageData(Long bid, PageReq pageReq){

        try {
            PageData<ChapterDto> pageData = chapterFacade.pageData(bid,pageReq);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("章节分页查询错误：bid:[{}]",bid,e);
        }

        return ResultDto.errorResult("查询失败");
    }

    @Access
    @ApiOperation(value = "查询章节目录" )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "bid", dataType = "int", value = "书籍ID", required = true),
    })
    @ResponseBody
    @RequestMapping(value = "/listChapter", method = RequestMethod.POST)
    public ResultDto<Chapter> listChapter(Long bid) {
        try {

            if( bid == null){
                return ResultDto.errorResult("参数异常");
            }

            List<Chapter> chapterList=this.chapterService.listByBid(bid);
            return ResultDto.succesResult(chapterList);
        } catch (Exception e) {
            log.error("查询章节目录异常", e);
            return ResultDto.errorResult("查询章节目录异常");
        }
    }



    @Access
    @ApiOperation(value = "章节内容" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bid", dataType = "long", value = "书籍ID", required = true),
            @ApiImplicitParam(name = "cid", dataType = "long", value = "章节ID", required = true),
    })
    @ResponseBody
    @RequestMapping(value = "/chapterContent", method = RequestMethod.POST)
    public ResultDto<ChapterDto> chapterContent(Long bid, Long cid){

        try {
            ChapterDto chapterDto = chapterFacade.chapterContent(bid,cid);
            return ResultDto.succesResult(chapterDto);
        } catch (Exception e) {
            log.error("章节分页查询错误：bid:[{}]",bid,e);
        }

        return ResultDto.errorResult("查询失败");
    }



}
