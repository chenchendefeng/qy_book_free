package com.only.tech.activity.controller;


import com.only.tech.activity.service.facade.CompensateChanceReceiveFacade;
import com.only.tech.base.result.ResultDto;
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
import ooh.chaos.controller.BaseController;

/**
 * <p>
 * 补签机会领取记录 前端控制器
 * </p>
 *
 * @author zzb
 * @since 2019-05-10
 */
@Slf4j
@Api(tags = "补签机会")
@RestController
@RequestMapping("/compensate-chance")
public class CompensateChanceReceiveController extends BaseController {

    @Autowired
    private CompensateChanceReceiveFacade compensateChanceReceiveFacade;


    @Access
    @ApiOperation(value = "领取补签机会")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cuId", value = "用户id", dataType = "Long"),
            @ApiImplicitParam(name = "type", value = "类型（video：视频）", dataType = "String"),
    })
    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto receive(Long cuId, String type){

        try {
            return compensateChanceReceiveFacade.receive(cuId,type);

        } catch (Exception e) {
            log.error("领取补签机会 错误：cuId:[{}]；type：[{}]",cuId,type,e);
        }
        return ResultDto.errorResult();
    }


}
