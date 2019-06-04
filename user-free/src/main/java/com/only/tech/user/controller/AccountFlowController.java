package com.only.tech.user.controller;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.user.AccountFlowRecordDto;
import com.only.tech.user.service.facade.AccountFlowRecordFacade;
import com.only.tech.user.service.facade.CustomerAccountFacade;
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
@Api(tags = "账户流水")
@RequestMapping("/account-flow")
public class AccountFlowController extends BaseController {

    @Autowired
    private AccountFlowRecordFacade flowRecordFacade;


    @Access
    @ApiOperation(value = "账户流水")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户id", required = true),
            @ApiImplicitParam(paramType = "query", name = "currencyType", dataType = "string", value = "币种(rmb|gold)", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "当前页码", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "分页大小", required = true),
    })
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<PageData<AccountFlowRecordDto>> page(Long cuId, String currencyType, PageReq pageReq){

        try {
            PageData<AccountFlowRecordDto> pageData = flowRecordFacade.getPage(cuId,currencyType,pageReq);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("账户流水 查询错误:",e);
        }

        return ResultDto.errorResult("查询失败");
    }


}
