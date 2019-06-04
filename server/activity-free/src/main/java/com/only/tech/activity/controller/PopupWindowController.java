package com.only.tech.activity.controller;


import com.only.tech.activity.service.facade.PopupWindowFacade;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.activity.PopupWindowDto;
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

import java.util.List;

/**
 * <p>
 * 弹窗 前端控制器
 * </p>
 *
 * @author zzb
 * @since 2019-04-29
 */
@Slf4j
@RestController
@Api(tags = "弹窗相关")
@RequestMapping("/popup-window")
public class PopupWindowController extends BaseController {

    @Autowired
    private PopupWindowFacade popupWindowFacade;


    @ApiOperation(value = "弹窗列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cuid", value = "用户ID", dataType = "long" ),
            @ApiImplicitParam(name = "showPage", value = "显示页面", dataType = "String",required = true),
            @ApiImplicitParam(name = "channel", value = "渠道", dataType = "String"),
            @ApiImplicitParam(name = "clientType", value = "客户端类型（ Android | IOS | H5 | PC ）", dataType = "String",required = true),
    })
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<List<PopupWindowDto>> list(Long cuid, String showPage, String channel, String clientType){

        try {
            List<PopupWindowDto> list = popupWindowFacade.list(cuid,showPage,channel,clientType);
            return ResultDto.succesResult(list);
        } catch (Exception e) {
            log.error("查询弹窗错误：",e);
        }

        return ResultDto.errorResult();
    }

}
