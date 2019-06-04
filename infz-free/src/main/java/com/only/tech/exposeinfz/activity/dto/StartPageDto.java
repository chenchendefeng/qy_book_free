package com.only.tech.exposeinfz.activity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 开屏配置
 * @author shutong
 * @since 2019-01-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartPageDto implements Serializable {


	private static final long serialVersionUID = 1L;

    /**
     * ID
	 */
	private Long id;

	/**
	 * 文件类型  （ pic-图片 | gif-动图 | video-视频 )
	 */
	private String fileType;

	/**
	 * 文件地址
	 */
	private  String fileUrl;

	/**
	 * 有效期-开始时间
	 */
	private Date beginDate;

	/**
	 * 有效期-结束时间
	 */
	private Date endDate;

	/**
	 * 是否启用  （ 1-启用  | 0-停用 ）
	 */
	private Integer status;

	/**
	 * 渠道编号array ( 多个渠道号用","分隔 )
	 */
	private String channelCodes;

	/**
	 * 客户端 (all-苹果&安卓 | ios-苹果手机  | android-安卓手机 )
	 */
	private String clientType;

}
