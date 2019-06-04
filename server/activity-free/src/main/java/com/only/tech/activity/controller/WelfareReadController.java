package com.only.tech.activity.controller;

import com.only.tech.activity.service.biz.StartPageService;
import com.only.tech.activity.service.facade.WelfareReadFacade;
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
 * 控制器: 阅读福利
 * @author shutong
 * @since 2019/05/06
 */
@Api(tags="读书福利")
@Slf4j
@RestController
@RequestMapping("/welfareRead")
public class WelfareReadController extends BaseController {

    @Autowired
    private WelfareReadFacade welfareReadFacade;

    @ApiOperation(value="获取30秒阅读福利" )
    @ResponseBody
    @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户id", required = true)
    @RequestMapping(value = "/get30sWelfareRead", method = RequestMethod.POST)
    public ResultDto get30sWelfareRead(Long cuId) {
        try {
            return this.welfareReadFacade.get30sWelfareRead(cuId);

        } catch (Exception e) {
            log.error("获取30秒阅读福利异常", e);
            return ResultDto.errorResult("获取30秒阅读福利异常");
        }
    }






}
