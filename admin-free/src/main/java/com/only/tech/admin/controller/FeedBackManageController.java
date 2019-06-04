package com.only.tech.admin.controller;

import com.only.tech.base.result.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 反馈管理
 *
 * @author Lenovo
 */
@RestController
@RequestMapping(value = "feeBackManage")
@Api(tags="反馈管理")
public class FeedBackManageController {

    /**
     * 反馈管理提供状态（已处理，未处理）、日期、用户ID检索，日期默认为最近7天，状态为未处理
     *
     * @param startDate
     * @param endDate
     * @param handleType
     * @param uid
     * @return
     */
    @ApiOperation(value = "feedBackList", notes = "充值列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", dataType = "int", value = "用户id", required = false),
            @ApiImplicitParam(paramType = "query", name = "startDate", dataType = "String", value = "开始时间", required = false),
            @ApiImplicitParam(paramType = "query", name = "endDate", dataType = "String", value = "结束时间", required = false),
            @ApiImplicitParam(paramType = "query", name = "handleType", dataType = "int", value = "handleType", required = false)
    })
    @RequestMapping(value = "/feedBackList", method = RequestMethod.POST)
    public ResultDto feedBackList(String startDate, String endDate, Integer handleType, Integer uid) {

        return ResultDto.errorResult();
    }
}
