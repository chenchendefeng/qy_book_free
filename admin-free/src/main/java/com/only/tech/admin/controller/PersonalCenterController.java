package com.only.tech.admin.controller;

import com.only.tech.admin.service.facade.PersonalCenterFacade;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.entity.user.PersonalCenter;
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
 * @since 2019/3/7
 */
@Slf4j
@RestController
@Api(tags="个人中心")
@RequestMapping(value = "personalCenter")
public class PersonalCenterController {

    @Autowired
    private PersonalCenterFacade personalCenterFacade;


    @ApiOperation(value = "个人中心分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "status", dataType = "int", value = "状态（0：停用；1：启用）", required = false),
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "每页数据条数", required = true)
    })
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultDto<PageData<PersonalCenter>> listByStatus(Integer status, PageReq pageReq){

        try {
            PageData<PersonalCenter> pageData = personalCenterFacade.pageByStatus(status,pageReq);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("个人中心查询错误：{}",e);
        }
        return ResultDto.errorResult("查询异常");

    }

    @ApiOperation(value = "个人中心查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "id", required = true),
    })
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResultDto<PersonalCenter> getById(Integer id){

        try {
            PersonalCenter dto = personalCenterFacade.getById(id);
            return ResultDto.succesResult(dto);
        } catch (Exception e) {
            log.error("个人中心查询错误：{}",e);
        }
        return ResultDto.errorResult("查询异常");

    }

    @ApiOperation(value = "个人中心新增")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "title", dataType = "String", value = "标题", required = true),
    })
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultDto insert(PersonalCenter dto){

        try {
            boolean insert = personalCenterFacade.insert(dto);
            return insert ? ResultDto.succesResult("添加成功") : ResultDto.errorResult("添加失败");
        } catch (Exception e) {
            log.error("个人中心添加错误：{}",e);
        }
        return ResultDto.errorResult("添加失败");

    }

    @ApiOperation(value = "个人中心修改")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "id", required = true),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultDto update(PersonalCenter dto){

        try {
            boolean update = personalCenterFacade.update(dto);
            return update ? ResultDto.succesResult("修改成功") : ResultDto.errorResult("修改失败");
        } catch (Exception e) {
            log.error("个人中心修改错误：{}",e);
        }
        return ResultDto.errorResult("修改失败");

    }

    @ApiOperation(value = "个人中心修改状态")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "id", required = true),
            @ApiImplicitParam(paramType = "query", name = "status", dataType = "int", value = "状态（0：停用；1：启用）", required = true),
    })
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public ResultDto updateStatus(Integer id,Integer status){

        try {
            boolean update = personalCenterFacade.updateStatus(id,status);
            return update ? ResultDto.succesResult("修改成功") : ResultDto.errorResult("修改失败");
        } catch (Exception e) {
            log.error("个人中心修改错误：{}",e);
        }
        return ResultDto.errorResult("修改失败");

    }

    @ApiOperation(value = "个人中心删除")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "id", required = true),
    })
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultDto delete(Integer id){

        try {
            boolean delete = personalCenterFacade.delete(id);
            return delete ? ResultDto.succesResult("删除成功") : ResultDto.errorResult("删除失败");
        } catch (Exception e) {
            log.error("个人中心删除错误：{}",e);
        }
        return ResultDto.errorResult("删除失败");

    }

}
