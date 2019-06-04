package com.only.tech.user.controller;

import com.only.tech.base.result.ResultDto;
import com.only.tech.user.dto.PersonalCenterPageDto;
import com.only.tech.user.service.facade.PersonalCenterFacade;
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
 * @since 2019/3/7
 */
@Api(tags="个人中心")
@Slf4j
@RestController
@RequestMapping("/personalCenter")
public class PersonalCenterController extends BaseController {

    @Autowired
    private PersonalCenterFacade personalCenterFacade;


    @Access
    @ResponseBody
    @ApiOperation(value = "个人中心选项集合")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户id", required = false),
            @ApiImplicitParam(paramType = "query", name = "channel", dataType = "string", value = "渠道", required = false)
    })

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultDto<PersonalCenterPageDto> page(Long cuId,String channel){
        try {
            PersonalCenterPageDto dto = personalCenterFacade.getPage(cuId,channel);
            return ResultDto.succesResult(dto);
        } catch (Exception e) {
            log.error("查询错误：",e);
        }
        return ResultDto.errorResult("查询错误");
    }

}
