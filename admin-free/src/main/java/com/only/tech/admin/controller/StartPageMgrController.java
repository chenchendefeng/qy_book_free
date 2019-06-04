package com.only.tech.admin.controller;

import com.only.tech.admin.service.facade.StartPageFacade;
import com.only.tech.base.result.ResultDto;
import com.only.tech.constant.Constants;
import com.only.tech.dto.admin.StartPageReqDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.service.OSSPicService;
import ooh.chaos.util.BeanValidation;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.Date;
import java.util.UUID;

@Api(tags="开屏页")
@Slf4j
@RestController
@RequestMapping("/startPage")
public class StartPageMgrController {

	@Autowired
	private StartPageFacade startPageFacade;

	@Autowired
	private OSSPicService oSSPicService;

	@ApiOperation(value = "新增或者修改开屏页信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "fileType", value = "文件类型（ pic-图片 | gif-动图 | video-视频 )", dataType = "string"),
			@ApiImplicitParam(name = "fileUrl", value = "文件url地址", dataType = "string"),
			@ApiImplicitParam(name = "beginDate", value = "开始时间", dataType = "string"),
			@ApiImplicitParam(name = "endDate", value = "结束时间", dataType = "string"),
			@ApiImplicitParam(name = "status", value = "是否启用  （ 1-启用  | 0-停用 ）", dataType = "int"),
			@ApiImplicitParam(name = "channelCodes", value = "渠道编号 ( 多个渠道号用\",\"分隔 )", dataType = "string"),
			@ApiImplicitParam(name = "clientType", value = "客户端 (all-苹果&安卓 | ios-苹果手机  | Android-安卓手机 )", dataType = "string")
	})
	@RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
	public ResultDto saveOrUpdate(StartPageReqDto dto) {

		log.info("新增或者修改开屏页面, id:[{}]",dto.getId());
		try {
			// 参数校验
			BeanValidation<StartPageReqDto> validationResult = new BeanValidation<StartPageReqDto>(dto);
			if (validationResult.hasError()) {
				return  ResultDto.responseResult("error", validationResult.getError(),validationResult.getAllErrors());
			}
			//添加or修改
			startPageFacade.saveOrUpdate(dto);
			return ResultDto.succesResult("新增或者修改开屏页面成功");

		} catch (Exception e) {
			log.error("新增或者修改开屏页面失败", e);
			return  ResultDto.errorResult("新增或者修改开屏页面失败");
		}
	}

	@ApiOperation(value = "开屏页文件上传", notes = "开屏页文件上传")
	@ResponseBody
	@ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "上传文件", dataType = "MultipartFile")
	})
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResultDto upload(@RequestParam(required = true) MultipartFile file) {

		if (file!=null) {
			String originalFilename = file.getOriginalFilename();// 获取上传文件的文件名

			// 校验上传图片大小
			long fileSize = file.getSize();
			if (fileSize >= 1024 * 1024 * 3) {
				return  ResultDto.errorResult( "文件大小不能超过3MB");
			}
			//图像上传
			try {
				String fileName = UUID.randomUUID() + "-" + new Date().getTime() + originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
				// 创建临时文件
				File newFile = new File(fileName);
				FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
				// 上传缩放后的图像
				oSSPicService.uploadFile(Constants.OSS_STARTPAGE, newFile);
				// 删除项目的临时文件
				FileUtils.deleteQuietly(newFile);

				String url = Constants.OSS_IPADDR + "/" + Constants.OSS_STARTPAGE + fileName;
				return  ResultDto.succesResult(url);

			} catch (Exception e) {
				log.error("文件上传失败", e);
				return  ResultDto.errorResult("文件上传失败");
			}
		} else {
			return  ResultDto.errorResult("上传的文件为空");
		}
	}

	@ApiOperation(value = "OSS文件删除", notes = "OSS文件删除")
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(name = "fileName", value = "文件名", dataType = "string")
	})
	@RequestMapping(value = "/deleteOSSFile", method = RequestMethod.POST)
	public ResultDto deleteOSSFile(@RequestParam(required = true)  String fileName) {
		ResultDto resultDto = null;
		try {

			oSSPicService.deleteFile(Constants.OSS_STARTPAGE, fileName);
			resultDto = ResultDto.succesResult();
			return resultDto;

		} catch (Exception e) {
			log.error("文件不存在，或者删除文件异常", e);
			resultDto = ResultDto.errorResult( "文件不存在，或者删除文件异常");
			return resultDto;
		}
	}

	@ApiOperation(value = "删除开屏页", notes = "删除开屏页")
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "主键ID", dataType = "long")
	})
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResultDto delete(@RequestParam(required = true)  Long  id) {
		try {
			//删除
			this.startPageFacade.deleteById(id);
			return ResultDto.succesResult();

		} catch (Exception e) {
			log.error("删除开屏页面异常", e);
			return  ResultDto.errorResult("删除开屏页面异常");
		}
	}

	@ApiOperation(value = "list", notes = "开屏页列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "status", dataType = "String", value = "状态 （ all-全部 | 1-开启 | 0-关闭 ）" ),
			@ApiImplicitParam(name = "channelCode", dataType = "string", value = "渠道（ all-全部 | 渠道号编码 ）" ) })
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ResultDto<StartPageReqDto> list(String status, String channelCode ) {
		try {
			return startPageFacade.list(status, channelCode);
		} catch (Exception e) {
			log.error("查询开屏页列表异常", e);
			return ResultDto.errorResult("查询开屏页列表异常");
		}
	}

}
