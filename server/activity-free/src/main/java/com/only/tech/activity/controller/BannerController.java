package com.only.tech.activity.controller;

import com.only.tech.activity.service.biz.BannerService;
import com.only.tech.base.result.ResultDto;
import com.only.tech.base.result.ResultString;
import com.only.tech.dto.activity.BannerReqDto;
import com.only.tech.entity.activity.Banner;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import ooh.chaos.targetMethod.Access;
import ooh.chaos.util.BeanValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 控制层：横幅广告轮播图
 *
 * @author HUA MAN LOU
 * @date 2019/4/29
 * @version 1.0
 */
@RestController
@RequestMapping("api/banner")
@Api(tags="banner")
@Slf4j
public class BannerController extends BaseController {

    @Autowired
    BannerService bannerService;

    @Access
    @ApiOperation(value = "根据条件查询轮播图列表", notes = "banner列表")
    @ApiImplicitParams({ @ApiImplicitParam(name = "position", value = "位置(recommend推荐、girl女生、boy男生、personalCenter个人中心、categoryBoy分类-男生、categoryGirl分类-女生)", dataType = "string",required = true),
            @ApiImplicitParam(name = "channel", value = "渠道", dataType = "string")})
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultDto<Banner> getBannerList(BannerReqDto dto) {
        ResultDto resultDto = null;
        try {

            BeanValidation<BannerReqDto> validationResult = new BeanValidation<BannerReqDto>(dto);
            if (validationResult.hasError()) {
                resultDto = ResultDto.responseResult(ResultString.ERROR, validationResult.getError(),
                        validationResult.getAllErrors());
                return resultDto;
            }
            List<Banner> bannerRespDtos = bannerService.selectByCondition(dto);

            return ResultDto.succesResult(bannerRespDtos);
        } catch (Exception e) {
            log.error("查询轮播图列表失败", e);
        }
        return ResultDto.errorResult("查询失败");
    }
}
