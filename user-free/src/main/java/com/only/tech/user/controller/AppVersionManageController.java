package com.only.tech.user.controller;

import com.only.tech.base.result.ResultDto;
import com.only.tech.user.dto.VersionManageDto;
import com.only.tech.user.service.facade.AppVersionManageFacade;
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

/**
 * <p>
 * app版本管理 前端控制器
 * </p>
 *
 * @author ZHI ZUN BAO
 * @since 2018-12-26
 */
@Api(tags="app版本相关")
@Slf4j
@RestController
@RequestMapping("/version")
public class AppVersionManageController extends BaseController {

    @Autowired
    private AppVersionManageFacade appVersionManageFacade;


//    @Access
    @ApiOperation(value = "检查是否审核")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "versionCode", dataType = "String", value = "版本号", required = true),
            @ApiImplicitParam(paramType = "query", name = "clientType", dataType = "String", value = "客户端类型", required = true)
    })
    @RequestMapping(value = "check", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto check(Integer versionCode, String clientType) {
        log.info("检查是否审核   versionCode:[{}]",versionCode);

        try {
            boolean check = appVersionManageFacade.check(versionCode,clientType);

            if (check){
                return ResultDto.succesResult();
            }
            return ResultDto.errorResult();
        } catch (Exception e) {
            log.error("检查是否审核失败，}",e);
            return ResultDto.errorResult();
        }
    }


//    @Access
    @ApiOperation(value = "检查更新")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "versionCode", dataType = "int", value = "版本号", required = true),
            @ApiImplicitParam(paramType = "query", name = "clientType", dataType = "String", value = "客户端类型", required = true)
    })
    @RequestMapping(value = "checkUpdate", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<VersionManageDto> checkUpdate(Integer versionCode,String clientType){
        log.info("检查更新  version:[{}];clientType:[{}]",versionCode,clientType);
        VersionManageDto versionManageDto = appVersionManageFacade.checkUpdate(versionCode,clientType);
        if (versionManageDto == null){
            return ResultDto.errorResult("无更新版本");
        }
        return ResultDto.succesResult(versionManageDto);
    }




}
