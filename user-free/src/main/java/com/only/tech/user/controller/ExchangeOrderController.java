package com.only.tech.user.controller;


import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.user.dto.ExchangeOrderBaseDto;
import com.only.tech.user.service.facade.ExchangeOrderFacade;
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

import java.util.List;

/**
 * <p>
 * 兑换订单 前端控制器
 * </p>
 *
 * @author zzb
 * @since 2019-05-22
 */
@Slf4j
@Api(tags = "兑换相关")
@RestController
@RequestMapping("/exchange-order")
public class ExchangeOrderController extends BaseController {

    @Autowired
    private ExchangeOrderFacade exchangeOrderFacade;


    @Access
    @ApiOperation(value = "订单分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户id", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "当前页码", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "分页大小", required = true),
    })
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<PageData<ExchangeOrderBaseDto>> page(Long cuId, PageReq pageReq){
        try {
            PageData<ExchangeOrderBaseDto> pageData = exchangeOrderFacade.page(cuId,pageReq);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("订单分页查询 错误：cuId:[{}]",cuId,e);
        }
        return ResultDto.errorResult("查询失败");
    }



    @Access
    @ApiOperation(value = "兑换")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户id", required = true),
            @ApiImplicitParam(paramType = "query", name = "goodsId", dataType = "int", value = "礼品id", required = true),

    })
    @RequestMapping(value = "exchange", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto exchange(Long cuId, Integer goodsId){
        try {
            return exchangeOrderFacade.exchange(cuId,goodsId);
        } catch (Exception e) {
            log.error("兑换 错误：cuId:[{}];goodsId:[{}]",cuId,goodsId,e);
        }
        return ResultDto.errorResult("网络错误,稍后再次尝试");
    }



    @Access
    @ApiOperation(value = "提现广播消息分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "当前页码", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "分页大小", required = true),
    })
    @RequestMapping(value = "msgPage", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<PageData<String>> msgPage(PageReq pageReq){
        try {
            PageData<String> pageData = exchangeOrderFacade.msgPage(pageReq);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("提现广播消息分页查询 错误：",e);
        }
        return ResultDto.errorResult("查询失败");
    }



}
