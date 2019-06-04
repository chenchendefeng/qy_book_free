package com.only.tech.user.controller;

import com.only.tech.base.result.ResultDto;
import com.only.tech.user.dto.ExchangeGoodsPageDto;
import com.only.tech.user.service.facade.ExchangeGoodsFacade;
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
 * @since 2019/5/29
 */
@Slf4j
@Api(tags = "兑换礼品")
@RestController
@RequestMapping("exchangeGoods")
public class ExchangeGoodsController extends BaseController {

    @Autowired
    private ExchangeGoodsFacade exchangeGoodsFacade;


    @Access
    @ResponseBody
    @ApiOperation(value = "页面数据")
    @ApiImplicitParam(name = "cuId", value = "用户id", dataType = "Long",required = true)
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultDto<ExchangeGoodsPageDto> page(Long cuId){
        try {
            ExchangeGoodsPageDto pageDto = exchangeGoodsFacade.getPageData(cuId);
            return ResultDto.succesResult(pageDto);
        } catch (Exception e) {
            log.error("查询错误：",e);
        }
        return ResultDto.errorResult("查询失败");

    }


}
