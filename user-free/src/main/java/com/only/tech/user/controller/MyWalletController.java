package com.only.tech.user.controller;

import com.only.tech.base.result.ResultDto;
import com.only.tech.user.dto.WalletDto;
import com.only.tech.user.service.facade.MyWalletFacade;
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
@Api(tags = "我的钱包")
@RequestMapping("/my-wallet")
public class MyWalletController extends BaseController {

    @Autowired
    private MyWalletFacade myWalletFacade;

    @Access
    @ApiOperation(value = "账户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户id", required = true),
    })
    @RequestMapping(value = "balance", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<WalletDto> balance(Long cuId){

        try {
            WalletDto dto = myWalletFacade.balance(cuId);
            return dto != null?ResultDto.succesResult(dto):ResultDto.errorResult("");
        } catch (Exception e) {
            log.error("注册奖励错误：",e);
        }

        return ResultDto.errorResult("注册奖励失败");
    }

}
