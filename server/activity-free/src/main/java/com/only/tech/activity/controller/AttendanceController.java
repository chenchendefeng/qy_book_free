package com.only.tech.activity.controller;


import com.only.tech.activity.common.dto.AttendancePageDto;
import com.only.tech.activity.common.dto.AttendanceStatusDto;
import com.only.tech.activity.service.facade.AttendanceFacade;
import com.only.tech.base.result.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
 * <p>
 * 签到 前端控制器
 * </p>
 *
 * @author zzb
 * @since 2019-05-09
 */
@Slf4j
@RestController
@Api(tags = "签到相关")
@RequestMapping("/attendance")
public class AttendanceController extends BaseController {

    @Autowired
    private AttendanceFacade attendanceFacade;


    @Access
    @ApiOperation(value = "签到")
    @ApiImplicitParam(name = "cuId", value = "用户id", dataType = "Long")
    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto sign(Long cuId){

        try {
            return attendanceFacade.sign(cuId);
        } catch (Exception e) {
            log.error("签到错误：cuId:[{}]",cuId,e);
        }
        return ResultDto.errorResult();
    }


    @Access
    @ApiOperation(value = "签到日历页")
    @ApiImplicitParam(name = "cuId", value = "用户id", dataType = "Long")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<AttendancePageDto> page(Long cuId){

        try {
            AttendancePageDto pageDto = attendanceFacade.attendcanePage(cuId);
            return ResultDto.succesResult(pageDto);
        } catch (Exception e) {
            log.error("签到日历页 错误：cuId:[{}]",cuId,e);
        }
        return ResultDto.errorResult();
    }



    @Access
    @ApiOperation(value = "补签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cuId", value = "用户id", dataType = "Long"),
            @ApiImplicitParam(name = "date", value = "日期", dataType = "String"),
    })
    @RequestMapping(value = "/compensateSign", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto compensateSign(Long cuId,String date){

        try {
            return attendanceFacade.compensateSign(cuId,date);
        } catch (Exception e) {
            log.error("补签 错误：cuId:[{}]",cuId,e);
        }
        return ResultDto.errorResult();
    }


    @Access
    @ResponseBody
    @ApiOperation(value = "签到状态")
    @ApiImplicitParam(name = "cuId", value = "用户id", dataType = "Long")
    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public ResultDto<AttendanceStatusDto> status(Long cuId){

        try {
            AttendanceStatusDto dto = attendanceFacade.signStatus(cuId);
            return ResultDto.succesResult(dto);
        } catch (Exception e) {
            log.error("签到状态 查询错误：cuId:[{}]",cuId);
        }
        return ResultDto.errorResult("查询错误");
    }


}
