package com.only.tech.activity.controller;


import com.only.tech.activity.common.dto.WelfarePageDto;
import com.only.tech.activity.service.facade.WelfareFacade;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.user.CustomerBizInfoDto;
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
 * 福利配置 前端控制器
 * </p>
 *
 * @author zzb
 * @since 2019-05-10
 */
@Slf4j
@RestController
@Api(tags = "福利相关")
@RequestMapping("/welfare")
public class WelfareController extends BaseController {

    @Autowired
    private WelfareFacade welfareFacade;


    @Access
    @ResponseBody
    @ApiOperation(value = "福利页")
    @ApiImplicitParam(name = "cuId", value = "用户ID", dataType = "long" )
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultDto<WelfarePageDto> page(Long cuId){

        try {
            WelfarePageDto pageDto = welfareFacade.getPageDate(cuId);
            return ResultDto.succesResult(pageDto);
        } catch (Exception e) {
            log.error("福利页 错误：",e);
        }

        return ResultDto.errorResult();
    }

    /**
     * 看视频免广告20分钟
     */
    @Access
    @ApiOperation(value = "看视频免广告20分钟")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cuId", value = "用户ID", dataType = "String", required = true )
    })
    @RequestMapping(value = "/watchForFreeAdv", method = RequestMethod.POST)
    public ResultDto<CustomerBizInfoDto> watchForFreeAdv(Long cuId) {
        try {
            this.welfareFacade.watchForFreeAdv(cuId,20);
            return ResultDto.succesResult("免费时间生效");

        } catch (Exception e) {
            log.error("设置免费时间失败",e);
            return ResultDto.errorResult("设置免费时间失败");
        }
    }



    @Access
    @ApiOperation(value = "看视频奖励金豆")
    @ApiImplicitParam(name = "cuId", value = "用户ID", dataType = "long", required = true )
    @RequestMapping(value = "/videoForGole", method = RequestMethod.POST)
    public ResultDto videoForGole(Long cuId) {
        try {
            return welfareFacade.videoForGole(cuId);
        } catch (Exception e) {
            log.error("看视频奖励金豆 错误：cuId:[{}]",cuId,e);
            return ResultDto.errorResult("奖励失败");
        }
    }


    @Access
    @ApiOperation(value = "视频奖励金豆状态  0:未领取 | 1:已领取")
    @ApiImplicitParam(name = "cuId", value = "用户ID", dataType = "long", required = true )
    @RequestMapping(value = "/videoForGole/check", method = RequestMethod.POST)
    public ResultDto videoForGoleCheck(Long cuId) {
        try {
            Integer status = welfareFacade.videoForGoleCheck(cuId);
            return ResultDto.succesResult(status);
        } catch (Exception e) {
            log.error("看视频奖励金豆 错误：cuId:[{}]",cuId,e);
            return ResultDto.errorResult("奖励失败");
        }
    }

    @Access
    @ApiOperation(value = "每日分享奖励金豆")
    @ApiImplicitParam(name = "cuId", value = "用户ID", dataType = "long", required = true )
    @RequestMapping(value = "/watchForGole", method = RequestMethod.POST)
    public ResultDto shareForGole(Long cuId) {
        try {
            return welfareFacade.shareForGole(cuId);
        } catch (Exception e) {
            log.error("每日分享奖励金豆 错误：cuId:[{}]",cuId,e);
            return ResultDto.errorResult("奖励失败");
        }
    }


}
