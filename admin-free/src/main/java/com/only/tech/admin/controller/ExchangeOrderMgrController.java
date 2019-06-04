package com.only.tech.admin.controller;

import com.only.tech.admin.service.facade.ExchangeOrderMgrFacade;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.user.ExchangeOrderDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/22
 */
@Slf4j
@Api(tags = "兑换相关")
@RestController
@RequestMapping("/exchangeOrder")
public class ExchangeOrderMgrController extends BaseController {

    @Autowired
    private ExchangeOrderMgrFacade exchangeOrderMgrFacade;


    @ApiOperation(value = "兑换记录分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户ID", required = false),
            @ApiImplicitParam(paramType = "query", name = "orderStatus", dataType = "int", value = "订单状态(0：审核中 | 1：审核成功 | 2：审核失败 | 3：微信发送处理中 | 4：红包发送成功 | 5：红包发送失败 ）", required = false),
            @ApiImplicitParam(paramType = "query", name = "startTime", dataType = "string", value = "开始时间", required = false),
            @ApiImplicitParam(paramType = "query", name = "endTime", dataType = "string", value = "结束时间", required = false),
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "每页数据条数", required = true)
    })
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultDto<PageData<ExchangeOrderDto>> page(Long cuId, Integer orderStatus, String startTime, String endTime, PageReq pageReq){

        try {
            PageData<ExchangeOrderDto> pageData = exchangeOrderMgrFacade.page(cuId,orderStatus,startTime,endTime,pageReq);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("兑换记录 错误：{}",e);
        }
        return ResultDto.errorResult("查询异常");

    }


    @ApiOperation(value = "兑换审核")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "orderNo", dataType = "string", value = "订单号", required = true),
            @ApiImplicitParam(paramType = "query", name = "orderStatus", dataType = "int", value = "订单状态(0：审核中 | 1：审核成功 | 2：审核失败 | 3：微信发送处理中 | 4：红包发送成功 | 5：红包发送失败 ）", required = true),
            @ApiImplicitParam(paramType = "query", name = "remark", dataType = "string", value = "备注", required = false),
    })
    @RequestMapping(value = "/audit", method = RequestMethod.POST)
    public ResultDto audit(String orderNo, Integer orderStatus,String remark){

        try {
            return exchangeOrderMgrFacade.audit(orderNo,orderStatus,remark);
        } catch (Exception e) {
            log.error("兑换审核 错误：{}",e);
        }
        return ResultDto.errorResult("审核异常");

    }

}
