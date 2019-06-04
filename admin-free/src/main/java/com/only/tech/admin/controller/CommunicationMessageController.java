package com.only.tech.admin.controller;


import com.only.tech.admin.common.util.UserUtil;
import com.only.tech.admin.service.facade.CommunicationMessageFacade;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.admin.UserAdminDto;
import com.only.tech.dto.user.CommunicationMessageDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.DateFormatUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/15
 */
@Api(tags="消息推送")
@Slf4j
@RestController
@RequestMapping("/communicationMessage")
public class CommunicationMessageController {

    @Autowired
    private CommunicationMessageFacade communicationMessageFacade;



    @ApiOperation(value = "消息分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "sendStatus", dataType = "int", value = "状态（0：未发送；1：已发送）", required = false),
            @ApiImplicitParam(paramType = "query", name = "startTime", dataType = "String", value = "开始时间", required = true),
            @ApiImplicitParam(paramType = "query", name = "endTime", dataType = "String", value = "结束时间", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "每页数据条数", required = true) })
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultDto<PageData<CommunicationMessageDto>> getPage(Integer sendStatus, String startTime, String endTime, PageReq pageReq){
        try {
            PageData pageData = communicationMessageFacade.getPage(sendStatus,startTime,endTime,pageReq);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("消息分页查询错误：",e);
        }
        return ResultDto.errorResult("查询错误");
    }


    @ApiOperation(value = "添加消息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "msgType", dataType = "int", value = "消息类型（0：群发：1：单聊）", required = true),
            @ApiImplicitParam(paramType = "query", name = "fromIdentifier", dataType = "String", value = "发送方", required = true),
            @ApiImplicitParam(paramType = "query", name = "title", dataType = "String", value = "标题", required = true),
            @ApiImplicitParam(paramType = "query", name = "content", dataType = "String", value = "内容", required = true),
            @ApiImplicitParam(paramType = "query", name = "timing", dataType = "int", value = "是否定时（0：不是；1：是）", required = true),
             })
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultDto insert(CommunicationMessageDto dto,String sendTimeStr, HttpServletRequest request){
        try {
            UserAdminDto user = UserUtil.getUser(request);
            if (user != null){
                dto.setCreateUid(user.getId());
                dto.setCreateName(user.getUserName());
            }
            if (StringUtils.isNotBlank(sendTimeStr)){
                Date sendTime = DateFormatUtil.parse(sendTimeStr);
                dto.setSendTime(sendTime);
            }

            boolean insert = communicationMessageFacade.insert(dto);
            return insert ? ResultDto.succesResult("添加成功"):ResultDto.errorResult("添加失败");
        } catch (Exception e) {
            log.error("添加消息错误：",e);
        }
        return ResultDto.errorResult("添加失败");
    }


     @ApiOperation(value = "撤销/恢复消息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "id", required = true),
            @ApiImplicitParam(paramType = "query", name = "sendStatus", dataType = "int", value = "0：未发送；1：已发送；2：撤销", required = true),
             })
    @RequestMapping(value = "/updateSendStatus", method = RequestMethod.POST)
    public ResultDto updateSendStatus(Integer id,Integer sendStatus){
        try {

            boolean update = communicationMessageFacade.updateSendStatus(id,sendStatus);
            return update ? ResultDto.succesResult("修改成功"):ResultDto.errorResult("修改失败");
        } catch (Exception e) {
            log.error("修改消息错误：",e);
        }
        return ResultDto.errorResult("修改失败");
    }





}
