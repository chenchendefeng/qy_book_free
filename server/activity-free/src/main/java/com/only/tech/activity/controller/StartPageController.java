package com.only.tech.activity.controller;

import com.only.tech.activity.service.biz.StartPageService;
import com.only.tech.base.result.ResultDto;
import com.only.tech.entity.activity.StartPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器-开屏页
 * @author shutong
 * @since 2019-01-16
 */
@Api(tags="开屏页管理")
@Slf4j
@RestController
@RequestMapping("/startPage")
public class StartPageController extends BaseController {

    @Autowired
    private StartPageService startPageService;

    @ApiOperation(value = "返回当前开屏页", notes = "返回当前开屏页")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "channelCode", value = "渠道编码", dataType = "string",required = false),
            @ApiImplicitParam(name = "clientType ", value = "客户端类型 ( ios-苹果手机  | android-安卓手机 )", dataType = "string",required = false)
    })
    @RequestMapping(value = "/getCurStartPage", method = RequestMethod.POST)
    public ResultDto<StartPage> getCurStartPage(String channelCode, String  clientType ) {
        try {
            StartPage startPage=this.startPageService.getCurStartPage(channelCode,clientType);
            return ResultDto.succesResult(startPage);
        } catch (Exception e) {
            log.error("获取当前开屏页信息异常", e);
            return ResultDto.errorResult("获取当前开屏页信息异常");
        }
    }






}
