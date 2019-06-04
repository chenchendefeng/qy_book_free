package com.only.tech.admin.controller;

import com.only.tech.admin.service.facade.PopupWindowFacade;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.admin.PopupWindowReq;
import com.only.tech.entity.activity.PopupWindow;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "popupWindow")
@Api(tags="弹窗管理")
public class PopupWindowMgrController {

	@Autowired
	private PopupWindowFacade popupWindowFacade;


	@ApiOperation(value = "弹窗列表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "channel", dataType = "String", value = "渠道", required = false),
			@ApiImplicitParam(paramType = "query", name = "status", dataType = "int", value = "status(0:停用，1：启用)", required = false),
			@ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "int", value = "页码", required = true),
			@ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", value = "页大小", required = true) })
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public ResultDto<PageData<PopupWindow>> page(PageReq pageReq, String channel, Integer status) {
		try {
			PageData<PopupWindow> pageData = popupWindowFacade.page(pageReq, channel, status);
			return ResultDto.succesResult(pageData);
		} catch (Exception e) {
			log.error("弹窗分页查询错误：", e);
			return ResultDto.errorResult("查询失败");
		}
	}

	@ApiOperation(value = "详情")
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	@ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "弹窗id", required = true)
	public ResultDto<PopupWindow> detail(Integer id) {
		try {
			PopupWindow popupWindow = popupWindowFacade.detail(id);
			return popupWindow != null ? ResultDto.succesResult(popupWindow) : ResultDto.errorResult("查询失败");
		} catch (Exception e) {
			log.error("弹窗详情查询错误：", e);
			return ResultDto.errorResult("查询失败");
		}
	}

	@ApiOperation(value = "删除")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "弹窗id", required = true)
	public ResultDto delete(Integer id) {
		try {
			boolean delete = popupWindowFacade.delete(id);
			return delete ? ResultDto.succesResult("删除成功"): ResultDto.errorResult("删除失败");
		} catch (Exception e) {
			log.error("PopupWindowManagerController.delete error", e);
			return ResultDto.errorResult();
		}
	}

	@ApiOperation(value = "更新弹窗")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "弹窗id", required = true)
	public ResultDto update(PopupWindowReq dto) {
		try {
			boolean update = popupWindowFacade.update(dto);
			return update ? ResultDto.succesResult("更新成功"): ResultDto.errorResult("更新失败");
		} catch (Exception e) {
			log.error("更新弹窗错误：",e);
			return ResultDto.errorResult();
		}
	}

	@ApiOperation(value = "添加弹窗")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultDto add(PopupWindowReq dto) {
		try {
			boolean insert = popupWindowFacade.insert(dto);
			return insert ? ResultDto.succesResult("添加成功"): ResultDto.errorResult("添加失败");
		} catch (Exception e) {
			log.error("添加弹窗错误：",e);
			return ResultDto.errorResult("添加失败");
		}
	}


}
