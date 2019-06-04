package com.only.tech.activity.controller;

import com.only.tech.activity.service.facade.TurnaroundDrawFacade;
import com.only.tech.base.result.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import ooh.chaos.targetMethod.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/20
 */
@Slf4j
@RestController
@Api(tags = "转盘抽奖")
@RequestMapping("/turnaround")
public class TurnaroundDrawController extends BaseController {

    @Autowired
    private TurnaroundDrawFacade turnaroundDrawFacade;


    @Access
    @ApiOperation(value = "抽奖机会查询")
    @ApiImplicitParam(name = "cuId", value = "用户ID", dataType = "long", required = true )
    @RequestMapping(value = "/chance", method = RequestMethod.POST)
    public ResultDto chance(Long cuId) {
        try {
            Integer chance =  turnaroundDrawFacade.getChance(cuId);
            return ResultDto.succesResult(chance);
        } catch (Exception e) {
            log.error("抽奖机会查询 错误：cuId:[{}]",cuId,e);
            return ResultDto.errorResult("查询失败");
        }
    }


    @Access
    @ApiOperation(value = "抽奖机会添加")
    @ApiImplicitParam(name = "cuId", value = "用户ID", dataType = "long", required = true )
    @RequestMapping(value = "/addChance", method = RequestMethod.POST)
    public ResultDto addChance(Long cuId) {
        try {
            return turnaroundDrawFacade.addChance(cuId);
        } catch (Exception e) {
            log.error("抽奖机会添加 错误：cuId:[{}]",cuId,e);
            return ResultDto.errorResult("添加失败");
        }
    }

    @Access
    @ApiOperation(value = "抽奖")
    @ApiImplicitParam(name = "cuId", value = "用户ID", dataType = "long", required = true )
    @RequestMapping(value = "/draw", method = RequestMethod.POST)
    public ResultDto draw(Long cuId) {
        try {
            return turnaroundDrawFacade.draw(cuId);
        } catch (Exception e) {
            log.error("抽奖 错误：cuId:[{}]",cuId,e);
            return ResultDto.errorResult("抽奖失败");
        }
    }



}
