package com.only.tech.admin.controller;

import com.only.tech.admin.service.facade.AppVersionManageFacade;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.exposeinfz.admin.dto.AppVersionDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/3
 */
@RestController
@RequestMapping(value = "versionManage")
@Api(tags="app版本控制")
@Slf4j
public class AppVersionManageController {

    @Autowired
    private AppVersionManageFacade appVersionManageFacade;


    @ApiOperation(value = "/versionManage/page", notes = "版本列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "每页数据条数", required = true) })
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultDto<PageData<AppVersionDto>> page(PageReq pageReq) {
        log.info("版本列表 pageNo:[{}];pageSize:[{}]",pageReq.getPageNo(),pageReq.getPageSize());

        try {
            PageData<AppVersionDto> pageData = appVersionManageFacade.getPage(pageReq);

            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("版本列表 信息：[{}]",e);
        }

        return ResultDto.errorResult();
    }

    @ApiOperation(value = "/versionManage/version", notes = "版本")
    @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "id", required = true)
    @RequestMapping(value = "/version", method = RequestMethod.POST)
    public ResultDto<AppVersionDto> getVsersion(Integer id) {
        log.info("版本 id:[{}]",id);

        try {
            AppVersionDto appVersionDto = appVersionManageFacade.getById(id);

            return appVersionDto != null ?ResultDto.succesResult(appVersionDto) : ResultDto.errorResult("不存在");
        } catch (Exception e) {
            log.error("版本 信息：[{}]",e);
        }
        return ResultDto.errorResult();
    }


    @ApiOperation(value = "/versionManage/insert", notes = "版本添加")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "version", dataType = "String", value = "版本号", required = true),
//            @ApiImplicitParam(paramType = "query", name = "versionCode", dataType = "int", value = "版本code", required = true),
            @ApiImplicitParam(paramType = "query", name = "audit", dataType = "int", value = "审核状态", required = true),
            @ApiImplicitParam(paramType = "query", name = "enable", dataType = "int", value = "是否启用", required = true),
            @ApiImplicitParam(paramType = "query", name = "clientType", dataType = "String", value = "客户端类型", required = true),
            @ApiImplicitParam(paramType = "query", name = "miniVersion", dataType = "String", value = "最低版本", required = false),
            @ApiImplicitParam(paramType = "query", name = "downloadUrl", dataType = "String", value = "下载路径", required = false),
            @ApiImplicitParam(paramType = "query", name = "des", dataType = "String", value = "描述", required = false),
    })
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultDto insertVsersion(AppVersionDto appVersionDto) {
        log.info("版本添加 appVersionDto:[{}]",appVersionDto);

        try {
            Boolean result = appVersionManageFacade.insertVsersion(appVersionDto);

            return result? ResultDto.succesResult("添加成功") : ResultDto.errorResult("添加失败");
        } catch (Exception e) {
            log.error("版本添加 信息：[{}]",e);
        }
        return ResultDto.errorResult();
    }

    @ApiOperation(value = "/versionManage/update", notes = "版本更新")
    @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "id", required = true)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultDto updateVsersion(AppVersionDto appVersionDto) {
        log.info("版本更新 appVersionDto:[{}]",appVersionDto);

        try {
            Boolean result = appVersionManageFacade.updateVsersion(appVersionDto);

            return result? ResultDto.succesResult("更新成功") : ResultDto.errorResult("更新失败");
        } catch (Exception e) {
            log.error("版本更新 信息：[{}]",e);
        }
        return ResultDto.errorResult();
    }


    @ApiOperation(value = "/versionManage/delete", notes = "版本删除")
    @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "id", required = true)
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultDto deleteVsersion(Integer id) {
        log.info("版本删除 appVersionDto:[{}]",id);

        try {
            Boolean result = appVersionManageFacade.deleteVsersion(id);

            return result? ResultDto.succesResult("删除成功") : ResultDto.errorResult("删除失败");
        } catch (Exception e) {
            log.error("版本删除 信息：[{}]",e);
        }
        return ResultDto.errorResult();
    }

}
