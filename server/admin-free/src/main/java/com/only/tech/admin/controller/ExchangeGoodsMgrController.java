package com.only.tech.admin.controller;

import com.only.tech.admin.service.facade.ExchangeGoodsMgrFacade;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.entity.user.ExchangeGoods;
import com.only.tech.entity.user.PersonalCenter;
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
@Api(tags = "礼品管理")
@RestController
@RequestMapping("/exchangeGoods")
public class ExchangeGoodsMgrController extends BaseController {

    @Autowired
    private ExchangeGoodsMgrFacade exchangeGoodsMgrFacade;

    @ApiOperation(value = "礼品分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "status", dataType = "int", value = "状态（0：停用；1：启用）", required = false),
            @ApiImplicitParam(paramType = "query", name = "exchangeType", dataType = "string", value = "兑换类型（gold:金豆 | rmb:人民币）", required = false),
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "每页数据条数", required = true)
    })
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultDto<PageData<ExchangeGoods>> page(Integer status,String exchangeType, PageReq pageReq){

        try {
            PageData<ExchangeGoods> pageData = exchangeGoodsMgrFacade.page(status,exchangeType,pageReq);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("礼品分页查询 错误：{}",e);
        }
        return ResultDto.errorResult("查询异常");

    }


    @ApiOperation(value = "礼品查询")
    @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "id", required = true)
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    public ResultDto<ExchangeGoods> getById(Integer id){

        try {
            ExchangeGoods goods = exchangeGoodsMgrFacade.getById(id);
            return goods != null?ResultDto.succesResult(goods):ResultDto.errorResult("数据不存在");
        } catch (Exception e) {
            log.error("礼品查询 错误：{}",e);
        }
        return ResultDto.errorResult("查询异常");

    }


    @ApiOperation(value = "新建礼品")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", dataType = "string", value = "名称", required = true),
            @ApiImplicitParam(paramType = "query", name = "exchangeType", dataType = "string", value = "兑换类型（gold:金豆 | rmb:人民币）", required = true),
            @ApiImplicitParam(paramType = "query", name = "requirement", dataType = "string", value = "条件（VIP:会员 | readTime:阅读时间 | all:所有）", required = true),
            @ApiImplicitParam(paramType = "query", name = "cost", dataType = "int", value = "费用", required = true),
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultDto<ExchangeGoods> add(ExchangeGoods goods){

        try {
            boolean add = exchangeGoodsMgrFacade.add(goods);
            return add?ResultDto.succesResult("添加成功"):ResultDto.errorResult("添加失败");
        } catch (Exception e) {
            log.error("新建礼品 错误：{}",e);
        }
        return ResultDto.errorResult("添加失败");

    }

    @ApiOperation(value = "修改礼品")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "id", required = true),
            @ApiImplicitParam(paramType = "query", name = "name", dataType = "string", value = "名称", required = true),
            @ApiImplicitParam(paramType = "query", name = "exchangeType", dataType = "string", value = "兑换类型（gold:金豆 | rmb:人民币）", required = true),
            @ApiImplicitParam(paramType = "query", name = "requirement", dataType = "string", value = "条件（VIP:会员 | readTime | all:所有）", required = true),
            @ApiImplicitParam(paramType = "query", name = "cost", dataType = "int", value = "费用", required = true),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultDto<ExchangeGoods> update(ExchangeGoods goods){

        try {
            boolean update = exchangeGoodsMgrFacade.update(goods);
            return update?ResultDto.succesResult("修改成功"):ResultDto.errorResult("修改失败");
        } catch (Exception e) {
            log.error("新建礼品 错误：{}",e);
        }
        return ResultDto.errorResult("修改失败");
    }


    @ApiOperation(value = "礼品上下架")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "id", required = true),
            @ApiImplicitParam(paramType = "query", name = "status", dataType = "int", value = "id", required = true)
    })
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public ResultDto<ExchangeGoods> updateStatus(Integer id ,Integer status){

        try {
            boolean update = exchangeGoodsMgrFacade.updateStatus(id,status);
            return update?ResultDto.succesResult("修改成功"):ResultDto.errorResult("修改失败");
        } catch (Exception e) {
            log.error("修改礼品 错误：{}",e);
        }
        return ResultDto.errorResult("修改失败");
    }


    @ApiOperation(value = "删除礼品")
    @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "id", required = true)
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultDto<ExchangeGoods> delete(Integer id){

        try {
            boolean delete = exchangeGoodsMgrFacade.delete(id);
            return delete?ResultDto.succesResult("删除成功"):ResultDto.errorResult("删除失败");
        } catch (Exception e) {
            log.error("新建礼品 错误：{}",e);
        }
        return ResultDto.errorResult("删除失败");
    }




}
