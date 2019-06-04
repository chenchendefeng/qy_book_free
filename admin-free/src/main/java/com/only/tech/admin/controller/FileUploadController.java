package com.only.tech.admin.controller;

import com.only.tech.base.result.ResultDto;
import com.only.tech.constant.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.service.OSSPicService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ZHI ZUN BAO
 * @since 2018/12/22
 */
@RestController
@RequestMapping(value = "upload")
@Api(tags="文件上传")
@Slf4j
public class FileUploadController {

	/**
	 * 头像后缀
	 */
	public final static List<String> STRUFF_LIST = new ArrayList<>();

	static {
		STRUFF_LIST.add(".jpg");
		STRUFF_LIST.add(".png");
		STRUFF_LIST.add(".gif");
	}

	@Autowired
	private OSSPicService oSSPicService;

	@ApiOperation(value = "图像上传", notes = "图像上传")
	@ResponseBody
	@RequestMapping(value = "/picture", method = RequestMethod.POST)
	public ResultDto upload(@RequestParam(required = true) MultipartFile file, String folder) {

		ResultDto resultDto = null;
		MultipartFile pic = file;
		if (null != pic && !pic.isEmpty()) {
			// 校验上传图片格式
			String originalFilename = pic.getOriginalFilename();// 获取上传文件的文件名
			String struff = originalFilename.substring(originalFilename.lastIndexOf("."));
			if (!STRUFF_LIST.contains(struff)) {
				resultDto = ResultDto.errorResult("图像类型不正确（支持JPG,PNG,GIF格式）");
				return resultDto;
			}
			// 校验上传图片大小
			long fileSize = pic.getSize();
			if (fileSize >= 1024 * 1024 * 3) {
				resultDto = ResultDto.errorResult("图像大小不能超过3MB");
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
				oSSPicService.uploadFile(folder + "/", newFile);
				// 删除项目的临时文件
				FileUtils.deleteQuietly(newFile);

				String url = Constants.OSS_IPADDR + "/" + folder + "/" + fileName;
				resultDto = ResultDto.succesResult(url);
				return resultDto;

			} catch (Exception e) {
				log.error("图像上传失败", e);
				resultDto = ResultDto.errorResult("图像上传失败");
				return resultDto;
			}
		} else {
			resultDto = ResultDto.errorResult("上传的图像为空");
			return resultDto;
		}

	}
}
