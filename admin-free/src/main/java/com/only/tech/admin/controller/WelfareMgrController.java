package com.only.tech.admin.controller;

import com.only.tech.admin.service.facade.WelfareFacade;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.activity.WelfareTypeDto;
import com.only.tech.entity.activity.Welfare;
import com.only.tech.enums.WelfareTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/13
 */
@Slf4j
@RestController
@Api(tags="福利管理")
@RequestMapping("/welfare")
public class WelfareMgrController {


    @Autowired
    private WelfareFacade welfareFacade;


    @ApiOperation(value = "福利分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", dataType = "String", value = "类型(novice:新手;read:阅读；daily：日常）",required = true),
            @ApiImplicitParam(name = "status", dataType = "int", value = "是否启用（ 1:启用|0:关闭）" ),
            @ApiImplicitParam(name = "rewardType", dataType = "String", value = "奖励类型（rmb:人民币，gold:金豆）" ),
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "页大小", required = true)
    })
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultDto<PageData<Welfare>> page(String type, Integer status, String rewardType, PageReq pageReq) {
        try {
            PageData<Welfare> pageData = welfareFacade.pageData(type,status,rewardType,pageReq);
            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            log.error("福利分页查询 错误：", e);
            return ResultDto.errorResult("查询错误");
        }
    }


    @ApiOperation(value = "福利查询")
    @ApiImplicitParam(name = "id", dataType = "int", value = "id" )
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    public ResultDto<Welfare> getById(Integer id) {
        try {
            Welfare welfare = welfareFacade.getById(id);
            return welfare!=null? ResultDto.succesResult(welfare):ResultDto.errorResult("查询失败");
        } catch (Exception e) {
            log.error("福利分页查询 错误：", e);
            return ResultDto.errorResult("查询错误");
        }
    }


    @ApiOperation(value = "新增福利")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", dataType = "String", value = "类型(novice:新手;read:阅读；daily：日常）",required = true),
            @ApiImplicitParam(name = "status", dataType = "int", value = "是否启用（ 1:启用|0:关闭）",required = true),
            @ApiImplicitParam(name = "sort", dataType = "int", value = "排序",required = true),
            @ApiImplicitParam(name = "welfareType", dataType = "String", value = "福利类型（videoForGold：看视频奖励金豆 | dailyShareForGold：每日分享奖励1-100 | turnaroundDraw：转盘抽奖",required = true),
            @ApiImplicitParam(name = "rewardType", dataType = "String", value = "奖励类型（rmb:人民币，gold:金豆）",required = true),
            @ApiImplicitParam(name = "mainTitle", dataType = "String", value = "主标题",required = true),
            @ApiImplicitParam(name = "mainTitleColor", dataType = "String", value = "主标题字色",required = false),
            @ApiImplicitParam(name = "subTitle", dataType = "String", value = "副标题",required = true),
            @ApiImplicitParam(name = "subTitleColor", dataType = "String", value = "副标题字色",required = false),
            @ApiImplicitParam(paramType = "query", name = "minNum", dataType = "Double", value = "最小值", required = true),
            @ApiImplicitParam(paramType = "query", name = "maxNum", dataType = "Double", value = "最大值", required = true),
            @ApiImplicitParam(name = "skipType", dataType = "String", value = "跳转类型(app,h5）",required = true),
            @ApiImplicitParam(name = "skipPage", dataType = "String", value = "跳转地址",required = false),
            @ApiImplicitParam(name = "buttonTex", dataType = "String", value = "按钮文案",required = true),
            @ApiImplicitParam(name = "iconTex", dataType = "String", value = "图标文案",required = true),
    })
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultDto insert(Welfare welfare) {
        try {
            return welfareFacade.insert(welfare);
        } catch (Exception e) {
            log.error("新增福利 错误：", e);
            return ResultDto.errorResult("新增错误");
        }
    }

    @ApiOperation(value = "修改福利")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "int", value = "id",required = true),
            @ApiImplicitParam(name = "type", dataType = "String", value = "类型(novice:新手;read:阅读；daily：日常）",required = true),
            @ApiImplicitParam(name = "status", dataType = "int", value = "是否启用（ 1:启用|0:关闭）",required = true),
            @ApiImplicitParam(name = "sort", dataType = "int", value = "排序",required = true),
            @ApiImplicitParam(name = "welfareType", dataType = "String", value = "福利类型（videoForGold：看视频奖励1金豆 | dailyShareForGold：每日分享奖励1-100 | turnaroundDraw：转盘抽奖",required = true),
            @ApiImplicitParam(name = "rewardType", dataType = "String", value = "奖励类型（rmb:人民币，gold:金豆）",required = true),
            @ApiImplicitParam(name = "mainTitle", dataType = "String", value = "主标题",required = true),
            @ApiImplicitParam(name = "mainTitleColor", dataType = "String", value = "主标题字色",required = false),
            @ApiImplicitParam(name = "subTitle", dataType = "String", value = "副标题",required = true),
            @ApiImplicitParam(name = "subTitleColor", dataType = "String", value = "副标题字色",required = false),
            @ApiImplicitParam(paramType = "query", name = "minNum", dataType = "Double", value = "最小值", required = true),
            @ApiImplicitParam(paramType = "query", name = "maxNum", dataType = "Double", value = "最大值", required = true),
            @ApiImplicitParam(name = "skipType", dataType = "String", value = "跳转类型(app,h5）",required = true),
            @ApiImplicitParam(name = "skipPage", dataType = "String", value = "跳转地址",required = false),
            @ApiImplicitParam(name = "buttonTex", dataType = "String", value = "按钮文案",required = true),
            @ApiImplicitParam(name = "iconTex", dataType = "String", value = "图标文案",required = true),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultDto update(Welfare welfare) {
        try {
            return welfareFacade.update(welfare);
        } catch (Exception e) {
            log.error("修改福利 错误：", e);
            return ResultDto.errorResult("修改错误");
        }
    }


    @ApiOperation(value = "修改福利状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "int", value = "id",required = true),
            @ApiImplicitParam(name = "status", dataType = "int", value = "是否启用（ 1:启用|0:关闭）",required = true),
    })
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public ResultDto updateStatus(Integer id,Integer status) {
        try {
            boolean update = welfareFacade.updateStatus(id,status);
            return update?ResultDto.succesResult("修改成功"):ResultDto.errorResult("修改失败");
        } catch (Exception e) {
            log.error("修改福利 错误：", e);
            return ResultDto.errorResult("修改错误");
        }
    }


    @ApiOperation(value = "删除")
    @ApiImplicitParam(name = "id", dataType = "int", value = "id",required = true)
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ResultDto remove(Integer id) {
        try {
            boolean remove = welfareFacade.remove(id);
            return remove?ResultDto.succesResult("删除成功"):ResultDto.errorResult("删除失败");
        } catch (Exception e) {
            log.error("删除福利 错误：", e);
            return ResultDto.errorResult("删除错误");
        }
    }



    @ApiOperation(value = "福利类型")
    @RequestMapping(value = "/welfareType", method = RequestMethod.POST)
    public ResultDto<List<WelfareTypeEnum>> welfareType() {
        try {
            WelfareTypeEnum[] typeEnums = WelfareTypeEnum.values();
            List<WelfareTypeDto> typeList = new ArrayList<>();
            for (WelfareTypeEnum typeEnum: typeEnums) {
                WelfareTypeDto dto = new WelfareTypeDto();
                dto.setType(typeEnum.getType());
                dto.setName(typeEnum.getName());

                typeList.add(dto);
            }
            return ResultDto.succesResult(typeList);
        } catch (Exception e) {
            log.error("查询 错误：", e);
            return ResultDto.errorResult("查询错误");
        }
    }


}
