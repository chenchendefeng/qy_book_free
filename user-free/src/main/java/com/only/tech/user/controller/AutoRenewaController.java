package com.only.tech.user.controller;


import com.only.tech.base.result.ResultDto;
import com.only.tech.user.dto.AutoRenewaDto;
import com.only.tech.user.service.facade.AutoRenewaFacade;
import com.only.tech.user.service.handler.AutoRenwaHandle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import ooh.chaos.targetMethod.Access;
import ooh.chaos.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 * 自动续费 前端控制器
 * </p>
 *
 * @author ZHI
 * @since 2019-01-15
 */
@Api(tags="自动续费相关")
@Slf4j
@RestController
@RequestMapping("/auto-renewa")
public class AutoRenewaController extends BaseController {


    @Autowired
    private AutoRenewaFacade autoRenewaFacade;

    @Autowired
    private AutoRenwaHandle autoRenwaHandle;

    @Access
    @ApiOperation(value = "检查是否是连续包月用户")
    @ApiImplicitParam(name = "cuId", value = "用户id", dataType = "Long",required = true)
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<AutoRenewaDto> check(Long cuId){

        AutoRenewaDto autoRenewaDto = autoRenewaFacade.check(cuId);

        return ResultDto.succesResult(autoRenewaDto);
    }


    @Access
    @ApiOperation(value = "申请续费-签约")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cuId", value = "用户id", dataType = "Long",required = true),
            @ApiImplicitParam(name = "goodsId", value = "商品id", dataType = "Long",required = true),
            @ApiImplicitParam(paramType = "query", name = "clientType", dataType = "String", value = "客户端类型（）", required = true)
    })
    @RequestMapping(value = "/applyRenewa", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<Map<String, String>> applyRenewa(Long cuId,Long goodsId, String clientType){

        try {
            return autoRenewaFacade.applyRenewa(cuId,goodsId,clientType);
        } catch (Exception e) {
            log.error("申请续费-签约 错误：cuId:[{}]",cuId,e);
        }
        return ResultDto.errorResult("申请续费-签约 错误");
    }


    @Access
    @ApiOperation(value = "自动续费  解约")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cuId", value = "用户id", dataType = "Long",required = true)
    })
    @RequestMapping(value = "/rescission", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto rescission(Long cuId){
        try {
            return autoRenewaFacade.rescission(cuId);
        } catch (Exception e) {
            log.error("自动续费  解约 错误：cuId:[{}]",cuId,e);
        }
        return ResultDto.errorResult("自动续费解约失败");
    }


    @ApiOperation(value = "续费信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户ID", required = true) })
    @RequestMapping(value = "/renewaInfo", method = RequestMethod.POST)
    @ResponseBody
    @Access
    public ResultDto renewaInfo(Long cuId){
        try {
//            return autoRenewaFacade.renewaInfo(cuId);
        } catch (Exception e) {
            log.error("续费信息 错误：cuId:[{}]",cuId,e);
        }
        return ResultDto.errorResult("续费信息");
    }



    /**
     * 自动续费签约回调
     */
    @RequestMapping(value = "/notify/applyRenewa", method = RequestMethod.POST)
    public void applyRenewaResultNotify(HttpServletRequest request, HttpServletResponse response){

        try {
            log.info("微信签约回调");
            String resultXml = StringUtils.servletToString(request);

            response.getWriter().write(autoRenewaFacade.parseResult(resultXml,null,null));
        } catch (IOException e) {
            log.error("自动续费签约回调 解析错误：",e);
        }
    }




    @Access
    @ApiOperation(value = "检查签约/解约状态  ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id", dataType = "Long",required = true),
            @ApiImplicitParam(name = "contractCode", value = "签约协议号", dataType = "String",required = true),
            @ApiImplicitParam(paramType = "query", name = "type", dataType = "String", value = "类型 ADD:签约；DELETE:解约", required = true)
    })
    @RequestMapping(value = "/checkWxResult", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto checkWxResult(Long uid,String contractCode,String type){
        log.info("检查签约/解约状态 uid:[{}];contractCode:[{}];type:[{}]",uid,contractCode,type);
        try {
			return autoRenwaHandle.checkWxResult(uid,contractCode,type);
		} catch (Exception e) {
			log.error("checkWxResult error,uid={},contractCode={},type={}",uid,contractCode,type,e);
			return ResultDto.errorResult("查询失败");
		}
    }
    
}
