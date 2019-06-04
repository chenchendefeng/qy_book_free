package com.only.tech.user.controller;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.user.dto.InvitationRecordDto;
import com.only.tech.user.service.facade.InvitationFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.targetMethod.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/13
 */
@Api(tags="邀请相关")
@Slf4j
@RestController
@RequestMapping("/invitation")
public class InvitationController {

    @Autowired
    private InvitationFacade invitationFacade;

    @Access
    @ApiOperation(value = "查询邀请码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户id", required = true),
    })
    @RequestMapping(value = "getCode", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto getCode(Long cuId){

        try {
            String invitationCode = invitationFacade.getCode(cuId);
            return ResultDto.succesResultData(invitationCode);
        } catch (Exception e) {
            log.error("查询邀请码 错误:",e);
        }

        return ResultDto.errorResult("查询失败");
    }



    @Access
    @ApiOperation(value = "填写邀请码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户id", required = true),
            @ApiImplicitParam(paramType = "query", name = "invitationCode", dataType = "String", value = "邀请码", required = true),
    })
    @RequestMapping(value = "fillInCode", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto fillInCode(Long cuId,String invitationCode){

        try {
            return invitationFacade.fillInCode(cuId,invitationCode);
        } catch (Exception e) {
            log.error("填写邀请码 查询错误:",e);
        }

        return ResultDto.errorResult("填写失败");
    }


    @Access
    @ApiOperation(value = "邀请记录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户id", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "页大小", required = true),
    })
    @RequestMapping(value = "record", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<PageData<InvitationRecordDto>> record(Long cuId, PageReq pageReq){

        try {
            PageData<InvitationRecordDto> pageData = invitationFacade.recordPage(cuId,pageReq);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("邀请记录 错误：cuId:[{}]",cuId);
        }
        return ResultDto.errorResult("查询失败");
    }



}
