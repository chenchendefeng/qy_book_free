package com.only.tech.admin.controller;

import com.only.tech.admin.service.facade.BannerFacade;
import com.only.tech.base.result.ResultDto;
import com.only.tech.base.result.ResultString;
import com.only.tech.dto.activity.BannerDto;
import com.only.tech.dto.admin.BannerReqDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.BeanValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="banner管理")
@Slf4j
@RestController
@RequestMapping("/banner")
public class BannerMgrController {


	@Autowired
	private BannerFacade bannerFacade;

	@ApiOperation(value = "新增或者修改banner")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "主键", dataType = "int"),
			@ApiImplicitParam(name = "img", value = "图片URL", dataType = "string",required = true),
			@ApiImplicitParam(name = "url", value = "链接地址", dataType = "string"),
			@ApiImplicitParam(name = "position", value = "位置(recommend推荐、categoryBoy分类-男生、categoryGirl分类-女生、girl女生、boy男生、personalCenter个人中心)", dataType = "string",required = true),
			@ApiImplicitParam(name = "type", value = "banner对象类型（H5、App)", dataType = "string",required = true),
			@ApiImplicitParam(name = "associatedId", value = "关联id,code等", dataType = "string"),
			@ApiImplicitParam(name = "beginTime", value = "轮播图开始时间 (eg: 2019-01-08 11:00:11)", dataType = "string"),
			@ApiImplicitParam(name = "endTime", value = "轮播图结束时间 (eg: 2019-01-08 11:00:11 )", dataType = "string"),
			@ApiImplicitParam(name = "validStatus", value = "有效状态 1：有效；0；无效", dataType = "int"),
			@ApiImplicitParam(name = "channel", value = "渠道", dataType = "string"),
			@ApiImplicitParam(name = "orderIndex", value = "排序", dataType = "int"),
			@ApiImplicitParam(name = "bgColor", value = "背景色", dataType = "string")
	})
	@RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
	public ResultDto saveOrUpdate(BannerReqDto dto) {

		log.info("新增或者修改banner, id:[{}]",dto.getId());
		try {
			// 参数校验
			BeanValidation<BannerReqDto> validationResult = new BeanValidation<BannerReqDto>(dto);
			if (validationResult.hasError()) {
				return  ResultDto.responseResult(ResultString.ERROR, validationResult.getError(),validationResult.getAllErrors());
			}
			//添加or修改
			bannerFacade.saveOrUpdate(dto);
			return ResultDto.succesResult("新增或者修改banner成功");

		} catch (Exception e) {
			log.error("新增或者修改banner失败", e);
			return  ResultDto.errorResult("新增或者修改banner失败");
		}
	}

	@ApiOperation(value = "删除banner", notes = "删除banner")
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "主键ID", dataType = "long")
	})
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResultDto delete(@RequestParam(required = true)  Long  id) {
		try {
			//删除
			bannerFacade.deleteById(id);
			return ResultDto.succesResult();

		} catch (Exception e) {
			log.error("删除banner异常", e);
			return  ResultDto.errorResult("删除banner异常");
		}
	}


	@ApiOperation(value = "list", notes = "banner列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "status", dataType = "String", value = "开启状态 （ all-全部 | 1-启用 | 0-停用 ）" ),
			@ApiImplicitParam(name = "channelCode", dataType = "string", value = "渠道（ all-全部 | 渠道号编码 ）" ) })
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ResultDto<BannerDto> list(String status, String channelCode) {
		try {
			return ResultDto.succesResult(bannerFacade.listByCondition(status,channelCode));
		} catch (Exception e) {
			log.error("查询banner列表异常", e);
			return ResultDto.errorResult("查询banner列表异常");
		}
	}

}
