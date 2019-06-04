package com.only.tech.user.controller;


import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.user.FriendInfoDto;
import com.only.tech.user.service.facade.FriendFacade;
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
 * 用户好友表 前端控制器
 * </p>
 *
 * @author ZHI
 * @since 2019-03-13
 */
@Slf4j
@Api(tags="好友接口")
@RestController
@RequestMapping("/friend")
public class FriendController extends BaseController {

    @Autowired
    private FriendFacade friendFacade;


    @Access
    @ResponseBody
    @ApiOperation(value = "加为好友")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户ID", required = true),
            @ApiImplicitParam(paramType = "query", name = "fuId", dataType = "long", value = "朋友id", required = true) })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultDto add(Long cuId, Long fuId) {

        try {
            boolean add = friendFacade.add(cuId, fuId);
            return add ? ResultDto.succesResult("添加成功") : ResultDto.errorResult("添加失败");
        } catch (Exception e) {
            log.error("添加好友错误：", e);
            return ResultDto.errorResult("添加失败");
        }
    }


    @Access
    @ResponseBody
    @ApiOperation(value = "查询好友")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户ID", required = true),
            @ApiImplicitParam(name = "pageNo", dataType = "int", value = "页码", required = true),
            @ApiImplicitParam(name = "pageSize", dataType = "int", value = "页大小", required = true),
    })
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultDto<PageData<FriendInfoDto>> page(Long cuId, PageReq pageReq) {

        try {
            PageData<FriendInfoDto> pageData = friendFacade.page(cuId, pageReq);
            return pageData!=null ? ResultDto.succesResult(pageData) : ResultDto.errorResult("查询失败");
        } catch (Exception e) {
            log.error("查询好友 错误：", e);
            return ResultDto.errorResult("查询失败");
        }
    }

}
