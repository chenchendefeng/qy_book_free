package com.only.tech.admin.controller;


import com.only.tech.admin.service.facade.ChannelManageFacade;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.admin.ChannleDto;
import com.only.tech.entity.admin.ChannleManage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 渠道管理 前端控制器
 * </p>
 *
 * @author HUA MAN LOU
 * @since 2019/5/15
 */
@Slf4j
@Api(tags="渠道管理")
@RestController
@RequestMapping("/channel")
public class ChannleManageController extends BaseController {


    @Autowired
    private ChannelManageFacade channelManageFacade;

    @ApiOperation(value = "/channel/list", notes = "渠道列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultDto<List<ChannleManage>> list() {

        try {

            List<ChannleDto> resultData  = channelManageFacade.getList();
            return ResultDto.succesResult(resultData);
        } catch (Exception e) {
            log.error("渠道列表 信息：[{}]",e);
        }

        return ResultDto.errorResult();
    }

}
