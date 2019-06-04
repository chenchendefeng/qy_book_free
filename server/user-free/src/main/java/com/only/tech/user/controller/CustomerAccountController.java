package com.only.tech.user.controller;

import com.only.tech.base.result.ResultDto;
import com.only.tech.user.service.facade.CustomerAccountFacade;
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

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/6
 */
@Api(tags="账户")
@Slf4j
@RestController
@RequestMapping("/customer-account")
public class CustomerAccountController extends BaseController {

    @Autowired
    private CustomerAccountFacade customerAccountFacade;


    @Access
    @ResponseBody
    @ApiOperation(value = "修改变更状态")
    @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户id", required = false)
    @RequestMapping(value = "/modifiedChange", method = RequestMethod.POST)
    public ResultDto modifiedChange(Long cuId){

        try {
            boolean update = customerAccountFacade.modifiedChange(cuId);
            return update?ResultDto.succesResult("修改成功"):ResultDto.errorResult("修改失败");
        } catch (Exception e) {
            log.error("修改变更状态 cuIdL:[{}] 错误：",cuId,e);
        }
        return ResultDto.errorResult("修改失败");
    }
}
