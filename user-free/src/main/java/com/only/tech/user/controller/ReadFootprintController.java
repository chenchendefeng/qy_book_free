package com.only.tech.user.controller;


import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.user.dto.ReadFootprintDto;
import com.only.tech.user.service.facade.ReadFootprintFacade;
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
 * 阅读足迹 前端控制器
 * </p>
 *
 * @author HUA MAN LOU
 * @since 2019/5/20
 */
@Slf4j
@Api(tags="阅读足迹")
@RestController
@RequestMapping("read-footprint")
public class ReadFootprintController extends BaseController {

    @Autowired
    private ReadFootprintFacade readFootprintFacade;


    @Access
    @ApiOperation(value = "记录足迹")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户id", required = true),
            @ApiImplicitParam(paramType = "query", name = "bid", dataType = "long", value = "书籍id", required = true)
    })
    @RequestMapping(value = "record", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto record(Long cuId, Long bid) {

        try {
            boolean record = readFootprintFacade.record(cuId,bid);
            return record ? ResultDto.succesResult(): ResultDto.errorResult("记录失败");
        } catch (Exception e) {
            log.error("记录足迹错误：",e);
            return ResultDto.errorResult();
        }
    }


    @Access
    @ApiOperation(value = "足迹数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户id", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "当前页码", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "每页数据数量", required = true)
    })
    @RequestMapping(value = "getPage", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<PageData<ReadFootprintDto>> getPage(Long cuId, PageReq pageReq){

        try {
            PageData<ReadFootprintDto> pageData = readFootprintFacade.getPage(cuId,pageReq);

            return ResultDto.succesResult(pageData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultDto.errorResult("error");
    }


    @Access
    @ApiOperation(value = "删除足迹")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "long", value = "id", required = true)
    })
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto delete(Long id){
        try {
            boolean delete = readFootprintFacade.delete(id);

            return delete ? ResultDto.succesResult("删除成功") : ResultDto.errorResult("删除失败");
        } catch (Exception e) {
            log.error("足迹删除错误：{}",e);
        }
        return ResultDto.errorResult("删除出错");
    }


}
