package com.only.tech.admin.controller;

import com.only.tech.admin.common.util.UserUtil;
import com.only.tech.admin.service.facade.HelpFacade;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.exposeinfz.user.dto.FaqDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author HUA MAN LOU
 * @since 2019/5/20
 */
@RestController
@RequestMapping(value = "help")
@Api(tags="帮助")
@Slf4j
public class HelpController {

    @Autowired
    private HelpFacade helpFacade;


    @ApiOperation(value = "帮助分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "status", dataType = "int", value = "状态", required = false),
            @ApiImplicitParam(paramType = "query", name = "channle", dataType = "String", value = "渠道", required = false),
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "每页数据条数", required = true) })
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultDto<PageData<FaqDto>> getPage(Integer status, String channle, PageReq pageReq){

        try {
            return helpFacade.getPage(status,channle,pageReq);
        } catch (Exception e) {
            log.error("作者分页查询错误：[{}]",e);
        }

        return ResultDto.errorResult("查询错误");
    }


    @ApiOperation(value = "帮助信息")
    @ApiImplicitParam(paramType = "query", name = "id", dataType = "Long", value = "id", required = true)
    @RequestMapping(value = "/getOne", method = RequestMethod.POST)
    public ResultDto<FaqDto> getFaq(Long id){

        try {
            return helpFacade.getFaq(id);
        } catch (Exception e) {
            log.error("帮助信息查询错误：[{}]",e);
        }
        return ResultDto.errorResult("查询错误");
    }

    @ApiOperation(value = "添加帮助反馈信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "question", dataType = "String", value = "问题", required = true),
            @ApiImplicitParam(paramType = "query", name = "answer", dataType = "String", value = "答案", required = true),
            @ApiImplicitParam(paramType = "query", name = "status", dataType = "int", value = "状态：0：无效；1：有效", required = true),
            @ApiImplicitParam(paramType = "query", name = "orderNo", dataType = "int", value = "排序", required = true),
            @ApiImplicitParam(paramType = "query", name = "channle", dataType = "String", value = "渠道", required = false),
    })
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultDto insertFaq(FaqDto faqDto, HttpServletRequest request){
        Integer userId = UserUtil.getUserId(request);
        faqDto.setCreateUid(userId);

        return helpFacade.insertFaq(faqDto);
    }


    @ApiOperation(value = "修改帮助反馈信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "Long", value = "id", required = true),
            @ApiImplicitParam(paramType = "query", name = "question", dataType = "String", value = "问题", required = true),
            @ApiImplicitParam(paramType = "query", name = "answer", dataType = "String", value = "答案", required = true),
            @ApiImplicitParam(paramType = "query", name = "status", dataType = "int", value = "状态：0：无效；1：有效", required = true),
            @ApiImplicitParam(paramType = "query", name = "orderNo", dataType = "int", value = "排序", required = true),
            @ApiImplicitParam(paramType = "query", name = "channle", dataType = "String", value = "渠道", required = false),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultDto updateFaq(FaqDto faqDto){

        return helpFacade.updateFaq(faqDto);
    }

    @ApiOperation(value = "删除帮助反馈信息")
    @ApiImplicitParam(paramType = "query", name = "id", dataType = "Long", value = "id", required = true)
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultDto daleteFaq(Long id){

        return helpFacade.daleteFaq(id);
    }




}
