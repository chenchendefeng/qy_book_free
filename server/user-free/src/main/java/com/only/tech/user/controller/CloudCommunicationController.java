package com.only.tech.user.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.only.tech.base.result.ResultDto;
import com.only.tech.user.dto.CloudCommunicationDto;
import com.only.tech.user.service.facade.CloudCommunicationFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
 * <p>
 * 云通讯账户表 前端控制器
 * </p>
 *
 * @author ZHI
 * @since 2019-03-12
 */
@Slf4j
@Api(tags="云通信账户接口")
@RestController
@RequestMapping("/communication")
public class CloudCommunicationController extends BaseController {

    @Autowired
    private CloudCommunicationFacade communicationFacade;


    @Access
    @ResponseBody
    @ApiOperation(value = "云通信账户信息")
    @ApiImplicitParam(name = "cuId", value = "cuId", dataType = "Long")
    @RequestMapping(value = "/getByUid", method = RequestMethod.POST)
    public ResultDto<CloudCommunicationDto> getByUid(Long cuId){
        try {
            CloudCommunicationDto dto = communicationFacade.getDtoByUid(cuId);
            return dto != null? ResultDto.succesResult(dto) : ResultDto.errorResult("查询失败");
        } catch (Exception e) {
            log.error("用户云通信信息查询错误：",e);
        }
        return ResultDto.errorResult("查询失败");
    }


    @Access
    @ResponseBody
    @ApiOperation(value = "云通信账户信息集合")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResultDto<List<CloudCommunicationDto>> getList(String uidList){
        try {
//            log.info("参数：{}",uidList);
            List<String> list = (List<String>) JSONUtils.parse(uidList);

            List<CloudCommunicationDto> dtoList = communicationFacade.getList(list);
            return dtoList != null? ResultDto.succesResult(dtoList) : ResultDto.errorResult("查询失败");

        } catch (Exception e) {
            log.error("用户云通信信息查询错误：uidList:[{}]",uidList,e);
        }
        return ResultDto.errorResult("查询失败");
    }


}
