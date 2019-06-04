package com.only.tech.user.controller;


import com.only.tech.base.result.ResultDto;
import com.only.tech.user.service.facade.OnlineRecordFacade;
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
 * 上线记录 前端控制器
 * </p>
 *
 * @author zzb
 * @since 2019-05-21
 */
@Slf4j
@Api(tags = "上线记录")
@RestController
@RequestMapping("/online-record")
public class OnlineRecordController extends BaseController {

    @Autowired
    private OnlineRecordFacade onlineRecordFacade;


    @Access
    @ResponseBody
    @ApiOperation(value = "添加记录")
    @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户ID", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultDto receiveAward(Long cuId) {

        try {
            boolean add = onlineRecordFacade.add(cuId);
            return add ? ResultDto.succesResult("添加成功") : ResultDto.errorResult("添加失败");
        } catch (Exception e) {
            log.error("添加好友错误：", e);
            return ResultDto.errorResult("添加失败");
        }
    }

}
