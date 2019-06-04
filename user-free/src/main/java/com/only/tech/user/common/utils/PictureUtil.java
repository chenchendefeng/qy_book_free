package com.only.tech.user.common.utils;

import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

/**
 * 图片处理工具类
 * 
 * @author xiaoshiyilang
 * @version 1.0
 * @date 2018/11/28
 */
public class PictureUtil {

	/**
	 * 私有化工具类对象
	 */
	private PictureUtil() {
	}

	/**
	 * 不按照比例，指定大小进行缩放
	 * 
	 * @param inFilepath
	 * @param width
	 * @param height
	 * @param outFilepath
	 * @throws IOException
	 */
	public static void keepAspectRatioFalse(String inFilepath, int width, int height, String outFilepath)
			throws IOException {
		Thumbnails.of(inFilepath).size(width, height).keepAspectRatio(false).toFile(outFilepath);
	}

}
