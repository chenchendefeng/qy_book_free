package com.only.tech.user.controller;

import com.only.tech.base.result.ResultDto;
import com.only.tech.base.result.ResultString;
import com.only.tech.constant.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import ooh.chaos.service.OSSPicService;
import ooh.chaos.targetMethod.Access;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

/**
 * 问题反馈图像上传
 * 
 * @date 2018/11/26
 * @version 1.0
 */
@Slf4j
@RequestMapping("/api/file")
@RestController
@Api(tags="问题反馈图像上传")
public class FileUploadController extends BaseController {

	/**
	 * 头像后缀
	 */
	public final static List<String> STRUFF_LIST = new ArrayList<String>();

	static {
		STRUFF_LIST.add(".jpg");
		STRUFF_LIST.add(".png");
		STRUFF_LIST.add(".gif");
	}

	@Autowired
	private OSSPicService oSSPicService;

	@Access
	@ApiOperation(value = "图像上传", notes = "图像上传")
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResultDto upload(@RequestParam(required = true) MultipartFile file, HttpServletRequest request,
							HttpServletResponse response) {
		ResultDto resultDto = null;
		MultipartFile pic = file;
		if (null != pic && !pic.isEmpty()) {
			// 校验上传图片格式
			String originalFilename = pic.getOriginalFilename();// 获取上传文件的文件名
			String struff = originalFilename.substring(originalFilename.lastIndexOf("."));
			if (!STRUFF_LIST.contains(struff)) {
				resultDto = ResultDto.responseResult(ResultString.ERROR, "图像类型不正确（支持JPG,PNG,GIF格式）");
				return resultDto;
			}
			// 校验上传图片大小
			long fileSize = pic.getSize();
			if (fileSize >= 1024 * 1024 * 2) {
				resultDto = ResultDto.responseResult(ResultString.ERROR, "图像大小不能超过2MB");
				return resultDto;
			}
			// 调用OSS图像上传方法
			try {
				String fileName = UUID.randomUUID() + "-" + new Date().getTime()
						+ originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
				// 创建临时文件
				File newFile = new File(fileName);
				FileUtils.copyInputStreamToFile(pic.getInputStream(), newFile);
				// 上传缩放后的图像
				oSSPicService.uploadFile(Constants.FEEDBACK_PICTURE_LIB, newFile);
				// 删除项目的临时文件
				FileUtils.deleteQuietly(newFile);
				Map<String, String> map = new HashMap<String, String>();
				map.put("path", Constants.OSS_IPADDR + "/" + Constants.FEEDBACK_PICTURE_LIB + fileName);
				resultDto = ResultDto.responseResult(ResultString.SUCCESS, "图像上传成功", map);
				return resultDto;
			} catch (Exception e) {
				log.error("图像上传失败", e);
				resultDto = ResultDto.responseResult(ResultString.ERROR, "图像上传失败");
				return resultDto;
			}
		} else {
			resultDto = ResultDto.responseResult(ResultString.ERROR, "上传的图像为空");
			return resultDto;
		}
	}

}
