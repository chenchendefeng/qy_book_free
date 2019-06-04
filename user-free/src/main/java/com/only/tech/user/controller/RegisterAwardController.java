package com.only.tech.user.controller;

import com.only.tech.base.result.ResultDto;
import com.only.tech.user.dto.AccountDto;
import com.only.tech.user.service.facade.RegisterAwardFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import ooh.chaos.targetMethod.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/5
 */
@Slf4j
@RestController
@Api(tags = "注册奖励")
@RequestMapping("/award-register")
public class RegisterAwardController extends BaseController {

    @Autowired
    private RegisterAwardFacade registerAwardFacade;


    @Access
    @ApiOperation(value = "奖励")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户id", required = true),
    })
    @RequestMapping(value = "award", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<AccountDto> award(Long cuId){

        try {
            return registerAwardFacade.award(cuId);
        } catch (Exception e) {
            log.error("注册奖励错误：",e);
        }

        return ResultDto.errorResult("注册奖励失败");
    }

}
