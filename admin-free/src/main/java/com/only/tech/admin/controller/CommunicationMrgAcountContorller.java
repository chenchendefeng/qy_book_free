package com.only.tech.admin.controller;

import com.only.tech.admin.service.facade.CommunicationMrgAcountFacade;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.user.CommunicationMrgAcountDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/15
 */
@Api(tags="云通信管理账户")
@Slf4j
@RestController
@RequestMapping("/communicationAcount")
public class CommunicationMrgAcountContorller {

    @Autowired
    private CommunicationMrgAcountFacade communicationMrgAcountFacade;

    @ApiOperation(value = "查询账户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "每页数据条数", required = true) })
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultDto<PageData<CommunicationMrgAcountDto>> getPage(PageReq pageReq){

        try {
            PageData<CommunicationMrgAcountDto> pageData = communicationMrgAcountFacade.getPage(pageReq);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("查询账户错误：{}",e);
        }
        return ResultDto.errorResult("查询异常");

    }



    @ApiOperation(value = "添加账户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nick", dataType = "String", value = "昵称", required = true),
            @ApiImplicitParam(paramType = "query", name = "type", dataType = "int", value = "类型（开发者默认无需填写值 0 表示普通帐号，1 表示机器人帐号）", required = true),
            @ApiImplicitParam(paramType = "query", name = "faceUrl", dataType = "String", value = "头像", required = true),
            @ApiImplicitParam(paramType = "query", name = "status", dataType = "int", value = "状态（0：未启用；1：启用）", required = true),
    })
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultDto insert(CommunicationMrgAcountDto dto){
        try {
            boolean insert = communicationMrgAcountFacade.insert(dto);

            return insert ? ResultDto.succesResult("添加成功") : ResultDto.succesResult("添加失败");
        } catch (Exception e) {
            log.error("添加账户错误： {}",e);
        }
        return ResultDto.errorResult("添加失败");
    }



}
